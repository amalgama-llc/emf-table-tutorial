package com.amalgamasimulation.tabletutorial.application.editors;

import static com.amalgamasimulation.tabletutorial.application.editors.SampleData.createScenario;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;

import com.amalgamasimulation.desktop.binding.ValidationStrategies;
import com.amalgamasimulation.desktop.ui.editor.Buttons;
import com.amalgamasimulation.desktop.ui.editor.SectionGroup;
import com.amalgamasimulation.desktop.ui.editor.Sections;
import com.amalgamasimulation.desktop.ui.editor.common.IComboBoxSection;
import com.amalgamasimulation.desktop.ui.editor.common.ITextSection;
import com.amalgamasimulation.desktop.ui.editor.sections.descriptors.ComboBoxProperties;
import com.amalgamasimulation.desktop.ui.editor.sections.descriptors.LabelProperties;
import com.amalgamasimulation.desktop.ui.editor.sections.descriptors.TextProperties;
import com.amalgamasimulation.emf.commands.CommandsManager;
import com.amalgamasimulation.tabletutorial.datamodel.DatamodelPackage;
import com.amalgamasimulation.tabletutorial.datamodel.DriverEMF;
import com.amalgamasimulation.tabletutorial.datamodel.Scenario;
import com.amalgamasimulation.tabletutorial.datamodel.TruckEMF;
import com.amalgamasimulation.tabletutorial.datamodel.TruckType;

/** Examples of emfEditors.adoc: the editors edit a feature of an EObject and write it with a command. */
public class EmfEditorsTab extends EditorsTab {

	private Font boldFont = new Font(Display.getDefault(), "Arial", 9, SWT.BOLD);
	private Font italicFont = new Font(Display.getDefault(), "Arial", 9, SWT.ITALIC);

	/**
	 * Every example has its own container and its own copy of a truck, so a change in one example does not show up in another.
	 * The drivers are shared. Every change is a command, so the Undo button of the first example reverts the last change on the tab.
	 */
	@Override
	protected void fill(SectionGroup parent) {
		Scenario scenario = createScenario();
		WritableValue<Scenario> scenarioValue = new WritableValue<>(scenario, Scenario.class);
		@SuppressWarnings("unchecked")
		IObservableList<DriverEMF> drivers = EMFProperties.list(DatamodelPackage.Literals.SCENARIO__DRIVERS).observeDetail(scenarioValue);
		@SuppressWarnings("unchecked")
		IObservableList<TruckEMF> trucks = EMFProperties.list(DatamodelPackage.Literals.SCENARIO__TRUCKS).observeDetail(scenarioValue);

		emfEditingTheSelectedObject(title(parent, "Switching the edited object", "emfEditingTheSelectedObject"), trucks);

		emfDoubleEditor(title(parent, "Double editor", "emfDoubleEditor"), truck(scenario));
		emfIntegerEditor(title(parent, "Integer editor", "emfIntegerEditor"), truck(scenario));
		emfStringEditor(title(parent, "String editor", "emfStringEditor"), truck(scenario));
		emfComboboxEditor(title(parent, "Combobox editor", "emfComboboxEditor"), truck(scenario), drivers);
		emfComboboxSettings(title(parent, "Combobox settings", "emfComboboxSettings"), truck(scenario), drivers);
		emfAutocompleteEditor(title(parent, "Autocomplete editor", "emfAutocompleteEditor"), truck(scenario), drivers);
		emfEnumEditor(title(parent, "Enum editor", "emfEnumEditor"), truck(scenario));
		emfBooleanEditor(title(parent, "Boolean editor", "emfBooleanEditor"), truck(scenario));
		emfLocalDateTimeEditor(title(parent, "LocalDateTime editor", "emfLocalDateTimeEditor"), truck(scenario));
		emfLocalTimeEditor(title(parent, "LocalTime editor", "emfLocalTimeEditor"), truck(scenario));
		emfColorEditor(title(parent, "Color editor", "emfColorEditor"), truck(scenario));
		emfRealDistributionEditor(title(parent, "Real distribution editor", "emfRealDistributionEditor"), truck(scenario));
		emfTimeSeriesEditor(title(parent, "Time Series editor", "emfTimeSeriesEditor"), truck(scenario));
		customSectionsNote(title(parent, "Custom section"));

		SectionGroup visibleGroup = title(parent, "visible()", "emfVisible");
		emfVisible(visibleGroup, truckSelector(visibleGroup, scenario));
		SectionGroup enabledGroup = title(parent, "enabled()", "emfEnabled");
		emfEnabled(enabledGroup, truckSelector(enabledGroup, scenario));
		emfTooltip(title(parent, "tooltip()", "emfTooltip"), truck(scenario));
		emfLabelProperties(title(parent, "labelProperties()", "emfLabelProperties"), truck(scenario));
		emfTextProperties(title(parent, "textProperties()", "emfTextProperties"), truck(scenario));
		emfComboBoxProperties(title(parent, "comboBoxProperties()", "emfComboBoxProperties"), truck(scenario), drivers);
		emfAddButton(title(parent, "addButton()", "emfAddButton"), truck(scenario));
		emfCommonButtonSettings(title(parent, "Common Button Settings", "emfCommonButtonSettings"), truck(scenario));
		emfSectionGroup(title(parent, "SectionGroup", "emfSectionGroup"), truck(scenario));

		emfSelectElementFromTable(title(parent, "Select element from table", "emfSelectElementFromTable"), truck(scenario), drivers);
	}

