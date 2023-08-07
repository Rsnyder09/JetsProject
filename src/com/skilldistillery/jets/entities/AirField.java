package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AirField {

	private List<Jet> fleet = new ArrayList<>();

	public AirField() {
		try (BufferedReader bufIn = new BufferedReader(new FileReader("jets.txt"))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				String[] jetParams = line.split(",");
				Double param2 = Double.valueOf(jetParams[2]);
				int param3 = Integer.parseInt(jetParams[3]);
				long param4 = Integer.parseInt(jetParams[4]);

				if (jetParams[0].equalsIgnoreCase("Fighter")) {
					FighterJet fighter = new FighterJet(jetParams[1], param2, param3, param4);
					fleet.add(fighter);
				} else if (jetParams[0].equalsIgnoreCase("Cargo Carrier")) {
					CargoPlane cargo = new CargoPlane(jetParams[1], param2, param3, param4);
					fleet.add(cargo);
				} else {

				}
			}
			bufIn.close();
		} catch (IOException e) {
			System.err.println(e);
		}

	}

	public void listFleet() {
		for (int i = 0; i < fleet.size(); i++) {
			System.out.println(i + ": " + fleet.get(i));
		}
	}

	public void fleetFlight() {
		int count = 0;
		for (Jet jet : fleet) {
			jet.fly();
			count++;
		}
		if (count == 0) {
			System.out.println("No jets to fly");
		}
	}

	

	public void fastestJet() {
		Jet fastjet = fleet.get(1);
		for (Jet jet : fleet) {
			if (jet.getSpeed() > fastjet.getSpeed()) {
				fastjet = jet;

			}

		}
		System.out.println(fastjet);
	}

	public void jetLongestRange() {
		Jet jetRange = fleet.get(0);
		for (Jet jet : fleet) {
			if (jet.getRange() > jetRange.getRange()) {
				jetRange = jet;
			}
		}
		System.out.println(jetRange);
	}
	
	public void loadCargo() {
		int count = 0;
		for (Jet jet : fleet) {
			if (jet instanceof CargoCarrier) {
				((CargoCarrier) jet).loadCargo();
				count++;
				System.out.println(jet);
			}
		}
		if (count == 0) {
			System.out.println("No cargo planes to load");
		}
	}
	public void dogFight() {
		int count = 0;
		for (Jet jet : fleet) {
			if (jet instanceof FighterJet) {
				((FighterJet) jet).fight();
				count++;
			}
		}
		if (count == 0) {
			System.out.println("No jets to fight");
		}
	}
	


	public List<Jet> getFleet() {
		return fleet;
	}

	public void setFleet(List<Jet> fleet) {
		this.fleet = fleet;
	}

}
