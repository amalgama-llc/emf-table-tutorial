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

} // Scenario
