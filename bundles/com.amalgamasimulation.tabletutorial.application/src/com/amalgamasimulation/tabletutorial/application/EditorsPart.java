package com.amalgamasimulation.tabletutorial.application;

import java.awt.Color;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.function.Predicate;

import org.apache.commons.math3.distribution.ConstantRealDistribution;
import org.apache.commons.math3.distribution.RealDistribution;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import com.amalgamasimulation.desktop.binding.ValidationStrategies;
import com.amalgamasimulation.desktop.html.HTML;
import com.amalgamasimulation.desktop.ui.editor.Buttons;
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
import com.amalgamasimulation.timeseriesdatamodel.TimeseriesdatamodelFactory;

import jakarta.annotation.PostConstruct;

public class EditorsPart {
	
	private LabelProperties commonLabelProperties = LabelProperties.label().width(250);
	
	@PostConstruct
	public void createComposite(Composite parent) {
		parent.setLayout(new GridLayout(1, false));
		parent.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		

		ScrolledComposite scrolledComposite = new ScrolledComposite(parent, SWT.None | SWT.V_SCROLL | SWT.H_SCROLL);
		scrolledComposite.setLayout(createGridLayout(0));
		scrolledComposite.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		GridData scrData = new GridData(SWT.FILL, SWT.FILL, true, true);
		scrolledComposite.setLayoutData(scrData);
		
		
		Composite sectionsComposite = new Composite(scrolledComposite, SWT.NONE);
		sectionsComposite.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		GridData gdSections = new GridData(SWT.FILL, SWT.FILL, true, false);
		sectionsComposite.setLayoutData(gdSections);
		sectionsComposite.setLayout(createGridLayout(3));
		
	
		scrolledComposite.setContent(sectionsComposite);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);

		standaloneEditors(sectionsComposite);
		fineTuneMethods(sectionsComposite);
		
		scrolledComposite.setMinSize(sectionsComposite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		
	}
	
	private void fineTuneMethods(Composite parent) {
		simpleTooltip(parent);
		advancedTooltip(parent);

		separator(parent);
		fillLine(parent);
		image(parent);
		customSwtControl(parent);
		labelProperties(parent);
		textProperties(parent);
		comboBoxProperties(parent);
		
		simpleButton(parent);
		customSimpleButton(parent);
		
	}


	private void standaloneEditors(Composite parent) {
		editorVisibility(parent);
		editorEditable(parent);
		editorDouble(parent);
		editorInteger(parent);
		editorString(parent);
		
		comboboxEditor(parent);
		enumEditor(parent);
		autoCompleteEditor(parent);
		additionalSettingsCombobox(parent);
		
		booleanEditor(parent);
		localDateTimeEditor(parent);
		localTimeEditor(parent);
		colorEditor(parent);
		timeSiriesEditor(parent);
		realDistributionEditor(parent);
		customEditor(parent);
		
	}
	


	private void customSwtControl(Composite parent) {
		Sections.customSectionBuilder(parent)
				.addLabel(LabelProperties.fillLine()
						.height(30)
						.background(Display.getDefault().getSystemColor(SWT.COLOR_GRAY))
						.text("Progress bar and Slider")
						.font(fillLineFont)).createSection();
		
		Composite customComposite = Sections.customSectionBuilder(parent).createSection().getCompositeSection();
		GridLayout gl = new GridLayout(1, false);
		customComposite.setLayout(gl);
		
		ProgressBar progressBar = new ProgressBar(customComposite, SWT.SMOOTH);
		progressBar.setSelection(50);
		
		Slider slider = new Slider(customComposite, SWT.HORIZONTAL);
		slider.setMinimum(0);
		slider.setMaximum(100);
		slider.setSelection(75);
	}
	

	private void image(Composite parent) {
		Sections.customSectionBuilder(parent)
		    .addLabel(LabelProperties.image(PlatformImages.getImage("icons/cat.png", EditorsPart.class)))
		    .createSection();
		
	}
	
