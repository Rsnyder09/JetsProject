package com.skilldistillery.jets.entities;

	public abstract class Jet {
		private String model;
		private double speed;
		private int range;
		private long price;
		
	

	public Jet() {
		
	}
	
	public Jet(String model,double speed,int range,long price ) {
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}
	
	public void flightLength() {
		double flightLength;
		flightLength = range / speed;
		System.out.println(flightLength);
	}
	
	public abstract void fly();
	
	public double getSpeedInMach() {
		double machNumber;
		machNumber = speed * 0.001303;
		return machNumber;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Model: " + model + ", Speed: " + speed + ", Range" + range + ", Price:" + price
				+ ", Speed In Mach: " + getSpeedInMach();
	}


	
	
	
}