	/** A container with its own copy of the first truck. The copy refers to the drivers of the scenario. */
	private WritableValue<TruckEMF> truck(Scenario scenario) {
		return new WritableValue<>(EcoreUtil.copy(scenario.getTrucks().get(0)), TruckEMF.class);
	}

	/** Radio buttons that switch the truck of one example between copies of the trucks. Returns the container of that example. */
	private WritableValue<TruckEMF> truckSelector(Composite parent, Scenario scenario) {
		List<TruckEMF> trucks = new ArrayList<>(EcoreUtil.copyAll(scenario.getTrucks()));
		WritableValue<TruckEMF> selectedTruck = new WritableValue<>(trucks.get(0), TruckEMF.class);
		Composite radios = new Composite(parent, SWT.NONE); // own parent: radio buttons with one parent are one group
		radios.setLayout(new RowLayout());
		for (TruckEMF truck : trucks) {
			Button radio = new Button(radios, SWT.RADIO);
			radio.setText(truck.getName());
			radio.setSelection(truck == selectedTruck.getValue());
			radio.addListener(SWT.Selection, e -> {
				if (radio.getSelection()) {
					selectedTruck.setValue(truck);
				}
			});
		}
		return selectedTruck;
	}

	private void emfEditingTheSelectedObject(Composite parent, List<TruckEMF> trucks) {
		WritableValue<TruckEMF> selectedTruck = new WritableValue<>(); // holds the object being edited

		// copy:emfEditingTheSelectedObject
		for (TruckEMF truck : trucks) {
			Button radio = new Button(parent, SWT.RADIO);
			radio.setText(truck.getName());
			radio.addListener(SWT.Selection, e -> {
				if (radio.getSelection()) {
					selectedTruck.setValue(truck); // editors show the selected truck
				}
			});
		}

		SectionGroup group = new SectionGroup(parent, SWT.NONE); // aligns the labels

		Sections
			.emfStringEditor(selectedTruck)
			.parent(group)
			.feature(DatamodelPackage.Literals.TRUCK_EMF__NAME)
			.label("Name")
			.validationStrategy(ValidationStrategies.stringIsNotEmpty())
			.create();

		Sections
			.emfDoubleEditor(selectedTruck)
			.parent(group)
			.feature(DatamodelPackage.Literals.TRUCK_EMF__CAPACITY)
			.label("Capacity")
			.validationStrategy(ValidationStrategies.doublePositive())
			.create();

		Button undo = new Button(parent, SWT.PUSH);
		undo.setText("Undo");
		undo.addListener(SWT.Selection, e -> CommandsManager.getEditingDomain().getCommandStack().undo());
		// copy:end

		selectFirst(parent, selectedTruck, trucks.get(0)); // not in the article: start with the first truck
	}