	private Font fillLineFont = new Font(Display.getDefault(), "Arial", 15, SWT.NORMAL);
	private void fillLine(Composite parent) {
		Sections.customSectionBuilder(parent)
			.addLabel(LabelProperties.fillLine().height(30).background(Display.getDefault().getSystemColor(SWT.COLOR_GRAY)).text("Example fill line").font(fillLineFont)).createSection();
	}

	private int firstIntegerValue = 13;
	private int secondIntegerValue = 165;
	private int thirdIntegerValue = -91;
	private ComboboxRecord comboboxRecordCE = new ComboboxRecord("Name 1");
	private	ICustomSection tripleTextEditorsSection;
	private void customEditor(Composite parent) {
		tripleTextEditorsSection = Sections
			.customSectionBuilder(parent)
			.addLabel(LabelProperties.label().text("Example of a triple text field"))
			.textEditor(() -> firstIntegerValue)
				.validationStrategy(ValidationStrategies.integerAny())
				.handler(v -> firstIntegerValue = v)
				.textProperties(TextProperties.newInstance().width(50))
				.create()
			.textEditor(() -> secondIntegerValue)
				.validationStrategy(ValidationStrategies.integerAny())
				.handler(v -> secondIntegerValue = v)
				.textProperties(TextProperties.newInstance().width(50))
				.create()
			.textEditor(() -> thirdIntegerValue)
				.validationStrategy(ValidationStrategies.integerAny())
				.handler(v -> thirdIntegerValue = v)
				.textProperties(TextProperties.newInstance().width(50))
				.create()
			.addButton(Buttons.separateButton().text("-").handler(e -> {
				firstIntegerValue--;
				secondIntegerValue--;
				thirdIntegerValue--;
				tripleTextEditorsSection.updateSection();
			}))	
			.addButton(Buttons.separateButton().text("+").handler(e -> {
				firstIntegerValue++;
				secondIntegerValue++;
				thirdIntegerValue++;
				tripleTextEditorsSection.updateSection();
			}))	
			.createSection();
			
		IObservableList<ComboboxRecord> records = new WritableList<>();

		records.add(comboboxRecordCE);
		records.add(new ComboboxRecord("Name 3"));
		records.add(new ComboboxRecord("Name 11"));	
		records.add(new ComboboxRecord("Name 13"));	
		records.add(new ComboboxRecord("Name 4"));
		records.add(new ComboboxRecord("Name 2"));
		records.add(new ComboboxRecord("Name 5"));
		records.add(new ComboboxRecord("Name 12"));	
		
		Sections
			.customSectionBuilder(parent)
			.addLabel(LabelProperties.label().text("Example").font(new Font(Display.getDefault(), "Arial", 9, SWT.NORMAL)).width(50))
			.addLabel(LabelProperties.label().text(" bold text,").font(new Font(Display.getDefault(), "Arial", 9, SWT.BOLD)).width(60))
			.addLabel(LabelProperties.label().text(" italic text, with Combobox ").font(new Font(Display.getDefault(), "Arial", 9, SWT.ITALIC)).width(180))
			.comboBoxEditor(() -> comboboxRecordCE)
				.elements(records)
				.format(ComboboxRecord::getName)
				.handler(newValue -> comboboxRecordCE = newValue)
				.create()
			.addLabel(LabelProperties.label().text(" in the middle of the text").width(150).font(new Font(Display.getDefault(), "Arial", 9, SWT.NORMAL)))
			.createSection();
		
	}

	private Color colorValue = Color.BLUE;
	private void colorEditor(Composite parent) {
		Sections.colorEditor(() -> colorValue)
			.parent(parent)
			.label("Editing color value")
			.handler(newValue -> colorValue = newValue)
			.labelProperties(commonLabelProperties)
			.create();
	}

	private RealDistribution realDistributionValue = new ConstantRealDistribution(12);
	private void realDistributionEditor(Composite parent) {
		Sections.realDistributionEditor(() -> realDistributionValue)
			.parent(parent)
			.label("Editing real distribution value")
			.handler(newValue -> realDistributionValue = newValue)
			.labelProperties(commonLabelProperties)
			.create();
		
	}

