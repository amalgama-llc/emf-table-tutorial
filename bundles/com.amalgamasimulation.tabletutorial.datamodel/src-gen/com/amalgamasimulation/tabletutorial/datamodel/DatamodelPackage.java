/**
 */
package com.amalgamasimulation.tabletutorial.datamodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.amalgamasimulation.tabletutorial.datamodel.DatamodelFactory
 * @model kind="package"
 * @generated
 */
public interface DatamodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "datamodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/datamodel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "datamodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DatamodelPackage eINSTANCE = com.amalgamasimulation.tabletutorial.datamodel.impl.DatamodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.amalgamasimulation.tabletutorial.datamodel.impl.ScenarioImpl <em>Scenario</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.amalgamasimulation.tabletutorial.datamodel.impl.ScenarioImpl
	 * @see com.amalgamasimulation.tabletutorial.datamodel.impl.DatamodelPackageImpl#getScenario()
	 * @generated
	 */
	int SCENARIO = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__NAME = 0;

	/**
	 * The feature id for the '<em><b>Begin Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__BEGIN_DATE = 1;

	/**
	 * The feature id for the '<em><b>End Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__END_DATE = 2;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__NODES = 3;

	/**
	 * The feature id for the '<em><b>Arcs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__ARCS = 4;

	/**
	 * The feature id for the '<em><b>Agents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__AGENTS = 5;

	/**
	 * The feature id for the '<em><b>People</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__PEOPLE = 6;

	/**
	 * The number of structural features of the '<em>Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.amalgamasimulation.tabletutorial.datamodel.impl.ArcImpl <em>Arc</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.amalgamasimulation.tabletutorial.datamodel.impl.ArcImpl
	 * @see com.amalgamasimulation.tabletutorial.datamodel.impl.DatamodelPackageImpl#getArc()
	 * @generated
	 */
	int ARC = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC__NAME = 1;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC__SOURCE = 2;

	/**
	 * The feature id for the '<em><b>Dest</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC__DEST = 3;

	/**
	 * The feature id for the '<em><b>Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC__POINTS = 4;

	/**
	 * The feature id for the '<em><b>Scenario</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC__SCENARIO = 5;

	/**
	 * The number of structural features of the '<em>Arc</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Arc</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.amalgamasimulation.tabletutorial.datamodel.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.amalgamasimulation.tabletutorial.datamodel.impl.NodeImpl
	 * @see com.amalgamasimulation.tabletutorial.datamodel.impl.DatamodelPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__Y = 2;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__X = 3;

	/**
	 * The feature id for the '<em><b>Scenario</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__SCENARIO = 4;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.amalgamasimulation.tabletutorial.datamodel.impl.PointImpl <em>Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.amalgamasimulation.tabletutorial.datamodel.impl.PointImpl
	 * @see com.amalgamasimulation.tabletutorial.datamodel.impl.DatamodelPackageImpl#getPoint()
	 * @generated
	 */
	int POINT = 3;

	/**
	 * The feature id for the '<em><b>Arc</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT__ARC = 0;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT__Y = 1;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT__X = 2;

	/**
	 * The number of structural features of the '<em>Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.amalgamasimulation.tabletutorial.datamodel.impl.AgentImpl <em>Agent</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.amalgamasimulation.tabletutorial.datamodel.impl.AgentImpl
	 * @see com.amalgamasimulation.tabletutorial.datamodel.impl.DatamodelPackageImpl#getAgent()
	 * @generated
	 */
	int AGENT = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__NAME = 1;

	/**
	 * The feature id for the '<em><b>Included</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__INCLUDED = 2;

	/**
	 * The feature id for the '<em><b>Base Position</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__BASE_POSITION = 3;

	/**
	 * The feature id for the '<em><b>Velocity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__VELOCITY = 4;

	/**
	 * The feature id for the '<em><b>Scenario</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__SCENARIO = 5;

	/**
	 * The number of structural features of the '<em>Agent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Agent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.amalgamasimulation.tabletutorial.datamodel.impl.PersonEMFImpl <em>Person EMF</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.amalgamasimulation.tabletutorial.datamodel.impl.PersonEMFImpl
	 * @see com.amalgamasimulation.tabletutorial.datamodel.impl.DatamodelPackageImpl#getPersonEMF()
	 * @generated
	 */
	int PERSON_EMF = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_EMF__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_EMF__NAME = 1;

	/**
	 * The feature id for the '<em><b>Is Preferential</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_EMF__IS_PREFERENTIAL = 2;

	/**
	 * The feature id for the '<em><b>Arrive Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_EMF__ARRIVE_TIME = 3;

	/**
	 * The feature id for the '<em><b>Purchase Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_EMF__PURCHASE_DATE = 4;

	/**
	 * The feature id for the '<em><b>Favourite Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_EMF__FAVOURITE_COLOR = 5;

	/**
	 * The feature id for the '<em><b>Cars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_EMF__CARS = 6;

	/**
	 * The feature id for the '<em><b>Main Car</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_EMF__MAIN_CAR = 7;

	/**
	 * The feature id for the '<em><b>Scenario</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_EMF__SCENARIO = 8;

	/**
	 * The feature id for the '<em><b>Country</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_EMF__COUNTRY = 9;

	/**
	 * The feature id for the '<em><b>Visit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_EMF__VISIT = 10;

	/**
	 * The feature id for the '<em><b>Visit Distribution</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_EMF__VISIT_DISTRIBUTION = 11;

	/**
	 * The number of structural features of the '<em>Person EMF</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_EMF_FEATURE_COUNT = 12;

	/**
	 * The number of operations of the '<em>Person EMF</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_EMF_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.amalgamasimulation.tabletutorial.datamodel.impl.CarEMFImpl <em>Car EMF</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.amalgamasimulation.tabletutorial.datamodel.impl.CarEMFImpl
	 * @see com.amalgamasimulation.tabletutorial.datamodel.impl.DatamodelPackageImpl#getCarEMF()
	 * @generated
	 */
	int CAR_EMF = 6;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAR_EMF__NUMBER = 0;

	/**
	 * The feature id for the '<em><b>Person</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAR_EMF__PERSON = 1;

	/**
	 * The number of structural features of the '<em>Car EMF</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAR_EMF_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Car EMF</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAR_EMF_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.amalgamasimulation.tabletutorial.datamodel.Country <em>Country</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.amalgamasimulation.tabletutorial.datamodel.Country
	 * @see com.amalgamasimulation.tabletutorial.datamodel.impl.DatamodelPackageImpl#getCountry()
	 * @generated
	 */
	int COUNTRY = 7;

	/**
	 * Returns the meta object for class '{@link com.amalgamasimulation.tabletutorial.datamodel.Scenario <em>Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scenario</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.Scenario
	 * @generated
	 */
	EClass getScenario();

	/**
	 * Returns the meta object for the attribute '{@link com.amalgamasimulation.tabletutorial.datamodel.Scenario#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.Scenario#getName()
	 * @see #getScenario()
	 * @generated
	 */
	EAttribute getScenario_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.amalgamasimulation.tabletutorial.datamodel.Scenario#getBeginDate <em>Begin Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Begin Date</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.Scenario#getBeginDate()
	 * @see #getScenario()
	 * @generated
	 */
	EAttribute getScenario_BeginDate();

	/**
	 * Returns the meta object for the attribute '{@link com.amalgamasimulation.tabletutorial.datamodel.Scenario#getEndDate <em>End Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Date</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.Scenario#getEndDate()
	 * @see #getScenario()
	 * @generated
	 */
	EAttribute getScenario_EndDate();

	/**
	 * Returns the meta object for the containment reference list '{@link com.amalgamasimulation.tabletutorial.datamodel.Scenario#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.Scenario#getNodes()
	 * @see #getScenario()
	 * @generated
	 */
	EReference getScenario_Nodes();

	/**
	 * Returns the meta object for the containment reference list '{@link com.amalgamasimulation.tabletutorial.datamodel.Scenario#getArcs <em>Arcs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Arcs</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.Scenario#getArcs()
	 * @see #getScenario()
	 * @generated
	 */
	EReference getScenario_Arcs();

	/**
	 * Returns the meta object for the containment reference list '{@link com.amalgamasimulation.tabletutorial.datamodel.Scenario#getAgents <em>Agents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Agents</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.Scenario#getAgents()
	 * @see #getScenario()
	 * @generated
	 */
	EReference getScenario_Agents();

	/**
	 * Returns the meta object for the reference list '{@link com.amalgamasimulation.tabletutorial.datamodel.Scenario#getPeople <em>People</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>People</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.Scenario#getPeople()
	 * @see #getScenario()
	 * @generated
	 */
	EReference getScenario_People();

	/**
	 * Returns the meta object for class '{@link com.amalgamasimulation.tabletutorial.datamodel.Arc <em>Arc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Arc</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.Arc
	 * @generated
	 */
	EClass getArc();

	/**
	 * Returns the meta object for the attribute '{@link com.amalgamasimulation.tabletutorial.datamodel.Arc#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.Arc#getId()
	 * @see #getArc()
	 * @generated
	 */
	EAttribute getArc_Id();

	/**
	 * Returns the meta object for the attribute '{@link com.amalgamasimulation.tabletutorial.datamodel.Arc#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.Arc#getName()
	 * @see #getArc()
	 * @generated
	 */
	EAttribute getArc_Name();

	/**
	 * Returns the meta object for the reference '{@link com.amalgamasimulation.tabletutorial.datamodel.Arc#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.Arc#getSource()
	 * @see #getArc()
	 * @generated
	 */
	EReference getArc_Source();

	/**
	 * Returns the meta object for the reference '{@link com.amalgamasimulation.tabletutorial.datamodel.Arc#getDest <em>Dest</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Dest</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.Arc#getDest()
	 * @see #getArc()
	 * @generated
	 */
	EReference getArc_Dest();

	/**
	 * Returns the meta object for the containment reference list '{@link com.amalgamasimulation.tabletutorial.datamodel.Arc#getPoints <em>Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Points</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.Arc#getPoints()
	 * @see #getArc()
	 * @generated
	 */
	EReference getArc_Points();

	/**
	 * Returns the meta object for the container reference '{@link com.amalgamasimulation.tabletutorial.datamodel.Arc#getScenario <em>Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Scenario</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.Arc#getScenario()
	 * @see #getArc()
	 * @generated
	 */
	EReference getArc_Scenario();

	/**
	 * Returns the meta object for class '{@link com.amalgamasimulation.tabletutorial.datamodel.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the attribute '{@link com.amalgamasimulation.tabletutorial.datamodel.Node#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.Node#getId()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Id();

	/**
	 * Returns the meta object for the attribute '{@link com.amalgamasimulation.tabletutorial.datamodel.Node#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.Node#getName()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.amalgamasimulation.tabletutorial.datamodel.Node#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.Node#getY()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Y();

	/**
	 * Returns the meta object for the attribute '{@link com.amalgamasimulation.tabletutorial.datamodel.Node#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.Node#getX()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_X();

	/**
	 * Returns the meta object for the container reference '{@link com.amalgamasimulation.tabletutorial.datamodel.Node#getScenario <em>Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Scenario</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.Node#getScenario()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Scenario();

	/**
	 * Returns the meta object for class '{@link com.amalgamasimulation.tabletutorial.datamodel.Point <em>Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Point</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.Point
	 * @generated
	 */
	EClass getPoint();

	/**
	 * Returns the meta object for the container reference '{@link com.amalgamasimulation.tabletutorial.datamodel.Point#getArc <em>Arc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Arc</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.Point#getArc()
	 * @see #getPoint()
	 * @generated
	 */
	EReference getPoint_Arc();

	/**
	 * Returns the meta object for the attribute '{@link com.amalgamasimulation.tabletutorial.datamodel.Point#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.Point#getY()
	 * @see #getPoint()
	 * @generated
	 */
	EAttribute getPoint_Y();

	/**
	 * Returns the meta object for the attribute '{@link com.amalgamasimulation.tabletutorial.datamodel.Point#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.Point#getX()
	 * @see #getPoint()
	 * @generated
	 */
	EAttribute getPoint_X();

	/**
	 * Returns the meta object for class '{@link com.amalgamasimulation.tabletutorial.datamodel.Agent <em>Agent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Agent</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.Agent
	 * @generated
	 */
	EClass getAgent();

	/**
	 * Returns the meta object for the attribute '{@link com.amalgamasimulation.tabletutorial.datamodel.Agent#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.Agent#getId()
	 * @see #getAgent()
	 * @generated
	 */
	EAttribute getAgent_Id();

	/**
	 * Returns the meta object for the attribute '{@link com.amalgamasimulation.tabletutorial.datamodel.Agent#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.Agent#getName()
	 * @see #getAgent()
	 * @generated
	 */
	EAttribute getAgent_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.amalgamasimulation.tabletutorial.datamodel.Agent#isIncluded <em>Included</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Included</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.Agent#isIncluded()
	 * @see #getAgent()
	 * @generated
	 */
	EAttribute getAgent_Included();

	/**
	 * Returns the meta object for the reference '{@link com.amalgamasimulation.tabletutorial.datamodel.Agent#getBasePosition <em>Base Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Position</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.Agent#getBasePosition()
	 * @see #getAgent()
	 * @generated
	 */
	EReference getAgent_BasePosition();

	/**
	 * Returns the meta object for the attribute '{@link com.amalgamasimulation.tabletutorial.datamodel.Agent#getVelocity <em>Velocity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Velocity</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.Agent#getVelocity()
	 * @see #getAgent()
	 * @generated
	 */
	EAttribute getAgent_Velocity();

	/**
	 * Returns the meta object for the container reference '{@link com.amalgamasimulation.tabletutorial.datamodel.Agent#getScenario <em>Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Scenario</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.Agent#getScenario()
	 * @see #getAgent()
	 * @generated
	 */
	EReference getAgent_Scenario();

	/**
	 * Returns the meta object for class '{@link com.amalgamasimulation.tabletutorial.datamodel.PersonEMF <em>Person EMF</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Person EMF</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.PersonEMF
	 * @generated
	 */
	EClass getPersonEMF();

	/**
	 * Returns the meta object for the attribute '{@link com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#getId()
	 * @see #getPersonEMF()
	 * @generated
	 */
	EAttribute getPersonEMF_Id();

	/**
	 * Returns the meta object for the attribute '{@link com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#getName()
	 * @see #getPersonEMF()
	 * @generated
	 */
	EAttribute getPersonEMF_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#isIsPreferential <em>Is Preferential</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Preferential</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#isIsPreferential()
	 * @see #getPersonEMF()
	 * @generated
	 */
	EAttribute getPersonEMF_IsPreferential();

	/**
	 * Returns the meta object for the attribute '{@link com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#getArriveTime <em>Arrive Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Arrive Time</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#getArriveTime()
	 * @see #getPersonEMF()
	 * @generated
	 */
	EAttribute getPersonEMF_ArriveTime();

	/**
	 * Returns the meta object for the attribute '{@link com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#getPurchaseDate <em>Purchase Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Purchase Date</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#getPurchaseDate()
	 * @see #getPersonEMF()
	 * @generated
	 */
	EAttribute getPersonEMF_PurchaseDate();

	/**
	 * Returns the meta object for the attribute '{@link com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#getFavouriteColor <em>Favourite Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Favourite Color</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#getFavouriteColor()
	 * @see #getPersonEMF()
	 * @generated
	 */
	EAttribute getPersonEMF_FavouriteColor();

	/**
	 * Returns the meta object for the containment reference list '{@link com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#getCars <em>Cars</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Cars</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#getCars()
	 * @see #getPersonEMF()
	 * @generated
	 */
	EReference getPersonEMF_Cars();

	/**
	 * Returns the meta object for the reference '{@link com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#getMainCar <em>Main Car</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Main Car</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#getMainCar()
	 * @see #getPersonEMF()
	 * @generated
	 */
	EReference getPersonEMF_MainCar();

	/**
	 * Returns the meta object for the reference '{@link com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#getScenario <em>Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Scenario</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#getScenario()
	 * @see #getPersonEMF()
	 * @generated
	 */
	EReference getPersonEMF_Scenario();

	/**
	 * Returns the meta object for the attribute '{@link com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#getCountry <em>Country</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Country</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#getCountry()
	 * @see #getPersonEMF()
	 * @generated
	 */
	EAttribute getPersonEMF_Country();

	/**
	 * Returns the meta object for the reference '{@link com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#getVisit <em>Visit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Visit</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#getVisit()
	 * @see #getPersonEMF()
	 * @generated
	 */
	EReference getPersonEMF_Visit();

	/**
	 * Returns the meta object for the reference '{@link com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#getVisitDistribution <em>Visit Distribution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Visit Distribution</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.PersonEMF#getVisitDistribution()
	 * @see #getPersonEMF()
	 * @generated
	 */
	EReference getPersonEMF_VisitDistribution();

	/**
	 * Returns the meta object for class '{@link com.amalgamasimulation.tabletutorial.datamodel.CarEMF <em>Car EMF</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Car EMF</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.CarEMF
	 * @generated
	 */
	EClass getCarEMF();

	/**
	 * Returns the meta object for the attribute '{@link com.amalgamasimulation.tabletutorial.datamodel.CarEMF#getNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.CarEMF#getNumber()
	 * @see #getCarEMF()
	 * @generated
	 */
	EAttribute getCarEMF_Number();

	/**
	 * Returns the meta object for the reference '{@link com.amalgamasimulation.tabletutorial.datamodel.CarEMF#getPerson <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Person</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.CarEMF#getPerson()
	 * @see #getCarEMF()
	 * @generated
	 */
	EReference getCarEMF_Person();

	/**
	 * Returns the meta object for enum '{@link com.amalgamasimulation.tabletutorial.datamodel.Country <em>Country</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Country</em>'.
	 * @see com.amalgamasimulation.tabletutorial.datamodel.Country
	 * @generated
	 */
	EEnum getCountry();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DatamodelFactory getDatamodelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.amalgamasimulation.tabletutorial.datamodel.impl.ScenarioImpl <em>Scenario</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.amalgamasimulation.tabletutorial.datamodel.impl.ScenarioImpl
		 * @see com.amalgamasimulation.tabletutorial.datamodel.impl.DatamodelPackageImpl#getScenario()
		 * @generated
		 */
		EClass SCENARIO = eINSTANCE.getScenario();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCENARIO__NAME = eINSTANCE.getScenario_Name();

		/**
		 * The meta object literal for the '<em><b>Begin Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCENARIO__BEGIN_DATE = eINSTANCE.getScenario_BeginDate();

		/**
		 * The meta object literal for the '<em><b>End Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCENARIO__END_DATE = eINSTANCE.getScenario_EndDate();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCENARIO__NODES = eINSTANCE.getScenario_Nodes();

		/**
		 * The meta object literal for the '<em><b>Arcs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCENARIO__ARCS = eINSTANCE.getScenario_Arcs();

		/**
		 * The meta object literal for the '<em><b>Agents</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCENARIO__AGENTS = eINSTANCE.getScenario_Agents();

		/**
		 * The meta object literal for the '<em><b>People</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCENARIO__PEOPLE = eINSTANCE.getScenario_People();

		/**
		 * The meta object literal for the '{@link com.amalgamasimulation.tabletutorial.datamodel.impl.ArcImpl <em>Arc</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.amalgamasimulation.tabletutorial.datamodel.impl.ArcImpl
		 * @see com.amalgamasimulation.tabletutorial.datamodel.impl.DatamodelPackageImpl#getArc()
		 * @generated
		 */
		EClass ARC = eINSTANCE.getArc();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARC__ID = eINSTANCE.getArc_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARC__NAME = eINSTANCE.getArc_Name();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARC__SOURCE = eINSTANCE.getArc_Source();

		/**
		 * The meta object literal for the '<em><b>Dest</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARC__DEST = eINSTANCE.getArc_Dest();

		/**
		 * The meta object literal for the '<em><b>Points</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARC__POINTS = eINSTANCE.getArc_Points();

		/**
		 * The meta object literal for the '<em><b>Scenario</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARC__SCENARIO = eINSTANCE.getArc_Scenario();

		/**
		 * The meta object literal for the '{@link com.amalgamasimulation.tabletutorial.datamodel.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.amalgamasimulation.tabletutorial.datamodel.impl.NodeImpl
		 * @see com.amalgamasimulation.tabletutorial.datamodel.impl.DatamodelPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__ID = eINSTANCE.getNode_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__NAME = eINSTANCE.getNode_Name();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__Y = eINSTANCE.getNode_Y();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__X = eINSTANCE.getNode_X();

		/**
		 * The meta object literal for the '<em><b>Scenario</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__SCENARIO = eINSTANCE.getNode_Scenario();

		/**
		 * The meta object literal for the '{@link com.amalgamasimulation.tabletutorial.datamodel.impl.PointImpl <em>Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.amalgamasimulation.tabletutorial.datamodel.impl.PointImpl
		 * @see com.amalgamasimulation.tabletutorial.datamodel.impl.DatamodelPackageImpl#getPoint()
		 * @generated
		 */
		EClass POINT = eINSTANCE.getPoint();

		/**
		 * The meta object literal for the '<em><b>Arc</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POINT__ARC = eINSTANCE.getPoint_Arc();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POINT__Y = eINSTANCE.getPoint_Y();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POINT__X = eINSTANCE.getPoint_X();

		/**
		 * The meta object literal for the '{@link com.amalgamasimulation.tabletutorial.datamodel.impl.AgentImpl <em>Agent</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.amalgamasimulation.tabletutorial.datamodel.impl.AgentImpl
		 * @see com.amalgamasimulation.tabletutorial.datamodel.impl.DatamodelPackageImpl#getAgent()
		 * @generated
		 */
		EClass AGENT = eINSTANCE.getAgent();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGENT__ID = eINSTANCE.getAgent_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGENT__NAME = eINSTANCE.getAgent_Name();

		/**
		 * The meta object literal for the '<em><b>Included</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGENT__INCLUDED = eINSTANCE.getAgent_Included();

		/**
		 * The meta object literal for the '<em><b>Base Position</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGENT__BASE_POSITION = eINSTANCE.getAgent_BasePosition();

		/**
		 * The meta object literal for the '<em><b>Velocity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGENT__VELOCITY = eINSTANCE.getAgent_Velocity();

		/**
		 * The meta object literal for the '<em><b>Scenario</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGENT__SCENARIO = eINSTANCE.getAgent_Scenario();

		/**
		 * The meta object literal for the '{@link com.amalgamasimulation.tabletutorial.datamodel.impl.PersonEMFImpl <em>Person EMF</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.amalgamasimulation.tabletutorial.datamodel.impl.PersonEMFImpl
		 * @see com.amalgamasimulation.tabletutorial.datamodel.impl.DatamodelPackageImpl#getPersonEMF()
		 * @generated
		 */
		EClass PERSON_EMF = eINSTANCE.getPersonEMF();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON_EMF__ID = eINSTANCE.getPersonEMF_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON_EMF__NAME = eINSTANCE.getPersonEMF_Name();

		/**
		 * The meta object literal for the '<em><b>Is Preferential</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON_EMF__IS_PREFERENTIAL = eINSTANCE.getPersonEMF_IsPreferential();

		/**
		 * The meta object literal for the '<em><b>Arrive Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON_EMF__ARRIVE_TIME = eINSTANCE.getPersonEMF_ArriveTime();

		/**
		 * The meta object literal for the '<em><b>Purchase Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON_EMF__PURCHASE_DATE = eINSTANCE.getPersonEMF_PurchaseDate();

		/**
		 * The meta object literal for the '<em><b>Favourite Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON_EMF__FAVOURITE_COLOR = eINSTANCE.getPersonEMF_FavouriteColor();

		/**
		 * The meta object literal for the '<em><b>Cars</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERSON_EMF__CARS = eINSTANCE.getPersonEMF_Cars();

		/**
		 * The meta object literal for the '<em><b>Main Car</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERSON_EMF__MAIN_CAR = eINSTANCE.getPersonEMF_MainCar();

		/**
		 * The meta object literal for the '<em><b>Scenario</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERSON_EMF__SCENARIO = eINSTANCE.getPersonEMF_Scenario();

		/**
		 * The meta object literal for the '<em><b>Country</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON_EMF__COUNTRY = eINSTANCE.getPersonEMF_Country();

		/**
		 * The meta object literal for the '<em><b>Visit</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERSON_EMF__VISIT = eINSTANCE.getPersonEMF_Visit();

		/**
		 * The meta object literal for the '<em><b>Visit Distribution</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERSON_EMF__VISIT_DISTRIBUTION = eINSTANCE.getPersonEMF_VisitDistribution();

		/**
		 * The meta object literal for the '{@link com.amalgamasimulation.tabletutorial.datamodel.impl.CarEMFImpl <em>Car EMF</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.amalgamasimulation.tabletutorial.datamodel.impl.CarEMFImpl
		 * @see com.amalgamasimulation.tabletutorial.datamodel.impl.DatamodelPackageImpl#getCarEMF()
		 * @generated
		 */
		EClass CAR_EMF = eINSTANCE.getCarEMF();

		/**
		 * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CAR_EMF__NUMBER = eINSTANCE.getCarEMF_Number();

		/**
		 * The meta object literal for the '<em><b>Person</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CAR_EMF__PERSON = eINSTANCE.getCarEMF_Person();

		/**
		 * The meta object literal for the '{@link com.amalgamasimulation.tabletutorial.datamodel.Country <em>Country</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.amalgamasimulation.tabletutorial.datamodel.Country
		 * @see com.amalgamasimulation.tabletutorial.datamodel.impl.DatamodelPackageImpl#getCountry()
		 * @generated
		 */
		EEnum COUNTRY = eINSTANCE.getCountry();

	}

} //DatamodelPackage
