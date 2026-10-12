package com.amalgamasimulation.tabletutorial.application.editors;

/** A plain Java object: the driver of a {@link Truck}. */
public class Driver {

	private String name;
	private String phone;
	private int experience;

	public Driver(String name, String phone, int experience) {
		this.name = name;
		this.phone = phone;
		this.experience = experience;
	}

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getPhone() { return phone; }
	public void setPhone(String phone) { this.phone = phone; }
	public int getExperience() { return experience; }
	public void setExperience(int experience) { this.experience = experience; }
}
