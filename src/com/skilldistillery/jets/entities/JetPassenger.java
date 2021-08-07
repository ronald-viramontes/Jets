package com.skilldistillery.jets.entities;

public class JetPassenger extends Jet {

	public JetPassenger() {
		super();
	}

	@Override
	public void fly() {
		System.out.println("Fighter jet is flying!");
	
	}

	@Override
	public double getSpeedInMach(double speed) {
		return super.getSpeedInMach(speed);
	}

	public JetPassenger(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	public JetPassenger(String model, double speed, int range) {
		super(model, speed, range);
	}

	public JetPassenger(String jetType, String model, double speed, int range, long price) {
		super(jetType, model, speed, range, price);
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

	@Override
	public String toString() {
		return "JetPassenger ✈ " + super.toString() + "\n";
	}

}
