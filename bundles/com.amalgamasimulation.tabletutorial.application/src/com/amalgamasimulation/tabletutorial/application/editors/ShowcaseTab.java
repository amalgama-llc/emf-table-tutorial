package com.amalgamasimulation.tabletutorial.application.editors;

import static com.amalgamasimulation.tabletutorial.application.editors.SampleData.createDrivers;
import static com.amalgamasimulation.tabletutorial.application.editors.SampleData.createScenario;
import static com.amalgamasimulation.tabletutorial.application.editors.SampleData.createTrucks;

import java.time.DayOfWeek;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.swt.widgets.Spinner;

import com.amalgamasimulation.desktop.binding.ValidationStrategies;
import com.amalgamasimulation.desktop.binding.ValidationStrategy;
import com.amalgamasimulation.desktop.html.HTML;
import com.amalgamasimulation.desktop.ui.editor.Buttons;
import com.amalgamasimulation.desktop.ui.editor.SectionGroup;
import com.amalgamasimulation.desktop.ui.editor.Sections;
import com.amalgamasimulation.desktop.ui.editor.common.ICustomSection;
import com.amalgamasimulation.desktop.ui.editor.common.ISection;
import com.amalgamasimulation.desktop.ui.editor.common.ITextSection;
import com.amalgamasimulation.desktop.ui.editor.sections.descriptors.LabelProperties;
import com.amalgamasimulation.desktop.ui.editor.sections.descriptors.TextProperties;
import com.amalgamasimulation.desktop.ui.editor.sections.descriptors.ToolTipProperties;
import com.amalgamasimulation.tabletutorial.datamodel.DatamodelPackage;
import com.amalgamasimulation.tabletutorial.datamodel.DriverEMF;
import com.amalgamasimulation.tabletutorial.datamodel.Scenario;
import com.amalgamasimulation.tabletutorial.datamodel.TruckEMF;
import com.amalgamasimulation.tabletutorial.datamodel.TruckType;
import com.amalgamasimulation.utils.format.Formats;

/** Larger examples that combine several features of the library. */
public class ShowcaseTab extends EditorsTab {

	private Font boldFont = new Font(Display.getDefault(), "Arial", 9, SWT.BOLD);

	@Override
	protected void fill(SectionGroup parent) {
		orderCalculator(title(parent, "1. Order calculator: a computed row and a dependent field"));
		settingsForm(title(parent, "2. Settings form: groups, fill lines and rich tooltips"));
		dynamicRows(title(parent, "3. Dynamic rows with addComposite()"));
		crossFieldValidation(title(parent, "4. Own validation strategies and a check across two fields"));
		buttonGallery(title(parent, "5. Button gallery"));
		masterDetail(title(parent, "6. Master-detail: a list of trucks and a form"));
		fieldsByType(title(parent, "7. Fields that depend on the type of the object"));
		containerChain(title(parent, "8. A chain of containers: a truck and its driver"));
		emfUndoRedo(title(parent, "9. EMF: undo, redo, a text view and a form"));
	}

	@Override
	protected boolean copyButtons() {
		return false;
	}

	// ---- 1. Order calculator ----

	private int quantity = 3;
	private double price = 19.9;
	private boolean hasDiscount = false;
	private double discount = 0.1;
	private ICustomSection totalSection;
	private ITextSection<Double> discountSection;

	private void orderCalculator(Composite parent) {
		Sections.integerEditor(() -> quantity).parent(parent).label("Quantity")
			.validationStrategy(ValidationStrategies.integerPositive())
			.handler(newValue -> { quantity = newValue; totalSection.updateSection(); })
			.create();

		Sections.doubleEditor(() -> price).parent(parent).label("Price")
			.validationStrategy(ValidationStrategies.doublePositive())
			.handler(newValue -> { price = newValue; totalSection.updateSection(); })
			.create();

		Sections.checkBoxEditor(() -> hasDiscount).parent(parent).label("Has discount")
			.handler(newValue -> {
				hasDiscount = newValue;
				discountSection.updateEnabled(); // the discount field depends on this flag
				totalSection.updateSection();
			})
			.create();

		discountSection = Sections.doubleEditor(() -> discount).parent(parent).label("Discount")
			.validationStrategy(ValidationStrategies.doublePercentage()) // stores 10% as 0.1
			.handler(newValue -> { discount = newValue; totalSection.updateSection(); })
			.enabled(() -> hasDiscount)
			.create();

		// A computed row: the label text is a supplier, updateSection() reads it again
		totalSection = Sections.customSectionBuilder(parent)
			.addLabel(LabelProperties.label().text("Total"))
			.addLabel(LabelProperties.label().text(() -> Formats.getDefaultFormats().customDecimals(total(), 2)).font(boldFont))
			.createSection();
	}

