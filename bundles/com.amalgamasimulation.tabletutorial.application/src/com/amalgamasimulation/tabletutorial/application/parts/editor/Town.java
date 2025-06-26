package com.amalgamasimulation.tabletutorial.application.parts.editor;

enum Town {
	LONDON("London"), DUBLIN("Dublin"), BIRMINGHAM("Birmingham");
	
	private String name;
	
	private Town(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}