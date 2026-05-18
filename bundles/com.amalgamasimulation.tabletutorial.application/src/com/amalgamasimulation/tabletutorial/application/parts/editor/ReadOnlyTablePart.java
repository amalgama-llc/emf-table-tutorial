package com.amalgamasimulation.tabletutorial.application.parts.editor;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

import com.amalgamasimulation.desktop.ui.tables.Table;
import com.amalgamasimulation.desktop.ui.tables.Tables;

import jakarta.annotation.PostConstruct;

public class ReadOnlyTablePart {

	private List<Car> cars = new ArrayList<>();
	private List<Person> people = new ArrayList<>();
	
	private Image saveImage = new Image( Display.getDefault(), getClass().getClassLoader().getResourceAsStream( "icons/save_edit.png" ) );
	private Image homeImage = new Image( Display.getDefault(), getClass().getClassLoader().getResourceAsStream( "icons/home.png" ) );
	
	private Font font1 = new Font(Display.getCurrent(), "Arial", 7, 0);
	private Font font2 = new Font(Display.getCurrent(), "Times New Roman", 14, 2);
	
	@PostConstruct
	public void createComposite(Composite parent) {
		initializeList();
		Table<Car> table = Tables
				.readonly(cars)
				.parent(parent)
				.create();
		
		table
			.column(Car::owner)
			.name("Owner")
			.width(100)
			.format(Person::getName)
			.tooltip("Additional information about the owner"); 

		table
			.column(Car::color)
			.name("Color")
			.width(100)
			.format(color -> "")
			.backgroundColor(Car::color);
		
		table
			.column(Car::owner) // getting owner field from every car object
			.name("Owner")
			.width(150)
			.format(Person::getName) // show owner name in cell
			.headerIcon(homeImage)
			.font(car -> car.owner().getAge() > 50 ? font1 : font2) // assign font 
			.fontColor(car -> car.number() % 2 == 0 ? Color.RED : Color.BLUE); // assign font color
		
		table
			.column(car -> car.owner().getAge())
			.name("Owner age")
			.width(100)
			.pseudoHistogramColor(car -> car.owner().getAge() % 2 == 0 ? Color.GREEN : Color.YELLOW); // assign pseudohistogram color
		
		table
			.column(Car::number)
			.name("Number")
			.width(100)
			.icon(car -> car.number() > 100 ? homeImage : saveImage); // assign icon depends on number of car

	}
	
	private void initializeList() {
		Person person1 = new Person("Alexander", 20);
		Person person2 = new Person("Harry", 56);
		Person person3 = new Person("Peter", 49);
		people.addAll(List.of(person1, person2, person3));
		cars.addAll(List.of(
				new Car(81, person1, Color.RED),
				new Car(125, person2, Color.BLUE),
				new Car(38, person3, Color.GREEN)));
	}
}
