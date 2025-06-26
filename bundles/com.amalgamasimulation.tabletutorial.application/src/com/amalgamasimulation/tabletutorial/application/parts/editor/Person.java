package com.amalgamasimulation.tabletutorial.application.parts.editor;

import java.awt.Color;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

class Person {
		private String name;
		private int age;
		private String country;
		private double discount;
		private boolean isPreferential;
		private Car car;
		private Color favouriteColor;
		private LocalDateTime purchaseDate;
		private Town town;
		private List<Car> cars;
		private LocalTime arriveTime;

		public Person(String name, int age) {
			this.name = name;
			this.age = age;
			this.country = "United Kingdom";
		}
		
		public LocalTime getArriveTime() {
			return arriveTime;
		}

		public void setArriveTime(LocalTime arriveTime) {
			this.arriveTime = arriveTime;
		}

		public List<Car> getCars() {
			return cars;
		}

		public void setCars(List<Car> cars) {
			this.cars = cars;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public int getAge() {
			return age;
		}
		
		public void setAge(int age) {
			this.age = age;
		}
		
		public void setPreferential(boolean preferential) {
			this.isPreferential = preferential;
		}
		
		public boolean isPreferential() {
			return isPreferential;
		}
		
		public void setCar(Car car) {
			this.car = car;
		}
		
		public Car getCar() {
			return car;
		}
		
		public Color getFavouriteColor() {
			return favouriteColor;
		}

		public void setFavouriteColor(Color favouriteColor) {
			this.favouriteColor = favouriteColor;
		}
		
		public LocalDateTime getPurchaseDate() {
			return purchaseDate;
		}

		public void setPurchaseDate(LocalDateTime purchaseDate) {
			this.purchaseDate = purchaseDate;
		}
		
		public Town getTown() {
			return town;
		}

		public void setTown(Town town) {
			this.town = town;
		}
		
		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public double getDiscount() {
			return discount;
		}

		public void setDiscount(double discount) {
			this.discount = discount;
		}
	}