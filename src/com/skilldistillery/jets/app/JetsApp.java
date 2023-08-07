package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.Jet;
import com.skilldistillery.jets.entities.PassengerJet;

public class JetsApp {

	Scanner kb = new java.util.Scanner(System.in);
	private AirField aF = new AirField();
	private List<Jet> fleet = new ArrayList<>();

	public static void main(String[] args) {
		System.out.println("Welcome to the AirField!!!");
		JetsApp app = new JetsApp();
		app.launch();

	}

	public void launch() {
		displayUserMenu();
	}

	public void displayUserMenu() {
		System.out.println("_____________________________________");
		System.out.println("|              Menu                 |");
		System.out.println("|___________________________________|");
		System.out.println("|                                   |");
		System.out.println("|  1. List Fleet                    |");
		System.out.println("|  2. Fly all jets                  |");
		System.out.println("|  3. View fastest jet              |");
		System.out.println("|  4. View jet with longest range   |");
		System.out.println("|  5. Load all Cargo Jets           |");
		System.out.println("|  6. Dogfight!                     |");
		System.out.println("|  7. Add a jet to Fleet            |");
		System.out.println("|  8. Remove a jet from Fleet       |");
		System.out.println("|  9. Quit                          |");
		System.out.println("|___________________________________|");
		int choice = kb.nextInt();

		switch (choice) {
		case 1:
			aF.listFleet();
			displayUserMenu();
			break;
		case 2:
			aF.fleetFlight();
			displayUserMenu();
			break;
		case 3:
			aF.fastestJet();
			displayUserMenu();
			break;
		case 4:
			aF.jetLongestRange();
			displayUserMenu();
			break;
		case 5:
			aF.loadCargo();
			displayUserMenu();
			break;
		case 6:
			aF.dogFight();
			displayUserMenu();
			break;
		case 7:
			addJet();
			displayUserMenu();
			break;
		case 8:
			removeJet();
			displayUserMenu();
			break;
		case 9:
			 System.out.println("Goodbye");
			 break;
		default:
			System.out.println("Please enter a number between 1 and 9");
		}
	}

	public void addJet() {
		PassengerJet newJet;
		kb.nextLine();
		while (true) {
			try (BufferedReader bufIn = new BufferedReader(new FileReader("jets.txt"))) {

				System.out.println("Enter model name: ");
				String param1 = kb.nextLine();
				
				System.out.println("Enter jet speed in mph: ");
				double param2 = kb.nextDouble();
				
				System.out.println("Enter  jet range in miles: ");
				int param3 = kb.nextInt();
				
				System.out.println("Enter jet price: ");
				long param4 = kb.nextLong();
				
				newJet = new PassengerJet(param1, param2, param3, param4);
				break;
				
			} 
			catch (IOException e) {
				System.err.println(e);
			}
		}

		fleet.add(newJet);

	}

	public void removeJet() {
		while (true) {
			try {
				if (fleet.size() <= 0) {
					System.out.println("No jets in Airfield to be removed");
					displayUserMenu();
					break;
				}
				System.out.println(
						"Select a jet number to remove starting at 1, or you can enter 0 to quit. Current fleet size is "
								+ fleet.size());
				int jetDelete = kb.nextInt() - 1;
				if (jetDelete > fleet.size() - 1 || jetDelete < -1) {
					System.out.println("Selected number is not in range");
					kb.nextLine();
					continue;
				} else if (jetDelete == -1) {
					System.out.println("Returning to main menu");
					displayUserMenu();
					break;
				}
				fleet.remove(jetDelete);
			} catch (InputMismatchException e) {
				kb.nextLine();
				System.out.println("Please enter a number: ");
				continue;
			}
			break;
		}

	}

}
