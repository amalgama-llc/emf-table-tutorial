package com.amalgamasimulation.tabletutorial.application.editors;

import static com.amalgamasimulation.tabletutorial.application.editors.SampleData.singleTimeSeries;

import java.awt.Color;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import org.apache.commons.math3.distribution.ConstantRealDistribution;
import org.apache.commons.math3.distribution.RealDistribution;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.swt.widgets.Spinner;

import com.amalgamasimulation.desktop.binding.ValidationStrategies;
import com.amalgamasimulation.desktop.html.HTML;
import com.amalgamasimulation.desktop.ui.editor.Buttons;
import com.amalgamasimulation.desktop.ui.editor.SectionGroup;
import com.amalgamasimulation.desktop.ui.editor.Sections;
import com.amalgamasimulation.desktop.ui.editor.common.IComboBoxSection;
import com.amalgamasimulation.desktop.ui.editor.common.ICustomSection;
import com.amalgamasimulation.desktop.ui.editor.common.ITextSection;
import com.amalgamasimulation.desktop.ui.editor.sections.descriptors.ComboBoxProperties;
import com.amalgamasimulation.desktop.ui.editor.sections.descriptors.LabelProperties;
import com.amalgamasimulation.desktop.ui.editor.sections.descriptors.TextProperties;
import com.amalgamasimulation.desktop.ui.editor.sections.descriptors.ToolTipProperties;
import com.amalgamasimulation.desktop.utils.PlatformImages;
import com.amalgamasimulation.timeseriesdatamodel.TimeSeries;
import com.amalgamasimulation.utils.format.Formats;

/** Examples of standaloneEditors.adoc: each editor reads a field and writes it back in the handler. */
public class StandaloneEditorsTab extends EditorsTab {

	@Override
	protected void fill(SectionGroup parent) {
		// Adding editors
		refreshingEditor(title(parent, "Refreshing an editor", "refreshingEditor"));
		doubleEditor(title(parent, "Double editor", "doubleEditor"));
		integerEditor(title(parent, "Integer editor", "integerEditor"));
		stringEditor(title(parent, "String editor", "stringEditor"));
		comboboxEditor(title(parent, "Combobox editor", "comboboxEditor"));
		comboboxSettings(title(parent, "Combobox settings", "comboboxSettings"));
		autocompleteEditor(title(parent, "Autocomplete editor", "autocompleteEditor"));
		enumEditor(title(parent, "Enum editor", "enumEditor"));
		booleanEditor(title(parent, "Boolean editor", "booleanEditor"));
		localDateTimeEditor(title(parent, "LocalDateTime editor", "localDateTimeEditor"));
		localTimeEditor(title(parent, "LocalTime editor", "localTimeEditor"));
		colorEditor(title(parent, "Color editor", "colorEditor"));
		realDistributionEditor(title(parent, "Real distribution editor", "realDistributionEditor"));
		timeSeriesEditor(title(parent, "Time Series editor", "timeSeriesEditor"));
		customSection(title(parent, "Custom section", "customSection"));
		customSectionExample2(title(parent, "Custom section: Example 2", "customSectionExample2"));
		separator(title(parent, "separator()", "separator"));
		fillLine(title(parent, "fillLine()", "fillLine"));
		image(title(parent, "image()", "image"));
		addComposite(title(parent, "addComposite()", "addComposite"));
		furtherCustomization(title(parent, "Further customization", "furtherCustomization"));

		// Fine-tuning
		visible(title(parent, "visible()", "visible"));
		enabled(title(parent, "enabled()", "enabled"));
		tooltip(title(parent, "tooltip()", "tooltip"));
		labelProperties(title(parent, "labelProperties()", "labelProperties"));
		textProperties(title(parent, "textProperties()", "textProperties"));
		comboBoxProperties(title(parent, "comboBoxProperties()", "comboBoxProperties"));
		addButton(title(parent, "addButton()", "addButton"));
		commonButtonSettings(title(parent, "Common Button Settings", "commonButtonSettings"));

		sectionGroup(title(parent, "SectionGroup", "sectionGroup"));
	}