	private double total() {
		return quantity * price * (hasDiscount ? 1 - discount : 1);
	}

	// ---- 2. Settings form ----

	private String projectName = "Mine model";
	private int replications = 10;
	private double warmUpHours = 24;
	private boolean showAnimation = true;
	private DayOfWeek firstDayOfWeek = DayOfWeek.MONDAY;

	private void settingsForm(Composite parent) {
		header(parent, "General");
		Sections.stringEditor(() -> projectName).parent(parent).label("Project name")
			.validationStrategy(ValidationStrategies.stringIsNotEmpty())
			.handler(newValue -> projectName = newValue)
			.toolTip("The name is shown in the title of the application window")
			.create();
		Sections.enumEditor(() -> firstDayOfWeek).parent(parent).label("First day of the week")
			.elements(DayOfWeek.values())
			.format(DayOfWeek::name)
			.handler(newValue -> firstDayOfWeek = newValue)
			.create();

		header(parent, "Simulation");
		Sections.integerEditor(() -> replications).parent(parent).label("Replications")
			.validationStrategy(ValidationStrategies.integerBetweenValues(1, 1000))
			.handler(newValue -> replications = newValue)
			.toolTip(ToolTipProperties.newInstance()
				.width(320)
				.height(200)
				.elements(
					HTML.header("Replications", 2),
					HTML.textBlock("How many times the model runs with different random seeds.<br/><li>From 1 to 1000<br/><li>More runs give more precise statistics")))
			.create();
		Sections.doubleEditor(() -> warmUpHours).parent(parent).label("Warm-up, hours")
			.validationStrategy(ValidationStrategies.doublePositiveWithZero())
			.handler(newValue -> warmUpHours = newValue)
			.create();

		header(parent, "Display");
		Sections.checkBoxEditor(() -> showAnimation).parent(parent).label("Show animation")
			.handler(newValue -> showAnimation = newValue)
			.create();
	}

	private void header(Composite parent, String text) {
		Sections.customSectionBuilder(parent)
			.addLabel(LabelProperties.fillLine()
				.height(24)
				.background(Display.getDefault().getSystemColor(SWT.COLOR_WIDGET_LIGHT_SHADOW))
				.text(text)
				.font(boldFont))
			.createSection();
	}

	// ---- 3. Dynamic rows ----

	private ICustomSection rowCountSection;
	private int rowCount = 0;

	private void dynamicRows(Composite parent) {
		Sections.customSectionBuilder(parent)
			.addLabel(LabelProperties.label().text("Stops"))
			.addComposite()
				.createInternalContent(c -> {
					Button add = new Button(c, SWT.PUSH);
					add.setText("+ Add a stop");
					add.addListener(SWT.Selection, e -> {
						addStopRow(c);
						rowCount++;
						rowCountSection.updateSection();
					});
				})
				.create()
			.createSection();

		rowCountSection = Sections.customSectionBuilder(parent)
			.addLabel(LabelProperties.label().text(() -> "Stops added: " + rowCount))
			.createSection();
	}

	/** One row: a spinner and a scale that show the same number of minutes. */
	private void addStopRow(Composite c) {
		Composite row = new Composite(c, SWT.NONE);
		row.setLayout(new GridLayout(3, false));
		new Label(row, SWT.NONE).setText("Stop " + (c.getChildren().length - 1) + ", minutes:");
		Spinner minutes = new Spinner(row, SWT.BORDER);
		minutes.setMaximum(60);
		Scale scale = new Scale(row, SWT.HORIZONTAL);
		scale.setMaximum(60);
		minutes.addListener(SWT.Selection, e -> scale.setSelection(minutes.getSelection()));
		scale.addListener(SWT.Selection, e -> minutes.setSelection(scale.getSelection()));
	}

	// ---- 4. Own validation strategies ----

	private double lowerBound = 10;
	private double upperBound = 50;
	private String plateNumber = "AB-123";
	private ITextSection<Double> upperBoundSection;

