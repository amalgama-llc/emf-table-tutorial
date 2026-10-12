/**
 */
package com.amalgamasimulation.tabletutorial.datamodel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Truck Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.amalgamasimulation.tabletutorial.datamodel.DatamodelPackage#getTruckType()
 * @model
 * @generated
 */
public enum TruckType implements Enumerator {
	/**
	 * The '<em><b>FLATBED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FLATBED_VALUE
	 * @generated
	 * @ordered
	 */
	FLATBED(0, "FLATBED", "FLATBED"),

	/**
	 * The '<em><b>REFRIGERATOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REFRIGERATOR_VALUE
	 * @generated
	 * @ordered
	 */
	REFRIGERATOR(1, "REFRIGERATOR", "REFRIGERATOR"),

	/**
	 * The '<em><b>DUMP TRUCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DUMP_TRUCK_VALUE
	 * @generated
	 * @ordered
	 */
	DUMP_TRUCK(2, "DUMP_TRUCK", "DUMP_TRUCK");

	/**
	 * The '<em><b>FLATBED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FLATBED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FLATBED_VALUE = 0;

	/**
	 * The '<em><b>REFRIGERATOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REFRIGERATOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int REFRIGERATOR_VALUE = 1;

	/**
	 * The '<em><b>DUMP TRUCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DUMP_TRUCK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DUMP_TRUCK_VALUE = 2;

	/**
	 * An array of all the '<em><b>Truck Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TruckType[] VALUES_ARRAY = new TruckType[] { FLATBED, REFRIGERATOR, DUMP_TRUCK, };

	/**
	 * A public read-only list of all the '<em><b>Truck Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<TruckType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Truck Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TruckType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TruckType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Truck Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TruckType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TruckType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Truck Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TruckType get(int value) {
		switch (value) {
		case FLATBED_VALUE:
			return FLATBED;
		case REFRIGERATOR_VALUE:
			return REFRIGERATOR;
		case DUMP_TRUCK_VALUE:
			return DUMP_TRUCK;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private TruckType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
		return value;
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
	public String getLiteral() {
		return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} //TruckType
