/**
 */
package com.amalgamasimulation.tabletutorial.datamodel.impl;

import com.amalgamasimulation.tabletutorial.datamodel.Agent;
import com.amalgamasimulation.tabletutorial.datamodel.Arc;
import com.amalgamasimulation.tabletutorial.datamodel.DatamodelPackage;
import com.amalgamasimulation.tabletutorial.datamodel.Node;
import com.amalgamasimulation.tabletutorial.datamodel.PersonEMF;
import com.amalgamasimulation.tabletutorial.datamodel.Scenario;

import java.time.LocalDateTime;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
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
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.impl.ScenarioImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.impl.ScenarioImpl#getBeginDate <em>Begin Date</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.impl.ScenarioImpl#getEndDate <em>End Date</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.impl.ScenarioImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.impl.ScenarioImpl#getArcs <em>Arcs</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.impl.ScenarioImpl#getAgents <em>Agents</em>}</li>
 *   <li>{@link com.amalgamasimulation.tabletutorial.datamodel.impl.ScenarioImpl#getPeople <em>People</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ScenarioImpl extends MinimalEObjectImpl.Container implements Scenario {
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
	 * The default value of the '{@link #getBeginDate() <em>Begin Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBeginDate()
	 * @generated
	 * @ordered
	 */
	protected static final LocalDateTime BEGIN_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBeginDate() <em>Begin Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBeginDate()
	 * @generated
	 * @ordered
	 */
	protected LocalDateTime beginDate = BEGIN_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getEndDate() <em>End Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndDate()
	 * @generated
	 * @ordered
	 */
	protected static final LocalDateTime END_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEndDate() <em>End Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndDate()
	 * @generated
	 * @ordered
	 */
	protected LocalDateTime endDate = END_DATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<Node> nodes;

	/**
	 * The cached value of the '{@link #getArcs() <em>Arcs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArcs()
	 * @generated
	 * @ordered
	 */
	protected EList<Arc> arcs;

	/**
	 * The cached value of the '{@link #getAgents() <em>Agents</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAgents()
	 * @generated
	 * @ordered
	 */
	protected EList<Agent> agents;

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
			eNotify(new ENotificationImpl(this, Notification.SET, DatamodelPackage.SCENARIO__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LocalDateTime getBeginDate() {
		return beginDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBeginDate(LocalDateTime newBeginDate) {
		LocalDateTime oldBeginDate = beginDate;
		beginDate = newBeginDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatamodelPackage.SCENARIO__BEGIN_DATE, oldBeginDate,
					beginDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LocalDateTime getEndDate() {
		return endDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEndDate(LocalDateTime newEndDate) {
		LocalDateTime oldEndDate = endDate;
		endDate = newEndDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatamodelPackage.SCENARIO__END_DATE, oldEndDate,
					endDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Node> getNodes() {
		if (nodes == null) {
			nodes = new EObjectContainmentWithInverseEList<Node>(Node.class, this, DatamodelPackage.SCENARIO__NODES,
					DatamodelPackage.NODE__SCENARIO);
		}
		return nodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Arc> getArcs() {
		if (arcs == null) {
			arcs = new EObjectContainmentWithInverseEList<Arc>(Arc.class, this, DatamodelPackage.SCENARIO__ARCS,
					DatamodelPackage.ARC__SCENARIO);
		}
		return arcs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Agent> getAgents() {
		if (agents == null) {
			agents = new EObjectContainmentWithInverseEList<Agent>(Agent.class, this, DatamodelPackage.SCENARIO__AGENTS,
					DatamodelPackage.AGENT__SCENARIO);
		}
		return agents;
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
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case DatamodelPackage.SCENARIO__NODES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getNodes()).basicAdd(otherEnd, msgs);
		case DatamodelPackage.SCENARIO__ARCS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getArcs()).basicAdd(otherEnd, msgs);
		case DatamodelPackage.SCENARIO__AGENTS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getAgents()).basicAdd(otherEnd, msgs);
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
		case DatamodelPackage.SCENARIO__NODES:
			return ((InternalEList<?>) getNodes()).basicRemove(otherEnd, msgs);
		case DatamodelPackage.SCENARIO__ARCS:
			return ((InternalEList<?>) getArcs()).basicRemove(otherEnd, msgs);
		case DatamodelPackage.SCENARIO__AGENTS:
			return ((InternalEList<?>) getAgents()).basicRemove(otherEnd, msgs);
		case DatamodelPackage.SCENARIO__PEOPLE:
			return ((InternalEList<?>) getPeople()).basicRemove(otherEnd, msgs);
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
		case DatamodelPackage.SCENARIO__NAME:
			return getName();
		case DatamodelPackage.SCENARIO__BEGIN_DATE:
			return getBeginDate();
		case DatamodelPackage.SCENARIO__END_DATE:
			return getEndDate();
		case DatamodelPackage.SCENARIO__NODES:
			return getNodes();
		case DatamodelPackage.SCENARIO__ARCS:
			return getArcs();
		case DatamodelPackage.SCENARIO__AGENTS:
			return getAgents();
		case DatamodelPackage.SCENARIO__PEOPLE:
			return getPeople();
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
		case DatamodelPackage.SCENARIO__NAME:
			setName((String) newValue);
			return;
		case DatamodelPackage.SCENARIO__BEGIN_DATE:
			setBeginDate((LocalDateTime) newValue);
			return;
		case DatamodelPackage.SCENARIO__END_DATE:
			setEndDate((LocalDateTime) newValue);
			return;
		case DatamodelPackage.SCENARIO__NODES:
			getNodes().clear();
			getNodes().addAll((Collection<? extends Node>) newValue);
			return;
		case DatamodelPackage.SCENARIO__ARCS:
			getArcs().clear();
			getArcs().addAll((Collection<? extends Arc>) newValue);
			return;
		case DatamodelPackage.SCENARIO__AGENTS:
			getAgents().clear();
			getAgents().addAll((Collection<? extends Agent>) newValue);
			return;
		case DatamodelPackage.SCENARIO__PEOPLE:
			getPeople().clear();
			getPeople().addAll((Collection<? extends PersonEMF>) newValue);
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
		case DatamodelPackage.SCENARIO__NAME:
			setName(NAME_EDEFAULT);
			return;
		case DatamodelPackage.SCENARIO__BEGIN_DATE:
			setBeginDate(BEGIN_DATE_EDEFAULT);
			return;
		case DatamodelPackage.SCENARIO__END_DATE:
			setEndDate(END_DATE_EDEFAULT);
			return;
		case DatamodelPackage.SCENARIO__NODES:
			getNodes().clear();
			return;
		case DatamodelPackage.SCENARIO__ARCS:
			getArcs().clear();
			return;
		case DatamodelPackage.SCENARIO__AGENTS:
			getAgents().clear();
			return;
		case DatamodelPackage.SCENARIO__PEOPLE:
			getPeople().clear();
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
		case DatamodelPackage.SCENARIO__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case DatamodelPackage.SCENARIO__BEGIN_DATE:
			return BEGIN_DATE_EDEFAULT == null ? beginDate != null : !BEGIN_DATE_EDEFAULT.equals(beginDate);
		case DatamodelPackage.SCENARIO__END_DATE:
			return END_DATE_EDEFAULT == null ? endDate != null : !END_DATE_EDEFAULT.equals(endDate);
		case DatamodelPackage.SCENARIO__NODES:
			return nodes != null && !nodes.isEmpty();
		case DatamodelPackage.SCENARIO__ARCS:
			return arcs != null && !arcs.isEmpty();
		case DatamodelPackage.SCENARIO__AGENTS:
			return agents != null && !agents.isEmpty();
		case DatamodelPackage.SCENARIO__PEOPLE:
			return people != null && !people.isEmpty();
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
		result.append(", beginDate: ");
		result.append(beginDate);
		result.append(", endDate: ");
		result.append(endDate);
		result.append(')');
		return result.toString();
	}

} //ScenarioImpl
