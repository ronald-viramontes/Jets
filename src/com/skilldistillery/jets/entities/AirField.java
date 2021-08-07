package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.skilldistillery.jets.app.JetsApplication;

public class AirField {

	private List<Jet> fleet = new ArrayList<>();

	public AirField() {
		readJetsFromFile("jets.txt");
	}

	public AirField(List<Jet> jets) {
		super();
		this.fleet = jets;
	}

	@Override
	public String toString() {
		return "AirField [fleet=" + fleet + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(fleet);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AirField other = (AirField) obj;
		return Objects.equals(fleet, other.fleet);
	}

	public void displayFleet() {
		for (int i = 0; i < fleet.size(); i++) {
			System.out.println(i + 1 + " " + fleet.get(i));
		}
	}

	public List<Jet> getFleet() {
		return fleet;
	}

	public void setFleet(List<Jet> jets) {
		this.fleet = jets;
	}

	public void readJetsFromFile(String fileName) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(fileName));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] jetsArr = line.split(", ");
				if (jetsArr[0].equals("CargoPlane")) {
					CargoPlane cargoPlane = new CargoPlane(jetsArr[1], Double.parseDouble(jetsArr[2]),
							Integer.parseInt(jetsArr[3]), Long.parseLong(jetsArr[4]));
					fleet.add(cargoPlane);
				} else if (jetsArr[0].equals("FighterJet")) {
					FighterJet fighterJet = new FighterJet(jetsArr[1], Double.parseDouble(jetsArr[2]),
							Integer.parseInt(jetsArr[3]), Long.parseLong(jetsArr[4]));
					fleet.add(fighterJet);
				} else if (jetsArr[0].equals("JetPassenger")) {
					JetPassenger jetPassenger = new JetPassenger(jetsArr[1], Double.parseDouble(jetsArr[2]),
							Integer.parseInt(jetsArr[3]), Long.parseLong(jetsArr[4]));
					fleet.add(jetPassenger);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public Jet fastestJet() {
		Jet fastestJet = fleet.get(0);
		for (int i = 0; i < fleet.size(); i++) {
			if (fleet.get(i) != null && fleet.get(i).getSpeed() > fastestJet.getSpeed()) {
				fastestJet = fleet.get(i);
			}
		}
		return fastestJet;
	}

	public void loadCargo() {
		for (int i = 0; i < fleet.size(); i++) {
			if (fleet.get(i) instanceof CargoPlane) {
				System.out.println(fleet.get(i));
			}
		}
	}

	public void fight() {
		for (int i = 0; i < fleet.size(); i++) {
			if (fleet.get(i) instanceof FighterJet) {
				System.out.println(fleet.get(i));
			}
		}
	}

	public void getFlightTime() {
		for (Jet jet : fleet) {
			System.out.println(jet + " This jet flies: " + jet.getFlightTime());
		}

	}

	public Jet longestRange() {
		Jet longestRangeJet = fleet.get(0);
		for (int i = 0; i < fleet.size(); i++) {
			if (fleet.get(i) != null && fleet.get(i).getRange() > longestRangeJet.getRange())
				longestRangeJet = fleet.get(i);
		}
		return longestRangeJet;
	}

	public void addJet(String model, double speed, int range, long price) {
		fleet.add(new JetPassenger(model, speed, range, price));
	}

	public void removeJet(int menuChoice) {

		fleet.remove(menuChoice - 1);

	}
	
}
