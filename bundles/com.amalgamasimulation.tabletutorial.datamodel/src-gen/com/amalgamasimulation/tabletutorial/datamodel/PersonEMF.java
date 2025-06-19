/**
 */
package com.amalgamasimulation.tabletutorial.datamodel;

import com.amalgamasimulation.timeseriesdatamodel.TimeSeries;
import java.awt.Color;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Person EMF</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#getId <em>Id</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#getName <em>Name</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#isIsPreferential <em>Is Preferential</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#getArriveTime <em>Arrive Time</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#getPurchaseDate <em>Purchase Date</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#getFavouriteColor <em>Favourite Color</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#getCars <em>Cars</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#getMainCar <em>Main Car</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#getScenario <em>Scenario</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#getCountry <em>Country</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#getVisit <em>Visit</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#getVisitDistribution <em>Visit Distribution</em>}</li>
 * </ul>
 *
 * @see com.amalgamasimulation.tabletutorial.datamodel.DatamodelPackage#getPersonEMF()
 * @model
 * @generated
 */
public interface PersonEMF extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(int)
	 * @see com.amalgamasimulation.tabletutorial.datamodel.DatamodelPackage#getPersonEMF_Id()
	 * @model id="true"
	 * @generated
	 */
	int getId();

	/**
	 * Sets the value of the '{@link com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(int value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.amalgamasimulation.tabletutorial.datamodel.DatamodelPackage#getPersonEMF_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Is Preferential</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Preferential</em>' attribute.
	 * @see #setIsPreferential(boolean)
	 * @see com.amalgamasimulation.tabletutorial.datamodel.DatamodelPackage#getPersonEMF_IsPreferential()
	 * @model
	 * @generated
	 */
	boolean isIsPreferential();

	/**
	 * Sets the value of the '{@link com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#isIsPreferential <em>Is Preferential</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Preferential</em>' attribute.
	 * @see #isIsPreferential()
	 * @generated
	 */
	void setIsPreferential(boolean value);

	/**
	 * Returns the value of the '<em><b>Arrive Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arrive Time</em>' attribute.
	 * @see #setArriveTime(LocalTime)
	 * @see com.amalgamasimulation.tabletutorial.datamodel.DatamodelPackage#getPersonEMF_ArriveTime()
	 * @model dataType="com.amalgamasimulation.ecoreutils.LocalTime"
	 * @generated
	 */
	LocalTime getArriveTime();

	/**
	 * Sets the value of the '{@link com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#getArriveTime <em>Arrive Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Arrive Time</em>' attribute.
	 * @see #getArriveTime()
	 * @generated
	 */
	void setArriveTime(LocalTime value);

	/**
	 * Returns the value of the '<em><b>Purchase Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Purchase Date</em>' attribute.
	 * @see #setPurchaseDate(LocalDateTime)
	 * @see com.amalgamasimulation.tabletutorial.datamodel.DatamodelPackage#getPersonEMF_PurchaseDate()
	 * @model dataType="com.amalgamasimulation.ecoreutils.LocalDateTime"
	 * @generated
	 */
	LocalDateTime getPurchaseDate();

	/**
	 * Sets the value of the '{@link com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#getPurchaseDate <em>Purchase Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Purchase Date</em>' attribute.
	 * @see #getPurchaseDate()
	 * @generated
	 */
	void setPurchaseDate(LocalDateTime value);

	/**
	 * Returns the value of the '<em><b>Favourite Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Favourite Color</em>' attribute.
	 * @see #setFavouriteColor(Color)
	 * @see com.amalgamasimulation.tabletutorial.datamodel.DatamodelPackage#getPersonEMF_FavouriteColor()
	 * @model dataType="com.amalgamasimulation.ecoreutils.Color"
	 * @generated
	 */
	Color getFavouriteColor();

	/**
	 * Sets the value of the '{@link com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#getFavouriteColor <em>Favourite Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Favourite Color</em>' attribute.
	 * @see #getFavouriteColor()
	 * @generated
	 */
	void setFavouriteColor(Color value);

	/**
	 * Returns the value of the '<em><b>Cars</b></em>' containment reference list.
	 * The list contents are of type {@link com.amalgamasimulation.tabletutorial.datamodel.CarEMF}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cars</em>' containment reference list.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.DatamodelPackage#getPersonEMF_Cars()
	 * @model containment="true"
	 * @generated
	 */
	EList<CarEMF> getCars();

	/**
	 * Returns the value of the '<em><b>Main Car</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Main Car</em>' reference.
	 * @see #setMainCar(CarEMF)
	 * @see com.amalgamasimulation.tabletutorial.datamodel.DatamodelPackage#getPersonEMF_MainCar()
	 * @model
	 * @generated
	 */
	CarEMF getMainCar();

	/**
	 * Sets the value of the '{@link com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#getMainCar <em>Main Car</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Main Car</em>' reference.
	 * @see #getMainCar()
	 * @generated
	 */
	void setMainCar(CarEMF value);

	/**
	 * Returns the value of the '<em><b>Scenario</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link com.amalgamasimulation.tabletutorial.datamodel.Scenario#getPeople <em>People</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scenario</em>' reference.
	 * @see #setScenario(Scenario)
	 * @see com.amalgamasimulation.tabletutorial.datamodel.DatamodelPackage#getPersonEMF_Scenario()
	 * @see com.amalgamasimulation.tabletutorial.datamodel.Scenario#getPeople
	 * @model opposite="people"
	 * @generated
	 */
	Scenario getScenario();

	/**
	 * Sets the value of the '{@link com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#getScenario <em>Scenario</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scenario</em>' reference.
	 * @see #getScenario()
	 * @generated
	 */
	void setScenario(Scenario value);

	/**
	 * Returns the value of the '<em><b>Country</b></em>' attribute.
	 * The literals are from the enumeration {@link com.amalgamasimulation.tabletutorial.datamodel.Country}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Country</em>' attribute.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.Country
	 * @see #setCountry(Country)
	 * @see com.amalgamasimulation.tabletutorial.datamodel.DatamodelPackage#getPersonEMF_Country()
	 * @model
	 * @generated
	 */
	Country getCountry();

	/**
	 * Sets the value of the '{@link com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#getCountry <em>Country</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Country</em>' attribute.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.Country
	 * @see #getCountry()
	 * @generated
	 */
	void setCountry(Country value);

	/**
	 * Returns the value of the '<em><b>Visit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visit</em>' reference.
	 * @see #setVisit(TimeSeries)
	 * @see com.amalgamasimulation.tabletutorial.datamodel.DatamodelPackage#getPersonEMF_Visit()
	 * @model
	 * @generated
	 */
	TimeSeries getVisit();

	/**
	 * Sets the value of the '{@link com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#getVisit <em>Visit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visit</em>' reference.
	 * @see #getVisit()
	 * @generated
	 */
	void setVisit(TimeSeries value);

	/**
	 * Returns the value of the '<em><b>Visit Distribution</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visit Distribution</em>' reference.
	 * @see #setVisitDistribution(com.amalgamasimulation.randomdatamodel.Distribution)
	 * @see com.amalgamasimulation.tabletutorial.datamodel.DatamodelPackage#getPersonEMF_VisitDistribution()
	 * @model
	 * @generated
	 */
	com.amalgamasimulation.randomdatamodel.Distribution getVisitDistribution();

	/**
	 * Sets the value of the '{@link com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#getVisitDistribution <em>Visit Distribution</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visit Distribution</em>' reference.
	 * @see #getVisitDistribution()
	 * @generated
	 */
	void setVisitDistribution(com.amalgamasimulation.randomdatamodel.Distribution value);

} // PersonEMF
