package com.amalgamasimulation.tabletutorial.testsapplication;

import java.util.List;

public abstract class TreeElement {
	
	private String name;
	
	public abstract List<TreeElement> getChildElements();
	public abstract RunResult getRunResult();
	
	public TreeElement(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

