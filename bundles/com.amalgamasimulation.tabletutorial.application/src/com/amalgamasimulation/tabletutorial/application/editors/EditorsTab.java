package com.amalgamasimulation.tabletutorial.application.editors;

import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.amalgamasimulation.desktop.ui.editor.Buttons;
import com.amalgamasimulation.desktop.ui.editor.SectionGroup;
import com.amalgamasimulation.desktop.ui.editor.Sections;
import com.amalgamasimulation.desktop.ui.editor.sections.descriptors.LabelProperties;
import com.amalgamasimulation.desktop.utils.DisplayUtils;

/**
 * A tab of the editor examples. {@link #create(Composite)} builds one tab without the others,
 * so a single tab can be opened and tried alone.
 * The Copy code button of an example copies its code, see {@link CodeSnippets}.
 */
public abstract class EditorsTab {

	private static final int LABEL_WIDTH = 230;
	private static final int TITLE_HEIGHT = 30;

	private static final String CODE_HINT = "Press Copy code to see the code here";
	private static final int CODE_LINES = 20;
	private static final int CODE_GAP = DisplayUtils.getRelativeSize(15);
	private static final int CODE_MARGIN = DisplayUtils.getRelativeSize(10);
	private static final int CODE_MIN_WIDTH = DisplayUtils.getRelativeSize(100);

	private final Font titleFont = new Font(Display.getDefault(), "Arial", 12, SWT.BOLD);
	private final Font codeFont = new Font(Display.getDefault(), "Consolas", 9, SWT.NORMAL);
	private CodeSnippets snippets = new CodeSnippets(getClass());
	private Text codeText;