	private TimeSeries timeSeriesValue = TimeseriesdatamodelFactory.eINSTANCE.createSingleTimeSeries();
	private void timeSiriesEditor(Composite parent) {
		Sections.timeSeriesEditor(() -> timeSeriesValue)
			.parent(parent)
			.label("Editing time series value")
			.handler(newValue -> timeSeriesValue = newValue)
			.labelProperties(commonLabelProperties)
			.create();
		
	}

	private LocalTime localTimeValue = LocalTime.now();
	private void localTimeEditor(Composite parent) {
		Sections.localTimeEditor(() -> localTimeValue)
			.parent(parent)
			.label("Editing local time")
			.handler(newValue -> localTimeValue = newValue)
			.labelProperties(commonLabelProperties)
			.create();		
	}

	private LocalDateTime localDateTimeValue = LocalDateTime.now();
	private void localDateTimeEditor(Composite parent) {
		Sections.localDateTimeEditor(() -> localDateTimeValue)
			.parent(parent)
			.label("Editing local date time")
			.handler(newValue -> localDateTimeValue = newValue)
			.labelProperties(commonLabelProperties)
			.create();
		
	}

	private boolean booleanValue = true;
	private void booleanEditor(Composite parent) {
		Sections.booleanEditor(() -> booleanValue)
			.parent(parent)
			.label("Editing boolean value")
			.handler(newValue -> booleanValue = newValue)
			.labelProperties(commonLabelProperties)
			.create();
		
	}

	private ComboboxRecord comboBoxRecord = new ComboboxRecord("Name 1");
	private IComboBoxSection<ComboboxRecord> comboBoxSection;
	private boolean setFilterB = false;
	private boolean setComparatorB = false;
	private boolean canBeNull = false;
	private Predicate<ComboboxRecord> filter = rec -> {
		if(!setFilterB) {
			return true;
		}
		return rec.name.contains("1");
	};
	private Comparator<ComboboxRecord> comparator = (o1, o2) -> {
		if(!setComparatorB) {
			return 0;
		}
		return o1.getName().compareTo(o2.getName());
	};
	
	private void additionalSettingsCombobox(Composite parent) {
		ToolBar toolBarFilter = new ToolBar(parent, SWT.HORIZONTAL | SWT.FLAT);
		ToolItem setFilter = new ToolItem(toolBarFilter, SWT.PUSH);
		setFilter.setText("Set filter (only contain '1')");
		setFilter.addSelectionListener(SelectionListener.widgetSelectedAdapter(l -> {
			setFilterB = true;
			comboBoxSection.updateSection();
		}));
		
		ToolItem unsetFilter = new ToolItem(toolBarFilter, SWT.PUSH);
		unsetFilter.setText("Unset filter");
		unsetFilter.addSelectionListener(SelectionListener.widgetSelectedAdapter(l -> {
			setFilterB = false;
			comboBoxSection.updateSection();
		}));
		
		ToolBar toolBarComparator = new ToolBar(parent, SWT.HORIZONTAL | SWT.FLAT);
		ToolItem setComparator = new ToolItem(toolBarComparator, SWT.PUSH);
		setComparator.setText("Set comparator(alphabet)");
		setComparator.addSelectionListener(SelectionListener.widgetSelectedAdapter(l -> {
			setComparatorB = true;
			comboBoxSection.updateSection();
		}));
		
		ToolItem unsetComparator = new ToolItem(toolBarComparator, SWT.PUSH);
		unsetComparator.setText("Unset comparator");
		unsetComparator.addSelectionListener(SelectionListener.widgetSelectedAdapter(l -> {
			setComparatorB = false;
			comboBoxSection.updateSection();
		}));
		
		ToolBar toolBarCanBeNull = new ToolBar(parent, SWT.HORIZONTAL | SWT.FLAT);
		ToolItem setCanBeNull = new ToolItem(toolBarCanBeNull, SWT.PUSH);
		setCanBeNull.setText("Set can be null");
		setCanBeNull.addSelectionListener(SelectionListener.widgetSelectedAdapter(l -> {
			canBeNull = true;
			comboBoxSection.updateSection();
		}));
		
		ToolItem unsetCanBeNull = new ToolItem(toolBarCanBeNull, SWT.PUSH);
		unsetCanBeNull.setText("Set can`t be null");
		unsetCanBeNull.addSelectionListener(SelectionListener.widgetSelectedAdapter(l -> {
			canBeNull = false;
			comboBoxSection.updateSection();
		}));
		
		
		IObservableList<ComboboxRecord> records = new WritableList<>();

		records.add(comboBoxRecord);
		records.add(new ComboboxRecord("Name 3"));
		records.add(new ComboboxRecord("Name 11"));	
		records.add(new ComboboxRecord("Name 13"));	
		records.add(new ComboboxRecord("Name 4"));
		records.add(new ComboboxRecord("Name 2"));
		records.add(new ComboboxRecord("Name 5"));
		records.add(new ComboboxRecord("Name 12"));
		
		comboBoxSection = Sections
			.comboboxEditor(() -> comboBoxRecord)
			.parent(parent)
			.label("Editing combobox record")
			.elements(records)
			.format(ComboboxRecord::getName)
			.handler(newValue -> comboBoxRecord = newValue)
			.canBeNull(() -> canBeNull)
			.filter(filter)
			.comparator(comparator)
			.addButton(Buttons.clear())
			.labelProperties(commonLabelProperties)
			.create();
		
	}

