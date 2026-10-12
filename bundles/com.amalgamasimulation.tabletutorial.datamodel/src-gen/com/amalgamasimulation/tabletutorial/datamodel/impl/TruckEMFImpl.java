/**
 */
package com.amalgamasimulation.tabletutorial.datamodel.impl;

import com.amalgamasimulation.tabletutorial.datamodel.DatamodelPackage;
import com.amalgamasimulation.tabletutorial.datamodel.DriverEMF;
import com.amalgamasimulation.tabletutorial.datamodel.TruckEMF;
import com.amalgamasimulation.tabletutorial.datamodel.TruckType;

import com.amalgamasimulation.timeseriesdatamodel.TimeSeries;
import java.awt.Color;
import java.time.LocalDateTime;
import java.time.LocalTime;
import org.apache.commons.math3.distribution.RealDistribution;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Truck EMF</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.impl.TruckEMFImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.impl.TruckEMFImpl#getCapacity <em>Capacity</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.impl.TruckEMFImpl#isActive <em>Active</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.impl.TruckEMFImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.impl.TruckEMFImpl#getDriver <em>Driver</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.impl.TruckEMFImpl#getAxles <em>Axles</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.impl.TruckEMFImpl#getLastService <em>Last Service</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.impl.TruckEMFImpl#getDepartureTime <em>Departure Time</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.impl.TruckEMFImpl#getColor <em>Color</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.impl.TruckEMFImpl#getLoadingTime <em>Loading Time</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.impl.TruckEMFImpl#getSchedule <em>Schedule</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TruckEMFImpl extends MinimalEObjectImpl.Container implements TruckEMF {
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
	 * The default value of the '{@link #getCapacity() <em>Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCapacity()
	 * @generated
	 * @ordered
	 */
	protected static final double CAPACITY_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getCapacity() <em>Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCapacity()
	 * @generated
	 * @ordered
	 */
	protected double capacity = CAPACITY_EDEFAULT;

	/**
	 * The default value of the '{@link #isActive() <em>Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isActive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ACTIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isActive() <em>Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isActive()
	 * @generated
	 * @ordered
	 */
	protected boolean active = ACTIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final TruckType TYPE_EDEFAULT = TruckType.FLATBED;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected TruckType type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDriver() <em>Driver</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDriver()
	 * @generated
	 * @ordered
	 */
	protected DriverEMF driver;

	/**
	 * The default value of the '{@link #getAxles() <em>Axles</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAxles()
	 * @generated
	 * @ordered
	 */
	protected static final int AXLES_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getAxles() <em>Axles</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAxles()
	 * @generated
	 * @ordered
	 */
	protected int axles = AXLES_EDEFAULT;

	/**
	 * The default value of the '{@link #getLastService() <em>Last Service</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastService()
	 * @generated
	 * @ordered
	 */
	protected static final LocalDateTime LAST_SERVICE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLastService() <em>Last Service</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastService()
	 * @generated
	 * @ordered
	 */
	protected LocalDateTime lastService = LAST_SERVICE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDepartureTime() <em>Departure Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepartureTime()
	 * @generated
	 * @ordered
	 */
	protected static final LocalTime DEPARTURE_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDepartureTime() <em>Departure Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepartureTime()
	 * @generated
	 * @ordered
	 */
	protected LocalTime departureTime = DEPARTURE_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getColor() <em>Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColor()
	 * @generated
	 * @ordered
	 */
	protected static final Color COLOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getColor() <em>Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColor()
	 * @generated
	 * @ordered
	 */
	protected Color color = COLOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getLoadingTime() <em>Loading Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoadingTime()
	 * @generated
	 * @ordered
	 */
	protected static final RealDistribution LOADING_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLoadingTime() <em>Loading Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoadingTime()
	 * @generated
	 * @ordered
	 */
	protected RealDistribution loadingTime = LOADING_TIME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSchedule() <em>Schedule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedule()
	 * @generated
	 * @ordered
	 */
	protected TimeSeries schedule;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TruckEMFImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DatamodelPackage.Literals.TRUCK_EMF;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DatamodelPackage.TRUCK_EMF__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getCapacity() {
		return capacity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCapacity(double newCapacity) {
		double oldCapacity = capacity;
		capacity = newCapacity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatamodelPackage.TRUCK_EMF__CAPACITY, oldCapacity,
					capacity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isActive() {
		return active;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setActive(boolean newActive) {
		boolean oldActive = active;
		active = newActive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatamodelPackage.TRUCK_EMF__ACTIVE, oldActive,
					active));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TruckType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(TruckType newType) {
		TruckType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatamodelPackage.TRUCK_EMF__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DriverEMF getDriver() {
		if (driver != null && driver.eIsProxy()) {
			InternalEObject oldDriver = (InternalEObject) driver;
			driver = (DriverEMF) eResolveProxy(oldDriver);
			if (driver != oldDriver) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DatamodelPackage.TRUCK_EMF__DRIVER,
							oldDriver, driver));
			}
		}
		return driver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DriverEMF basicGetDriver() {
		return driver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDriver(DriverEMF newDriver) {
		DriverEMF oldDriver = driver;
		driver = newDriver;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatamodelPackage.TRUCK_EMF__DRIVER, oldDriver,
					driver));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getAxles() {
		return axles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAxles(int newAxles) {
		int oldAxles = axles;
		axles = newAxles;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatamodelPackage.TRUCK_EMF__AXLES, oldAxles, axles));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LocalDateTime getLastService() {
		return lastService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLastService(LocalDateTime newLastService) {
		LocalDateTime oldLastService = lastService;
		lastService = newLastService;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatamodelPackage.TRUCK_EMF__LAST_SERVICE,
					oldLastService, lastService));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LocalTime getDepartureTime() {
		return departureTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDepartureTime(LocalTime newDepartureTime) {
		LocalTime oldDepartureTime = departureTime;
		departureTime = newDepartureTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatamodelPackage.TRUCK_EMF__DEPARTURE_TIME,
					oldDepartureTime, departureTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Color getColor() {
		return color;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setColor(Color newColor) {
		Color oldColor = color;
		color = newColor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatamodelPackage.TRUCK_EMF__COLOR, oldColor, color));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RealDistribution getLoadingTime() {
		return loadingTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLoadingTime(RealDistribution newLoadingTime) {
		RealDistribution oldLoadingTime = loadingTime;
		loadingTime = newLoadingTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatamodelPackage.TRUCK_EMF__LOADING_TIME,
					oldLoadingTime, loadingTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TimeSeries getSchedule() {
		return schedule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSchedule(TimeSeries newSchedule, NotificationChain msgs) {
		TimeSeries oldSchedule = schedule;
		schedule = newSchedule;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					DatamodelPackage.TRUCK_EMF__SCHEDULE, oldSchedule, newSchedule);
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
	public void setSchedule(TimeSeries newSchedule) {
		if (newSchedule != schedule) {
			NotificationChain msgs = null;
			if (schedule != null)
				msgs = ((InternalEObject) schedule).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - DatamodelPackage.TRUCK_EMF__SCHEDULE, null, msgs);
			if (newSchedule != null)
				msgs = ((InternalEObject) newSchedule).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - DatamodelPackage.TRUCK_EMF__SCHEDULE, null, msgs);
			msgs = basicSetSchedule(newSchedule, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatamodelPackage.TRUCK_EMF__SCHEDULE, newSchedule,
					newSchedule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case DatamodelPackage.TRUCK_EMF__SCHEDULE:
			return basicSetSchedule(null, msgs);
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
		case DatamodelPackage.TRUCK_EMF__NAME:
			return getName();
		case DatamodelPackage.TRUCK_EMF__CAPACITY:
			return getCapacity();
		case DatamodelPackage.TRUCK_EMF__ACTIVE:
			return isActive();
		case DatamodelPackage.TRUCK_EMF__TYPE:
			return getType();
		case DatamodelPackage.TRUCK_EMF__DRIVER:
			if (resolve)
				return getDriver();
			return basicGetDriver();
		case DatamodelPackage.TRUCK_EMF__AXLES:
			return getAxles();
		case DatamodelPackage.TRUCK_EMF__LAST_SERVICE:
			return getLastService();
		case DatamodelPackage.TRUCK_EMF__DEPARTURE_TIME:
			return getDepartureTime();
		case DatamodelPackage.TRUCK_EMF__COLOR:
			return getColor();
		case DatamodelPackage.TRUCK_EMF__LOADING_TIME:
			return getLoadingTime();
		case DatamodelPackage.TRUCK_EMF__SCHEDULE:
			return getSchedule();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case DatamodelPackage.TRUCK_EMF__NAME:
			setName((String) newValue);
			return;
		case DatamodelPackage.TRUCK_EMF__CAPACITY:
			setCapacity((Double) newValue);
			return;
		case DatamodelPackage.TRUCK_EMF__ACTIVE:
			setActive((Boolean) newValue);
			return;
		case DatamodelPackage.TRUCK_EMF__TYPE:
			setType((TruckType) newValue);
			return;
		case DatamodelPackage.TRUCK_EMF__DRIVER:
			setDriver((DriverEMF) newValue);
			return;
		case DatamodelPackage.TRUCK_EMF__AXLES:
			setAxles((Integer) newValue);
			return;
		case DatamodelPackage.TRUCK_EMF__LAST_SERVICE:
			setLastService((LocalDateTime) newValue);
			return;
		case DatamodelPackage.TRUCK_EMF__DEPARTURE_TIME:
			setDepartureTime((LocalTime) newValue);
			return;
		case DatamodelPackage.TRUCK_EMF__COLOR:
			setColor((Color) newValue);
			return;
		case DatamodelPackage.TRUCK_EMF__LOADING_TIME:
			setLoadingTime((RealDistribution) newValue);
			return;
		case DatamodelPackage.TRUCK_EMF__SCHEDULE:
			setSchedule((TimeSeries) newValue);
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
		case DatamodelPackage.TRUCK_EMF__NAME:
			setName(NAME_EDEFAULT);
			return;
		case DatamodelPackage.TRUCK_EMF__CAPACITY:
			setCapacity(CAPACITY_EDEFAULT);
			return;
		case DatamodelPackage.TRUCK_EMF__ACTIVE:
			setActive(ACTIVE_EDEFAULT);
			return;
		case DatamodelPackage.TRUCK_EMF__TYPE:
			setType(TYPE_EDEFAULT);
			return;
		case DatamodelPackage.TRUCK_EMF__DRIVER:
			setDriver((DriverEMF) null);
			return;
		case DatamodelPackage.TRUCK_EMF__AXLES:
			setAxles(AXLES_EDEFAULT);
			return;
		case DatamodelPackage.TRUCK_EMF__LAST_SERVICE:
			setLastService(LAST_SERVICE_EDEFAULT);
			return;
		case DatamodelPackage.TRUCK_EMF__DEPARTURE_TIME:
			setDepartureTime(DEPARTURE_TIME_EDEFAULT);
			return;
		case DatamodelPackage.TRUCK_EMF__COLOR:
			setColor(COLOR_EDEFAULT);
			return;
		case DatamodelPackage.TRUCK_EMF__LOADING_TIME:
			setLoadingTime(LOADING_TIME_EDEFAULT);
			return;
		case DatamodelPackage.TRUCK_EMF__SCHEDULE:
			setSchedule((TimeSeries) null);
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
		case DatamodelPackage.TRUCK_EMF__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case DatamodelPackage.TRUCK_EMF__CAPACITY:
			return capacity != CAPACITY_EDEFAULT;
		case DatamodelPackage.TRUCK_EMF__ACTIVE:
			return active != ACTIVE_EDEFAULT;
		case DatamodelPackage.TRUCK_EMF__TYPE:
			return type != TYPE_EDEFAULT;
		case DatamodelPackage.TRUCK_EMF__DRIVER:
			return driver != null;
		case DatamodelPackage.TRUCK_EMF__AXLES:
			return axles != AXLES_EDEFAULT;
		case DatamodelPackage.TRUCK_EMF__LAST_SERVICE:
			return LAST_SERVICE_EDEFAULT == null ? lastService != null : !LAST_SERVICE_EDEFAULT.equals(lastService);
		case DatamodelPackage.TRUCK_EMF__DEPARTURE_TIME:
			return DEPARTURE_TIME_EDEFAULT == null ? departureTime != null
					: !DEPARTURE_TIME_EDEFAULT.equals(departureTime);
		case DatamodelPackage.TRUCK_EMF__COLOR:
			return COLOR_EDEFAULT == null ? color != null : !COLOR_EDEFAULT.equals(color);
		case DatamodelPackage.TRUCK_EMF__LOADING_TIME:
			return LOADING_TIME_EDEFAULT == null ? loadingTime != null : !LOADING_TIME_EDEFAULT.equals(loadingTime);
		case DatamodelPackage.TRUCK_EMF__SCHEDULE:
			return schedule != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", capacity: ");
		result.append(capacity);
		result.append(", active: ");
		result.append(active);
		result.append(", type: ");
		result.append(type);
		result.append(", axles: ");
		result.append(axles);
		result.append(", lastService: ");
		result.append(lastService);
		result.append(", departureTime: ");
		result.append(departureTime);
		result.append(", color: ");
		result.append(color);
		result.append(", loadingTime: ");
		result.append(loadingTime);
		result.append(')');
		return result.toString();
	}

} //TruckEMFImpl
