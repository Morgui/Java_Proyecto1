package com.example.project1.services;

import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.project1.models.Car;
import com.example.project1.models.Combustion;
import com.example.project1.models.Electrico;
import com.example.project1.models.Hibrido;

public class CarFacadeTest {

	Car hybridCar;
	Car combustionCar;
	Car electricCar;

	@BeforeEach
	void setUp() throws Exception {

		// se usa directamente el método porque es static, no hace falta instanciar la
		// clase

		hybridCar = CarFacade.createHybridCar(1L, "azul", 5, "Kia Niro");
		combustionCar = CarFacade.createCombustionCar(1L, "rojo", 3, "Opel Corsa");
		electricCar = CarFacade.createElectricCar(1L, "verde", 5, "Ford Kuga");

	}
	
	@Test
	@DisplayName("Test para comprobar el constructor de CarFacade")
	void testIntanciateFacade() {
		CarFacade carFacade = new CarFacade();
		assertNotNull(carFacade);
	}

	@Test
	@DisplayName("HybridTest que devuelve un coche no null y del tipo esperado")
	void testCreateHybridCarNotNull() {
		assertNotNull(hybridCar);
		assertTrue(hybridCar instanceof Hibrido);
	}

	@Test
	@DisplayName("HybridTest with correct color")
	void testCreateHybridCarColor() {
		assertEquals("azul", hybridCar.getColor());
	}

	@Test
	@DisplayName("HybridTest with correct numberDoors")
	void testCreateHybridCarDoors() {
		assertEquals(5, hybridCar.getNumberDoor());
	}

	@Test
	@DisplayName("HybridTest with proper name")
	void testCreateHybridCarName() {
		assertEquals("Kia Niro", hybridCar.getName());
	}

	@Test
	@DisplayName("HybridTest has battery and is on")
	void testCreateHybridCarHasBattery() {
		assertNotNull(hybridCar.getBattery());
		assertTrue(hybridCar.getBattery().isOn());
	}

	@Test
	@DisplayName("HybridTest has motor and is on")
	void testCreateHybridCarHasMotor() {
		assertNotNull(hybridCar.getMotor());
		assertTrue(hybridCar.getMotor().isOn());
	}

	@Test
	@DisplayName("HybridTest has HydrogenTank and is on")
	void testCreateHybridCarHasHydrogenTank() {
		assertNotNull(((Hibrido) hybridCar).getHydrogen());
		assertTrue(((Hibrido) hybridCar).getHydrogen().isOn());
	}

	@Test
	@DisplayName("HybridTest has air and is on")
	void testCreateHybridCarHasAirAconditioner() {
		assertNotNull(hybridCar.getAir());
		assertTrue(hybridCar.getAir().isOn());
	}

	@Test
	@DisplayName("HybridTest para comprobar que el coche hibrido está arrancado")
	void testCreateHybridCarIsOn() {
		assertTrue(hybridCar.getOn());
	}

	@Test
	@DisplayName("CombustionTest que devuelve un coche no null y del tipo esperado")
	void testCreateCombustionCarNotNull() {
		assertNotNull(combustionCar);
		assertTrue(combustionCar instanceof Combustion);
	}

	@Test
	@DisplayName("CombustionTest with correct color")
	void testCreateCombustionCarCarColor() {
		assertEquals("rojo", combustionCar.getColor());
	}

	@Test
	@DisplayName("CombustionTest with correct numberDoors")
	void testCreateCombustionCarDoors() {
		assertEquals(3, combustionCar.getNumberDoor());
	}

	@Test
	@DisplayName("CombustionTest with proper name")
	void testCreateCombustionCarName() {
		assertEquals("Opel Corsa", combustionCar.getName());
	}

	@Test
	@DisplayName("CombustionTest has battery and is on")
	void testCreateCombustionCarHasBattery() {
		assertNotNull(combustionCar.getBattery());
		assertTrue(combustionCar.getBattery().isOn());
	}

	@Test
	@DisplayName("CombustionTest has motor and is on")
	void testCreateCombustionCarHasMotor() {
		assertNotNull(combustionCar.getMotor());
		assertTrue(combustionCar.getMotor().isOn());
	}

	@Test
	@DisplayName("CombustionTest has Inyeccion and is on")
	void testCreateCombustionCarHasInyeccion() {
		assertNotNull(((Combustion) combustionCar).getInyeccion());
		assertTrue(((Combustion) combustionCar).getInyeccion().isOn());
	}

	@Test
	@DisplayName("CombustionTest has air and is on")
	void testCreateCombustionCarHasAirAconditioner() {
		assertNotNull(combustionCar.getAir());
		assertTrue(combustionCar.getAir().isOn());
	}

	@Test
	@DisplayName("CombustionTest para comprobar que el coche de combustion está arrancado")
	void testCreateCombustionCarIsOn() {
		assertTrue(combustionCar.getOn());
	}

	@Test
	@DisplayName("ElectricTest que devuelve un coche no null y del tipo esperado")
	void testCreateElectricCarNotNull() {
		assertNotNull(electricCar);
		assertTrue(electricCar instanceof Electrico);
	}

	@Test
	@DisplayName("ElectricTest with correct color")
	void testCreateElectricCarCarColor() {
		assertEquals("verde", electricCar.getColor());
	}

	@Test
	@DisplayName("ElectricTest with correct numberDoors")
	void testCreateElectricCarDoors() {
		assertEquals(5, electricCar.getNumberDoor());
	}

	@Test
	@DisplayName("ElectricTest with proper name")
	void testCreateElectricCarName() {
		assertEquals("Ford Kuga", electricCar.getName());
	}

	@Test
	@DisplayName("ElectricTest has battery and is on")
	void testCreateElectricCarHasBattery() {
		assertNotNull(electricCar.getBattery());
		assertTrue(electricCar.getBattery().isOn());
	}

	@Test
	@DisplayName("ElectricTest has motor and is on")
	void testCreateElectricCarHasMotor() {
		assertNotNull(electricCar.getMotor());
		assertTrue(electricCar.getMotor().isOn());
	}

	@Test
	@DisplayName("ElectricTest has ElectricBattery and is on")
	void testCreateElectricCarHasElectricBattery() {
		assertNotNull(((Electrico) electricCar).getElectricBattery());
		assertTrue(((Electrico) electricCar).getElectricBattery().isOn());
	}

	@Test
	@DisplayName("ElectricTest has air and is on")
	void testCreateElectricCarHasAirAconditioner() {
		assertNotNull(electricCar.getAir());
		assertTrue(electricCar.getAir().isOn());
	}

	@Test
	@DisplayName("ElectricTest para comprobar que el coche eléctrico está arrancado")
	void testCreateElectricCarIsOn() {
		assertTrue(electricCar.getOn());
	}

}