	private ComboboxRecord autoCompleteRecordValue = new ComboboxRecord("Name 1");
	private void autoCompleteEditor(Composite parent) {
		IObservableList<ComboboxRecord> records = new WritableList<>();

		records.add(autoCompleteRecordValue);
		records.add(new ComboboxRecord("Name 3"));
		records.add(new ComboboxRecord("Name 11"));	
		records.add(new ComboboxRecord("Name 13"));	
		records.add(new ComboboxRecord("Name 4"));
		records.add(new ComboboxRecord("Name 2"));
		records.add(new ComboboxRecord("Name 5"));
		records.add(new ComboboxRecord("Name 12"));
		
		Sections
			.autoCompleteEditor(() -> autoCompleteRecordValue)
			.parent(parent)
			.label("Editing autoComplete record")
			.elements(records)
			.format(ComboboxRecord::getName)
			.handler(newValue -> autoCompleteRecordValue = newValue)
			.canBeNull(() -> true)
			.labelProperties(commonLabelProperties)
			.create();
		
	}

	private DayOfWeek dayOfWeek = DayOfWeek.FRIDAY;
	private void enumEditor(Composite parent) {
		Sections.enumEditor(() -> dayOfWeek)
			.parent(parent)
			.label("Editing Day of week")
			.elements(DayOfWeek.values())
			.format(DayOfWeek::name)
			.handler(newValue -> dayOfWeek = newValue)
			.labelProperties(commonLabelProperties)
			.create();
	}

	private ComboboxRecord comboboxRecordValue = new ComboboxRecord("Name 1");
	private void comboboxEditor(Composite parent) {
		IObservableList<ComboboxRecord> records = new WritableList<>();

		records.add(comboboxRecordValue);
		records.add(new ComboboxRecord("Name 3"));
		records.add(new ComboboxRecord("Name 11"));	
		records.add(new ComboboxRecord("Name 13"));	
		records.add(new ComboboxRecord("Name 4"));
		records.add(new ComboboxRecord("Name 2"));
		records.add(new ComboboxRecord("Name 5"));
		records.add(new ComboboxRecord("Name 12"));
		
		Sections
			.comboboxEditor(() -> comboboxRecordValue)
			.parent(parent)
			.label("Editing combobox record")
			.elements(records)
			.format(ComboboxRecord::getName)
			.handler(newValue -> comboboxRecordValue = newValue)
			.labelProperties(commonLabelProperties)
			.create();
		
	}

