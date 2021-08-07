package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements CombatMissionReady {

	public FighterJet() {
		super();
	}

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);

	}

	public FighterJet(String model, double speed, int range) {
		super(model, speed, range);
	}

	public FighterJet(String jetType, String model, double speed, int range, long price) {
		super(jetType, model, speed, range, price);
	}

	@Override
	public void fly() {
		System.out.println("Fighter jet is flying!");
	
	}

	@Override
	public double getSpeedInMach(double speed) {
		return super.getSpeedInMach(speed);
	}

	public void fight() {
		System.out.println("Fighter jet is fighting!");
	}

	@Override
	public String toString() {
		return "FighterJet ✈ " + super.toString() + "\n";
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}
}
