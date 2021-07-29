package com.example.project1.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.example.project1.models.Electrico;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ElectricoServiceTest {

	ElectricoService service;
	
	@BeforeEach
	void setUp() throws Exception {
		service = new ElectricoService();
	}

	@Order(1)
	@Test
	@DisplayName("Test cuántos objetos tiene el servicio")
	void testCount() {
		assertEquals(3, service.count());

		service.save(CarFacade.createElectricCar(4L, "mostaza", 5, "Renault Captur"));
		assertEquals(4, service.count());
		
		service.delete(4L);
	}
	
	@Order(2)
	@Test
	@DisplayName("Test de lista de objetos")
	void testFindAll() {
		List<Electrico> result = service.findAll();
		assertEquals(3, result.size());

		service.save(CarFacade.createElectricCar(5L, "morado", 3, "Renault Ankara"));
		result = service.findAll();
		assertEquals(4, result.size());
	}
	
	@Order(3)
	@Test
	@DisplayName("Test de creación correcta de objeto sin Id")
	void testSaveCreateNullId() {
		service.save(CarFacade.createElectricCar(null, "mostaza", 3, "Renault Captur"));
		Electrico result = service.findOne(6L);
		assertEquals("mostaza", result.getColor());
		assertEquals(3, result.getNumberDoor());
		assertEquals("Renault Captur", result.getName());
	}
	
	@Order(4)
	@Test
	@DisplayName("Test de creación correcta de objeto con zero Id")
	void testSaveCreateZero() {
		service.save(CarFacade.createElectricCar(0L, "mostaza", 3, "Renault Captur"));
		Electrico result = service.findOne(6L);
		assertEquals("mostaza", result.getColor());
		assertEquals(3, result.getNumberDoor());
		assertEquals("Renault Captur", result.getName());
	}
	
	@Order(5)
	@Test
	@DisplayName("Test de actualizacion correcta de objeto")
	void testSaveUpdate() {
		Electrico result = service.findOne(3L);
		result.setColor("azul cielo");
		service.save(result);

		Electrico updated = service.findOne(3L);
		assertEquals("azul cielo", updated.getColor());
	}
	
	@Order(6)
	@Test
	@DisplayName("Test que devuelve el elemento solicitado")
	void testFindOneExists() {
		Electrico result = service.findOne(1L);
		assertEquals(1L, result.getId());
	}

	@Order(7)
	@Test
	@DisplayName("Test que devuelve nulo cuando busca un elemento que no existe")
	void testFindOneNotExists() {
		Electrico result = service.findOne(24L);
		assertNull(result);
	}
	
	@Order(8)
	@Test
	@DisplayName("Test que comprueba que existe un elemento con el color dado")
	void testFindByColor() {
		List<Electrico> result = service.findByColor("negro");
		assertEquals(1, result.size());

	}

	@Order(9)
	@Test
	@DisplayName("Test que comprueba que existe un elemento con el numero de puertas dadas")
	void testFindByDoorsNumber() {
		List<Electrico> result = service.findByDoorsNumber(5);
		assertEquals(2, result.size());
	}
	
	@Order(10)
	@Test
	@DisplayName("Test que comprueba que existe un elemento del nombre dado")
	void testFindByName() {
		List<Electrico> result = service.findByName("Tesla");
		assertEquals(1, result.size());
	}

	@Order(11)
	@Test
	@DisplayName("Test que devuelve null cuando no encuentra el elemento a borrar")
	void testDeleteNull() {
		assertFalse(service.delete(null));
	}

	@Order(12)
	@Test
	@DisplayName("Test que comprueba que se borra el elemento dado")
	void testDeleteOne() {
		assertTrue(service.delete(1L));
	}
	
	@Order(13)
	@Test
	@DisplayName("Test que comprueba que lo que borra no existe")
	void testDeleteNotExists() {
		assertFalse(service.delete(24L));
	}

	@Order(14)
	@Test
	@DisplayName("Test que comprueba que se borra todo y no falla cuando no hay nada al borrar")
	void testDeleteAll() {
		ElectricoService service = new ElectricoService();

		service.deleteAll();
		assertEquals(0, service.count());
		service.deleteAll();
		assertEquals(0, service.count());
	}
	
	@Order(15)
	@Test
	@DisplayName("Test que comprueba el lastID")
	// Una vez que la lista este vacia debe generarse un objeto nuevo con id 1
	void getLastId() {
		Electrico car = service.save(CarFacade.createElectricCar(null, "mostaza", 3, "Renault Captur"));
		assertEquals(1L, car.getId());

	}

}