	private double doubleValueCSB = 2.67;
	private boolean customSimpleBtnVisibility = true;
	private boolean customSimpleBtnEnabled = true;
	private ITextSection<Double> doubleEditorCSB;
	private void customSimpleButton(Composite parent) {
		ToolBar toolBarEnable = new ToolBar(parent, SWT.HORIZONTAL | SWT.FLAT);
		ToolItem enable = new ToolItem(toolBarEnable, SWT.PUSH);
		enable.setText("Enable button");
		enable.addSelectionListener(SelectionListener.widgetSelectedAdapter(l -> {
			customSimpleBtnEnabled = true;
			doubleEditorCSB.updateSection();
		}));
		
		ToolItem disable = new ToolItem(toolBarEnable, SWT.PUSH);
		disable.setText("Disable button");
		disable.addSelectionListener(SelectionListener.widgetSelectedAdapter(l -> {
			customSimpleBtnEnabled = false;
			doubleEditorCSB.updateSection();
		}));
		
		ToolBar toolBarVisible = new ToolBar(parent, SWT.HORIZONTAL | SWT.FLAT);
		ToolItem visible = new ToolItem(toolBarVisible, SWT.PUSH);
		visible.setText("Show button");
		visible.addSelectionListener(SelectionListener.widgetSelectedAdapter(l -> {
			customSimpleBtnVisibility = true;
			doubleEditorCSB.updateSection();
		}));
		
		ToolItem invisible = new ToolItem(toolBarVisible, SWT.PUSH);
		invisible.setText("Hide button");
		invisible.addSelectionListener(SelectionListener.widgetSelectedAdapter(l -> {
			customSimpleBtnVisibility = false;
			doubleEditorCSB.updateSection();
		}));
		
		
		doubleEditorCSB = Sections
			.doubleEditor(() -> doubleValueCSB)
			.parent(parent)
			.label("Editing double")
			.validationStrategy(ValidationStrategies.doubleAny())
			.handler(newValue -> doubleValueCSB = newValue)
			.addButton(Buttons.<Double>simpleButton()
					.text("Custom text")
					.tooltip("Custom tooltip")
					.height(50)
					.width(250)
					.setVisible(() -> customSimpleBtnVisibility)
					.setEnable(() -> customSimpleBtnEnabled)
					.action((event, value) -> {
						MessageBox messageBox = new MessageBox(parent.getShell(), SWT.ICON_INFORMATION);
						messageBox.setMessage("Current value = "+ value);
						messageBox.open();					
					}))
			.addButton(Buttons.simpleButton())
			.labelProperties(commonLabelProperties)
			.create();
		
	}

	private double doubleValueSB = 2.67;
	private void simpleButton(Composite parent) {
		Sections
			.doubleEditor(() -> doubleValueSB)
			.parent(parent)
			.label("Editing double")
			.validationStrategy(ValidationStrategies.doubleAny())
			.handler(newValue -> doubleValueSB = newValue)
			.labelProperties(commonLabelProperties)
			.addButton(Buttons.<Double>simpleButton()
					.action((event, value) -> {
						MessageBox messageBox = new MessageBox(parent.getShell(), SWT.ICON_INFORMATION);
						messageBox.setMessage("Current value = "+ value);
						messageBox.open();					
					}))
			.create();
		
	}

	private ComboboxRecord comboboxRecordValueP = new ComboboxRecord("Name 1");
	private void comboBoxProperties(Composite parent) {
		IObservableList<ComboboxRecord> records = new WritableList<>();

		records.add(comboboxRecordValueP);
		records.add(new ComboboxRecord("Name 3"));
		records.add(new ComboboxRecord("Name 11"));	
		records.add(new ComboboxRecord("Name 13"));	
		records.add(new ComboboxRecord("Name 4"));
		records.add(new ComboboxRecord("Name 2"));
		records.add(new ComboboxRecord("Name 5"));
		records.add(new ComboboxRecord("Name 12"));
		
		Sections
			.comboboxEditor(() -> comboboxRecordValueP)
			.parent(parent)
			.label("Editing combobox record")
			.elements(records)
			.format(ComboboxRecord::getName)
			.handler(newValue -> comboboxRecordValueP = newValue)
			.addButton(Buttons.simpleButton())
			.labelProperties(commonLabelProperties)
		    .comboBoxProperties(ComboBoxProperties.newInstance()
		            .width(600)
		            .setFont(new Font(Display.getDefault(), "Arial", 10, SWT.ITALIC))
		            .enable(() -> true))
			.create();
		
		
	}

