package com.amalgamasimulation.tabletutorial.application;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import com.amalgamasimulation.tabletutorial.application.editors.ContainerEditorsTab;
import com.amalgamasimulation.tabletutorial.application.editors.EditorsTab;
import com.amalgamasimulation.tabletutorial.application.editors.EmfEditorsTab;
import com.amalgamasimulation.tabletutorial.application.editors.ShowcaseTab;
import com.amalgamasimulation.tabletutorial.application.editors.StandaloneEditorsTab;

import jakarta.annotation.PostConstruct;

/**
 * Examples for the editor articles of the DesktopUI documentation.
 * <p>
 * Each tab matches one article and lives in its own class: {@link StandaloneEditorsTab}, {@link ContainerEditorsTab}
 * and {@link EmfEditorsTab}. The {@link ShowcaseTab} combines several features in larger examples.
 */
public class EditorsPart {

	@PostConstruct
	public void createComposite(Composite parent) {
		parent.setLayout(new GridLayout(1, false));
		CTabFolder tabs = new CTabFolder(parent, SWT.TOP | SWT.BORDER);
		tabs.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		addTab(tabs, "Standalone", new StandaloneEditorsTab());
		addTab(tabs, "Container", new ContainerEditorsTab());
		addTab(tabs, "EMF", new EmfEditorsTab());
		addTab(tabs, "Showcase", new ShowcaseTab());
		tabs.setSelection(0);
	}

	private void addTab(CTabFolder tabs, String text, EditorsTab tab) {
		CTabItem item = new CTabItem(tabs, SWT.NONE);
		item.setText(text);
		item.setControl(tab.create(tabs));
	}
}
