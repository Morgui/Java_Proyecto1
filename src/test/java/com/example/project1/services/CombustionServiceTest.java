package com.example.project1.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;

import com.example.project1.models.Combustion;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CombustionServiceTest {

	CombustionService service;

	@BeforeEach
	void setUp() throws Exception {
		service = new CombustionService();
	}

	@Order(1)
	@Test
	@DisplayName("Test cuántos objetos tiene el servicio")
	void testCount() {
		assertEquals(3, service.count());

		service.save(CarFacade.createCombustionCar(4L, "naranja", 3, "Enzo Ferrari"));
		assertEquals(4, service.count());
	}

	@Order(2)
	@Test
	@DisplayName("Test de lista de objetos")
	void testFindAll() {
		List<Combustion> result = service.findAll();
		assertEquals(4, result.size());

		service.save(CarFacade.createCombustionCar(5L, "amarillo", 3, "New Beatle"));
		result = service.findAll();
		assertEquals(5, result.size());
	}

	@Order(3)
	@Test
	@DisplayName("Test de creación correcta de objeto sin Id")
	void testSaveCreateNullId() {
		service.save(CarFacade.createCombustionCar(null, "fosforito", 3, "Seat Leon"));
		Combustion result = service.findOne(6L);
		assertEquals(result.getColor(), "fosforito");
		assertEquals(result.getNumberDoor(), 3);
		assertEquals(result.getName(), "Seat Leon");
	}

	@Order(4)
	@Test
	@DisplayName("Test de creación correcta de objeto con zero Id")
	void testSaveCreateZero() {
		service.save(CarFacade.createCombustionCar(0L, "fosforito", 3, "Seat Leon"));
		Combustion result = service.findOne(6L);
		assertEquals(result.getColor(), "fosforito");
		assertEquals(result.getNumberDoor(), 3);
		assertEquals(result.getName(), "Seat Leon");
	}

	@Order(5)
	@Test
	@DisplayName("Test de actualizacion correcta de objeto")
	void testSaveUpdate() {
		Combustion result = service.findOne(3L);
		result.setColor("azul marino");
		service.save(result);

		Combustion updated = service.findOne(3L);
		assertEquals(updated.getColor(), "azul marino");
	}

	@Order(6)
	@Test
	@DisplayName("Test que devuelve el elemento solicitado")
	void testFindOneExists() {
		Combustion result = service.findOne(1L);
		assertEquals(1L, result.getId());
	}

	@Order(7)
	@Test
	@DisplayName("Test que devuelve nulo cuando busca un elemento que no existe")
	void testFindOneNotExists() {
		Combustion result = service.findOne(33L);
		assertNull(result);

	}

	@Order(8)
	@Test
	@DisplayName("Test que comprueba que existe un elemento del color dado")
	void testFindByColor() {
		List<Combustion> result = service.findByColor("rojo");
		assertEquals(1, result.size());

	}

	@Order(9)
	@Test
	@DisplayName("Test que comprueba que existe un elemento con el numero de puertas dadas")
	void testFindByDoorsNumber() {
		List<Combustion> result = service.findByDoorsNumber(5);
		assertEquals(2, result.size());
	}

	@Order(10)
	@Test
	@DisplayName("Test que comprueba que existe un elemento del nombre dado")
	void testFindByName() {
		List<Combustion> result = service.findByName("Renault 5");
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
		assertFalse(service.delete(33L));
	}

	@Order(14)
	@Test
	@DisplayName("Test que comprueba que se borra todo y no falla cuando no hay nada al borrar")
	void testDeleteAll() {
		CombustionService service = new CombustionService();

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
		Combustion car = service.save(CarFacade.createCombustionCar(null, "fosforito", 5, "Seat Leon"));
		assertEquals(1L, car.getId());

	}
}
