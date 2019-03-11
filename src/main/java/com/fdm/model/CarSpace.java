package com.fdm.model;

import java.util.ArrayList;

public class CarSpace {

	private int totalSpace;
	private ArrayList<Car> parkedCars;
	private ArrayList<Truck> parkedTrucks;
	

	public ArrayList<Car> getParkedCars() {
		return parkedCars;
	}


	public void setParkedCars(ArrayList<Car> parkedCars) {
		this.parkedCars = parkedCars;
	}


	public ArrayList<Truck> getParkedTrucks() {
		return parkedTrucks;
	}


	public void setParkedTrucks(ArrayList<Truck> parkedTrucks) {
		this.parkedTrucks = parkedTrucks;
	}


	public int getTotalSpace() {
		return totalSpace;
	}


	public CarSpace(int totalNumberOfSpace) {
		this.totalSpace = totalNumberOfSpace;
	}

}
