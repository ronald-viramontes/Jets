package com.skilldistillery.jets.entities;

public class CargoPlane extends Jet implements CargoCarrier {

	public CargoPlane() {
		super();
	}

	@Override
	public void fly() {
		System.out.println("Cargo jet is flying!");
	}

	@Override
	public void loadCargo() {
		System.out.println("Cargo jet is loaded out!");
	}

	@Override
	public double getSpeedInMach(double speed) {
		return super.getSpeedInMach(speed);
	}

	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	public CargoPlane(String model, double speed, int range) {
		super(model, speed, range);
		fly((int) speed, range);
	}

	public CargoPlane(String jetType, String model, double speed, int range, long price) {
		super(jetType, model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CargoPlane ✈ " + super.toString() + "\n";
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
