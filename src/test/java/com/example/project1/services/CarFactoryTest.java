package com.example.project1.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.project1.models.Car;
import com.example.project1.models.Combustion;
import com.example.project1.models.Electrico;
import com.example.project1.models.Hibrido;

class CarFactoryTest {
	
	@Test
	@DisplayName("Test para comprobar el constructor de CarFactory")
	void testIntanciateFactory() {
		CarFactory carFactory = new CarFactory();
		assertNotNull(carFactory);
	}

	@Test
	@DisplayName("Test que comprueba el tipo Hibrido")
	void testCreateByTypeHybrid() {
		Car hybridCar = CarFactory.createByType("Hybrid");
		assertNotNull(hybridCar);
		assertTrue(hybridCar instanceof Hibrido);
	}

	@Test
	@DisplayName("Test que comprueba el tipo Combustion")
	void testCreateByTypeCombustion() {
		Car combustionCar = CarFactory.createByType("Combustion");
		assertNotNull(combustionCar);
		assertTrue(combustionCar instanceof Combustion);

	}

	@Test
	@DisplayName("Test que comprueba el tipo Electrico")
	void testCreateByTypeElectric() {
		Car electricCar = CarFactory.createByType("Electric");
		assertNotNull(electricCar);
		assertTrue(electricCar instanceof Electrico);
	}

	@Test
	@DisplayName("Test que comprueba si lanza la exception cuando el tipo no es correcto")
	void testCreateByTypeDefault() {

		Exception exception = assertThrows(IllegalArgumentException.class, () -> CarFactory.createByType("volador"));

		assertEquals("Unexpected value: volador", exception.getMessage());

	}
}