	private void crossFieldValidation(Composite parent) {
		Sections.doubleEditor(() -> lowerBound).parent(parent).label("Lower bound")
			.validationStrategy(ValidationStrategies.doubleAny())
			.handler(newValue -> {
				lowerBound = newValue;
				upperBoundSection.updateSection(); // checks the upper bound again
			})
			.create();

		upperBoundSection = Sections.doubleEditor(() -> upperBound).parent(parent).label("Upper bound")
			.validationStrategy(notLessThanLowerBound())
			.handler(newValue -> upperBound = newValue)
			.create();

		Sections.stringEditor(() -> plateNumber).parent(parent).label("Plate number (AA-000)")
			.validationStrategy(plateNumberFormat())
			.handler(newValue -> plateNumber = newValue)
			.create();
	}

	/** Parses and shows numbers like the standard strategies, but compares with the current lower bound. */
	private ValidationStrategy<Double, String> notLessThanLowerBound() {
		return ValidationStrategies.createDoubleStrategy("Must not be less than the lower bound", value -> value >= lowerBound, 2);
	}

	/** Two capital letters, a dash and three digits. */
	private ValidationStrategy<String, String> plateNumberFormat() {
		return new ValidationStrategy<String, String>("Use the format AA-000")
			.check(text -> text != null && text.matches("[A-Z]{2}-\\d{3}"))
			.setToModelConverter(text -> text)
			.setToTargetConverter(value -> value == null ? "" : value);
	}

	// ---- 5. Button gallery ----

	private static final double DEFAULT_SPEED = 60;
	private double speed = 80;
	private String reportFile = "";
	private int passengers = 2;
	private ICustomSection passengersSection;
	private boolean showHelpButton = true;
	private boolean helpButtonEnabled = true;
	private ITextSection<Double> speedSection;

	private void buttonGallery(Composite parent) {
		speedSection = Sections.doubleEditor(() -> speed).parent(parent).label("Speed, km/h")
			.validationStrategy(ValidationStrategies.doublePositive())
			.handler(newValue -> speed = newValue)
			.addButton(Buttons.<Double>clear().action((event, value) -> speed = DEFAULT_SPEED)) // resets instead of writing null
			.addButton(Buttons.<Double>simpleButton()
				.text("?")
				.toolTip("Shows a hint")
				.visible(() -> showHelpButton)
				.enabled(() -> helpButtonEnabled)
				.action((event, value) -> {
					MessageBox messageBox = new MessageBox(parent.getShell(), SWT.ICON_INFORMATION);
					messageBox.setMessage("The default speed is " + DEFAULT_SPEED + " km/h, the current one is " + value);
					messageBox.open();
				}))
			.create();
		Sections.checkBoxEditor(() -> showHelpButton).parent(parent).label("Show the ? button")
			.handler(newValue -> { showHelpButton = newValue; speedSection.updateSection(); }).create();
		Sections.checkBoxEditor(() -> helpButtonEnabled).parent(parent).label("Enable the ? button")
			.handler(newValue -> { helpButtonEnabled = newValue; speedSection.updateSection(); }).create();

		Sections.stringEditor(() -> reportFile).parent(parent).label("Report file")
			.validationStrategy(ValidationStrategies.stringAny())
			.handler(newValue -> reportFile = newValue)
			.addButton(Buttons.openFile().extensions(object -> new String[] { "*.xlsx", "*.csv" }))
			.create();

		// A stepper: two buttons change the value and refresh the section
		passengersSection = Sections.customSectionBuilder(parent)
			.addLabel(LabelProperties.label().text("Passengers"))
			.addButton(Buttons.separateButton().text("-").handler(e -> {
				passengers = Math.max(0, passengers - 1);
				passengersSection.updateSection();
			}))
			.textEditor(() -> passengers)
				.validationStrategy(ValidationStrategies.integerPositiveWithZero())
				.handler(newValue -> passengers = newValue)
				.textProperties(TextProperties.newInstance().width(40))
				.create()
			.addButton(Buttons.separateButton().text("+").handler(e -> {
				passengers++;
				passengersSection.updateSection();
			}))
			.createSection();
	}

	// ---- 6. Master-detail ----

