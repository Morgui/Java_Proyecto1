package com.example.project1.models;

import com.example.project1.models.components.*;
/**
 * 
 * @author Luz D. Delgado
 *
 */
public class Combustion extends Car {

	Inyeccion inyeccion;
/**
 * 
 * @param id Id
 * @param color color
 * @param numberDoor numero de puertas
 * @param name nombre
 */
	public Combustion(Long id,String color, int numberDoor, String name) {
		super(id, color, numberDoor, name, "COMBUSTION");
	}
/**
 * Get Inyeccion
 * @return inyeccion
 */
	public Inyeccion getInyeccion() {
		return inyeccion;
	}
/**
 * Set Inyeccion
 * @param inyeccion inyeccion
 */
	public void setInyeccion(Inyeccion inyeccion) {
		this.inyeccion = inyeccion;
	}

	@Override
	public void start() {
		super.start();
		this.inyeccion.start();
	}

	@Override
	public String toString() {
		return "Combustion [getInyeccion()=" + getInyeccion() + ", getId()=" + getId() + ", getMotor()=" + getMotor()
				+ ", getAir()=" + getAir() + ", getBattery()=" + getBattery() + ", getColor()=" + getColor()
				+ ", getNumberDoor()=" + getNumberDoor() + ", getName()=" + getName() + ", getModelType()="
				+ getModelType() + ", getOn()=" + getOn() + "]";
	}
		
}
