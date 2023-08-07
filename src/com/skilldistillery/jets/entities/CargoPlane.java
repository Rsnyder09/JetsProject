package com.skilldistillery.jets.entities;

public class CargoPlane extends Jet implements CargoCarrier {

	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range,price);
	}
	
	
	
	@Override
	public void fly() {
		System.out.println(toString());
		System.out.println("Duration of flight: " + (this.getRange() / this.getSpeed()));
		
	}



	@Override
	public void loadCargo() {
	 
		System.out.println("Loading Cargo");

	}



	@Override
	public String toString() {
		return "Class: " + getClass().getSimpleName() + ", Model: " + getModel() + ", Speed: " + getSpeed() + ", Range: " + getRange()
				+ ", Price: " + getPrice();
	}

	
	

}