	private int quantity = 2;
	private double price = 12.5;
	private ICustomSection totalSection;
	private Font boldFont = new Font(Display.getDefault(), "Arial", 9, SWT.BOLD);

	private double total() {
		return quantity * price;
	}

	private void refreshingEditor(Composite parent) {
		// copy:refreshingEditor
		Sections
			.integerEditor(() -> quantity)
			.parent(parent)
			.label("Quantity")
			.validationStrategy(ValidationStrategies.integerPositive())
			.handler(newValue -> { quantity = newValue; totalSection.updateSection(); })
			.create();

		totalSection = Sections
			.customSectionBuilder(parent)
			.addLabel(LabelProperties.label().text("Total"))
			.addLabel(LabelProperties.label().text(() -> Formats.getDefaultFormats().customDecimals(total(), 2)).font(boldFont)) // the text is a supplier
			.createSection();
		// copy:end
	}

	private double doubleValue = 2.67;

	private void doubleEditor(Composite parent) {
		// copy:doubleEditor
		Sections
			.doubleEditor(() -> doubleValue)
			.parent(parent)
			.label("Editing double")
			.validationStrategy(ValidationStrategies.doubleAny())
			.handler(newValue -> doubleValue = newValue)
			.create();
		// copy:end
	}

	private int integerValue = 2;

	private void integerEditor(Composite parent) {
		// copy:integerEditor
		Sections
			.integerEditor(() -> integerValue)
			.parent(parent)
			.label("Editing integer")
			.validationStrategy(ValidationStrategies.integerAny())
			.handler(newValue -> integerValue = newValue)
			.create();
		// copy:end
	}

	private String stringValue = "Something";

	private void stringEditor(Composite parent) {
		// copy:stringEditor
		Sections
			.stringEditor(() -> stringValue)
			.parent(parent)
			.label("Editing string")
			.validationStrategy(ValidationStrategies.stringIsNotEmpty())
			.handler(newValue -> stringValue = newValue)
			.create();
		// copy:end
	}

	/** A plain object shown in the comboboxes of the standalone examples. */
	public static class ComboboxRecord {
		private final String name;

		public ComboboxRecord(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}

	private IObservableList<ComboboxRecord> records = new WritableList<>(List.of(
			new ComboboxRecord("Name 1"), new ComboboxRecord("Name 3"), new ComboboxRecord("Name 11"),
			new ComboboxRecord("Name 13"), new ComboboxRecord("Name 4"), new ComboboxRecord("Name 2"),
			new ComboboxRecord("Name 5"), new ComboboxRecord("Name 12")), ComboboxRecord.class);

	private ComboboxRecord comboboxRecord = records.get(0);

	private void comboboxEditor(Composite parent) {
		// copy:comboboxEditor
		Sections
			.comboBoxEditor(() -> comboboxRecord)
			.parent(parent)
			.label("Editing combobox record")
			.elements(records)
			.format(ComboboxRecord::getName)
			.handler(newValue -> comboboxRecord = newValue)
			.create();
		// copy:end
	}

	private boolean canBeNull = false;
	private boolean onlyNamesWithOne = false;
	private boolean sortByName = false;
	private Predicate<ComboboxRecord> filter = rec -> !onlyNamesWithOne || rec.getName().contains("1");
	private Comparator<ComboboxRecord> comparator = (first, second) -> sortByName ? first.getName().compareTo(second.getName()) : 0;
	private IComboBoxSection<ComboboxRecord> comboboxSettingsSection;