	private void emfDoubleEditor(Composite parent, WritableValue<TruckEMF> selectedTruck) {
		// copy:emfDoubleEditor
		Sections
			.emfDoubleEditor(selectedTruck) // the container with the object being edited
			.parent(parent)
			.feature(DatamodelPackage.Literals.TRUCK_EMF__CAPACITY) // the feature to read and write
			.label("Capacity")
			.validationStrategy(ValidationStrategies.doublePositive())
			.create();

		// A custom handler replaces the command, so it runs the command itself to keep undo
		Sections
			.emfDoubleEditor(selectedTruck)
			.parent(parent)
			.feature(DatamodelPackage.Literals.TRUCK_EMF__CAPACITY)
			.label("Capacity (own handler)")
			.validationStrategy(ValidationStrategies.doublePositive())
			.handler((truck, value) -> CommandsManager.getEditingDomain().getCommandStack().execute(
					SetCommand.create(CommandsManager.getEditingDomain(), truck, DatamodelPackage.Literals.TRUCK_EMF__CAPACITY, value)))
			.create();
		// copy:end
	}

	private void emfIntegerEditor(Composite parent, WritableValue<TruckEMF> selectedTruck) {
		// copy:emfIntegerEditor
		Sections
			.emfIntegerEditor(selectedTruck)
			.parent(parent)
			.feature(DatamodelPackage.Literals.TRUCK_EMF__AXLES)
			.label("Axles")
			.validationStrategy(ValidationStrategies.integerBetweenValues(2, 10))
			.create();
		// copy:end
	}

	private void emfStringEditor(Composite parent, WritableValue<TruckEMF> selectedTruck) {
		// copy:emfStringEditor
		Sections
			.emfStringEditor(selectedTruck)
			.parent(parent)
			.feature(DatamodelPackage.Literals.TRUCK_EMF__NAME)
			.label("Name")
			.validationStrategy(ValidationStrategies.stringIsNotEmpty())
			.create();
		// copy:end
	}

	private void emfComboboxEditor(Composite parent, WritableValue<TruckEMF> selectedTruck, IObservableList<DriverEMF> drivers) {
		// copy:emfComboboxEditor
		Sections
			.<TruckEMF, DriverEMF>emfComboBoxEditor(selectedTruck) // the object type and the element type
			.parent(parent)
			.feature(DatamodelPackage.Literals.TRUCK_EMF__DRIVER)
			.label("Driver")
			.elements(drivers)
			.format(DatamodelPackage.Literals.DRIVER_EMF__NAME) // the element feature to display
			.create();
		// copy:end
	}

	private boolean emfDriversWithoutBob = false;
	private boolean emfDriversSortedByName = false;
	private boolean emfDriverCanBeNull = false;
	private IComboBoxSection<DriverEMF> emfDriverSettingsSection;

	private void emfComboboxSettings(Composite parent, WritableValue<TruckEMF> selectedTruck, IObservableList<DriverEMF> drivers) {
		Sections.checkBoxEditor(() -> emfDriversWithoutBob).parent(parent).label("filter(): hide Bob")
			.handler(newValue -> { emfDriversWithoutBob = newValue; emfDriverSettingsSection.updateSection(); }).create();
		Sections.checkBoxEditor(() -> emfDriversSortedByName).parent(parent).label("comparator(): sort by name")
			.handler(newValue -> { emfDriversSortedByName = newValue; emfDriverSettingsSection.updateSection(); }).create();
		Sections.checkBoxEditor(() -> emfDriverCanBeNull).parent(parent).label("canBeNull()")
			.handler(newValue -> { emfDriverCanBeNull = newValue; emfDriverSettingsSection.updateSection(); }).create();

		// copy:emfComboboxSettings
		emfDriverSettingsSection = Sections
			.<TruckEMF, DriverEMF>emfComboBoxEditor(selectedTruck)
			.parent(parent)
			.feature(DatamodelPackage.Literals.TRUCK_EMF__DRIVER)
			.label("Driver")
			.elements(drivers)
			.format(DatamodelPackage.Literals.DRIVER_EMF__NAME)
			.filter(driver -> !emfDriversWithoutBob || !"Bob".equals(driver.getName()))
			.comparator((first, second) -> emfDriversSortedByName ? first.getName().compareTo(second.getName()) : 0)
			.canBeNull(() -> emfDriverCanBeNull)
			.addButton(Buttons.clear())
			.create();
		// copy:end
	}

