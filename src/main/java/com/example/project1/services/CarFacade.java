package com.example.project1.services;

import com.example.project1.models.*;
import com.example.project1.models.components.*;

public class CarFacade {

	public CarFacade() {
		//se usa el constructor vacio para testear CarFacade

	}

	/**
	 * Crea un coche hibrido con sus componentes y lo enciede todo
	 * 
	 */
	public static Hibrido createHybridCar(Long id, String color, int numberDoor, String name) {

		Battery battery = new Battery();
		Motor motor = new Motor();
		AirAconditioner air = new AirAconditioner();
		// componente exclusivo del coche Hibrido
		HydrogenTank hydrogen = new HydrogenTank();

		// crea coche hibrido
		Hibrido coche = new Hibrido(id, color, numberDoor, name);

		coche.setAir(air);
		coche.setBattery(battery);
		coche.setMotor(motor);
		coche.setHydrogen(hydrogen);

		coche.start();
		return coche;
	}

	/**
	 * Crea un coche de combustion con sus componentes y lo enciede todo
	 * 
	 */
	public static Combustion createCombustionCar(Long id, String color, int numberDoor, String name) {

		Battery battery = new Battery();
		Motor motor = new Motor();
		AirAconditioner air = new AirAconditioner();

		// componente exclusivo del coche Combustion
		Inyeccion inyeccion = new Inyeccion();

		Combustion coche = new Combustion(id, color, numberDoor, name);
		coche.setAir(air);
		coche.setBattery(battery);
		coche.setMotor(motor);
		coche.setInyeccion(inyeccion);

		coche.start();
		return coche;

	}

	/**
	 * Crea un coche electrico con sus componentes y lo enciede todo
	 * 
	 */	
	public static Electrico createElectricCar(Long id, String color, int numberDoor, String name) {

		Battery battery = new Battery();
		Motor motor = new Motor();
		AirAconditioner air = new AirAconditioner();

		// componente exclusivo del coche ELectrico
		ElectricCarBattery electricBattery = new ElectricCarBattery();

		Electrico coche = new Electrico(id, color, numberDoor, name);
		coche.setAir(air);
		coche.setBattery(battery);
		coche.setMotor(motor);
		coche.setElectricBattery(electricBattery);

		coche.start();
		return coche;

	}

}
