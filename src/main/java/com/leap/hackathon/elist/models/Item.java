package com.leap.hackathon.elist.models;

public class Item {
	private long itemId;
	private String itemName;
	private double price;
	private boolean availability;
	
	public Item(long itemId, String itemName, double price) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.price = price;
		this.availability=true;
	}
	public long getItemId() {
		return itemId;
	}
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isAvailable() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	

}
