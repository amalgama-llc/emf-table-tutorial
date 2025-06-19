/**
 */
package com.amalgamasimulation.tabletutorial.datamodel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Country</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.amalgamasimulation.tabletutorial.datamodel.DatamodelPackage#getCountry()
 * @model
 * @generated
 */
public enum Country implements Enumerator {
	/**
	 * The '<em><b>RUSSIA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RUSSIA_VALUE
	 * @generated
	 * @ordered
	 */
	RUSSIA(0, "RUSSIA", "RUSSIA"),

	/**
	 * The '<em><b>GERMANY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GERMANY_VALUE
	 * @generated
	 * @ordered
	 */
	GERMANY(1, "GERMANY", "GERMANY"),

	/**
	 * The '<em><b>PORTUGAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PORTUGAL_VALUE
	 * @generated
	 * @ordered
	 */
	PORTUGAL(2, "PORTUGAL", "PORTUGAL"),

	/**
	 * The '<em><b>ITALY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ITALY_VALUE
	 * @generated
	 * @ordered
	 */
	ITALY(3, "ITALY", "ITALY");

	/**
	 * The '<em><b>RUSSIA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RUSSIA
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RUSSIA_VALUE = 0;

	/**
	 * The '<em><b>GERMANY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GERMANY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GERMANY_VALUE = 1;

	/**
	 * The '<em><b>PORTUGAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PORTUGAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PORTUGAL_VALUE = 2;

	/**
	 * The '<em><b>ITALY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ITALY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ITALY_VALUE = 3;

	/**
	 * An array of all the '<em><b>Country</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Country[] VALUES_ARRAY = new Country[] { RUSSIA, GERMANY, PORTUGAL, ITALY, };

	/**
	 * A public read-only list of all the '<em><b>Country</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Country> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Country</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Country get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Country result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Country</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Country getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Country result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Country</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Country get(int value) {
		switch (value) {
		case RUSSIA_VALUE:
			return RUSSIA;
		case GERMANY_VALUE:
			return GERMANY;
		case PORTUGAL_VALUE:
			return PORTUGAL;
		case ITALY_VALUE:
			return ITALY;
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
	private Country(int value, String name, String literal) {
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

} //Country
