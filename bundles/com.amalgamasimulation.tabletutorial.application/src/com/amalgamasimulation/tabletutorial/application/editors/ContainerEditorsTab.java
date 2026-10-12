package com.amalgamasimulation.tabletutorial.application.editors;

import static com.amalgamasimulation.tabletutorial.application.editors.SampleData.createDrivers;
import static com.amalgamasimulation.tabletutorial.application.editors.SampleData.createTrucks;

import java.util.List;

import org.eclipse.core.databinding.observable.value.WritableValue;
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
import com.amalgamasimulation.desktop.ui.editor.common.ICustomSection;
import com.amalgamasimulation.desktop.ui.editor.common.ITextSection;
import com.amalgamasimulation.desktop.ui.editor.sections.descriptors.ComboBoxProperties;
import com.amalgamasimulation.desktop.ui.editor.sections.descriptors.LabelProperties;
import com.amalgamasimulation.desktop.ui.editor.sections.descriptors.TextProperties;
import com.amalgamasimulation.tabletutorial.datamodel.TruckType;
import com.amalgamasimulation.utils.format.Formats;

/** Examples of containerEditors.adoc: the editors edit the object in a WritableValue. */
public class ContainerEditorsTab extends EditorsTab {

	private Font boldFont = new Font(Display.getDefault(), "Arial", 9, SWT.BOLD);
	private Font italicFont = new Font(Display.getDefault(), "Arial", 9, SWT.ITALIC);

	/**
	 * Every example has its own container and its own truck, so a change in one example does not show up in another.
	 * The drivers are shared: no example on this tab edits them.
	 */
	@Override
	protected void fill(SectionGroup parent) {
		List<Driver> drivers = createDrivers();

		refreshingEditor(title(parent, "Refreshing an editor", "refreshingEditor"));
		editingTheSelectedObject(title(parent, "Switching the edited object", "editingTheSelectedObject"), createTrucks(drivers));

		containerDoubleEditor(title(parent, "Double editor", "containerDoubleEditor"), truck(drivers));
		containerIntegerEditor(title(parent, "Integer editor", "containerIntegerEditor"), truck(drivers));
		containerStringEditor(title(parent, "String editor", "containerStringEditor"), truck(drivers));
		containerComboboxEditor(title(parent, "Combobox editor", "containerComboboxEditor"), truck(drivers), drivers);
		containerComboboxSettings(title(parent, "Combobox settings", "containerComboboxSettings"), truck(drivers), drivers);
		containerAutocompleteEditor(title(parent, "Autocomplete editor", "containerAutocompleteEditor"), truck(drivers), drivers);
		containerEnumEditor(title(parent, "Enum editor", "containerEnumEditor"), truck(drivers));
		containerBooleanEditor(title(parent, "Boolean editor", "containerBooleanEditor"), truck(drivers));
		containerLocalDateTimeEditor(title(parent, "LocalDateTime editor", "containerLocalDateTimeEditor"), truck(drivers));
		containerLocalTimeEditor(title(parent, "LocalTime editor", "containerLocalTimeEditor"), truck(drivers));
		containerColorEditor(title(parent, "Color editor", "containerColorEditor"), truck(drivers));
		containerRealDistributionEditor(title(parent, "Real distribution editor", "containerRealDistributionEditor"), truck(drivers));
		containerTimeSeriesEditor(title(parent, "Time Series editor", "containerTimeSeriesEditor"), truck(drivers));
		customSectionsNote(title(parent, "Custom section"));

		SectionGroup visibleGroup = title(parent, "visible()", "containerVisible");
		containerVisible(visibleGroup, truckSelector(visibleGroup, drivers));
		SectionGroup enabledGroup = title(parent, "enabled()", "containerEnabled");
		containerEnabled(enabledGroup, truckSelector(enabledGroup, drivers));
		containerTooltip(title(parent, "tooltip()", "containerTooltip"), truck(drivers));
		containerLabelProperties(title(parent, "labelProperties()", "containerLabelProperties"), truck(drivers));
		containerTextProperties(title(parent, "textProperties()", "containerTextProperties"), truck(drivers));
		containerComboBoxProperties(title(parent, "comboBoxProperties()", "containerComboBoxProperties"), truck(drivers), drivers);
		containerAddButton(title(parent, "addButton()", "containerAddButton"), truck(drivers));
		containerCommonButtonSettings(title(parent, "Common Button Settings", "containerCommonButtonSettings"), truck(drivers));
		containerSectionGroup(title(parent, "SectionGroup", "containerSectionGroup"), truck(drivers));

		selectElementFromTable(title(parent, "Select element from table", "selectElementFromTable"), truck(drivers), drivers);
	}