	private void comboboxSettings(Composite parent) {
		// The switches are boolean editors too: their handlers change a condition and refresh the combobox
		Sections.checkBoxEditor(() -> onlyNamesWithOne).parent(parent).label("filter(): only names with '1'")
			.handler(newValue -> { onlyNamesWithOne = newValue; comboboxSettingsSection.updateSection(); }).create();
		Sections.checkBoxEditor(() -> sortByName).parent(parent).label("comparator(): sort by name")
			.handler(newValue -> { sortByName = newValue; comboboxSettingsSection.updateSection(); }).create();
		Sections.checkBoxEditor(() -> canBeNull).parent(parent).label("canBeNull()")
			.handler(newValue -> { canBeNull = newValue; comboboxSettingsSection.updateSection(); }).create();

		// copy:comboboxSettings
		comboboxSettingsSection = Sections
			.comboBoxEditor(() -> comboboxRecord)
			.parent(parent)
			.label("Editing combobox record")
			.elements(records)
			.format(ComboboxRecord::getName)
			.handler(newValue -> comboboxRecord = newValue)
			.canBeNull(() -> canBeNull)
			.filter(filter)
			.comparator(comparator)
			.addButton(Buttons.clear())
			.create();
		// copy:end
	}

	private ComboboxRecord autoCompleteRecord = records.get(0);

	private void autocompleteEditor(Composite parent) {
		// copy:autocompleteEditor
		Sections
			.autoCompleteEditor(() -> autoCompleteRecord)
			.parent(parent)
			.label("Editing autoComplete record")
			.elements(records)
			.format(ComboboxRecord::getName)
			.handler(newValue -> autoCompleteRecord = newValue)
			.create();
		// copy:end
	}

	private DayOfWeek dayOfWeek = DayOfWeek.FRIDAY;

	private void enumEditor(Composite parent) {
		// copy:enumEditor
		Sections.enumEditor(() -> dayOfWeek)
			.parent(parent)
			.label("Editing Day of week")
			.elements(DayOfWeek.values())
			.format(DayOfWeek::name)
			.handler(newValue -> dayOfWeek = newValue)
			.create();
		// copy:end
	}

	private boolean booleanValue = true;

	private void booleanEditor(Composite parent) {
		// copy:booleanEditor
		Sections.checkBoxEditor(() -> booleanValue)
			.parent(parent)
			.label("Editing boolean value")
			.handler(newValue -> booleanValue = newValue)
			.create();
		// copy:end
	}

	private LocalDateTime localDateTimeValue = LocalDateTime.now();

	private void localDateTimeEditor(Composite parent) {
		// copy:localDateTimeEditor
		Sections.localDateTimeEditor(() -> localDateTimeValue)
			.parent(parent)
			.label("Editing local date time")
			.handler(newValue -> localDateTimeValue = newValue)
			.create();
		// copy:end
	}

	private LocalTime localDateValue = LocalTime.now();

	private void localTimeEditor(Composite parent) {
		// copy:localTimeEditor
		Sections.localTimeEditor(() -> localDateValue)
			.parent(parent)
			.label("Editing local time")
			.handler(newValue -> localDateValue = newValue)
			.create();
		// copy:end
	}

	private Color colorValue = Color.BLUE;

	private void colorEditor(Composite parent) {
		// copy:colorEditor
		Sections.colorEditor(() -> colorValue)
			.parent(parent)
			.label("Editing color value")
			.handler(newValue -> colorValue = newValue)
			.create();
		// copy:end
	}

	private RealDistribution realDistributionValue = new ConstantRealDistribution(12);

	private void realDistributionEditor(Composite parent) {
		// copy:realDistributionEditor
		Sections.realDistributionEditor(() -> realDistributionValue)
			.parent(parent)
			.label("Editing real distribution value")
			.handler(newValue -> realDistributionValue = newValue)
			.create();
		// copy:end
	}

	private TimeSeries timeSeriesValue = singleTimeSeries(LocalDateTime.now().plusDays(1));

	private void timeSeriesEditor(Composite parent) {
		// copy:timeSeriesEditor
		Sections.timeSeriesEditor(() -> timeSeriesValue)
			.parent(parent)
			.label("Editing time series value")
			.handler(newValue -> timeSeriesValue = newValue)
			.create();
		// copy:end
	}

	private String truckName = "Truck 1";
	private DayOfWeek shiftDay = DayOfWeek.MONDAY;
	private ComboboxRecord driver = records.get(0);
	private ComboboxRecord helper = null;
	private boolean truckActive = true;
	private ICustomSection truckSection;

