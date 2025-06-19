/**
 */
package com.amalgamasimulation.tabletutorial.datamodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Car EMF</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.CarEMF#getNumber <em>Number</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.CarEMF#getPerson <em>Person</em>}</li>
 * </ul>
 *
 * @see com.amalgamasimulation.tabletutorial.datamodel.DatamodelPackage#getCarEMF()
 * @model
 * @generated
 */
public interface CarEMF extends EObject {
	/**
	 * Returns the value of the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number</em>' attribute.
	 * @see #setNumber(int)
	 * @see com.amalgamasimulation.tabletutorial.datamodel.DatamodelPackage#getCarEMF_Number()
	 * @model
	 * @generated
	 */
	int getNumber();

	/**
	 * Sets the value of the '{@link com.amalgamasimulation.tabletutorial.datamodel.CarEMF#getNumber <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number</em>' attribute.
	 * @see #getNumber()
	 * @generated
	 */
	void setNumber(int value);

	/**
	 * Returns the value of the '<em><b>Person</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Person</em>' reference.
	 * @see #setPerson(PersonEMF)
	 * @see com.amalgamasimulation.tabletutorial.datamodel.DatamodelPackage#getCarEMF_Person()
	 * @model
	 * @generated
	 */
	PersonEMF getPerson();

	/**
	 * Sets the value of the '{@link com.amalgamasimulation.tabletutorial.datamodel.CarEMF#getPerson <em>Person</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Person</em>' reference.
	 * @see #getPerson()
	 * @generated
	 */
	void setPerson(PersonEMF value);

} // CarEMF
