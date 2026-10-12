/**
 */
package com.amalgamasimulation.tabletutorial.datamodel.impl;

import com.amalgamasimulation.tabletutorial.datamodel.DatamodelPackage;
import com.amalgamasimulation.tabletutorial.datamodel.DriverEMF;
import com.amalgamasimulation.tabletutorial.datamodel.PersonEMF;
import com.amalgamasimulation.tabletutorial.datamodel.Scenario;
import com.amalgamasimulation.tabletutorial.datamodel.TruckEMF;
import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scenario</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.impl.ScenarioImpl#getPeople <em>People</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.impl.ScenarioImpl#getTrucks <em>Trucks</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.impl.ScenarioImpl#getDrivers <em>Drivers</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ScenarioImpl extends MinimalEObjectImpl.Container implements Scenario {
	/**
	 * The cached value of the '{@link #getPeople() <em>People</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeople()
	 * @generated
	 * @ordered
	 */
	protected EList<PersonEMF> people;

	/**
	 * The cached value of the '{@link #getTrucks() <em>Trucks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrucks()
	 * @generated
	 * @ordered
	 */
	protected EList<TruckEMF> trucks;
	/**
	 * The cached value of the '{@link #getDrivers() <em>Drivers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDrivers()
	 * @generated
	 * @ordered
	 */
	protected EList<DriverEMF> drivers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScenarioImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DatamodelPackage.Literals.SCENARIO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PersonEMF> getPeople() {
		if (people == null) {
			people = new EObjectWithInverseResolvingEList<PersonEMF>(PersonEMF.class, this,
					DatamodelPackage.SCENARIO__PEOPLE, DatamodelPackage.PERSON_EMF__SCENARIO);
		}
		return people;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TruckEMF> getTrucks() {
		if (trucks == null) {
			trucks = new EObjectContainmentEList<TruckEMF>(TruckEMF.class, this, DatamodelPackage.SCENARIO__TRUCKS);
		}
		return trucks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DriverEMF> getDrivers() {
		if (drivers == null) {
			drivers = new EObjectContainmentEList<DriverEMF>(DriverEMF.class, this, DatamodelPackage.SCENARIO__DRIVERS);
		}
		return drivers;
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
		case DatamodelPackage.SCENARIO__PEOPLE:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getPeople()).basicAdd(otherEnd, msgs);
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
		case DatamodelPackage.SCENARIO__PEOPLE:
			return ((InternalEList<?>) getPeople()).basicRemove(otherEnd, msgs);
		case DatamodelPackage.SCENARIO__TRUCKS:
			return ((InternalEList<?>) getTrucks()).basicRemove(otherEnd, msgs);
		case DatamodelPackage.SCENARIO__DRIVERS:
			return ((InternalEList<?>) getDrivers()).basicRemove(otherEnd, msgs);
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
		case DatamodelPackage.SCENARIO__PEOPLE:
			return getPeople();
		case DatamodelPackage.SCENARIO__TRUCKS:
			return getTrucks();
		case DatamodelPackage.SCENARIO__DRIVERS:
			return getDrivers();
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
		case DatamodelPackage.SCENARIO__PEOPLE:
			getPeople().clear();
			getPeople().addAll((Collection<? extends PersonEMF>) newValue);
			return;
		case DatamodelPackage.SCENARIO__TRUCKS:
			getTrucks().clear();
			getTrucks().addAll((Collection<? extends TruckEMF>) newValue);
			return;
		case DatamodelPackage.SCENARIO__DRIVERS:
			getDrivers().clear();
			getDrivers().addAll((Collection<? extends DriverEMF>) newValue);
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
		case DatamodelPackage.SCENARIO__PEOPLE:
			getPeople().clear();
			return;
		case DatamodelPackage.SCENARIO__TRUCKS:
			getTrucks().clear();
			return;
		case DatamodelPackage.SCENARIO__DRIVERS:
			getDrivers().clear();
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
		case DatamodelPackage.SCENARIO__PEOPLE:
			return people != null && !people.isEmpty();
		case DatamodelPackage.SCENARIO__TRUCKS:
			return trucks != null && !trucks.isEmpty();
		case DatamodelPackage.SCENARIO__DRIVERS:
			return drivers != null && !drivers.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ScenarioImpl