	private void customSection(Composite parent) {
		// copy:customSection
		truckSection = Sections
			.customSectionBuilder(parent)
			.addLabel(LabelProperties.label().text("Truck").width(40))
			.textEditor(() -> truckName)
				.validationStrategy(ValidationStrategies.stringIsNotEmpty())
				.handler(newValue -> truckName = newValue)
				.textProperties(TextProperties.newInstance().width(70))
				.create()
			.enumEditor(() -> shiftDay)
				.elements(DayOfWeek.values())
				.format(DayOfWeek::name)
				.handler(newValue -> shiftDay = newValue)
				.comboBoxProperties(ComboBoxProperties.newInstance().width(100))
				.create()
			.comboBoxEditor(() -> driver)
				.elements(records)
				.format(ComboboxRecord::getName)
				.handler(newValue -> driver = newValue)
				.comboBoxProperties(ComboBoxProperties.newInstance().width(80))
				.canBeNull(() -> true) // an empty value is allowed
				.filter(record -> record.getName().contains("1")) // only names with "1"
				.comparator(Comparator.comparing(ComboboxRecord::getName))
				.create()
			.autoCompleteEditor(() -> helper)
				.elements(records)
				.format(ComboboxRecord::getName)
				.handler(newValue -> helper = newValue)
				.textProperties(TextProperties.newInstance().width(70))
				.canBeNull(() -> true)
				.create()
			.checkBoxEditor(() -> truckActive)
				.handler(newValue -> truckActive = newValue)
				.checkBoxProperties(Buttons.checkBox().text("Active").width(60)) // the text is shown next to the checkbox
				.create()
			.addButton(Buttons.separateButton().text("Reset").width(50).handler(e -> {
				truckName = "Truck 1";
				shiftDay = DayOfWeek.MONDAY;
				driver = null;
				helper = null;
				truckActive = true;
				truckSection.updateSection(); // refreshes all input controls of the row
			}))
			.createSection();
		// copy:end
	}

	WritableValue<String> icon = new WritableValue<>("home", String.class);
	Image homeImage = PlatformImages.getImage("icons/home.png", StandaloneEditorsTab.class);
	Image propertiesImage = PlatformImages.getImage("icons/properties.png", StandaloneEditorsTab.class);
	boolean detailsVisible = true;
	boolean detailsEditable = true;
	ICustomSection detailsSection;

	private void customSectionExample2(Composite parent) {
		// copy:customSectionExample2
		Sections
			.customSectionBuilder(parent)
			.addLabel(LabelProperties.label().text("Details").skipAlignment(true)) // the label does not widen the label column of a SectionGroup
			.checkBoxEditor(() -> detailsVisible)
				.handler(newValue -> {
					detailsVisible = newValue;
					detailsSection.updateVisible();
				})
				.checkBoxProperties(Buttons.checkBox().text("Visible").width(70))
				.create()
			.checkBoxEditor(() -> detailsEditable)
				.handler(newValue -> {
					detailsEditable = newValue;
					detailsSection.updateEnabled();
				})
				.checkBoxProperties(Buttons.checkBox().text("Editable").width(70))
				.create()
			.createSection();

		detailsSection = Sections
			.customSectionBuilder(parent)
			.addLabel(LabelProperties.label()
				.text(() -> "Icon: " + icon.getValue()) // the text is read again on every updateSection()
				.width(110) // the text changes, so the width is set for the longest one
				.foreground(Display.getDefault().getSystemColor(SWT.COLOR_DARK_BLUE))
				.toolTip("Select an icon in the list"))
			.image(homeImage) // a fixed image
			.comboBoxEditor(() -> icon.getValue())
				.elements(List.of("home", "properties"))
				.format(name -> name)
				.handler(newValue -> {
					icon.setValue(newValue);
					detailsSection.updateSection();
				})
				.create()
			.image(icon) // the image follows the value in the container
				.imageExtractor(name -> "home".equals(name) ? homeImage : propertiesImage)
				.labelProperties(LabelProperties.imageWithContainer().toolTip("The selected icon"))
				.create()
			.addLabel(LabelProperties.label()
				.text("read only")
				.width(70)
				.style(SWT.RIGHT) // text alignment inside the label
				.enabled(false)) // a grey label
			.visible(() -> detailsVisible)
			.enabled(() -> detailsEditable)
			.createSection();
		// copy:end
	}