	private void emfAutocompleteEditor(Composite parent, WritableValue<TruckEMF> selectedTruck, IObservableList<DriverEMF> drivers) {
		// copy:emfAutocompleteEditor
		Sections
			.<TruckEMF, DriverEMF>emfAutoCompleteEditor(selectedTruck)
			.parent(parent)
			.feature(DatamodelPackage.Literals.TRUCK_EMF__DRIVER)
			.label("Driver")
			.elements(drivers)
			.format(DatamodelPackage.Literals.DRIVER_EMF__NAME)
			.create();
		// copy:end
	}

	private void emfEnumEditor(Composite parent, WritableValue<TruckEMF> selectedTruck) {
		// copy:emfEnumEditor
		Sections
			.<TruckEMF, TruckType>emfEnumEditor(selectedTruck)
			.parent(parent)
			.feature(DatamodelPackage.Literals.TRUCK_EMF__TYPE)
			.label("Type")
			.elements(TruckType.values())
			.format((truck, type) -> type.getName())
			.create();
		// copy:end
	}

	private void emfBooleanEditor(Composite parent, WritableValue<TruckEMF> selectedTruck) {
		// copy:emfBooleanEditor
		Sections
			.emfCheckBoxEditor(selectedTruck)
			.parent(parent)
			.feature(DatamodelPackage.Literals.TRUCK_EMF__ACTIVE)
			.label("Active")
			.create();
		// copy:end
	}

	private void emfLocalDateTimeEditor(Composite parent, WritableValue<TruckEMF> selectedTruck) {
		// copy:emfLocalDateTimeEditor
		Sections
			.emfLocalDateTimeEditor(selectedTruck)
			.parent(parent)
			.feature(DatamodelPackage.Literals.TRUCK_EMF__LAST_SERVICE)
			.label("Last service")
			.create();
		// copy:end
	}

	private void emfLocalTimeEditor(Composite parent, WritableValue<TruckEMF> selectedTruck) {
		// copy:emfLocalTimeEditor
		Sections
			.emfLocalTimeEditor(selectedTruck)
			.parent(parent)
			.feature(DatamodelPackage.Literals.TRUCK_EMF__DEPARTURE_TIME)
			.label("Departure time")
			.create();
		// copy:end
	}

	private void emfColorEditor(Composite parent, WritableValue<TruckEMF> selectedTruck) {
		// copy:emfColorEditor
		Sections
			.emfColorEditor(selectedTruck)
			.parent(parent)
			.feature(DatamodelPackage.Literals.TRUCK_EMF__COLOR)
			.label("Color")
			.create();
		// copy:end
	}

	private void emfRealDistributionEditor(Composite parent, WritableValue<TruckEMF> selectedTruck) {
		// copy:emfRealDistributionEditor
		Sections
			.emfRealDistributionEditor(selectedTruck)
			.parent(parent)
			.feature(DatamodelPackage.Literals.TRUCK_EMF__LOADING_TIME)
			.label("Loading time, min")
			.create();
		// copy:end
	}

	private void emfTimeSeriesEditor(Composite parent, WritableValue<TruckEMF> selectedTruck) {
		// copy:emfTimeSeriesEditor
		Sections
			.emfTimeSeriesEditor(selectedTruck)
			.parent(parent)
			.feature(DatamodelPackage.Literals.TRUCK_EMF__SCHEDULE)
			.label("Schedule")
			.create();
		// copy:end
	}

	private void emfVisible(Composite parent, WritableValue<TruckEMF> selectedTruck) {
		Sections.emfCheckBoxEditor(selectedTruck).parent(parent).feature(DatamodelPackage.Literals.TRUCK_EMF__ACTIVE).label("Active")
			.create();

		// copy:emfVisible
		Sections
			.emfDoubleEditor(selectedTruck)
			.parent(parent)
			.feature(DatamodelPackage.Literals.TRUCK_EMF__CAPACITY)
			.label("Capacity")
			.validationStrategy(ValidationStrategies.doublePositive())
			.visible(truck -> truck != null && truck.isActive()) // shown for active trucks only
			.observableFeatures(DatamodelPackage.Literals.TRUCK_EMF__ACTIVE) // no updateVisible() call is needed
			.create();
		// copy:end
	}

