package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.CargoPlane;
import com.skilldistillery.jets.entities.FighterJet;
import com.skilldistillery.jets.entities.Jet;
import com.skilldistillery.jets.entities.JetPassenger;

public class JetsApplication {
	private AirField airField;
	private static String fileName = "jets.txt";

	public static void main(String[] args) {
		AirField airField = new AirField();
		Scanner kb = new Scanner(System.in);
		JetsApplication app = new JetsApplication();
		app.displayUserMenu(airField, kb);
	}

	public JetsApplication() {
		super();
	}


	public void writeToFile(String fileName, List<Jet> fleet) {
		try {
			FileWriter fw = new FileWriter(fileName);
			PrintWriter pw = new PrintWriter(fw);

			for (Jet jet : fleet) {
				pw.println(jet.getJetType() + "\t" + jet.getModel() + "\t" + jet.getSpeed() + "\t" + jet.getRange()
						+ "\t" + jet.getPrice());
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void displayUserMenu(AirField airField, Scanner kb) {
		String menuSelection = "0";
		while (menuSelection != "9" || menuSelection != "Quit") {

			System.out.println("  >>--- Jets Application ---<<    ");
			System.out.println("1. List Fleet");
			System.out.println("2. Fly all jets");
			System.out.println("3. View fastest jet");
			System.out.println("4. View jet with longest range");
			System.out.println("5. Load all Cargo Jets");
			System.out.println("6. Dogfight!");
			System.out.println("7. Add a jet to the Fleet");
			System.out.println("8. Remove a jet from the Fleet");
			System.out.println("9. Quit");
			menuSelection = kb.nextLine();
			if (menuSelection.equals("1")) {
				airField.displayFleet();
			}
			if (menuSelection.equals("2")) {
				airField.getFlightTime();
			}
			if (menuSelection.equals("3")) {
				Jet fastestJet = airField.fastestJet();
				System.out.println("Fastest Jet: " + fastestJet);
			}
			if (menuSelection.equals("4")) {
				Jet longestRange = airField.longestRange();
				System.out.println("Longest Range: " + longestRange);
			}
			if (menuSelection.equals("5")) {
				airField.loadCargo();
			}
			if (menuSelection.equals("6")) {
				airField.fight();
			}
			if (menuSelection.equals("7")) {
//				System.out.println("Select a numeric option to add to fleet: ");
//				System.out.println("1. Fighter Jet " + "2. CargoJet " + "3. Passenger Jet");
//				String jetType = kb.nextLine();
				System.out.println("Enter model: ");
				String model = kb.nextLine();
				System.out.println("Enter jet speed: ");
				double speed = kb.nextDouble();
				kb.nextLine();
				System.out.println("Enter jet range: ");
				int range = kb.nextInt();
				kb.nextLine();
				System.out.println("Enter jet purchase price: ");
				long price = kb.nextLong();
				kb.nextLine();
				airField.addJet(model, speed, range, price);
			}
			if (menuSelection.equals("8")) {
				airField.displayFleet();
				System.out.println("Enter jet to remove from fleet by number.");
				int menuChoice = kb.nextInt();
				kb.nextLine();
				airField.removeJet(menuChoice);
			}
			if (menuSelection.equals("9")) {
				System.exit(0);
			}

		}
	}
}