	private void separator(Composite parent) {
		// copy:separator
		Sections.customSectionBuilder(parent)
			.addLabel(LabelProperties.separator())
			.createSection();

		// or use a simpler method

		Sections.separator(parent);
		// copy:end
	}

	private Font fillLineFont = new Font(Display.getDefault(), "Arial", 15, SWT.NORMAL);

	private void fillLine(Composite parent) {
		// copy:fillLine
		Sections.customSectionBuilder(parent)
			.addLabel(LabelProperties.fillLine()
				.height(30)
				.background(Display.getDefault().getSystemColor(SWT.COLOR_GRAY))
				.text("Example fill line")
				.font(fillLineFont)).createSection();
		// copy:end
	}

	private Image image = PlatformImages.getImage("icons/cat.png", StandaloneEditorsTab.class);

	private void image(Composite parent) {
		// copy:image
		Sections.customSectionBuilder(parent)
			.addLabel(LabelProperties.image(image))
			.createSection();
		// copy:end
	}

	private Spinner spinner;
	private int spinnerValue = 5;

	private void addComposite(Composite parent) {
		// copy:addComposite
		Sections
			.customSectionBuilder(parent)
			.addLabel(LabelProperties.label().text("Rows"))
			.addComposite() // adds an empty composite to the row
				.createInternalContent(c -> { // creates your controls in the composite (required)
					Button add = new Button(c, SWT.PUSH);
					add.setText("+");
					add.addListener(SWT.Selection, e -> new Label(c, SWT.NONE).setText("Row " + (c.getChildren().length - 1)));
				})
				.create()
			.createSection();

		Sections
			.doubleEditor(() -> doubleValue)
			.parent(parent)
			.label("Editing double")
			.validationStrategy(ValidationStrategies.doubleAny())
			.handler(newValue -> doubleValue = newValue)
			.create();

		ICustomSection spinnerSection = Sections
			.customSectionBuilder(parent)
			.addLabel(LabelProperties.label().text("Spinner"))
			.addComposite()
				.createInternalContent(c -> spinner = new Spinner(c, SWT.BORDER))
				.updater(c -> spinner.setSelection(spinnerValue)) // refreshes the controls (optional)
				.create()
			.createSection();

		spinnerValue = 10;
		spinnerSection.updateSection(); // runs the updater

		// the same from a button: the code changes the value and refreshes the section
		Sections.customSectionBuilder(parent)
			.addButton(Buttons.separateButton()
				.text("Set the spinner to 20")
				.width(150) // the default width fits only a short text
				.handler(e -> {
					spinnerValue = 20;
					spinnerSection.updateSection();
				}))
			.createSection();
		// copy:end
	}

	private void furtherCustomization(Composite parent) {
		// copy:furtherCustomization
		Composite customComposite = Sections.customSectionBuilder(parent).createSection().getCompositeSection();
		GridLayout gridLayout = new GridLayout(1, false);
		customComposite.setLayout(gridLayout);

		ProgressBar progressBar = new ProgressBar(customComposite, SWT.SMOOTH);
		progressBar.setSelection(50);

		Slider slider = new Slider(customComposite, SWT.HORIZONTAL);
		slider.setMinimum(0);
		slider.setMaximum(100);
		slider.setSelection(75);
		// copy:end
	}

	private boolean editorVisibility = true;
	private ITextSection<Double> visibleSection;

	private void visible(Composite parent) {
		Sections.checkBoxEditor(() -> editorVisibility).parent(parent).label("Show the double editor")
			.handler(newValue -> { editorVisibility = newValue; visibleSection.updateVisible(); }).create();

		// copy:visible
		visibleSection = Sections
			.doubleEditor(() -> doubleValue)
			.parent(parent)
			.label("Editing double")
			.validationStrategy(ValidationStrategies.doubleAny())
			.handler(newValue -> doubleValue = newValue)
			.visible(() -> editorVisibility)
			.create();
		// copy:end
	}

