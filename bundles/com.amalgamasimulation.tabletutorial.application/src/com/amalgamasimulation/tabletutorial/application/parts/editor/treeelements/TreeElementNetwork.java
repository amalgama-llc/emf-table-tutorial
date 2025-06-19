package com.amalgamasimulation.tabletutorial.application.parts.editor.treeelements;

import java.util.List;

import com.amalgamasimulation.desktop.ui.editor.utils.TreeElement;
import com.amalgamasimulation.tabletutorial.application.utils.TreeElementType;
import com.amalgamasimulation.tabletutorial.datamodel.Scenario;


public class TreeElementNetwork extends TreeElement {
	private Scenario scenario;
	
	public TreeElementNetwork(Scenario scenario) {
		super(TreeElementType.NETWORK, scenario);
		this.scenario = scenario;
	}
	
	@Override
	protected List<TreeElement> createChildElements() {
		return List.of(
				createLeaf(TreeElementType.NODE, () -> scenario.getNodes().size()),
				createLeaf(TreeElementType.ARC, () -> scenario.getArcs().size())
				);
	}
}