	/** A container with its own truck, so the example does not share its object with the other examples. */
	private WritableValue<Truck> truck(List<Driver> drivers) {
		return new WritableValue<>(createTrucks(drivers).get(0), Truck.class);
	}

	/** Radio buttons that switch the truck of one example. Returns the container of that example. */
	private WritableValue<Truck> truckSelector(Composite parent, List<Driver> drivers) {
		List<Truck> trucks = createTrucks(drivers);
		WritableValue<Truck> selectedTruck = new WritableValue<>(trucks.get(0), Truck.class);
		Composite radios = new Composite(parent, SWT.NONE); // own parent: radio buttons with one parent are one group
		radios.setLayout(new RowLayout());
		for (Truck truck : trucks) {
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

	private ICustomSection totalSection;

	private void refreshingEditor(Composite parent) {
		// copy:refreshingEditor
		WritableValue<Order> order = new WritableValue<>(new Order(2, 12.5), Order.class); // Order has a quantity and a price

		Sections
			.integerEditor(order)
			.parent(parent)
			.valueExtractor(Order::getQuantity)
			.label("Quantity")
			.validationStrategy(ValidationStrategies.integerPositive())
			.handler((o, newValue) -> { o.setQuantity(newValue); totalSection.updateSection(); }) // the object in the container changed
			.create();

		totalSection = Sections
			.customSectionBuilder(parent)
			.addLabel(LabelProperties.label().text("Total"))
			.addLabel(LabelProperties.label().text(() -> Formats.getDefaultFormats().customDecimals(order.getValue().getTotal(), 2)).font(boldFont)) // the text is a supplier
			.createSection();
		// copy:end
	}

	private void editingTheSelectedObject(Composite parent, List<Truck> trucks) {
		WritableValue<Truck> selectedTruck = new WritableValue<>(); // holds the object being edited

		// copy:editingTheSelectedObject
		for (Truck truck : trucks) {
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
			.stringEditor(selectedTruck)
			.parent(group)
			.valueExtractor(Truck::getName)
			.label("Name")
			.validationStrategy(ValidationStrategies.stringIsNotEmpty())
			.handler(Truck::setName)
			.create();

		Sections
			.doubleEditor(selectedTruck)
			.parent(group)
			.valueExtractor(Truck::getCapacity)
			.label("Capacity")
			.validationStrategy(ValidationStrategies.doublePositive())
			.handler(Truck::setCapacity)
			.create();
		// copy:end

		selectFirst(parent, selectedTruck, trucks.get(0)); // not in the article: start with the first truck
	}

	private void containerDoubleEditor(Composite parent, WritableValue<Truck> selectedTruck) {
		// copy:containerDoubleEditor
		Sections
			.doubleEditor(selectedTruck) // the container with the object being edited
			.parent(parent)
			.valueExtractor(Truck::getCapacity) // reads the value from the object
			.label("Capacity")
			.validationStrategy(ValidationStrategies.doublePositive())
			.handler(Truck::setCapacity) // gets the object and the new value
			.create();
		// copy:end
	}

	private void containerIntegerEditor(Composite parent, WritableValue<Truck> selectedTruck) {
		// copy:containerIntegerEditor
		Sections
			.integerEditor(selectedTruck)
			.parent(parent)
			.valueExtractor(Truck::getAxles)
			.label("Axles")
			.validationStrategy(ValidationStrategies.integerBetweenValues(2, 10))
			.handler(Truck::setAxles)
			.create();
		// copy:end
	}

	private void containerStringEditor(Composite parent, WritableValue<Truck> selectedTruck) {
		// copy:containerStringEditor
		Sections
			.stringEditor(selectedTruck)
			.parent(parent)
			.valueExtractor(Truck::getName)
			.label("Name")
			.validationStrategy(ValidationStrategies.stringIsNotEmpty())
			.handler(Truck::setName)
			.create();
		// copy:end
	}

	private void containerComboboxEditor(Composite parent, WritableValue<Truck> selectedTruck, List<Driver> drivers) {
		// copy:containerComboboxEditor
		Sections
			.<Truck, Driver>comboBoxEditor(selectedTruck) // the object type and the element type
			.parent(parent)
			.valueExtractor(Truck::getDriver)
			.label("Driver")
			.elements(drivers)
			.format((truck, driver) -> driver.getName()) // gets the object and the element
			.handler(Truck::setDriver)
			.create();
		// copy:end
	}

	private boolean driversWithExperienceOnly = false;
	private boolean driversSortedByName = false;
	private boolean driverCanBeNull = false;
	private IComboBoxSection<Driver> driverSettingsSection;

	private void containerComboboxSettings(Composite parent, WritableValue<Truck> selectedTruck, List<Driver> drivers) {
		Sections.checkBoxEditor(() -> driversWithExperienceOnly).parent(parent).label("filter(): 5+ years of experience")
			.handler(newValue -> { driversWithExperienceOnly = newValue; driverSettingsSection.updateSection(); }).create();
		Sections.checkBoxEditor(() -> driversSortedByName).parent(parent).label("comparator(): sort by name")
			.handler(newValue -> { driversSortedByName = newValue; driverSettingsSection.updateSection(); }).create();
		Sections.checkBoxEditor(() -> driverCanBeNull).parent(parent).label("canBeNull()")
			.handler(newValue -> { driverCanBeNull = newValue; driverSettingsSection.updateSection(); }).create();

		// copy:containerComboboxSettings
		driverSettingsSection = Sections
			.<Truck, Driver>comboBoxEditor(selectedTruck)
			.parent(parent)
			.valueExtractor(Truck::getDriver)
			.label("Driver")
			.elements(drivers)
			.format((truck, driver) -> driver.getName())
			.handler(Truck::setDriver)
			.filter(driver -> !driversWithExperienceOnly || driver.getExperience() >= 5)
			.comparator((first, second) -> driversSortedByName ? first.getName().compareTo(second.getName()) : 0)
			.canBeNull(() -> driverCanBeNull)
			.addButton(Buttons.clear())
			.create();
		// copy:end
	}

	private void containerAutocompleteEditor(Composite parent, WritableValue<Truck> selectedTruck, List<Driver> drivers) {
		// copy:containerAutocompleteEditor
		Sections
			.<Truck, Driver>autoCompleteEditor(selectedTruck)
			.parent(parent)
			.valueExtractor(Truck::getDriver)
			.label("Driver")
			.elements(drivers)
			.format((truck, driver) -> driver.getName())
			.handler(Truck::setDriver)
			.create();
		// copy:end
	}

	private void containerEnumEditor(Composite parent, WritableValue<Truck> selectedTruck) {
		// copy:containerEnumEditor
		Sections
			.<Truck, TruckType>enumEditor(selectedTruck)
			.parent(parent)
			.valueExtractor(Truck::getType)
			.label("Type")
			.elements(TruckType.values())
			.format((truck, type) -> type.getName())
			.handler(Truck::setType)
			.create();
		// copy:end
	}

	private void containerBooleanEditor(Composite parent, WritableValue<Truck> selectedTruck) {
		// copy:containerBooleanEditor
		Sections
			.checkBoxEditor(selectedTruck)
			.parent(parent)
			.valueExtractor(Truck::isActive)
			.label("Active")
			.handler(Truck::setActive)
			.create();
		// copy:end
	}

	private void containerLocalDateTimeEditor(Composite parent, WritableValue<Truck> selectedTruck) {
		// copy:containerLocalDateTimeEditor
		Sections
			.localDateTimeEditor(selectedTruck)
			.parent(parent)
			.valueExtractor(Truck::getLastService)
			.label("Last service")
			.handler(Truck::setLastService)
			.create();
		// copy:end
	}

	private void containerLocalTimeEditor(Composite parent, WritableValue<Truck> selectedTruck) {
		// copy:containerLocalTimeEditor
		Sections
			.localTimeEditor(selectedTruck)
			.parent(parent)
			.valueExtractor(Truck::getDepartureTime)
			.label("Departure time")
			.handler(Truck::setDepartureTime)
			.create();
		// copy:end
	}

	private void containerColorEditor(Composite parent, WritableValue<Truck> selectedTruck) {
		// copy:containerColorEditor
		Sections
			.colorEditor(selectedTruck)
			.parent(parent)
			.valueExtractor(Truck::getColor)
			.label("Color")
			.handler(Truck::setColor)
			.create();
		// copy:end
	}

	private void containerRealDistributionEditor(Composite parent, WritableValue<Truck> selectedTruck) {
		// copy:containerRealDistributionEditor
		Sections
			.realDistributionEditor(selectedTruck)
			.parent(parent)
			.valueExtractor(Truck::getLoadingTime)
			.label("Loading time, min")
			.handler(Truck::setLoadingTime)
			.create();
		// copy:end
	}

	private void containerTimeSeriesEditor(Composite parent, WritableValue<Truck> selectedTruck) {
		// copy:containerTimeSeriesEditor
		Sections
			.timeSeriesEditor(selectedTruck)
			.parent(parent)
			.valueExtractor(Truck::getSchedule)
			.label("Schedule")
			.handler(Truck::setSchedule)
			.create();
		// copy:end
	}

	private ITextSection<Double> activeCapacitySection;

	private void containerVisible(Composite parent, WritableValue<Truck> selectedTruck) {
		Sections.checkBoxEditor(selectedTruck).parent(parent).valueExtractor(Truck::isActive).label("Active")
			.handler((truck, active) -> {
				truck.setActive(active);
				activeCapacitySection.updateVisible(); // the same object changed, so the section is refreshed here
			})
			.create();

		// copy:containerVisible
		activeCapacitySection = Sections
			.doubleEditor(selectedTruck)
			.parent(parent)
			.valueExtractor(Truck::getCapacity)
			.label("Capacity")
			.validationStrategy(ValidationStrategies.doublePositive())
			.handler(Truck::setCapacity)
			.visible(truck -> truck != null && truck.isActive()) // shown for active trucks only
			.create();
		// copy:end
	}

	private void containerEnabled(Composite parent, WritableValue<Truck> selectedTruck) {
		// copy:containerEnabled
		ITextSection<Double> capacitySection = Sections
			.doubleEditor(selectedTruck)
			.parent(parent)
			.valueExtractor(Truck::getCapacity)
			.label(truck -> truck == null ? "Capacity" : "Capacity of " + truck.getName())
			.validationStrategy(ValidationStrategies.doublePositive())
			.handler(Truck::setCapacity)
			.enabled(truck -> truck != null && truck.isActive()) // the field is enabled for active trucks only
			.create(); // returns the section
		// copy:end

		// The code changes the same object, so it refreshes the section itself
		Sections.customSectionBuilder(parent)
			.addButton(Buttons.separateButton()
				.text("Add 10 to the capacity in code")
				.width(200) // the default width fits only a short text
				.handler(e -> {
					Truck truck = selectedTruck.getValue();
					if (truck != null) {
						truck.setCapacity(truck.getCapacity() + 10);
						capacitySection.updateSection();
					}
				}))
			.createSection();
	}

	private void containerTooltip(Composite parent, WritableValue<Truck> selectedTruck) {
		// copy:containerTooltip
		Sections
			.stringEditor(selectedTruck)
			.parent(parent)
			.valueExtractor(Truck::getName)
			.label("Name")
			.validationStrategy(ValidationStrategies.stringIsNotEmpty())
			.handler(Truck::setName)
			.toolTip("<b>Name</b> of the truck<br/><li>shown in the lists<br/><li>cannot be empty")
			.create();
		// copy:end
	}

	private void containerLabelProperties(Composite parent, WritableValue<Truck> selectedTruck) {
		// copy:containerLabelProperties
		Sections
			.doubleEditor(selectedTruck)
			.parent(parent)
			.valueExtractor(Truck::getCapacity)
			.label("Capacity")
			.validationStrategy(ValidationStrategies.doublePositive())
			.handler(Truck::setCapacity)
			.labelProperties(LabelProperties.label()
				.foreground(Display.getDefault().getSystemColor(SWT.COLOR_DARK_BLUE))
				.font(boldFont))
			.create();
		// copy:end
	}

	private void containerTextProperties(Composite parent, WritableValue<Truck> selectedTruck) {
		// copy:containerTextProperties
		Sections
			.stringEditor(selectedTruck)
			.parent(parent)
			.valueExtractor(Truck::getName)
			.label("Name")
			.validationStrategy(ValidationStrategies.stringIsNotEmpty())
			.handler(Truck::setName)
			.textProperties(TextProperties.newInstance()
				.width(150)
				.font(boldFont))
			.create();
		// copy:end
	}

	private void containerComboBoxProperties(Composite parent, WritableValue<Truck> selectedTruck, List<Driver> drivers) {
		// copy:containerComboBoxProperties
		Sections
			.<Truck, Driver>comboBoxEditor(selectedTruck)
			.parent(parent)
			.valueExtractor(Truck::getDriver)
			.label("Driver")
			.elements(drivers)
			.format((truck, driver) -> driver.getName())
			.handler(Truck::setDriver)
			.comboBoxProperties(ComboBoxProperties.newInstance()
				.width(150)
				.font(italicFont))
			.create();
		// copy:end
	}

	private void containerAddButton(Composite parent, WritableValue<Truck> selectedTruck) {
		// copy:containerAddButton
		Sections
			.doubleEditor(selectedTruck)
			.parent(parent)
			.valueExtractor(Truck::getCapacity)
			.label("Capacity")
			.validationStrategy(ValidationStrategies.doublePositive())
			.handler(Truck::setCapacity)
			.addButton(Buttons.<Truck, Double>containerButton() // the action gets the object and the value
				.action((event, truck, value) -> {
					MessageBox messageBox = new MessageBox(parent.getShell(), SWT.ICON_INFORMATION);
					messageBox.setMessage("Capacity of " + truck.getName() + " = " + value);
					messageBox.open();
				}))
			.create();
		// copy:end
	}

	private boolean truckButtonVisible = true;
	private boolean truckButtonEnabled = true;
	private ITextSection<Double> truckButtonSection;

	private void containerCommonButtonSettings(Composite parent, WritableValue<Truck> selectedTruck) {
		Sections.checkBoxEditor(() -> truckButtonVisible).parent(parent).label("Show the button")
			.handler(newValue -> { truckButtonVisible = newValue; truckButtonSection.updateSection(); }).create();
		Sections.checkBoxEditor(() -> truckButtonEnabled).parent(parent).label("Enable the button")
			.handler(newValue -> { truckButtonEnabled = newValue; truckButtonSection.updateSection(); }).create();

		// copy:containerCommonButtonSettings
		truckButtonSection = Sections
			.doubleEditor(selectedTruck)
			.parent(parent)
			.valueExtractor(Truck::getCapacity)
			.label("Capacity")
			.validationStrategy(ValidationStrategies.doublePositive())
			.handler(Truck::setCapacity)
			.addButton(Buttons.<Truck, Double>containerButton()
				.text("Double it")
				.toolTip("Doubles the capacity")
				.width(100)
				.visible(() -> truckButtonVisible)
				.enabled(() -> truckButtonEnabled)
				.action((event, truck, value) -> {
					truck.setCapacity(value * 2);
					truckButtonSection.updateSection();
				}))
			.create();
		// copy:end
	}

	private void containerSectionGroup(Composite parent, WritableValue<Truck> selectedTruck) {
		// copy:containerSectionGroup
		SectionGroup group = new SectionGroup(parent, SWT.NONE);
		group.labelWidth(200); // one width for all labels of the group

		Sections.stringEditor(selectedTruck).parent(group).valueExtractor(Truck::getName).label("Name")
			.validationStrategy(ValidationStrategies.stringIsNotEmpty())
			.handler(Truck::setName)
			.create();
		Sections.integerEditor(selectedTruck).parent(group).valueExtractor(Truck::getAxles).label("Number of axles")
			.validationStrategy(ValidationStrategies.integerBetweenValues(2, 10))
			.handler(Truck::setAxles)
			.create();
		// copy:end
	}

	private void selectElementFromTable(Composite parent, WritableValue<Truck> selectedTruck, List<Driver> drivers) {
		// copy:selectElementFromTable
		Sections
			.<Truck, Driver>comboBoxEditor(selectedTruck)
			.parent(parent)
			.valueExtractor(Truck::getDriver)
			.label("Driver")
			.elements(drivers)
			.format((truck, driver) -> driver.getName())
			.handler(Truck::setDriver)
			.addButton(Buttons.<Truck, Driver>selectElementFromTable()
				.title("driver") // shown in the dialog title
				.values(() -> drivers) // elements in the table
				.columns(table -> table.column(Driver::getName).name("Name").width(200))) // table columns
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
