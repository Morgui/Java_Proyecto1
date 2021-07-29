package com.example.project1.models;

import com.example.project1.models.components.*;
/**
 * 
 * @author Luz D. Delgado
 *
 */
public class Hibrido extends Car {

	HydrogenTank hydrogen;

	/**
	 * 
	 * @param id Id
	 * @param color Color
	 * @param numberDoor Numero de puertas
	 * @param name Nombre
	 */
	public Hibrido(Long id, String color, int numberDoor, String name) {
		super(id, color, numberDoor, name, "HYBRID");

	}
/**
 * Get Hydrogen
 * @return hydrogen
 */
	public HydrogenTank getHydrogen() {
		return hydrogen;
	}
/**
 * Set Hydrogen
 * @param hydrogen hydrogen
 */
	public void setHydrogen(HydrogenTank hydrogen) {
		this.hydrogen = hydrogen;
	}

	@Override
	public void start() {
		super.start();
		this.hydrogen.start();
	}

	@Override
	public String toString() {
		return "Hibrido [getHydrogen()=" + getHydrogen() + ", getId()=" + getId() + ", getMotor()=" + getMotor()
				+ ", getAir()=" + getAir() + ", getBattery()=" + getBattery() + ", getColor()=" + getColor()
				+ ", getNumberDoor()=" + getNumberDoor() + ", getName()=" + getName() + ", getModelType()="
				+ getModelType() + ", getOn()=" + getOn() + "]";
	}

}