	/**
	 * Creates the scrolled white page of the tab in the parent and fills it with the examples.
	 * The field with the copied code is a child of the scrolled composite, so it stays at the top when the page scrolls.
	 */
	public Control create(Composite parent) {
		ScrolledComposite scroll = new ScrolledComposite(parent, SWT.V_SCROLL | SWT.H_SCROLL);
		scroll.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		scroll.setExpandHorizontal(true); // the page height follows its content, so rows added later are scrolled too
		SectionGroup page = new SectionGroup(scroll, SWT.NONE);
		page.labelWidth(LABEL_WIDTH); // fixed: some labels change their text after the tab is created
		page.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		page.setBackgroundMode(SWT.INHERIT_DEFAULT);
		if (copyButtons()) {
			GridLayout layout = new GridLayout(2, false); // the sections on the left, the copy buttons on the right
			layout.horizontalSpacing = DisplayUtils.getRelativeSize(10);
			page.setLayout(layout);
		} else {
			page.setLayout(new GridLayout(1, false));
		}
		page.addDisposeListener(e -> {
			titleFont.dispose();
			codeFont.dispose();
			disposeResources();
		});
		fill(page);

		scroll.setContent(page);
		scroll.setMinWidth(page.computeSize(SWT.DEFAULT, SWT.DEFAULT).x);
		page.setSize(page.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		if (copyButtons()) {
			createCodeText(scroll, page);
		}
		return scroll;
	}

	/** Creates the field with the copied code. */
	private void createCodeText(ScrolledComposite scroll, Composite page) {
		codeText = new Text(scroll, SWT.MULTI | SWT.READ_ONLY | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		codeText.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		codeText.setFont(codeFont);
		codeText.setText(CODE_HINT);
		codeText.moveAbove(null);
		scroll.addListener(SWT.Resize, e -> placeCodeText(scroll, page));
		page.addListener(SWT.Move, e -> placeCodeText(scroll, page)); // horizontal scrolling moves the buttons
		page.addListener(SWT.Resize, e -> placeCodeText(scroll, page));
		for (Control child : page.getChildren()) { // the page lays out its children after its own resize
			child.addListener(SWT.Move, e -> placeCodeText(scroll, page));
			child.addListener(SWT.Resize, e -> placeCodeText(scroll, page));
		}
		placeCodeText(scroll, page);
	}

	/** Puts the code field between the examples and the scroll bar, at the top. Hides it if there is no room. */
	private void placeCodeText(ScrolledComposite scroll, Composite page) {
		if (codeText == null || codeText.isDisposed()) {
			return;
		}
		int examplesRight = 0; // the titles can be wider than the copy buttons
		for (Control child : page.getChildren()) {
			Rectangle bounds = child.getBounds();
			examplesRight = Math.max(examplesRight, bounds.x + bounds.width);
		}
		Rectangle area = scroll.getClientArea();
		int x = page.getLocation().x + examplesRight + CODE_GAP;
		int width = area.width - x - CODE_MARGIN;
		if (width < CODE_MIN_WIDTH) {
			codeText.setVisible(false);
			return;
		}
		int height = codeText.computeSize(SWT.DEFAULT, codeText.getLineHeight() * CODE_LINES).y;
		codeText.setBounds(x, CODE_MARGIN, width, Math.min(height, area.height - 2 * CODE_MARGIN));
		codeText.setVisible(true);
	}

	/** Copies the code of the example to the clipboard and shows it in the code field. */
	void copyCode(String copyId, Shell shell) {
		String code = snippets.copy(copyId, shell);
		if (code != null && codeText != null && !codeText.isDisposed()) {
			codeText.setText(code);
		}
	}

	/** Adds the examples of the tab to the page. */
	protected abstract void fill(SectionGroup page);

	/** Disposes the fonts of the tab. */
	protected void disposeResources() {
	}

	/** Returns {@code false} for a tab without copy buttons: its page has one column and no code field. */
	protected boolean copyButtons() {
		return true;
	}

	/** Adds the title of an example without a copy button and returns the group for its sections. */
	protected SectionGroup title(SectionGroup page, String text) {
		return title(page, text, null);
	}

	/**
	 * Adds the title and the copy button of an example and returns the group for its sections.
	 * The groups have the same label width, so the labels of all examples are in one column.
	 *
	 * @param copyId the id after {@code // copy:} in the source file of the tab
	 */
	protected SectionGroup title(SectionGroup page, String text, String copyId) {
		if (!copyButtons()) {
			addTitle(page, LabelProperties.label().text(text));
			return page;
		}
		Composite header = new Composite(page, SWT.NONE);
		GridData headerData = new GridData(SWT.FILL, SWT.TOP, false, false, 2, 1); // the title line ends at the copy button
		headerData.verticalIndent = DisplayUtils.getRelativeSize(12);
		header.setLayoutData(headerData);
		GridLayout headerLayout = new GridLayout(1, false);
		headerLayout.marginWidth = 0;
		headerLayout.marginHeight = 0;
		header.setLayout(headerLayout);
		addTitle(header, LabelProperties.fillLine()
			.text(text)
			.background(Display.getDefault().getSystemColor(SWT.COLOR_TITLE_BACKGROUND))
			.style(SWT.BORDER));

		SectionGroup group = new SectionGroup(page, SWT.NONE);
		group.labelWidth(LABEL_WIDTH); // fixed: some labels change their text after the tab is created
		int columns = copyId == null ? 2 : 1; // without the button the group takes both columns
		group.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false, columns, 1));
		group.setLayout(new GridLayout(1, false)); // parent() of a section sets the same layout, examples without sections need it too
		if (copyId == null) {
			return group;
		}

		Composite buttonCell = new Composite(page, SWT.NONE);
		buttonCell.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
		Sections.customSectionBuilder(buttonCell)
			.addButton(Buttons.separateButton()
				.text("Copy code")
				.width(DisplayUtils.getRelativeSize(90))
				.toolTip("Copy the code that creates this section")
				.handler(e -> copyCode(copyId, page.getShell())))
			.createSection();
		return group;
	}

	private void addTitle(Composite parent, LabelProperties title) {
		Sections.customSectionBuilder(parent)
			.addLabel(title
				.font(titleFont)
				.height(TITLE_HEIGHT)
				.skipCalculatingWidth(true)) // the title keeps its own width, the column of the tab is for the fields
			.createSection();
	}

	/** Checks the first radio button of the example and puts its object into the container. */
	protected static <T> void selectFirst(Composite parent, WritableValue<T> container, T first) {
		for (org.eclipse.swt.widgets.Control control : parent.getChildren()) {
			if (control instanceof Button radio && (radio.getStyle() & SWT.RADIO) != 0) {
				radio.setSelection(true);
				break;
			}
		}
		container.setValue(first);
	}

	/** Custom sections have no container or EMF version. */
	protected void customSectionsNote(Composite parent) {
		new Label(parent, SWT.NONE).setText("Custom sections are standalone only, see the Standalone tab.");
	}

	/** Returns the snippets of the tab. The checks use it. */
	CodeSnippets snippets() {
		return snippets;
	}

	/** Replaces the snippets of the tab. The checks use it to copy without the system clipboard. */
	void snippets(CodeSnippets snippets) {
		this.snippets = snippets;
	}

	/** Returns the code field. The checks use it. */
	Text codeText() {
		return codeText;
	}
}