	private String stringValueTP = "Note that the `enable()` setting affects only the Text field — unlike the editor-level `enabled()` method which disables the entire editor (label, input, and buttons).";
	private void textProperties(Composite parent) {
		Sections
			.stringEditor(() -> stringValueTP)
			.parent(parent)
			.label("Editing string")
			.validationStrategy(ValidationStrategies.stringIsNotEmpty())
			.handler(newValue -> stringValueTP = newValue)
			.labelProperties(commonLabelProperties)
			.textProperties(TextProperties.newInstance()
				    .width(400)
				    .linesCount(4)
				    .font(new Font(Display.getDefault(), "Arial", 10, SWT.NORMAL))
				    .enable(() -> false)
		            )
			.addButton(Buttons.simpleButton())
			.create();

		
	}


	private double doubleValueLP = 2.67;
	private void labelProperties(Composite parent) {
		Sections
		.doubleEditor(() -> doubleValueLP)
		.parent(parent)
		.label("Editing double")
		.validationStrategy(ValidationStrategies.doubleAny())
		.handler(newValue -> doubleValueLP = newValue)
		.labelProperties(LabelProperties.label()
		        .foreground(Display.getDefault().getSystemColor(SWT.COLOR_DARK_RED))
		        .background(Display.getDefault().getSystemColor(SWT.COLOR_INFO_BACKGROUND))
		        .font(new Font(Display.getDefault(), "Arial", 15, SWT.BOLD))
		        .height(50)
		        .width(250)
		        .style(SWT.BORDER | SWT.CENTER))
		.create();

		
	}


	private double doubleValueS = 2.67;
	private int integerValueS = 2;
	private void separator(Composite parent) {
		Sections
				.doubleEditor(() -> doubleValueS)
				.parent(parent)
				.label("Editing double")
				.validationStrategy(ValidationStrategies.doubleAny())
				.handler(newValue -> doubleValueS = newValue)
				.labelProperties(commonLabelProperties)
				.create();
		
		Sections.separator(parent);
		
		Sections
			.integerEditor(() -> integerValueS)
			.parent(parent)
			.label("Editing integer")
			.validationStrategy(ValidationStrategies.integerAny())
			.handler(newValue -> integerValueS = newValue)
			.labelProperties(commonLabelProperties)
			.create();
		
	}

