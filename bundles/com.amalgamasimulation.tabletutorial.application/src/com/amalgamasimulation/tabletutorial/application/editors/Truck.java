package com.amalgamasimulation.tabletutorial.application.editors;

import static com.amalgamasimulation.tabletutorial.application.editors.SampleData.singleTimeSeries;

import java.awt.Color;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.apache.commons.math3.distribution.ConstantRealDistribution;
import org.apache.commons.math3.distribution.RealDistribution;

import com.amalgamasimulation.tabletutorial.datamodel.TruckType;
import com.amalgamasimulation.timeseriesdatamodel.TimeSeries;

/** A plain Java object edited by the container examples. */
public class Truck {

	private String name;
	private double capacity;
	private boolean active;
	private Driver driver;
	private TruckType type = TruckType.FLATBED;
	private int axles = 2;
	private LocalDateTime lastService = LocalDateTime.now().minusDays(30);
	private LocalTime departureTime = LocalTime.of(8, 0);
	private Color color = Color.ORANGE;
	private RealDistribution loadingTime = new ConstantRealDistribution(15);
	private TimeSeries schedule = singleTimeSeries(LocalDateTime.now().plusDays(1));
	private double temperature = -18;
	private double bodyVolume = 12;

	public Truck(String name, double capacity, boolean active, Driver driver) {
		this.name = name;
		this.capacity = capacity;
		this.active = active;
		this.driver = driver;
	}

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public double getCapacity() { return capacity; }
	public void setCapacity(double capacity) { this.capacity = capacity; }
	public boolean isActive() { return active; }
	public void setActive(boolean active) { this.active = active; }
	public Driver getDriver() { return driver; }
	public void setDriver(Driver driver) { this.driver = driver; }
	public TruckType getType() { return type; }
	public void setType(TruckType type) { this.type = type; }
	public int getAxles() { return axles; }
	public void setAxles(int axles) { this.axles = axles; }
	public LocalDateTime getLastService() { return lastService; }
	public void setLastService(LocalDateTime lastService) { this.lastService = lastService; }
	public LocalTime getDepartureTime() { return departureTime; }
	public void setDepartureTime(LocalTime departureTime) { this.departureTime = departureTime; }
	public Color getColor() { return color; }
	public void setColor(Color color) { this.color = color; }
	public RealDistribution getLoadingTime() { return loadingTime; }
	public void setLoadingTime(RealDistribution loadingTime) { this.loadingTime = loadingTime; }
	public TimeSeries getSchedule() { return schedule; }
	public void setSchedule(TimeSeries schedule) { this.schedule = schedule; }
	public double getTemperature() { return temperature; }
	public void setTemperature(double temperature) { this.temperature = temperature; }
	public double getBodyVolume() { return bodyVolume; }
	public void setBodyVolume(double bodyVolume) { this.bodyVolume = bodyVolume; }
}