	private void emfEnabled(Composite parent, WritableValue<TruckEMF> selectedTruck) {
		// copy:emfEnabled
		Sections
			.emfStringEditor(selectedTruck)
			.parent(parent)
			.feature(DatamodelPackage.Literals.TRUCK_EMF__NAME)
			.label("Name")
			.validationStrategy(ValidationStrategies.stringIsNotEmpty())
			.create();

		Sections
			.emfCheckBoxEditor(selectedTruck)
			.parent(parent)
			.feature(DatamodelPackage.Literals.TRUCK_EMF__ACTIVE)
			.label("Active")
			.create();

		Sections
			.emfDoubleEditor(selectedTruck)
			.parent(parent)
			.feature(DatamodelPackage.Literals.TRUCK_EMF__CAPACITY)
			.label(truck -> truck == null ? "Capacity" : "Capacity of " + truck.getName())
			.validationStrategy(ValidationStrategies.doublePositive())
			.enabled(truck -> truck != null && truck.isActive()) // the field is enabled for active trucks only
			.observableFeatures(DatamodelPackage.Literals.TRUCK_EMF__NAME, DatamodelPackage.Literals.TRUCK_EMF__ACTIVE) // features the functions read
			.create();

		Button undo = new Button(parent, SWT.PUSH);
		undo.setText("Undo");
		undo.addListener(SWT.Selection, e -> CommandsManager.getEditingDomain().getCommandStack().undo());

		// A label that reads a feature of the referenced driver
		Sections
			.emfStringEditor(selectedTruck)
			.parent(parent)
			.feature(DatamodelPackage.Literals.TRUCK_EMF__NAME)
			.label(truck -> truck == null || truck.getDriver() == null ? "Name" : "Name (driver " + truck.getDriver().getName() + ")")
			.validationStrategy(ValidationStrategies.stringIsNotEmpty())
			.observableFeaturePaths(FeaturePath.fromList(DatamodelPackage.Literals.TRUCK_EMF__DRIVER, DatamodelPackage.Literals.DRIVER_EMF__NAME))
			.create();
		// copy:end
	}

	private void emfTooltip(Composite parent, WritableValue<TruckEMF> selectedTruck) {
		// copy:emfTooltip
		Sections
			.emfStringEditor(selectedTruck)
			.parent(parent)
			.feature(DatamodelPackage.Literals.TRUCK_EMF__NAME)
			.label("Name")
			.validationStrategy(ValidationStrategies.stringIsNotEmpty())
			.toolTip("<b>Name</b> of the truck<br/><li>shown in the lists<br/><li>cannot be empty")
			.create();
		// copy:end
	}

	private void emfLabelProperties(Composite parent, WritableValue<TruckEMF> selectedTruck) {
		// copy:emfLabelProperties
		Sections
			.emfDoubleEditor(selectedTruck)
			.parent(parent)
			.feature(DatamodelPackage.Literals.TRUCK_EMF__CAPACITY)
			.label("Capacity")
			.validationStrategy(ValidationStrategies.doublePositive())
			.labelProperties(LabelProperties.label()
				.foreground(Display.getDefault().getSystemColor(SWT.COLOR_DARK_BLUE))
				.font(boldFont))
			.create();
		// copy:end
	}

	private void emfTextProperties(Composite parent, WritableValue<TruckEMF> selectedTruck) {
		// copy:emfTextProperties
		Sections
			.emfStringEditor(selectedTruck)
			.parent(parent)
			.feature(DatamodelPackage.Literals.TRUCK_EMF__NAME)
			.label("Name")
			.validationStrategy(ValidationStrategies.stringIsNotEmpty())
			.textProperties(TextProperties.newInstance()
				.width(150)
				.font(boldFont))
			.create();
		// copy:end
	}

	private void emfComboBoxProperties(Composite parent, WritableValue<TruckEMF> selectedTruck, IObservableList<DriverEMF> drivers) {
		// copy:emfComboBoxProperties
		Sections
			.<TruckEMF, DriverEMF>emfComboBoxEditor(selectedTruck)
			.parent(parent)
			.feature(DatamodelPackage.Literals.TRUCK_EMF__DRIVER)
			.label("Driver")
			.elements(drivers)
			.format(DatamodelPackage.Literals.DRIVER_EMF__NAME)
			.comboBoxProperties(ComboBoxProperties.newInstance()
				.width(150)
				.font(italicFont))
			.create();
		// copy:end
	}

