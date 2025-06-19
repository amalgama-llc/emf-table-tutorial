package com.amalgamasimulation.tabletutorial.application.pages;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;

import com.amalgamasimulation.desktop.binding.ValidationStrategies;
import com.amalgamasimulation.desktop.ui.editor.pages.AbstractPage;
import com.amalgamasimulation.desktop.ui.tables.EMFTable;
import com.amalgamasimulation.desktop.ui.tables.Tables;
import com.amalgamasimulation.tabletutorial.datamodel.CarEMF;
import com.amalgamasimulation.tabletutorial.datamodel.Country;
import com.amalgamasimulation.tabletutorial.datamodel.DatamodelFactory;
import com.amalgamasimulation.tabletutorial.datamodel.DatamodelPackage;
import com.amalgamasimulation.tabletutorial.datamodel.PersonEMF;
import com.amalgamasimulation.tabletutorial.datamodel.Scenario;
import com.amalgamasimulation.utils.format.Formats;

public class PeoplePage extends AbstractPage<PersonEMF, Scenario> {
	
	List<PersonEMF> peopleList = new ArrayList<>();
	List<CarEMF> cars = new ArrayList<>();

	public PeoplePage() {
		super(PersonEMF::getScenario);
		initializeList();
	}

	@Override
	protected String getNameClassObject() {
		return "Person_";
	}

	@Override
	public boolean isVisible(Object selectedObject) {
		return true;
	}

