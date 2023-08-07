package com.skilldistillery.jets.entities;

public class PassengerJet extends Jet {

	public PassengerJet(String model, double speed, int range, long price) {
		super(model,speed,range,price);
	}
	
	@Override
	public void fly() {
		System.out.println(toString());
		System.out.println("Duration of flight: " + (this.getRange() / this.getSpeed()));
		
	}

	@Override
	public String toString() {
		return "Class: " + getClass() + ", Model: " + getModel() + " Speed: "
				+ getSpeed() + ", Range: " + getRange() + ", Price: " + getPrice() ;
	}
	

}
