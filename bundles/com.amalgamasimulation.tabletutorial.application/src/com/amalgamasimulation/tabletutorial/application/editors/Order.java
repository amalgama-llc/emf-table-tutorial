package com.amalgamasimulation.tabletutorial.application.editors;

/** A plain Java object edited by the refreshing example of the container article. */
public class Order {

	private int quantity;
	private double price;

	public Order(int quantity, double price) {
		this.quantity = quantity;
		this.price = price;
	}

	public int getQuantity() { return quantity; }
	public void setQuantity(int quantity) { this.quantity = quantity; }
	public double getTotal() { return quantity * price; }
}
