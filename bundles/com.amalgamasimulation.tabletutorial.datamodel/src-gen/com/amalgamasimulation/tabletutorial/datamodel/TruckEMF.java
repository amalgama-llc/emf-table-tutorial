/**
 */
package com.amalgamasimulation.tabletutorial.datamodel;

import com.amalgamasimulation.timeseriesdatamodel.TimeSeries;
import java.awt.Color;
import java.time.LocalDateTime;
import java.time.LocalTime;
import org.apache.commons.math3.distribution.RealDistribution;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Truck EMF</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.TruckEMF#getName <em>Name</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.TruckEMF#getCapacity <em>Capacity</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.TruckEMF#isActive <em>Active</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.TruckEMF#getType <em>Type</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.TruckEMF#getDriver <em>Driver</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.TruckEMF#getAxles <em>Axles</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.TruckEMF#getLastService <em>Last Service</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.TruckEMF#getDepartureTime <em>Departure Time</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.TruckEMF#getColor <em>Color</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.TruckEMF#getLoadingTime <em>Loading Time</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.TruckEMF#getSchedule <em>Schedule</em>}</li>
 * </ul>
 *
 * @see com.amalgamasimulation.tabletutorial.datamodel.DatamodelPackage#getTruckEMF()
 * @model
 * @generated
 */