	private void masterDetail(Composite parent) {
		List<Driver> drivers = createDrivers();
		List<Truck> trucks = createTrucks(drivers);
		WritableValue<Truck> selectedTruck = new WritableValue<>();

		Composite row = new Composite(parent, SWT.NONE);
		row.setLayout(new GridLayout(2, false));
		row.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		// Master: a list with Add and Remove buttons
		Composite master = new Composite(row, SWT.NONE);
		master.setLayout(new GridLayout(2, true));
		org.eclipse.swt.widgets.List list = new org.eclipse.swt.widgets.List(master, SWT.BORDER | SWT.SINGLE | SWT.V_SCROLL);
		list.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		((GridData) list.getLayoutData()).heightHint = 120;
		((GridData) list.getLayoutData()).widthHint = 150;
		Runnable refreshList = () -> {
			list.setItems(trucks.stream().map(Truck::getName).toArray(String[]::new));
			list.setSelection(trucks.indexOf(selectedTruck.getValue()));
		};
		list.addListener(SWT.Selection, e -> selectedTruck.setValue(list.getSelectionIndex() < 0 ? null : trucks.get(list.getSelectionIndex())));
		Button add = new Button(master, SWT.PUSH);
		add.setText("Add");
		add.addListener(SWT.Selection, e -> {
			Truck truck = new Truck("Truck " + (trucks.size() + 1), 20, true, null);
			trucks.add(truck);
			selectedTruck.setValue(truck);
			refreshList.run();
		});
		Button remove = new Button(master, SWT.PUSH);
		remove.setText("Remove");
		remove.addListener(SWT.Selection, e -> {
			trucks.remove(selectedTruck.getValue());
			selectedTruck.setValue(null);
			refreshList.run();
		});

		// Detail: container editors of the selected truck
		SectionGroup detail = new SectionGroup(row, SWT.NONE);
		detail.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		Sections.stringEditor(selectedTruck).parent(detail).valueExtractor(Truck::getName).label("Name")
			.validationStrategy(ValidationStrategies.stringIsNotEmpty())
			.handler((truck, name) -> { truck.setName(name); refreshList.run(); }) // the list shows the new name
			.create();
		Sections.doubleEditor(selectedTruck).parent(detail).valueExtractor(Truck::getCapacity).label("Capacity")
			.validationStrategy(ValidationStrategies.doublePositive())
			.handler(Truck::setCapacity)
			.create();
		Sections.checkBoxEditor(selectedTruck).parent(detail).valueExtractor(Truck::isActive).label("Active")
			.handler(Truck::setActive)
			.create();
		Sections.<Truck, Driver>comboBoxEditor(selectedTruck).parent(detail).valueExtractor(Truck::getDriver).label("Driver")
			.elements(drivers)
			.format((truck, driver) -> driver.getName())
			.handler(Truck::setDriver)
			.canBeNull(() -> true)
			.addButton(Buttons.<Truck, Driver>selectElementFromTable()
				.title("driver")
				.values(() -> drivers)
				.columns(table -> {
					table.column(Driver::getName).name("Name").width(120);
					table.column(Driver::getExperience).name("Experience, years").width(120);
				}))
			.create();

		selectedTruck.setValue(trucks.get(0));
		refreshList.run();
	}

	// ---- 7. Fields by type ----

	private ITextSection<Double> temperatureSection;
	private ITextSection<Double> bodyVolumeSection;

	private void fieldsByType(Composite parent) {
		List<Driver> drivers = createDrivers();
		List<Truck> trucks = createTrucks(drivers);

		WritableValue<Truck> selectedTruck = new WritableValue<>(trucks.get(0), Truck.class);
		Composite radios = new Composite(parent, SWT.NONE); // own parent: radio buttons with one parent are one group
		radios.setLayout(new RowLayout());
		for (Truck truck : trucks) {
			Button radio = new Button(radios, SWT.RADIO);
			radio.setText(truck.getName() + " (" + truck.getType().getName() + ")");
			radio.setSelection(truck == selectedTruck.getValue());
			radio.addListener(SWT.Selection, e -> {
				if (radio.getSelection()) {
					selectedTruck.setValue(truck);
				}
			});
		}

		Sections.<Truck, TruckType>enumEditor(selectedTruck).parent(parent).valueExtractor(Truck::getType).label("Type")
			.elements(TruckType.values())
			.format((truck, type) -> type.getName())
			.handler((truck, type) -> {
				truck.setType(type);
				temperatureSection.updateVisible(); // the same object changed, so the sections are refreshed here
				bodyVolumeSection.updateVisible();
			})
			.create();
		temperatureSection = Sections.doubleEditor(selectedTruck).parent(parent).valueExtractor(Truck::getTemperature).label("Temperature, °C")
			.validationStrategy(ValidationStrategies.doubleBetweenValues(-30, 10))
			.handler(Truck::setTemperature)
			.visible(truck -> truck != null && truck.getType() == TruckType.REFRIGERATOR)
			.create();
		bodyVolumeSection = Sections.doubleEditor(selectedTruck).parent(parent).valueExtractor(Truck::getBodyVolume).label("Body volume, m³")
			.validationStrategy(ValidationStrategies.doublePositive())
			.handler(Truck::setBodyVolume)
			.visible(truck -> truck != null && truck.getType() == TruckType.DUMP_TRUCK)
			.create();
	}

