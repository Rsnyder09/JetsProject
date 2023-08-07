package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements CombatReady {

	
		public FighterJet(String model, double speed, int range, long price) {
			super(model, speed, range,price);
		}
		
		@Override
		public void fly() {
			System.out.println(this.toString());
			System.out.println("Duration of flight: " + (this.getRange() / this.getSpeed()));
		}
		
		@Override
		public void fight() {
			System.out.println(this.toString());
			System.out.println("Fire missiles!!!");
		}

		@Override
		public String toString() {
			return "Class: " + getClass().getSimpleName() + ", Model: " + getModel() + ", Speed: " + getSpeed() + ", Range: " + getRange()
					+ ", Price: " + getPrice();
		}

		


		
		
		
}