	private void emfAddButton(Composite parent, WritableValue<TruckEMF> selectedTruck) {
		// copy:emfAddButton
		Sections
			.emfDoubleEditor(selectedTruck)
			.parent(parent)
			.feature(DatamodelPackage.Literals.TRUCK_EMF__CAPACITY)
			.label("Capacity")
			.validationStrategy(ValidationStrategies.doublePositive())
			.addButton(Buttons.<TruckEMF, Double>emfButton() // the action gets the object and the feature
				.action((event, truck, feature) -> {
					MessageBox messageBox = new MessageBox(parent.getShell(), SWT.ICON_INFORMATION);
					messageBox.setMessage(feature.getName() + " of " + truck.getName() + " = " + truck.eGet(feature));
					messageBox.open();
				}))
			.create();
		// copy:end
	}

	private boolean emfButtonVisible = true;
	private boolean emfButtonEnabled = true;
	private ITextSection<Double> emfButtonSection;

	private void emfCommonButtonSettings(Composite parent, WritableValue<TruckEMF> selectedTruck) {
		Sections.checkBoxEditor(() -> emfButtonVisible).parent(parent).label("Show the button")
			.handler(newValue -> { emfButtonVisible = newValue; emfButtonSection.updateSection(); }).create();
		Sections.checkBoxEditor(() -> emfButtonEnabled).parent(parent).label("Enable the button")
			.handler(newValue -> { emfButtonEnabled = newValue; emfButtonSection.updateSection(); }).create();

		// copy:emfCommonButtonSettings
		emfButtonSection = Sections
			.emfDoubleEditor(selectedTruck)
			.parent(parent)
			.feature(DatamodelPackage.Literals.TRUCK_EMF__CAPACITY)
			.label("Capacity")
			.validationStrategy(ValidationStrategies.doublePositive())
			.addButton(Buttons.<TruckEMF, Double>emfButton()
				.text("Double it")
				.toolTip("Doubles the capacity with a command, so Undo reverts it")
				.width(100)
				.visible(() -> emfButtonVisible)
				.enabled(() -> emfButtonEnabled)
				.action((event, truck, feature) -> CommandsManager.getEditingDomain().getCommandStack().execute(
						SetCommand.create(CommandsManager.getEditingDomain(), truck, feature, truck.getCapacity() * 2))))
			.create();
		// copy:end
	}

	private void emfSectionGroup(Composite parent, WritableValue<TruckEMF> selectedTruck) {
		// copy:emfSectionGroup
		SectionGroup group = new SectionGroup(parent, SWT.NONE);
		group.labelWidth(200); // one width for all labels of the group

		Sections.emfStringEditor(selectedTruck).parent(group).feature(DatamodelPackage.Literals.TRUCK_EMF__NAME).label("Name")
			.validationStrategy(ValidationStrategies.stringIsNotEmpty())
			.create();
		Sections.emfIntegerEditor(selectedTruck).parent(group).feature(DatamodelPackage.Literals.TRUCK_EMF__AXLES).label("Number of axles")
			.validationStrategy(ValidationStrategies.integerBetweenValues(2, 10))
			.create();
		// copy:end
	}

	private void emfSelectElementFromTable(Composite parent, WritableValue<TruckEMF> selectedTruck, IObservableList<DriverEMF> drivers) {
		// copy:emfSelectElementFromTable
		Sections
			.<TruckEMF, DriverEMF>emfComboBoxEditor(selectedTruck)
			.parent(parent)
			.feature(DatamodelPackage.Literals.TRUCK_EMF__DRIVER)
			.label("Driver")
			.elements(drivers)
			.format(DatamodelPackage.Literals.DRIVER_EMF__NAME)
			.addButton(Buttons.<TruckEMF, DriverEMF>selectEmfElementFromTable()
				.title("driver") // shown in the dialog title
				.values(() -> drivers) // elements in the table
				.columns(table -> table.column(DriverEMF::getName).name("Name").width(200))) // table columns
			.create();
		// copy:end
	}

	@Override
	protected void disposeResources() {
		for (Font font : List.of(boldFont, italicFont)) {
			font.dispose();
		}
	}
}