	private boolean isFormEditable = true;
	private ITextSection<Double> enabledSection;

	private void enabled(Composite parent) {
		Sections.checkBoxEditor(() -> isFormEditable).parent(parent).label("Enable the double editor")
			.handler(newValue -> { isFormEditable = newValue; enabledSection.updateEnabled(); }).create();

		// copy:enabled
		enabledSection = Sections
			.doubleEditor(() -> doubleValue)
			.parent(parent)
			.label("Editing double")
			.validationStrategy(ValidationStrategies.doubleAny())
			.handler(newValue -> doubleValue = newValue)
			.enabled(() -> isFormEditable)
			.addButton(Buttons.simpleButton())
			.create();
		// copy:end
	}

	private Font font1 = new Font(Display.getDefault(), "Arial", 11, SWT.NORMAL);

	private void tooltip(Composite parent) {
		// copy:tooltip
		Sections
			.stringEditor(() -> stringValue)
			.parent(parent)
			.label("Simple string tooltip")
			.validationStrategy(ValidationStrategies.stringIsNotEmpty())
			.handler(newValue -> stringValue = newValue)
			.toolTip("This is a simple tooltip message")
			.create();

		Sections
			.stringEditor(() -> stringValue)
			.parent(parent)
			.label("Tooltip with HTML tags")
			.validationStrategy(ValidationStrategies.stringIsNotEmpty())
			.handler(newValue -> stringValue = newValue)
			.toolTip("<b>Important:</b><br/><li>Option 1<br/><li>Option 2")
			.create();

		Sections
			.stringEditor(() -> stringValue)
			.parent(parent)
			.label("Rich tooltip")
			.validationStrategy(ValidationStrategies.stringIsNotEmpty())
			.handler(newValue -> stringValue = newValue)
			.toolTip(ToolTipProperties.newInstance()
				.width(300)
				.height(300)
				.background(Color.WHITE)
				.foreground(new Color(0, 25, 102))
				.font(font1)
				.fontWeight("lighter")
				.lineHeight(1.5)
				.elements(
					HTML.header("Main title", 1),
					HTML.textBlock("Description text with <b>HTML</b> formatting"),
					HTML.header("First subtitle", 2),
					HTML.textBlock("<b>Important:</b><br/><li>Option 1<br/><li>Option 2"),
					HTML.header("Second subtitle", 2),
					HTML.textBlock("Some text"),
					HTML.linkOpenInBrowser("Tables documentation", "https://platform.amalgamasimulation.com/amalgama/DesktopUI/tables/intro.html")
				)
			)
			.create();
		// copy:end
	}

	private void labelProperties(Composite parent) {
		// copy:labelProperties
		Sections
			.doubleEditor(() -> doubleValue)
			.parent(parent)
			.label("Editing double")
			.validationStrategy(ValidationStrategies.doubleAny())
			.handler(newValue -> doubleValue = newValue)
			.labelProperties(LabelProperties.label()
				.foreground(Display.getDefault().getSystemColor(SWT.COLOR_DARK_RED))
				.background(Display.getDefault().getSystemColor(SWT.COLOR_INFO_BACKGROUND))
				.font(new Font(Display.getDefault(), "Arial", 15, SWT.BOLD))
				.height(50)
				.width(250)
				.style(SWT.BORDER | SWT.CENTER))
			.create();
		// copy:end
	}

	private String description = "The enable() setting of TextProperties affects only the Text field. "
			+ "The editor-level enabled() method disables the entire editor: label, input and buttons.";

	private void textProperties(Composite parent) {
		// copy:textProperties
		Sections
			.stringEditor(() -> description)
			.parent(parent)
			.label("Editing string")
			.validationStrategy(ValidationStrategies.stringIsNotEmpty())
			.handler(newValue -> description = newValue)
			.textProperties(TextProperties.newInstance()
				.width(300)
				.linesCount(4)
				.font(new Font(Display.getDefault(), "Arial", 13, SWT.NORMAL))
				.enabled(() -> false)
			)
			.addButton(Buttons.simpleButton()) // the button stays enabled
			.create();
		// copy:end
	}

