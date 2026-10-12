package com.amalgamasimulation.tabletutorial.application.editors;

import java.awt.Color;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.distribution.ConstantRealDistribution;

import com.amalgamasimulation.tabletutorial.datamodel.DatamodelFactory;
import com.amalgamasimulation.tabletutorial.datamodel.DriverEMF;
import com.amalgamasimulation.tabletutorial.datamodel.Scenario;
import com.amalgamasimulation.tabletutorial.datamodel.TruckEMF;
import com.amalgamasimulation.tabletutorial.datamodel.TruckType;
import com.amalgamasimulation.timeseriesdatamodel.SingleTimeSeries;
import com.amalgamasimulation.timeseriesdatamodel.TimeSeries;
import com.amalgamasimulation.timeseriesdatamodel.TimeseriesdatamodelFactory;

/** The objects that the examples edit: plain trucks and drivers for the container editors, a scenario for the EMF editors. */
public final class SampleData {

	private SampleData() {
	}

	public static List<Driver> createDrivers() {
		return List.of(new Driver("Ann", "+1 555 0101", 12), new Driver("Bob", "+1 555 0102", 3), new Driver("Carl", "+1 555 0103", 7));
	}

	public static List<Truck> createTrucks(List<Driver> drivers) {
		List<Truck> trucks = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			Truck truck = new Truck("Truck " + (i + 1), List.of(40.0, 55.0, 30.0).get(i), i != 1, drivers.get(i));
			truck.setType(TruckType.get(i));
			truck.setAxles(2 + i);
			truck.setLastService(LocalDateTime.now().minusDays(10 * (i + 1)));
			truck.setDepartureTime(LocalTime.of(7 + i, 30));
			truck.setColor(List.of(Color.ORANGE, Color.GRAY, Color.RED).get(i));
			truck.setLoadingTime(new ConstantRealDistribution(10 + 5 * i));
			truck.setSchedule(singleTimeSeries(LocalDateTime.now().plusDays(i + 1)));
			trucks.add(truck);
		}
		return trucks;
	}

	public static Scenario createScenario() {
		Scenario scenario = DatamodelFactory.eINSTANCE.createScenario();
		for (String name : List.of("Ann", "Bob", "Carl")) {
			DriverEMF driver = DatamodelFactory.eINSTANCE.createDriverEMF();
			driver.setName(name);
			scenario.getDrivers().add(driver);
		}
		for (int i = 0; i < 3; i++) {
			TruckEMF truck = DatamodelFactory.eINSTANCE.createTruckEMF();
			truck.setName("Truck " + (i + 1));
			truck.setCapacity(30 + 10 * i);
			truck.setActive(i != 1);
			truck.setType(TruckType.get(i));
			truck.setDriver(scenario.getDrivers().get(i));
			truck.setAxles(2 + i);
			truck.setLastService(LocalDateTime.now().minusDays(10 * (i + 1)));
			truck.setDepartureTime(LocalTime.of(7 + i, 30));
			truck.setColor(List.of(Color.ORANGE, Color.GRAY, Color.RED).get(i));
			truck.setLoadingTime(new ConstantRealDistribution(10 + 5 * i));
			truck.setSchedule(singleTimeSeries(LocalDateTime.now().plusDays(i + 1)));
			scenario.getTrucks().add(truck);
		}
		return scenario;
	}

	/** A time series with one instant: the value of the time series editors. */
	public static TimeSeries singleTimeSeries(LocalDateTime instant) {
		SingleTimeSeries timeSeries = TimeseriesdatamodelFactory.eINSTANCE.createSingleTimeSeries();
		timeSeries.setInstantDateTime(instant.withSecond(0).withNano(0));
		return timeSeries;
	}
}
