package com.amalgamasimulation.tabletutorial.application.parts.editor;

import java.awt.Color;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;

import com.amalgamasimulation.desktop.binding.ValidationStrategies;
import com.amalgamasimulation.desktop.ui.tables.EditableTable;
import com.amalgamasimulation.desktop.ui.tables.Tables;
import com.amalgamasimulation.utils.format.Formats;
import jakarta.annotation.PostConstruct;

public class EditableTablePart {
	
	private List<Car> cars = new ArrayList<>();
	private List<Person> people = new ArrayList<>();
	private Image homeImage = new Image( Display.getDefault(), getClass().getClassLoader().getResourceAsStream( "icons/home.png" ) );
	
	@PostConstruct
	public void createComposite(Composite parent) {
		initializeList();
		IObservableList<Car> carsObservable = new WritableList<>(cars, Car.class);

		EditableTable<Person> peopleTable = Tables
				.editable(people)
				.parent(parent)
				.create();
		
		peopleTable
			.column(Person::getName)
			.name("Name")
			.width(100)
			.textEditor()
				.strategy(ValidationStrategies.stringIsNotEmpty())
				.handler((person, name) -> person.setName(name))
			.build();
		
		peopleTable
			.column(Person::getDiscount)
			.name("Discount")
			.textEditor()
				.strategy(ValidationStrategies.doubleBetweenValues(5, 20))
				.handler((person, discount) -> person.setDiscount(discount))
			.build();
		
		peopleTable
			.column(Person::getDiscount)
			.name("Discount, %")
			.textEditor()
				.strategy(ValidationStrategies.doublePercentage())
				.handler((person, discount) -> person.setDiscount(discount))
			.build();
	
		peopleTable
			.column(Person::getAge)
			.name("Age")
			.textEditor()
				.strategy(ValidationStrategies.integerPositive())
				.handler((person, age) -> person.setAge(age))
			.build();
		
		peopleTable
			.column(Person::getCountry)
			.name("Country")
			.textEditor()
				.strategy(ValidationStrategies.stringAny()) // data update strategy
				.handler((person, country) -> person.setCountry(country)) // send cell value to certain field of object
			.build();
		
		peopleTable
			.column(Person::isPreferential)
			.name("Privilege")
			.checkBoxEditor()
				.handler((person, value) -> person.setPreferential(value)) // set action after checkbox press
				.canEdit(person -> person.getAge() > 25) // some cells can be uneditable depends on table item value
				.format(value -> value ? "YES" : "NO") // change checkbox view
			.build();
		
		peopleTable
			.column(Person::getCar)
			.name("Car")
			.format(car -> String.valueOf(car.number()))
			.comboEditor()
				.elements(carsObservable) // observable list of cars that can be chosen as current field
				.format(car -> String.valueOf(car.number())) // show car as car number
				.handler((person, car) -> person.setCar(car)) // handle chosen car value as field of person
				//.enableNullElement("NONE") // add null element in combo list and specify its value
				//.comparator((p1, p2) -> p1.getNumber() - p2.getNumber()) // add comparator for combo list
				//.maxComboBoxElementsCount(2) // max combo list size
				//.filter(car -> car.getNumber() > 50) // add filter values
			.build();
		
		peopleTable
			.column(Person::getCar)
			.name("Car")
			.format(car -> String.valueOf(car.number()))
			.autoCompleteComboEditor()
				.elements(carsObservable)
				.format(car -> String.valueOf(car.number()))
				.handler((person, car) -> {person.setCar(car);peopleTable.updateContent();})
			.build();
		
		peopleTable
			.column(Person::getCar)
			.name("Car")
			.format(car -> String.valueOf(car.number()))
			.dynamicAutoCompleteComboEditor()
				.elements(carsObservable)
				.format(car -> String.valueOf(car.number()))
				.handler((person, car) -> person.setCar(car))
				//.maxComboBoxElementsCount(2)
			.build();
		
		peopleTable
			.column(Person::getCar)
			.name("Car with max combo box elem count")
			.format(car -> String.valueOf(car.number()))
			.dynamicAutoCompleteComboEditor()
				.elements(carsObservable)
				.format(car -> String.valueOf(car.number()))
				.handler((person, car) -> person.setCar(car))
				.maxComboBoxElementsCount(2)
			.build();
		
		peopleTable
			.column(Person::getTown)
			.name("Town")
			.format(Town::getName)
			.enumComboEditor()
				.elements(Town.values()) // set combo list as enum values
				.format(Town::getName) // set format of showing enum values in combo list
				.handler((person, town) -> person.setTown(town)) // handle chosen enum value
			.build();
		
		peopleTable
			.column(Person::getCars)
			.name("Cars")
			.format(this::listFormat) // set function which perform list as string
			.<Car>multiObjectsSelectionDialogEditor() // assign list elements type as generic
				.elements(carsObservable) // observable list of all cars available to choose
				.selectedElements(person -> person.getCars()) // list of chosen cars
				.columns(dialogTable -> {
					dialogTable.column(Car::number).name("Number");
				}) // create dialog table
				.handler((person, list) -> {
					person.setCars(list);
					MessageBox messageBox = new MessageBox(parent.getShell(), 1 << 1);
					messageBox.setMessage("The cars are selected");
					messageBox.open();
					peopleTable.refresh();
					}) // handle list of chosen cars as corresponding field
			    .dialogTitle("Car selection dialog") 
			    .dialogSubTitle("Select cars and confirm selection") 
			.build();
			
		peopleTable
			.column(Person::getCountry)
			.name("Country")
			.autoCompleteTextEditor()
				.elements(new WritableList<>(List.of("Spain", "Italy", "France"), String.class)) // set IObservableList of possible values
				.format(string -> string) // in this case observable values are string by itself
				.handler((person, string) -> person.setCountry(string)) // set chosen value as certain field
				.enableNullElement("")
			.build();
		
		peopleTable
			.column(Person::getCountry)
			.name("Country")
			.width(150)
			.buttonActionEditor()
				.handler(person -> person.setCountry("Russia")) // action to do after button pressing
				.buttonText("Change country") // set custom button text
				.buttonToolTip("Change country to \"Russia\"")
			.build();
		
		peopleTable
			.column(Person::getCountry)
			.name("Country")
			.width(150)
			.buttonOnTop()
				.handler(person -> person.setCountry("Germany")) // action to do after button pressing
				.buttonWidth(20) // button width
				.buttonToolTip("Change country to \"Germany\"") // button tool tip
				.icon(homeImage) // set icon instead of default button text
			.build();
		
		peopleTable
			.column(Person::getCar)
			.name("Car")
			.format(car -> String.valueOf(car.number()))
			.objectSelectionDialogEditor()
				.elements(carsObservable) // observable list of cars that can be chosen as current field
				.columns(dialogTable -> dialogTable.column(Car::number).name("Number")) // create dialog table of cars
				.handler((person, car) -> {
					person.setCar(car);
					MessageBox messageBox = new MessageBox(parent.getShell(), 1 << 1);
					messageBox.setMessage(String.format("The car with number %d is selected", car.number()));
					messageBox.open();
					}) // handle chosen car value as field of person
			    .dialogTitle("Car selection dialog") 
			    .dialogSubTitle("Select car and confirm selection") 
			.build();
		
		peopleTable
			.column(Person::getPurchaseDate)
			.name("Purchase date")
			.width(250)
			.format(Formats.getDefaultFormats()::dayMonthLongYearHoursMinutes)
			.localDateTimeEditor()
				.handler((person, date) -> {
					person.setPurchaseDate(date);
					peopleTable.refresh();
				}) // handle date assigning
				.clearExistButton() // add clear button to dialog window
				.newDateCreator(() -> LocalDateTime.of(2025, 1, 1, 10, 10)) // set default value
				//.typeDialog().onlyDate() // only date without time
			.build();
		
		peopleTable
			.column(Person::getArriveTime)
			.name("Arrive time")
			.format(Formats.getDefaultFormats()::hoursMinutes)
			.localTimeEditor()
				.handler((person, time) -> {
					person.setArriveTime(time);
					peopleTable.refresh();
				}) // handle time assigning
			.build();

		peopleTable
			.column(Person::getFavouriteColor)
			.name("Favourite color")
			.backgroundColor(Person::getFavouriteColor)
			.colorEditor()
				.handler((person, color) -> person.setFavouriteColor(color))
			.build();
	}
	
	private void initializeList() {
		Person person1 = new Person("Alexander", 20);
		Car car1 = new Car(81, person1, Color.RED);
		person1.getCars().add(car1);
		
		Person person2 = new Person("Harry", 56);
		Car car2 = new Car(125, person2, Color.BLUE);
		person2.getCars().add(car2);
		
		Person person3 = new Person("Peter", 49);
		Car car3 = new Car(38, person3, Color.GREEN);
		person3.getCars().add(car3);
		
		people.addAll(List.of(person1, person2, person3));
		cars.addAll(List.of(car1,car2,car3));
	}
	
	private String listFormat(List<Car> list) {
		return list.stream().map(c -> c.number() + "").collect(Collectors.joining(", "));
	}
}