	private void comboBoxProperties(Composite parent) {
		// copy:comboBoxProperties
		Sections
			.comboBoxEditor(() -> comboboxRecord)
			.parent(parent)
			.label("Editing combobox record")
			.elements(records)
			.format(ComboboxRecord::getName)
			.handler(newValue -> comboboxRecord = newValue)
			.comboBoxProperties(ComboBoxProperties.newInstance()
				.width(500)
				.font(new Font(Display.getDefault(), "Arial", 10, SWT.ITALIC))
				.enabled(() -> true))
			.create();
		// copy:end
	}

	private void addButton(Composite parent) {
		// copy:addButton
		Sections
			.doubleEditor(() -> doubleValue)
			.parent(parent)
			.label("Editing double")
			.validationStrategy(ValidationStrategies.doubleAny())
			.handler(newValue -> doubleValue = newValue)
			.addButton(Buttons.<Double>simpleButton()
				.action((event, value) -> {
					MessageBox messageBox = new MessageBox(parent.getShell(), SWT.ICON_INFORMATION);
					messageBox.setMessage("Current value = "+ value);
					messageBox.open();
				}))
			.create();
		// copy:end
	}

	private boolean customSimpleBtnVisibility = true;
	private boolean customSimpleBtnEnabled = true;
	private ITextSection<Double> customButtonSection;

	private void commonButtonSettings(Composite parent) {
		Sections.checkBoxEditor(() -> customSimpleBtnVisibility).parent(parent).label("Show the custom button")
			.handler(newValue -> { customSimpleBtnVisibility = newValue; customButtonSection.updateSection(); }).create();
		Sections.checkBoxEditor(() -> customSimpleBtnEnabled).parent(parent).label("Enable the custom button")
			.handler(newValue -> { customSimpleBtnEnabled = newValue; customButtonSection.updateSection(); }).create();

		// copy:commonButtonSettings
		customButtonSection = Sections
			.doubleEditor(() -> doubleValue)
			.parent(parent)
			.label("Editing double")
			.validationStrategy(ValidationStrategies.doubleAny())
			.handler(newValue -> doubleValue = newValue)
			.addButton(Buttons.<Double>simpleButton()
				.text("Custom text")
				.toolTip("Custom tooltip")
				.height(50)
				.width(150)
				.visible(() -> customSimpleBtnVisibility)
				.enabled(() -> customSimpleBtnEnabled)
				.action((event, value) -> {
					MessageBox messageBox = new MessageBox(parent.getShell(), SWT.ICON_INFORMATION);
					messageBox.setMessage("Current value = "+ value);
					messageBox.open();
				}))
			.addButton(Buttons.simpleButton())
			.create();
		// copy:end
	}

	private String name = "Truck 1";
	private double capacity = 40;
	private int maxTripsPerDay = 6;

	private void sectionGroup(Composite parent) {
		// copy:sectionGroup
		SectionGroup group = new SectionGroup(parent, SWT.NONE); // use instead of a plain Composite

		Sections
			.stringEditor(() -> name)
			.parent(group) // the section is aligned with the other sections of the group
			.label("Name")
			.validationStrategy(ValidationStrategies.stringIsNotEmpty())
			.handler(newValue -> name = newValue)
			.create();

		Sections
			.doubleEditor(() -> capacity)
			.parent(group)
			.label("Capacity")
			.validationStrategy(ValidationStrategies.doublePositive())
			.handler(newValue -> capacity = newValue)
			.create();

		Sections
			.integerEditor(() -> maxTripsPerDay)
			.parent(group)
			.label("Maximum number of trips per day")
			.validationStrategy(ValidationStrategies.integerPositive())
			.handler(newValue -> maxTripsPerDay = newValue)
			.create();
		// copy:end
	}

	@Override
	protected void disposeResources() {
		for (Font font : List.of(boldFont, fillLineFont, font1)) {
			font.dispose();
		}
	}
}