	// ---- 8. A chain of containers ----

	private void containerChain(Composite parent) {
		List<Driver> drivers = createDrivers();
		List<Truck> trucks = createTrucks(drivers);
		WritableValue<Truck> selectedTruck = new WritableValue<>();
		WritableValue<Driver> selectedDriver = new WritableValue<>(); // always holds the driver of the selected truck
		selectedTruck.addValueChangeListener(e -> selectedDriver.setValue(e.diff.getNewValue() == null ? null : e.diff.getNewValue().getDriver()));

		Composite radios = new Composite(parent, SWT.NONE); // own parent: radio buttons with one parent are one group
		radios.setLayout(new RowLayout());
		for (Truck truck : trucks) {
			Button radio = new Button(radios, SWT.RADIO);
			radio.setText(truck.getName());
			radio.addListener(SWT.Selection, e -> {
				if (radio.getSelection()) {
					selectedTruck.setValue(truck);
				}
			});
		}

		header(parent, "Truck");
		Sections.stringEditor(selectedTruck).parent(parent).valueExtractor(Truck::getName).label("Name")
			.validationStrategy(ValidationStrategies.stringIsNotEmpty())
			.handler(Truck::setName)
			.create();
		Sections.<Truck, Driver>comboBoxEditor(selectedTruck).parent(parent).valueExtractor(Truck::getDriver).label("Driver")
			.elements(drivers)
			.format((truck, driver) -> driver.getName())
			.handler((truck, driver) -> {
				truck.setDriver(driver);
				selectedDriver.setValue(driver); // the driver editors below switch to the new driver
			})
			.create();

		header(parent, "Driver of the truck");
		Sections.stringEditor(selectedDriver).parent(parent).valueExtractor(Driver::getPhone).label("Phone")
			.validationStrategy(ValidationStrategies.stringAny())
			.handler(Driver::setPhone)
			.create();
		Sections.integerEditor(selectedDriver).parent(parent).valueExtractor(Driver::getExperience)
			.label(driver -> driver == null ? "Experience, years" : "Experience of " + driver.getName() + ", years")
			.validationStrategy(ValidationStrategies.integerPositiveWithZero())
			.handler(Driver::setExperience)
			.create();

		selectFirst(radios, selectedTruck, trucks.get(0));
	}

	// ---- 9. EMF: undo, redo, a text view and a form ----

	private void emfUndoRedo(Composite parent) {
		Scenario scenario = createScenario();
		// An own editing domain: Undo here does not undo the edits of the other examples, and they do not undo this one
		EditingDomain domain = new AdapterFactoryEditingDomain(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE), new BasicCommandStack());
		CommandStack commandStack = domain.getCommandStack();
		@SuppressWarnings("unchecked")
		IObservableList<DriverEMF> drivers = EMFProperties.list(DatamodelPackage.Literals.SCENARIO__DRIVERS).observe(scenario);
		WritableValue<TruckEMF> selectedTruck = new WritableValue<>(scenario.getTrucks().get(0), TruckEMF.class);

		// Undo and Redo are enabled only when the command stack has something to undo or redo
		ICustomSection undoRedoSection = Sections.customSectionBuilder(parent)
			.addButton(Buttons.separateButton().text("Undo").width(60).enabled(commandStack::canUndo).handler(e -> commandStack.undo()))
			.addButton(Buttons.separateButton().text("Redo").width(60).enabled(commandStack::canRedo).handler(e -> commandStack.redo()))
			.createSection();

		Composite radios = new Composite(parent, SWT.NONE); // own parent: radio buttons with one parent are one group
		radios.setLayout(new RowLayout());
		for (TruckEMF truck : scenario.getTrucks()) {
			Button radio = new Button(radios, SWT.RADIO);
			radio.setText(truck.getName());
			radio.setSelection(truck == selectedTruck.getValue());
			radio.addListener(SWT.Selection, e -> {
				if (radio.getSelection()) {
					selectedTruck.setValue(truck);
				}
			});
		}

