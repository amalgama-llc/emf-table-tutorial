/**
 */
package com.amalgamasimulation.tabletutorial.datamodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scenario</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.Scenario#getPeople <em>People</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.Scenario#getTrucks <em>Trucks</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.Scenario#getDrivers <em>Drivers</em>}</li>
 * </ul>
 *
 * @see com.amalgamasimulation.tabletutorial.datamodel.DatamodelPackage#getScenario()
 * @model
 * @generated
 */
public interface Scenario extends EObject {
	/**
	 * Returns the value of the '<em><b>People</b></em>' reference list.
	 * The list contents are of type {@link com.amalgamasimulation.tabletutorial.datamodel.PersonEMF}.
	 * It is bidirectional and its opposite is '{@link com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#getScenario <em>Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>People</em>' reference list.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.DatamodelPackage#getScenario_People()
	 * @see com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#getScenario
	 * @model opposite="scenario"
	 * @generated
	 */
	EList<PersonEMF> getPeople();

	/**
	 * Returns the value of the '<em><b>Trucks</b></em>' containment reference list.
	 * The list contents are of type {@link com.amalgamasimulation.tabletutorial.datamodel.TruckEMF}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trucks</em>' containment reference list.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.DatamodelPackage#getScenario_Trucks()
	 * @model containment="true"
	 * @generated
	 */
	EList<TruckEMF> getTrucks();

	/**
	 * Returns the value of the '<em><b>Drivers</b></em>' containment reference list.
	 * The list contents are of type {@link com.amalgamasimulation.tabletutorial.datamodel.DriverEMF}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Drivers</em>' containment reference list.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.DatamodelPackage#getScenario_Drivers()
	 * @model containment="true"
	 * @generated
	 */
	EList<DriverEMF> getDrivers();

} // Scenario
