package com.amalgamasimulation.tabletutorial.application.parts.editor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.widgets.Composite;

import com.amalgamasimulation.desktop.binding.ValidationStrategies;
import com.amalgamasimulation.desktop.ui.editor.commands.CommandFactory;
import com.amalgamasimulation.desktop.ui.tables.EMFTable;
import com.amalgamasimulation.desktop.ui.tables.Tables;
import com.amalgamasimulation.tabletutorial.datamodel.CarEMF;
import com.amalgamasimulation.tabletutorial.datamodel.Country;
import com.amalgamasimulation.tabletutorial.datamodel.DatamodelFactory;
import com.amalgamasimulation.tabletutorial.datamodel.DatamodelPackage;
import com.amalgamasimulation.tabletutorial.datamodel.PersonEMF;
import com.amalgamasimulation.utils.format.Formats;
import com.amalgamasimulation.utils.random.Distributions;

import jakarta.annotation.PostConstruct;

public class EmfTablePart {

	private List<PersonEMF> emfPeopleList = new ArrayList<>();
	private List<CarEMF> emfCars = new ArrayList<>();
	
	@PostConstruct
	public void createComposite(Composite parent) {
		initializeList();
		
		EMFTable<PersonEMF> table = Tables.emf(emfPeopleList).parent(parent).create();
		IObservableList<CarEMF> carsObservable = new WritableList<>(emfCars, CarEMF.class);	
		
		table
			.column(PersonEMF::getName)
			.name("Name")
			.emfTextEditor()
				.feature(DatamodelPackage.Literals.PERSON_EMF__NAME) // corresponding EMF feature
				.strategy(ValidationStrategies.stringIsNotEmpty()) // validation strategy
			.build();
		
		table
			.column(PersonEMF::isIsPreferential)
			.name("Preferential")
			.emfCheckBoxEditor()
				.feature(DatamodelPackage.Literals.PERSON_EMF__IS_PREFERENTIAL) // corresponding EMF feature
			.build();
				
		table
			.column(PersonEMF::getFavouriteColor)
			.name("Favourite color")
			.emfColorEditor()
				.feature(DatamodelPackage.Literals.PERSON_EMF__FAVOURITE_COLOR) // corresponding EMF feature
			.build();
		
		table
			.column(PersonEMF::getArriveTime)
			.name("Arrive time")
			.emfLocalTimeEditor()
				.feature(DatamodelPackage.Literals.PERSON_EMF__ARRIVE_TIME) // corresponding EMF feature
			.build();
		
		table
			.column(PersonEMF::getPurchaseDate)
			.name("Purchase date")
			.format(Formats.getDefaultFormats()::dayMonthHoursMinutes)
			.emfLocalDateTimeEditor()
				.feature(DatamodelPackage.Literals.PERSON_EMF__PURCHASE_DATE) // corresponding EMF feature
			.build();
		
		table
			.column(PersonEMF::getCars)
			.name("Cars list")
			.width(150)
			.format(this::listAsString)
			.<CarEMF>emfMultiObjectsSelectionDialogEditor()
				.elements(carsObservable)
				.feature(DatamodelPackage.Literals.PERSON_EMF__CARS) // corresponding EMF feature
				.columns(dialogTable -> dialogTable
						.column(CarEMF::getNumber)
						.width(150)
						.name("Car number")
						)
			    .dialogTitle("Car selection dialog") 
			    .dialogSubTitle("Select cars and confirm selection") 
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
				.copyAction(car -> EcoreUtil.copy(car)) // datamodel method of coping EMF object
				.dialogSize(500, 400)
			    .dialogTitle("Dialog for creating and editing cars") 
			    .dialogSubTitle("Create and edit a cars and confirm selection") 
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
			    .dialogTitle("Car selection dialog") 
			    .dialogSubTitle("Select car and confirm selection") 
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
			.format(p -> Distributions.toString(p))
			.realDistributionEditor()
				.feature(DatamodelPackage.Literals.PERSON_EMF__VISIT_DISTRIBUTION) // corresponding EMF feature
			.build();
	}
	
	
	private void initializeList() {
		
		PersonEMF emfPerson1 = DatamodelFactory.eINSTANCE.createPersonEMF();
		emfPerson1.setName("Peter");
		emfPeopleList.add(emfPerson1);
		PersonEMF emfPerson2 = DatamodelFactory.eINSTANCE.createPersonEMF();
		emfPerson2.setName("Alexander");
		emfPeopleList.add(emfPerson2);
		CarEMF car1 = DatamodelFactory.eINSTANCE.createCarEMF();
		car1.setNumber(23);
		CarEMF car2 = DatamodelFactory.eINSTANCE.createCarEMF();
		car2.setNumber(56);
		CarEMF car3 = DatamodelFactory.eINSTANCE.createCarEMF();
		car3.setNumber(77);
		emfCars.addAll(List.of(
				car1, car2, car3));
	}
	
	private String listAsString(List<CarEMF> cars) {
		return cars.stream().map(c -> c.getNumber() + "").collect(Collectors.joining(", "));
	}
}