		Composite row = new Composite(parent, SWT.NONE);
		row.setLayout(new GridLayout(2, true));
		row.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		// Left: the selected truck as plain text
		SectionGroup view = new SectionGroup(row, SWT.NONE);
		view.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		view.labelWidth(100); // the same column as in the form on the right
		List<ICustomSection> viewRows = List.of(
			textRow(view, "Name", () -> selectedTruck.getValue().getName()),
			textRow(view, "Capacity", () -> Formats.getDefaultFormats().customDecimals(selectedTruck.getValue().getCapacity(), 2)),
			textRow(view, "Active", () -> selectedTruck.getValue().isActive() ? "yes" : "no"),
			textRow(view, "Type", () -> selectedTruck.getValue().getType().getName()),
			textRow(view, "Driver", () -> selectedTruck.getValue().getDriver() == null ? "none" : selectedTruck.getValue().getDriver().getName()),
			textRow(view, "Axles", () -> String.valueOf(selectedTruck.getValue().getAxles())));
		Runnable refreshView = () -> viewRows.forEach(ISection::updateSection);

		// Right: EMF editors of the same truck. By default they write to CommandsManager.getEditingDomain(), the handlers write to the own domain
		SectionGroup form = new SectionGroup(row, SWT.NONE);
		form.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		form.labelWidth(100);
		Sections.emfStringEditor(selectedTruck).parent(form).feature(DatamodelPackage.Literals.TRUCK_EMF__NAME).label("Name")
			.validationStrategy(ValidationStrategies.stringIsNotEmpty())
			.handler(setIn(domain, DatamodelPackage.Literals.TRUCK_EMF__NAME))
			.create();
		Sections.emfDoubleEditor(selectedTruck).parent(form).feature(DatamodelPackage.Literals.TRUCK_EMF__CAPACITY).label("Capacity")
			.validationStrategy(ValidationStrategies.doublePositive())
			.handler(setIn(domain, DatamodelPackage.Literals.TRUCK_EMF__CAPACITY))
			.create();
		Sections.emfCheckBoxEditor(selectedTruck).parent(form).feature(DatamodelPackage.Literals.TRUCK_EMF__ACTIVE).label("Active")
			.handler(setIn(domain, DatamodelPackage.Literals.TRUCK_EMF__ACTIVE))
			.create();
		Sections.<TruckEMF, TruckType>emfEnumEditor(selectedTruck).parent(form).feature(DatamodelPackage.Literals.TRUCK_EMF__TYPE).label("Type")
			.elements(TruckType.values())
			.format((truck, type) -> type.getName())
			.handler(setIn(domain, DatamodelPackage.Literals.TRUCK_EMF__TYPE))
			.create();
		Sections.<TruckEMF, DriverEMF>emfComboBoxEditor(selectedTruck).parent(form).feature(DatamodelPackage.Literals.TRUCK_EMF__DRIVER).label("Driver")
			.elements(drivers)
			.format(DatamodelPackage.Literals.DRIVER_EMF__NAME)
			.handler(setIn(domain, DatamodelPackage.Literals.TRUCK_EMF__DRIVER))
			.create();
		Sections.emfIntegerEditor(selectedTruck).parent(form).feature(DatamodelPackage.Literals.TRUCK_EMF__AXLES).label("Axles")
			.validationStrategy(ValidationStrategies.integerBetweenValues(2, 10))
			.handler(setIn(domain, DatamodelPackage.Literals.TRUCK_EMF__AXLES))
			.create();

		// An edit on the right, Undo and Redo all go through the command stack, so one listener refreshes the text and the buttons
		CommandStackListener listener = e -> {
			undoRedoSection.updateSection();
			refreshView.run();
		};
		commandStack.addCommandStackListener(listener); // the stack belongs to this example, so the listener is not removed
		selectedTruck.addValueChangeListener(e -> refreshView.run());
	}

	/** A handler that writes the value with a command on the stack of the given domain. */
	private static <T extends EObject, V> BiConsumer<T, V> setIn(EditingDomain domain, EStructuralFeature feature) {
		return (object, value) -> domain.getCommandStack().execute(SetCommand.create(domain, object, feature, value));
	}

	/** A row of the text view: the name of the property and its value. */
	private ICustomSection textRow(Composite parent, String name, Supplier<String> value) {
		return Sections.customSectionBuilder(parent)
			.addLabel(LabelProperties.label().text(name))
			.addLabel(LabelProperties.label().text(value).font(boldFont))
			.createSection();
	}

	@Override
	protected void disposeResources() {
		for (Font font : List.of(boldFont)) {
			font.dispose();
		}
	}
}
