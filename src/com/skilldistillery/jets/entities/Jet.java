package com.skilldistillery.jets.entities;

import java.util.Objects;

public abstract class Jet {
	private String model;
	private double speed;
	private int range;
	private long price;
	private double speedInMach = speed / 767.269;
	private String jetType;

	public void fly() {
		System.out.println("Jet is flying!");
		
	}

	public double getFlightTime() {
		double flightTime = range / speed;
		return flightTime;
	}

	public Jet(String model, double speed, int range) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
	}

	public Jet(String jetType, String model, double speed, int range, long price) {
		super();
		this.jetType = jetType;
		this.model = model;
		this.speed = speed;
		this.range = range;
	}

	public String getJetType() {
		return jetType;
	}

	public void setJetType(String jetType) {
		this.jetType = jetType;
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

	public double getSpeedInMach() {
		return speedInMach;
	}

	public void setSpeedInMach(double speedInMach) {
		this.speedInMach = speedInMach;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public double getSpeedInMach(double speed) {
		return speedInMach;
	}

	public Jet(String model, double speed, int range, long price) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}

	public Jet() {
		super();
	}

	@Override
	public String toString() {
		return "Model: " + model + ", Speed: " + speed + " MPH, " + "Range: " + range + " miles, " + "Price: $" + price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(model, price, range, speed);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jet other = (Jet) obj;
		return Objects.equals(model, other.model) && price == other.price && range == other.range
				&& Double.doubleToLongBits(speed) == Double.doubleToLongBits(other.speed);
	}

}
