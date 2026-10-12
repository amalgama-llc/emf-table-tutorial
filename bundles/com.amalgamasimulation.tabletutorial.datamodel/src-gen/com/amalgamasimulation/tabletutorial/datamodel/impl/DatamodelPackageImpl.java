/**
 */
package com.amalgamasimulation.tabletutorial.datamodel.impl;

import com.amalgamasimulation.ecoreutils.EcoreutilsPackage;
import com.amalgamasimulation.tabletutorial.datamodel.CarEMF;
import com.amalgamasimulation.tabletutorial.datamodel.Country;
import com.amalgamasimulation.tabletutorial.datamodel.DatamodelFactory;
import com.amalgamasimulation.tabletutorial.datamodel.DatamodelPackage;
import com.amalgamasimulation.tabletutorial.datamodel.DriverEMF;
import com.amalgamasimulation.tabletutorial.datamodel.PersonEMF;
import com.amalgamasimulation.tabletutorial.datamodel.Scenario;

import com.amalgamasimulation.tabletutorial.datamodel.TruckEMF;
import com.amalgamasimulation.tabletutorial.datamodel.TruckType;
import com.amalgamasimulation.timeseriesdatamodel.TimeseriesdatamodelPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DatamodelPackageImpl extends EPackageImpl implements DatamodelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scenarioEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass personEMFEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass carEMFEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass truckEMFEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass driverEMFEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum countryEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum truckTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.amalgamasimulation.tabletutorial.datamodel.DatamodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DatamodelPackageImpl() {
		super(eNS_URI, DatamodelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link DatamodelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DatamodelPackage init() {
		if (isInited)
			return (DatamodelPackage) EPackage.Registry.INSTANCE.getEPackage(DatamodelPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredDatamodelPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		DatamodelPackageImpl theDatamodelPackage = registeredDatamodelPackage instanceof DatamodelPackageImpl
				? (DatamodelPackageImpl) registeredDatamodelPackage
				: new DatamodelPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		EcoreutilsPackage.eINSTANCE.eClass();
		TimeseriesdatamodelPackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theDatamodelPackage.createPackageContents();

		// Initialize created meta-data
		theDatamodelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDatamodelPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DatamodelPackage.eNS_URI, theDatamodelPackage);
		return theDatamodelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getScenario() {
		return scenarioEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScenario_People() {
		return (EReference) scenarioEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScenario_Trucks() {
		return (EReference) scenarioEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScenario_Drivers() {
		return (EReference) scenarioEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPersonEMF() {
		return personEMFEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPersonEMF_Id() {
		return (EAttribute) personEMFEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPersonEMF_Name() {
		return (EAttribute) personEMFEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPersonEMF_IsPreferential() {
		return (EAttribute) personEMFEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPersonEMF_ArriveTime() {
		return (EAttribute) personEMFEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPersonEMF_PurchaseDate() {
		return (EAttribute) personEMFEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPersonEMF_FavouriteColor() {
		return (EAttribute) personEMFEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPersonEMF_Cars() {
		return (EReference) personEMFEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPersonEMF_MainCar() {
		return (EReference) personEMFEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPersonEMF_Scenario() {
		return (EReference) personEMFEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPersonEMF_Country() {
		return (EAttribute) personEMFEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPersonEMF_Visit() {
		return (EReference) personEMFEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPersonEMF_VisitDistribution() {
		return (EAttribute) personEMFEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCarEMF() {
		return carEMFEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCarEMF_Number() {
		return (EAttribute) carEMFEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCarEMF_Person() {
		return (EReference) carEMFEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTruckEMF() {
		return truckEMFEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTruckEMF_Name() {
		return (EAttribute) truckEMFEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTruckEMF_Capacity() {
		return (EAttribute) truckEMFEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTruckEMF_Active() {
		return (EAttribute) truckEMFEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTruckEMF_Type() {
		return (EAttribute) truckEMFEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTruckEMF_Driver() {
		return (EReference) truckEMFEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTruckEMF_Axles() {
		return (EAttribute) truckEMFEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTruckEMF_LastService() {
		return (EAttribute) truckEMFEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTruckEMF_DepartureTime() {
		return (EAttribute) truckEMFEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTruckEMF_Color() {
		return (EAttribute) truckEMFEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTruckEMF_LoadingTime() {
		return (EAttribute) truckEMFEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTruckEMF_Schedule() {
		return (EReference) truckEMFEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDriverEMF() {
		return driverEMFEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDriverEMF_Name() {
		return (EAttribute) driverEMFEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getCountry() {
		return countryEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getTruckType() {
		return truckTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DatamodelFactory getDatamodelFactory() {
		return (DatamodelFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		scenarioEClass = createEClass(SCENARIO);
		createEReference(scenarioEClass, SCENARIO__PEOPLE);
		createEReference(scenarioEClass, SCENARIO__TRUCKS);
		createEReference(scenarioEClass, SCENARIO__DRIVERS);

		personEMFEClass = createEClass(PERSON_EMF);
		createEAttribute(personEMFEClass, PERSON_EMF__ID);
		createEAttribute(personEMFEClass, PERSON_EMF__NAME);
		createEAttribute(personEMFEClass, PERSON_EMF__IS_PREFERENTIAL);
		createEAttribute(personEMFEClass, PERSON_EMF__ARRIVE_TIME);
		createEAttribute(personEMFEClass, PERSON_EMF__PURCHASE_DATE);
		createEAttribute(personEMFEClass, PERSON_EMF__FAVOURITE_COLOR);
		createEReference(personEMFEClass, PERSON_EMF__CARS);
		createEReference(personEMFEClass, PERSON_EMF__MAIN_CAR);
		createEReference(personEMFEClass, PERSON_EMF__SCENARIO);
		createEAttribute(personEMFEClass, PERSON_EMF__COUNTRY);
		createEReference(personEMFEClass, PERSON_EMF__VISIT);
		createEAttribute(personEMFEClass, PERSON_EMF__VISIT_DISTRIBUTION);

		carEMFEClass = createEClass(CAR_EMF);
		createEAttribute(carEMFEClass, CAR_EMF__NUMBER);
		createEReference(carEMFEClass, CAR_EMF__PERSON);

		truckEMFEClass = createEClass(TRUCK_EMF);
		createEAttribute(truckEMFEClass, TRUCK_EMF__NAME);
		createEAttribute(truckEMFEClass, TRUCK_EMF__CAPACITY);
		createEAttribute(truckEMFEClass, TRUCK_EMF__ACTIVE);
		createEAttribute(truckEMFEClass, TRUCK_EMF__TYPE);
		createEReference(truckEMFEClass, TRUCK_EMF__DRIVER);
		createEAttribute(truckEMFEClass, TRUCK_EMF__AXLES);
		createEAttribute(truckEMFEClass, TRUCK_EMF__LAST_SERVICE);
		createEAttribute(truckEMFEClass, TRUCK_EMF__DEPARTURE_TIME);
		createEAttribute(truckEMFEClass, TRUCK_EMF__COLOR);
		createEAttribute(truckEMFEClass, TRUCK_EMF__LOADING_TIME);
		createEReference(truckEMFEClass, TRUCK_EMF__SCHEDULE);

		driverEMFEClass = createEClass(DRIVER_EMF);
		createEAttribute(driverEMFEClass, DRIVER_EMF__NAME);

		// Create enums
		countryEEnum = createEEnum(COUNTRY);
		truckTypeEEnum = createEEnum(TRUCK_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcoreutilsPackage theEcoreutilsPackage = (EcoreutilsPackage) EPackage.Registry.INSTANCE
				.getEPackage(EcoreutilsPackage.eNS_URI);
		TimeseriesdatamodelPackage theTimeseriesdatamodelPackage = (TimeseriesdatamodelPackage) EPackage.Registry.INSTANCE
				.getEPackage(TimeseriesdatamodelPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(scenarioEClass, Scenario.class, "Scenario", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScenario_People(), this.getPersonEMF(), this.getPersonEMF_Scenario(), "people", null, 0, -1,
				Scenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScenario_Trucks(), this.getTruckEMF(), null, "trucks", null, 0, -1, Scenario.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScenario_Drivers(), this.getDriverEMF(), null, "drivers", null, 0, -1, Scenario.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(personEMFEClass, PersonEMF.class, "PersonEMF", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPersonEMF_Id(), ecorePackage.getEInt(), "id", null, 0, 1, PersonEMF.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPersonEMF_Name(), ecorePackage.getEString(), "name", null, 0, 1, PersonEMF.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPersonEMF_IsPreferential(), ecorePackage.getEBoolean(), "isPreferential", null, 0, 1,
				PersonEMF.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getPersonEMF_ArriveTime(), theEcoreutilsPackage.getLocalTime(), "arriveTime", null, 0, 1,
				PersonEMF.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getPersonEMF_PurchaseDate(), theEcoreutilsPackage.getLocalDateTime(), "purchaseDate", null, 0, 1,
				PersonEMF.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getPersonEMF_FavouriteColor(), theEcoreutilsPackage.getColor(), "favouriteColor", null, 0, 1,
				PersonEMF.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getPersonEMF_Cars(), this.getCarEMF(), this.getCarEMF_Person(), "cars", null, 0, -1,
				PersonEMF.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPersonEMF_MainCar(), this.getCarEMF(), null, "mainCar", null, 0, 1, PersonEMF.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPersonEMF_Scenario(), this.getScenario(), this.getScenario_People(), "scenario", null, 0, 1,
				PersonEMF.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPersonEMF_Country(), this.getCountry(), "country", null, 0, 1, PersonEMF.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPersonEMF_Visit(), theTimeseriesdatamodelPackage.getTimeSeries(), null, "visit", null, 0, 1,
				PersonEMF.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPersonEMF_VisitDistribution(), theEcoreutilsPackage.getRealDistribution(),
				"visitDistribution", null, 0, 1, PersonEMF.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(carEMFEClass, CarEMF.class, "CarEMF", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCarEMF_Number(), ecorePackage.getEInt(), "number", null, 0, 1, CarEMF.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCarEMF_Person(), this.getPersonEMF(), this.getPersonEMF_Cars(), "person", null, 0, 1,
				CarEMF.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(truckEMFEClass, TruckEMF.class, "TruckEMF", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTruckEMF_Name(), ecorePackage.getEString(), "name", null, 0, 1, TruckEMF.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTruckEMF_Capacity(), ecorePackage.getEDouble(), "capacity", null, 0, 1, TruckEMF.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTruckEMF_Active(), ecorePackage.getEBoolean(), "active", null, 0, 1, TruckEMF.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTruckEMF_Type(), this.getTruckType(), "type", null, 0, 1, TruckEMF.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTruckEMF_Driver(), this.getDriverEMF(), null, "driver", null, 0, 1, TruckEMF.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTruckEMF_Axles(), ecorePackage.getEInt(), "axles", null, 0, 1, TruckEMF.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTruckEMF_LastService(), theEcoreutilsPackage.getLocalDateTime(), "lastService", null, 0, 1,
				TruckEMF.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getTruckEMF_DepartureTime(), theEcoreutilsPackage.getLocalTime(), "departureTime", null, 0, 1,
				TruckEMF.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getTruckEMF_Color(), theEcoreutilsPackage.getColor(), "color", null, 0, 1, TruckEMF.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTruckEMF_LoadingTime(), theEcoreutilsPackage.getRealDistribution(), "loadingTime", null, 0, 1,
				TruckEMF.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getTruckEMF_Schedule(), theTimeseriesdatamodelPackage.getTimeSeries(), null, "schedule", null, 0,
				1, TruckEMF.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(driverEMFEClass, DriverEMF.class, "DriverEMF", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDriverEMF_Name(), ecorePackage.getEString(), "name", null, 0, 1, DriverEMF.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(countryEEnum, Country.class, "Country");
		addEEnumLiteral(countryEEnum, Country.RUSSIA);
		addEEnumLiteral(countryEEnum, Country.GERMANY);
		addEEnumLiteral(countryEEnum, Country.PORTUGAL);
		addEEnumLiteral(countryEEnum, Country.ITALY);

		initEEnum(truckTypeEEnum, TruckType.class, "TruckType");
		addEEnumLiteral(truckTypeEEnum, TruckType.FLATBED);
		addEEnumLiteral(truckTypeEEnum, TruckType.REFRIGERATOR);
		addEEnumLiteral(truckTypeEEnum, TruckType.DUMP_TRUCK);

		// Create resource
		createResource(eNS_URI);
	}

} //DatamodelPackageImpl
