package com.example.project1.services;

import com.example.project1.models.Car;

public class CarFactory {

	public static final String HIBRIDO = "Hybrid";
	public static final String ELECTRICO = "Electric";
	public static final String COMBUSTION = "Combustion";

	public CarFactory() {}

	public static Car createByType(String type) {
		
		return switch(type) {
		case HIBRIDO -> CarFacade.createHybridCar(1L, "azul", 5, "Kia Niro");
		case ELECTRICO -> CarFacade.createElectricCar(1L, "verde", 5, "Ford Kuga");
		case COMBUSTION -> CarFacade.createCombustionCar(1L, "rojo", 3, "Opel Corsa");
		default->throw new IllegalArgumentException("Unexpected value: " + type);
	};
}
}