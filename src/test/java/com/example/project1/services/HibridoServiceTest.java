package com.example.project1.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.example.project1.models.Hibrido;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class HibridoServiceTest {
	HibridoService service;

	@BeforeEach
	void setUp() throws Exception {
		service = new HibridoService();
	}

	@Order(1)
	@Test
	@DisplayName("Test cuántos objetos tiene el servicio")
	void testCount() {
		assertEquals(3, service.count());

		service.save(CarFacade.createHybridCar(4L, "verde metalizado", 3, "Jaguar"));
		assertEquals(4, service.count());

		service.delete(4L);
	}

	@Order(2)
	@Test
	@DisplayName("Test de lista de objetos")
	void testFindAll() {
		List<Hibrido> result = service.findAll();
		assertEquals(3, result.size());

		service.save(CarFacade.createHybridCar(5L, "gris", 5, "Mini Countryman"));
		result = service.findAll();
		assertEquals(4, result.size());
	}

	@Order(3)
	@Test
	@DisplayName("Test de creación correcta de objeto sin Id")
	void testSaveCreateNullId() {
		service.save(CarFacade.createHybridCar(null, "aqua", 5, "Kia Sportage"));
		Hibrido result = service.findOne(6L);
		assertEquals("aqua", result.getColor());
		assertEquals(5, result.getNumberDoor());
		assertEquals("Kia Sportage", result.getName());
	}

	@Order(4)
	@Test
	@DisplayName("Test de creación correcta de objeto con zero Id")
	void testSaveCreateZero() {
		service.save(CarFacade.createHybridCar(0L, "mostaza", 5, "Kia Sportage"));
		Hibrido result = service.findOne(6L);
		assertEquals("aqua", result.getColor());
		assertEquals(5, result.getNumberDoor());
		assertEquals("Kia Sportage", result.getName());
	}

	@Order(5)
	@Test
	@DisplayName("Test de actualizacion correcta de objeto")
	void testSaveUpdate() {
		Hibrido result = service.findOne(3L);
		result.setColor("mist");
		service.save(result);

		Hibrido updated = service.findOne(3L);
		assertEquals("mist", updated.getColor());
	}

	@Order(6)
	@Test
	@DisplayName("Test que devuelve el elemento solicitado")
	void testFindOneExists() {
		Hibrido result = service.findOne(1L);
		assertEquals(1L, result.getId());
	}

	@Order(7)
	@Test
	@DisplayName("Test que devuelve nulo cuando busca un elemento que no existe")
	void testFindOneNotExists() {
		Hibrido result = service.findOne(12L);
		assertNull(result);
	}

	@Order(8)
	@Test
	@DisplayName("Test que comprueba que existe un elemento con el color dado")
	void testFindByColor() {
		List<Hibrido> result = service.findByColor("azul");
		assertEquals(1, result.size());

	}

	@Order(9)
	@Test
	@DisplayName("Test que comprueba que existe un elemento con el numero de puertas dadas")
	void testFindByDoorsNumber() {
		List<Hibrido> result = service.findByDoorsNumber(3);
		assertEquals(1, result.size());
	}

	@Order(10)
	@Test
	@DisplayName("Test que comprueba que existe un elemento del nombre dado")
	void testFindByName() {
		List<Hibrido> result = service.findByName("Kia Niro");
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
		assertTrue(service.delete(2L));
	}

	@Order(13)
	@Test
	@DisplayName("Test que comprueba que lo que borra no existe")
	void testDeleteNotExists() {
		assertFalse(service.delete(12L));
	}

	@Order(14)
	@Test
	@DisplayName("Test que comprueba que se borra todo y no falla cuando no hay nada al borrar")
	void testDeleteAll() {
		HibridoService service = new HibridoService();

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
		Hibrido car = service.save(CarFacade.createHybridCar(null, "aqua", 5, "Kia Sportage"));
		assertEquals(1L, car.getId());

	}
}
