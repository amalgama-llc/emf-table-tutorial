package com.amalgamasimulation.tabletutorial.application.parts.editor;

import java.awt.Color;

record Car (int number, Person owner, Color color) {
	@Override
	public String toString() {
		return String.valueOf(number);
	}
}