	@Override
	protected void createControlsInternal() {
		
		EMFTable<PersonEMF> table = Tables.emf(peopleList).parent(parent).create();
		IObservableList<CarEMF> carsObservable = new WritableList<>(cars, CarEMF.class);	
		
		table
			.column(PersonEMF::getName)
			.name("Name")
			.emfTextEditor()
				.feature(DatamodelPackage.Literals.PERSON_EMF__NAME) // corresponding EMF feature
				.strategy(ValidationStrategies.stringIsNotEmpty()) // validation strategy
				.handler((person, string) -> {person.setName(string);})
			.build();
		
		table
			.column(PersonEMF::isIsPreferential)
			.name("Preferential")
			.emfCheckBoxEditor()
				.feature(DatamodelPackage.Literals.PERSON_EMF__IS_PREFERENTIAL) // corresponding EMF feature
				.handler((person, value) -> {person.setIsPreferential(value);})
			.build();
				
		table
			.column(PersonEMF::getFavouriteColor)
			.name("Favourite color")
			.emfColorEditor()
				.feature(DatamodelPackage.Literals.PERSON_EMF__FAVOURITE_COLOR) // corresponding EMF feature
				.handler((person, color) -> {person.setFavouriteColor(color);})
			.build();
		
		table
			.column(PersonEMF::getArriveTime)
			.name("Arrive time")
			.emfLocalTimeEditor()
				.feature(DatamodelPackage.Literals.PERSON_EMF__ARRIVE_TIME) // corresponding EMF feature
				.handler((person, time) -> {
					person.setArriveTime(time);
					table.refresh();
				})
			.build();
		
		table
			.column(PersonEMF::getPurchaseDate)
			.name("Purchase date")
			.format(Formats.getDefaultFormats()::dayMonthHoursMinutes)
			.emfLocalDateTimeEditor()
				.feature(DatamodelPackage.Literals.PERSON_EMF__PURCHASE_DATE) // corresponding EMF feature
				.handler((person, date) -> {
					person.setPurchaseDate(date);
					table.refresh();
					})
			.build();
		
		table
			.column(PersonEMF::getCars)
			.name("Cars list")
			.format(this::listAsString)
			.<CarEMF>emfMultiObjectsSelectionDialogEditor()
				.elements(carsObservable)
				.feature(DatamodelPackage.Literals.PERSON_EMF__CARS) // corresponding EMF feature
				.columns(dialogTable -> dialogTable
						.column(CarEMF::getNumber)
						.name("Car number")
						)
			.build();
		
		table
			.column(PersonEMF::getCars)
			.name("Cars list")
			.format(this::listAsString)
			.<CarEMF>emfMultiToolListDialogEditor()
				.creater(DatamodelFactory.eINSTANCE::createCarEMF) // datamodel method of creating new EMF object
				.feature(DatamodelPackage.Literals.PERSON_EMF__CARS) // corresponding EMF feature
				.columns(dialogTable -> dialogTable
					.column(CarEMF::getNumber)
					.name("Car number")
					.emfTextEditor()
						.feature(DatamodelPackage.Literals.CAR_EMF__NUMBER)
						.strategy(ValidationStrategies.integerPositive())
						.handler((car, number) -> car.setNumber(number))
					.build()
					)
				.build();
		
		table
			.column(PersonEMF::getMainCar)
			.name("Car")
			.format(car -> String.valueOf(car.getNumber()))
			.emfObjectSelectionDialogEditor()
				.elements(carsObservable)
				.columns(dialogTable -> dialogTable
						.column(CarEMF::getNumber)
						.name("Car number"))
				.feature(DatamodelPackage.Literals.PERSON_EMF__MAIN_CAR)  // corresponding EMF feature
			.build();
	
		table
			.column(PersonEMF::getMainCar)
			.name("Car")
			.format(car -> String.valueOf(car.getNumber()))
			.emfComboEditor()
				.elements(carsObservable)
				.feature(DatamodelPackage.Literals.PERSON_EMF__MAIN_CAR)  // corresponding EMF feature
				.format(car -> String.valueOf(car.getNumber()))
			.build();
		
		table
			.column(PersonEMF::getMainCar)
			.name("Car")
			.format(car -> String.valueOf(car.getNumber()))
			.emfAutoCompleteComboEditor()
				.elements(carsObservable)
				.feature(DatamodelPackage.Literals.PERSON_EMF__MAIN_CAR) // corresponding EMF feature
				.format(car -> car == null ? "" : String.valueOf(car.getNumber()))
			.build();
		
		table
			.column(PersonEMF::getMainCar)
			.name("Car")
			.format(car -> String.valueOf(car.getNumber()))
			.emfDynamicAutoCompleteComboEditor()
				.elements(carsObservable)
				.feature(DatamodelPackage.Literals.PERSON_EMF__MAIN_CAR) // corresponding EMF feature
				.format(car -> car == null ? "" : String.valueOf(car.getNumber()))
			.build();
		
		table
			.column(PersonEMF::getMainCar)
			.name("Car")
			.format(car -> String.valueOf(car.getNumber()))
			.emfAutoCompleteTextEditor()
				.elements(carsObservable)
				.feature(DatamodelPackage.Literals.PERSON_EMF__MAIN_CAR) // corresponding EMF feature
				.format(car -> car == null ? "" : String.valueOf(car.getNumber()))
			.build();
				
		table
			.column(PersonEMF::getCountry)
			.name("Country")
			.emfEnumComboEditor()
				.elements(Country.values())
				.feature(DatamodelPackage.Literals.PERSON_EMF__COUNTRY) // corresponding EMF feature
				.format(Country::getName)
			.build();

		table
			.column(PersonEMF::getVisit)
			.name("Visit time series")
			.width(200)		
			.timeSeriesEditor()
				.feature(DatamodelPackage.Literals.PERSON_EMF__VISIT) // corresponding EMF feature
			.build();

		table
			.column(PersonEMF::getVisitDistribution)
			.name("Visit distribution")
			.distributionEditor()
				.feature(DatamodelPackage.Literals.PERSON_EMF__VISIT_DISTRIBUTION) // corresponding EMF feature
			.build();
	}
	
	private void initializeList() {
		PersonEMF person1 = DatamodelFactory.eINSTANCE.createPersonEMF();
		person1.setName("Peter");
		peopleList.add(person1);
		PersonEMF person2 = DatamodelFactory.eINSTANCE.createPersonEMF();
		person2.setName("Alexander");
		peopleList.add(person2);
		CarEMF car1 = DatamodelFactory.eINSTANCE.createCarEMF();
		car1.setNumber(23);
		CarEMF car2 = DatamodelFactory.eINSTANCE.createCarEMF();
		car2.setNumber(56);
		CarEMF car3 = DatamodelFactory.eINSTANCE.createCarEMF();
		car3.setNumber(77);
		cars.addAll(List.of(
				car1, car2, car3));
	}

	
	private String listAsString(List<CarEMF> cars) {
		String string = cars.stream().map(CarEMF::getNumber).toList().toString();
		return string.substring(1, string.length()-1);
	}
}