	private String stringValueAT = "Something";
	private void advancedTooltip(Composite parent) {
		Font font1 = new Font(parent.getDisplay(), "Arial", 11, 0);
		Sections
			.stringEditor(() -> stringValueAT)
			.parent(parent)
			.label("Editing string")
			.validationStrategy(ValidationStrategies.stringIsNotEmpty())
			.handler(newValue -> stringValueAT = newValue)
			.labelProperties(commonLabelProperties)
			.tooltip(ToolTipProperties.newInstance()
				    .width(300)
				    .height(300)
				    .backgroundColor(Color.WHITE)
				    .foregroundColor(new Color(0, 25, 102))
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
		
	}


	private String stringValueST = "Something";
	private void simpleTooltip(Composite parent) {		
		Sections
			.stringEditor(() -> stringValueST)
			.parent(parent)
			.label("Editing string")
			.validationStrategy(ValidationStrategies.stringIsNotEmpty())
			.handler(newValue -> stringValueST = newValue)
			.tooltip("<b>Important:</b><br/><li>Option 1<br/><li>Option 2")
			.labelProperties(commonLabelProperties)
			.create();
	}


	private String stringValue = "Something";
	private void editorString(Composite parent) {
		Sections
			.stringEditor(() -> stringValue)
			.parent(parent)
			.label("Editing string")
			.validationStrategy(ValidationStrategies.stringIsNotEmpty())
			.handler(newValue -> stringValue = newValue)
			.labelProperties(commonLabelProperties)
			.create();
		
	}


	private int integerValue = 2;
	private void editorInteger(Composite parent) {
		Sections
			.integerEditor(() -> integerValue)
			.parent(parent)
			.label("Editing integer")
			.validationStrategy(ValidationStrategies.integerAny())
			.handler(newValue -> integerValue = newValue)
			.labelProperties(commonLabelProperties)
			.create();
		
	}


	private double doubleValue = 2.67;
	private void editorDouble(Composite parent) {
		Sections
			.doubleEditor(() -> doubleValue)
			.parent(parent)
			.label("Editing double")
			.validationStrategy(ValidationStrategies.doubleAny())
			.handler(newValue -> doubleValue = newValue)
			.labelProperties(commonLabelProperties)
			.create();
	}

	
	private double editingDoubleV = 2.67;
	private int editingIntegerV = 2;
	private ITextSection<Double> doubleEditorV;
	private boolean doubleEditorVisibility = true;
	private void editorVisibility(Composite parent) {
		ToolBar toolBar = new ToolBar(parent, SWT.HORIZONTAL | SWT.FLAT);
		ToolItem visible = new ToolItem(toolBar, SWT.PUSH);
		visible.setText("Show double editor");
		visible.addSelectionListener(SelectionListener.widgetSelectedAdapter(l -> {
			doubleEditorVisibility = true;
			doubleEditorV.updateVisible();
		}));
		
		ToolItem invisible = new ToolItem(toolBar, SWT.PUSH);
		invisible.setText("Hide double editor");
		invisible.addSelectionListener(SelectionListener.widgetSelectedAdapter(l -> {
			doubleEditorVisibility = false;
			doubleEditorV.updateVisible();
		}));
		
		doubleEditorV = Sections
			.doubleEditor(() -> editingDoubleV)
			.parent(parent)
			.label("Editing double")
			.validationStrategy(ValidationStrategies.doubleAny())
			.handler(newValue -> editingDoubleV = newValue)
			.visible(() -> doubleEditorVisibility)
			.labelProperties(commonLabelProperties)
			.create();
		
		Sections
			.integerEditor(() -> editingIntegerV)
			.parent(parent)
			.label("Editing integer")
			.validationStrategy(ValidationStrategies.integerAny())
			.handler(newValue -> editingIntegerV = newValue)
			.labelProperties(commonLabelProperties)
			.create();
		
	}
	
	private double doubleValueE = 2.67;
	private ITextSection<Double> doubleEditorE;
	private boolean isFormEditable = true;
	
	private void editorEditable(Composite parent) {
		ToolBar toolBar = new ToolBar(parent, SWT.HORIZONTAL | SWT.FLAT);
		ToolItem enable = new ToolItem(toolBar, SWT.PUSH);
		enable.setText("Enable double editor");
		enable.addSelectionListener(SelectionListener.widgetSelectedAdapter(l -> {
			isFormEditable = true;
			doubleEditorE.updateEnable();
		}));
		
		ToolItem disable = new ToolItem(toolBar, SWT.PUSH);
		disable.setText("Disable double editor");
		disable.addSelectionListener(SelectionListener.widgetSelectedAdapter(l -> {
			isFormEditable = false;
			doubleEditorE.updateEnable();
		}));
		
		doubleEditorE = Sections
			.doubleEditor(() -> doubleValueE)
			.parent(parent)
			.label("Editing double")
			.validationStrategy(ValidationStrategies.doubleAny())
			.handler(newValue -> doubleValueE = newValue)
			.enabled(() -> isFormEditable)
			.addButton(Buttons.simpleButton())
			.addButton(Buttons.simpleButton())
			.labelProperties(commonLabelProperties)
			.create();
		
		Sections
			.integerEditor(() -> integerValue)
			.parent(parent)
			.label("Editing integer")
			.validationStrategy(ValidationStrategies.integerAny())
			.handler(newValue -> integerValue = newValue)
			.labelProperties(commonLabelProperties)
			.create();
		
	}
	
	public class ComboboxRecord{
		private String name;

		public ComboboxRecord(String name) {
			super();
			this.name = name;
		}

		public String getName() {
			return name;
		}
		
	}
	
	private GridLayout createGridLayout(int value) {
		GridLayout gl = new GridLayout(1, false);
		gl.verticalSpacing = value;
		gl.horizontalSpacing = value;
		gl.marginWidth = value;
		gl.marginHeight = 0;
		return gl;
	}

}

