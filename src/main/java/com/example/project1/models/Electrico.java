package com.example.project1.models;

import com.example.project1.models.components.*;
/**
 * 
 * @author Luz D. Delgado
 *
 */
public class Electrico extends Car {

	ElectricCarBattery electricBattery;
/**
 * 
 * @param id Id
 * @param color Color
 * @param numberDoor Numero de puertas
 * @param name nombre
 */
	public Electrico(Long id, String color, int numberDoor, String name) {
		super(id, color, numberDoor, name, "ELECTRIC");

	}

	/**
	 * Get ElectricBattery
	 * @return electricBattery
	 */
	public ElectricCarBattery getElectricBattery() {
		return electricBattery;
	}

	/**
	 * Set ElectricBattery
	 * @param electricBattery electricBattery
	 */
	public void setElectricBattery(ElectricCarBattery electricBattery) {
		this.electricBattery = electricBattery;
	}

	@Override
	public void start() {
		super.start();
		this.electricBattery.start();
	}

	@Override
	public String toString() {
		return "Electrico [getElectricBattery()=" + getElectricBattery() + ", getId()=" + getId() + ", getMotor()="
				+ getMotor() + ", getAir()=" + getAir() + ", getBattery()=" + getBattery() + ", getColor()="
				+ getColor() + ", getNumberDoor()=" + getNumberDoor() + ", getName()=" + getName() + ", getModelType()="
				+ getModelType() + ", getOn()=" + getOn() + "]";
	}

}