public interface TruckEMF extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.amalgamasimulation.tabletutorial.datamodel.DatamodelPackage#getTruckEMF_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.amalgamasimulation.tabletutorial.datamodel.TruckEMF#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capacity</em>' attribute.
	 * @see #setCapacity(double)
	 * @see com.amalgamasimulation.tabletutorial.datamodel.DatamodelPackage#getTruckEMF_Capacity()
	 * @model
	 * @generated
	 */
	double getCapacity();

	/**
	 * Sets the value of the '{@link com.amalgamasimulation.tabletutorial.datamodel.TruckEMF#getCapacity <em>Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capacity</em>' attribute.
	 * @see #getCapacity()
	 * @generated
	 */
	void setCapacity(double value);

	/**
	 * Returns the value of the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Active</em>' attribute.
	 * @see #setActive(boolean)
	 * @see com.amalgamasimulation.tabletutorial.datamodel.DatamodelPackage#getTruckEMF_Active()
	 * @model
	 * @generated
	 */
	boolean isActive();

	/**
	 * Sets the value of the '{@link com.amalgamasimulation.tabletutorial.datamodel.TruckEMF#isActive <em>Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Active</em>' attribute.
	 * @see #isActive()
	 * @generated
	 */
	void setActive(boolean value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link com.amalgamasimulation.tabletutorial.datamodel.TruckType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.TruckType
	 * @see #setType(TruckType)
	 * @see com.amalgamasimulation.tabletutorial.datamodel.DatamodelPackage#getTruckEMF_Type()
	 * @model
	 * @generated
	 */
	TruckType getType();

	/**
	 * Sets the value of the '{@link com.amalgamasimulation.tabletutorial.datamodel.TruckEMF#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.TruckType
	 * @see #getType()
	 * @generated
	 */
	void setType(TruckType value);

	/**
	 * Returns the value of the '<em><b>Driver</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Driver</em>' reference.
	 * @see #setDriver(DriverEMF)
	 * @see com.amalgamasimulation.tabletutorial.datamodel.DatamodelPackage#getTruckEMF_Driver()
	 * @model
	 * @generated
	 */
	DriverEMF getDriver();

	/**
	 * Sets the value of the '{@link com.amalgamasimulation.tabletutorial.datamodel.TruckEMF#getDriver <em>Driver</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Driver</em>' reference.
	 * @see #getDriver()
	 * @generated
	 */
	void setDriver(DriverEMF value);

	/**
	 * Returns the value of the '<em><b>Axles</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Axles</em>' attribute.
	 * @see #setAxles(int)
	 * @see com.amalgamasimulation.tabletutorial.datamodel.DatamodelPackage#getTruckEMF_Axles()
	 * @model
	 * @generated
	 */
	int getAxles();

	/**
	 * Sets the value of the '{@link com.amalgamasimulation.tabletutorial.datamodel.TruckEMF#getAxles <em>Axles</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Axles</em>' attribute.
	 * @see #getAxles()
	 * @generated
	 */
	void setAxles(int value);

	/**
	 * Returns the value of the '<em><b>Last Service</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Service</em>' attribute.
	 * @see #setLastService(LocalDateTime)
	 * @see com.amalgamasimulation.tabletutorial.datamodel.DatamodelPackage#getTruckEMF_LastService()
	 * @model dataType="com.amalgamasimulation.ecoreutils.LocalDateTime"
	 * @generated
	 */
	LocalDateTime getLastService();

	/**
	 * Sets the value of the '{@link com.amalgamasimulation.tabletutorial.datamodel.TruckEMF#getLastService <em>Last Service</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Service</em>' attribute.
	 * @see #getLastService()
	 * @generated
	 */
	void setLastService(LocalDateTime value);

	/**
	 * Returns the value of the '<em><b>Departure Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Departure Time</em>' attribute.
	 * @see #setDepartureTime(LocalTime)
	 * @see com.amalgamasimulation.tabletutorial.datamodel.DatamodelPackage#getTruckEMF_DepartureTime()
	 * @model dataType="com.amalgamasimulation.ecoreutils.LocalTime"
	 * @generated
	 */
	LocalTime getDepartureTime();

	/**
	 * Sets the value of the '{@link com.amalgamasimulation.tabletutorial.datamodel.TruckEMF#getDepartureTime <em>Departure Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Departure Time</em>' attribute.
	 * @see #getDepartureTime()
	 * @generated
	 */
	void setDepartureTime(LocalTime value);

	/**
	 * Returns the value of the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Color</em>' attribute.
	 * @see #setColor(Color)
	 * @see com.amalgamasimulation.tabletutorial.datamodel.DatamodelPackage#getTruckEMF_Color()
	 * @model dataType="com.amalgamasimulation.ecoreutils.Color"
	 * @generated
	 */
	Color getColor();

	/**
	 * Sets the value of the '{@link com.amalgamasimulation.tabletutorial.datamodel.TruckEMF#getColor <em>Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color</em>' attribute.
	 * @see #getColor()
	 * @generated
	 */
	void setColor(Color value);

	/**
	 * Returns the value of the '<em><b>Loading Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loading Time</em>' attribute.
	 * @see #setLoadingTime(RealDistribution)
	 * @see com.amalgamasimulation.tabletutorial.datamodel.DatamodelPackage#getTruckEMF_LoadingTime()
	 * @model dataType="com.amalgamasimulation.ecoreutils.RealDistribution"
	 * @generated
	 */
	RealDistribution getLoadingTime();

	/**
	 * Sets the value of the '{@link com.amalgamasimulation.tabletutorial.datamodel.TruckEMF#getLoadingTime <em>Loading Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loading Time</em>' attribute.
	 * @see #getLoadingTime()
	 * @generated
	 */
	void setLoadingTime(RealDistribution value);

	/**
	 * Returns the value of the '<em><b>Schedule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schedule</em>' containment reference.
	 * @see #setSchedule(TimeSeries)
	 * @see com.amalgamasimulation.tabletutorial.datamodel.DatamodelPackage#getTruckEMF_Schedule()
	 * @model containment="true"
	 * @generated
	 */
	TimeSeries getSchedule();

	/**
	 * Sets the value of the '{@link com.amalgamasimulation.tabletutorial.datamodel.TruckEMF#getSchedule <em>Schedule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schedule</em>' containment reference.
	 * @see #getSchedule()
	 * @generated
	 */
	void setSchedule(TimeSeries value);

} // TruckEMF
