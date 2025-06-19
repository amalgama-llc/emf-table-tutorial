/**
 */
package com.amalgamasimulation.tabletutorial.datamodel.impl;

import com.amalgamasimulation.tabletutorial.datamodel.CarEMF;
import com.amalgamasimulation.tabletutorial.datamodel.Country;
import com.amalgamasimulation.tabletutorial.datamodel.DatamodelPackage;
import com.amalgamasimulation.tabletutorial.datamodel.PersonEMF;

import com.amalgamasimulation.tabletutorial.datamodel.Scenario;
import com.amalgamasimulation.timeseriesdatamodel.TimeSeries;
import java.awt.Color;

import java.time.LocalDateTime;
import java.time.LocalTime;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Person EMF</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.impl.PersonEMFImpl#getId <em>Id</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.impl.PersonEMFImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.impl.PersonEMFImpl#isIsPreferential <em>Is Preferential</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.impl.PersonEMFImpl#getArriveTime <em>Arrive Time</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.impl.PersonEMFImpl#getPurchaseDate <em>Purchase Date</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.impl.PersonEMFImpl#getFavouriteColor <em>Favourite Color</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.impl.PersonEMFImpl#getCars <em>Cars</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.impl.PersonEMFImpl#getMainCar <em>Main Car</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.impl.PersonEMFImpl#getScenario <em>Scenario</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.impl.PersonEMFImpl#getCountry <em>Country</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.impl.PersonEMFImpl#getVisit <em>Visit</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.impl.PersonEMFImpl#getVisitDistribution <em>Visit Distribution</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PersonEMFImpl extends MinimalEObjectImpl.Container implements PersonEMF {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final int ID_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected int id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsPreferential() <em>Is Preferential</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsPreferential()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_PREFERENTIAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsPreferential() <em>Is Preferential</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsPreferential()
	 * @generated
	 * @ordered
	 */
	protected boolean isPreferential = IS_PREFERENTIAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getArriveTime() <em>Arrive Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArriveTime()
	 * @generated
	 * @ordered
	 */
	protected static final LocalTime ARRIVE_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getArriveTime() <em>Arrive Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArriveTime()
	 * @generated
	 * @ordered
	 */
	protected LocalTime arriveTime = ARRIVE_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPurchaseDate() <em>Purchase Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPurchaseDate()
	 * @generated
	 * @ordered
	 */
	protected static final LocalDateTime PURCHASE_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPurchaseDate() <em>Purchase Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPurchaseDate()
	 * @generated
	 * @ordered
	 */
	protected LocalDateTime purchaseDate = PURCHASE_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFavouriteColor() <em>Favourite Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFavouriteColor()
	 * @generated
	 * @ordered
	 */
	protected static final Color FAVOURITE_COLOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFavouriteColor() <em>Favourite Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFavouriteColor()
	 * @generated
	 * @ordered
	 */
	protected Color favouriteColor = FAVOURITE_COLOR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCars() <em>Cars</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCars()
	 * @generated
	 * @ordered
	 */
	protected EList<CarEMF> cars;

	/**
	 * The cached value of the '{@link #getMainCar() <em>Main Car</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMainCar()
	 * @generated
	 * @ordered
	 */
	protected CarEMF mainCar;

	/**
	 * The cached value of the '{@link #getScenario() <em>Scenario</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScenario()
	 * @generated
	 * @ordered
	 */
	protected Scenario scenario;

	/**
	 * The default value of the '{@link #getCountry() <em>Country</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCountry()
	 * @generated
	 * @ordered
	 */
	protected static final Country COUNTRY_EDEFAULT = Country.RUSSIA;

	/**
	 * The cached value of the '{@link #getCountry() <em>Country</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCountry()
	 * @generated
	 * @ordered
	 */
	protected Country country = COUNTRY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getVisit() <em>Visit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisit()
	 * @generated
	 * @ordered
	 */
	protected TimeSeries visit;

	/**
	 * The cached value of the '{@link #getVisitDistribution() <em>Visit Distribution</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisitDistribution()
	 * @generated
	 * @ordered
	 */
	protected com.amalgamasimulation.randomdatamodel.Distribution visitDistribution;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PersonEMFImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DatamodelPackage.Literals.PERSON_EMF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setId(int newId) {
		int oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatamodelPackage.PERSON_EMF__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatamodelPackage.PERSON_EMF__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsPreferential() {
		return isPreferential;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsPreferential(boolean newIsPreferential) {
		boolean oldIsPreferential = isPreferential;
		isPreferential = newIsPreferential;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatamodelPackage.PERSON_EMF__IS_PREFERENTIAL,
					oldIsPreferential, isPreferential));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LocalTime getArriveTime() {
		return arriveTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setArriveTime(LocalTime newArriveTime) {
		LocalTime oldArriveTime = arriveTime;
		arriveTime = newArriveTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatamodelPackage.PERSON_EMF__ARRIVE_TIME,
					oldArriveTime, arriveTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LocalDateTime getPurchaseDate() {
		return purchaseDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPurchaseDate(LocalDateTime newPurchaseDate) {
		LocalDateTime oldPurchaseDate = purchaseDate;
		purchaseDate = newPurchaseDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatamodelPackage.PERSON_EMF__PURCHASE_DATE,
					oldPurchaseDate, purchaseDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Color getFavouriteColor() {
		return favouriteColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFavouriteColor(Color newFavouriteColor) {
		Color oldFavouriteColor = favouriteColor;
		favouriteColor = newFavouriteColor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatamodelPackage.PERSON_EMF__FAVOURITE_COLOR,
					oldFavouriteColor, favouriteColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<CarEMF> getCars() {
		if (cars == null) {
			cars = new EObjectContainmentEList<CarEMF>(CarEMF.class, this, DatamodelPackage.PERSON_EMF__CARS);
		}
		return cars;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CarEMF getMainCar() {
		if (mainCar != null && mainCar.eIsProxy()) {
			InternalEObject oldMainCar = (InternalEObject) mainCar;
			mainCar = (CarEMF) eResolveProxy(oldMainCar);
			if (mainCar != oldMainCar) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DatamodelPackage.PERSON_EMF__MAIN_CAR,
							oldMainCar, mainCar));
			}
		}
		return mainCar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CarEMF basicGetMainCar() {
		return mainCar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMainCar(CarEMF newMainCar) {
		CarEMF oldMainCar = mainCar;
		mainCar = newMainCar;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatamodelPackage.PERSON_EMF__MAIN_CAR, oldMainCar,
					mainCar));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Scenario getScenario() {
		if (scenario != null && scenario.eIsProxy()) {
			InternalEObject oldScenario = (InternalEObject) scenario;
			scenario = (Scenario) eResolveProxy(oldScenario);
			if (scenario != oldScenario) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DatamodelPackage.PERSON_EMF__SCENARIO,
							oldScenario, scenario));
			}
		}
		return scenario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scenario basicGetScenario() {
		return scenario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetScenario(Scenario newScenario, NotificationChain msgs) {
		Scenario oldScenario = scenario;
		scenario = newScenario;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					DatamodelPackage.PERSON_EMF__SCENARIO, oldScenario, newScenario);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setScenario(Scenario newScenario) {
		if (newScenario != scenario) {
			NotificationChain msgs = null;
			if (scenario != null)
				msgs = ((InternalEObject) scenario).eInverseRemove(this, DatamodelPackage.SCENARIO__PEOPLE,
						Scenario.class, msgs);
			if (newScenario != null)
				msgs = ((InternalEObject) newScenario).eInverseAdd(this, DatamodelPackage.SCENARIO__PEOPLE,
						Scenario.class, msgs);
			msgs = basicSetScenario(newScenario, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatamodelPackage.PERSON_EMF__SCENARIO, newScenario,
					newScenario));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Country getCountry() {
		return country;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCountry(Country newCountry) {
		Country oldCountry = country;
		country = newCountry == null ? COUNTRY_EDEFAULT : newCountry;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatamodelPackage.PERSON_EMF__COUNTRY, oldCountry,
					country));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TimeSeries getVisit() {
		if (visit != null && visit.eIsProxy()) {
			InternalEObject oldVisit = (InternalEObject) visit;
			visit = (TimeSeries) eResolveProxy(oldVisit);
			if (visit != oldVisit) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DatamodelPackage.PERSON_EMF__VISIT,
							oldVisit, visit));
			}
		}
		return visit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeSeries basicGetVisit() {
		return visit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVisit(TimeSeries newVisit) {
		TimeSeries oldVisit = visit;
		visit = newVisit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatamodelPackage.PERSON_EMF__VISIT, oldVisit, visit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public com.amalgamasimulation.randomdatamodel.Distribution getVisitDistribution() {
		if (visitDistribution != null && visitDistribution.eIsProxy()) {
			InternalEObject oldVisitDistribution = (InternalEObject) visitDistribution;
			visitDistribution = (com.amalgamasimulation.randomdatamodel.Distribution) eResolveProxy(
					oldVisitDistribution);
			if (visitDistribution != oldVisitDistribution) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							DatamodelPackage.PERSON_EMF__VISIT_DISTRIBUTION, oldVisitDistribution, visitDistribution));
			}
		}
		return visitDistribution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public com.amalgamasimulation.randomdatamodel.Distribution basicGetVisitDistribution() {
		return visitDistribution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVisitDistribution(com.amalgamasimulation.randomdatamodel.Distribution newVisitDistribution) {
		com.amalgamasimulation.randomdatamodel.Distribution oldVisitDistribution = visitDistribution;
		visitDistribution = newVisitDistribution;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatamodelPackage.PERSON_EMF__VISIT_DISTRIBUTION,
					oldVisitDistribution, visitDistribution));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case DatamodelPackage.PERSON_EMF__SCENARIO:
			if (scenario != null)
				msgs = ((InternalEObject) scenario).eInverseRemove(this, DatamodelPackage.SCENARIO__PEOPLE,
						Scenario.class, msgs);
			return basicSetScenario((Scenario) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case DatamodelPackage.PERSON_EMF__CARS:
			return ((InternalEList<?>) getCars()).basicRemove(otherEnd, msgs);
		case DatamodelPackage.PERSON_EMF__SCENARIO:
			return basicSetScenario(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case DatamodelPackage.PERSON_EMF__ID:
			return getId();
		case DatamodelPackage.PERSON_EMF__NAME:
			return getName();
		case DatamodelPackage.PERSON_EMF__IS_PREFERENTIAL:
			return isIsPreferential();
		case DatamodelPackage.PERSON_EMF__ARRIVE_TIME:
			return getArriveTime();
		case DatamodelPackage.PERSON_EMF__PURCHASE_DATE:
			return getPurchaseDate();
		case DatamodelPackage.PERSON_EMF__FAVOURITE_COLOR:
			return getFavouriteColor();
		case DatamodelPackage.PERSON_EMF__CARS:
			return getCars();
		case DatamodelPackage.PERSON_EMF__MAIN_CAR:
			if (resolve)
				return getMainCar();
			return basicGetMainCar();
		case DatamodelPackage.PERSON_EMF__SCENARIO:
			if (resolve)
				return getScenario();
			return basicGetScenario();
		case DatamodelPackage.PERSON_EMF__COUNTRY:
			return getCountry();
		case DatamodelPackage.PERSON_EMF__VISIT:
			if (resolve)
				return getVisit();
			return basicGetVisit();
		case DatamodelPackage.PERSON_EMF__VISIT_DISTRIBUTION:
			if (resolve)
				return getVisitDistribution();
			return basicGetVisitDistribution();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case DatamodelPackage.PERSON_EMF__ID:
			setId((Integer) newValue);
			return;
		case DatamodelPackage.PERSON_EMF__NAME:
			setName((String) newValue);
			return;
		case DatamodelPackage.PERSON_EMF__IS_PREFERENTIAL:
			setIsPreferential((Boolean) newValue);
			return;
		case DatamodelPackage.PERSON_EMF__ARRIVE_TIME:
			setArriveTime((LocalTime) newValue);
			return;
		case DatamodelPackage.PERSON_EMF__PURCHASE_DATE:
			setPurchaseDate((LocalDateTime) newValue);
			return;
		case DatamodelPackage.PERSON_EMF__FAVOURITE_COLOR:
			setFavouriteColor((Color) newValue);
			return;
		case DatamodelPackage.PERSON_EMF__CARS:
			getCars().clear();
			getCars().addAll((Collection<? extends CarEMF>) newValue);
			return;
		case DatamodelPackage.PERSON_EMF__MAIN_CAR:
			setMainCar((CarEMF) newValue);
			return;
		case DatamodelPackage.PERSON_EMF__SCENARIO:
			setScenario((Scenario) newValue);
			return;
		case DatamodelPackage.PERSON_EMF__COUNTRY:
			setCountry((Country) newValue);
			return;
		case DatamodelPackage.PERSON_EMF__VISIT:
			setVisit((TimeSeries) newValue);
			return;
		case DatamodelPackage.PERSON_EMF__VISIT_DISTRIBUTION:
			setVisitDistribution((com.amalgamasimulation.randomdatamodel.Distribution) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case DatamodelPackage.PERSON_EMF__ID:
			setId(ID_EDEFAULT);
			return;
		case DatamodelPackage.PERSON_EMF__NAME:
			setName(NAME_EDEFAULT);
			return;
		case DatamodelPackage.PERSON_EMF__IS_PREFERENTIAL:
			setIsPreferential(IS_PREFERENTIAL_EDEFAULT);
			return;
		case DatamodelPackage.PERSON_EMF__ARRIVE_TIME:
			setArriveTime(ARRIVE_TIME_EDEFAULT);
			return;
		case DatamodelPackage.PERSON_EMF__PURCHASE_DATE:
			setPurchaseDate(PURCHASE_DATE_EDEFAULT);
			return;
		case DatamodelPackage.PERSON_EMF__FAVOURITE_COLOR:
			setFavouriteColor(FAVOURITE_COLOR_EDEFAULT);
			return;
		case DatamodelPackage.PERSON_EMF__CARS:
			getCars().clear();
			return;
		case DatamodelPackage.PERSON_EMF__MAIN_CAR:
			setMainCar((CarEMF) null);
			return;
		case DatamodelPackage.PERSON_EMF__SCENARIO:
			setScenario((Scenario) null);
			return;
		case DatamodelPackage.PERSON_EMF__COUNTRY:
			setCountry(COUNTRY_EDEFAULT);
			return;
		case DatamodelPackage.PERSON_EMF__VISIT:
			setVisit((TimeSeries) null);
			return;
		case DatamodelPackage.PERSON_EMF__VISIT_DISTRIBUTION:
			setVisitDistribution((com.amalgamasimulation.randomdatamodel.Distribution) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case DatamodelPackage.PERSON_EMF__ID:
			return id != ID_EDEFAULT;
		case DatamodelPackage.PERSON_EMF__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case DatamodelPackage.PERSON_EMF__IS_PREFERENTIAL:
			return isPreferential != IS_PREFERENTIAL_EDEFAULT;
		case DatamodelPackage.PERSON_EMF__ARRIVE_TIME:
			return ARRIVE_TIME_EDEFAULT == null ? arriveTime != null : !ARRIVE_TIME_EDEFAULT.equals(arriveTime);
		case DatamodelPackage.PERSON_EMF__PURCHASE_DATE:
			return PURCHASE_DATE_EDEFAULT == null ? purchaseDate != null : !PURCHASE_DATE_EDEFAULT.equals(purchaseDate);
		case DatamodelPackage.PERSON_EMF__FAVOURITE_COLOR:
			return FAVOURITE_COLOR_EDEFAULT == null ? favouriteColor != null
					: !FAVOURITE_COLOR_EDEFAULT.equals(favouriteColor);
		case DatamodelPackage.PERSON_EMF__CARS:
			return cars != null && !cars.isEmpty();
		case DatamodelPackage.PERSON_EMF__MAIN_CAR:
			return mainCar != null;
		case DatamodelPackage.PERSON_EMF__SCENARIO:
			return scenario != null;
		case DatamodelPackage.PERSON_EMF__COUNTRY:
			return country != COUNTRY_EDEFAULT;
		case DatamodelPackage.PERSON_EMF__VISIT:
			return visit != null;
		case DatamodelPackage.PERSON_EMF__VISIT_DISTRIBUTION:
			return visitDistribution != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(", name: ");
		result.append(name);
		result.append(", isPreferential: ");
		result.append(isPreferential);
		result.append(", arriveTime: ");
		result.append(arriveTime);
		result.append(", purchaseDate: ");
		result.append(purchaseDate);
		result.append(", favouriteColor: ");
		result.append(favouriteColor);
		result.append(", country: ");
		result.append(country);
		result.append(')');
		return result.toString();
	}

} //PersonEMFImpl
