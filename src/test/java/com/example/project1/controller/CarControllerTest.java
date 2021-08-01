package com.example.project1.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.example.project1.models.Combustion;
import com.example.project1.models.Electrico;
import com.example.project1.models.Hibrido;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class CarControllerTest {

	private TestRestTemplate clientController;

	@Autowired
	private RestTemplateBuilder clientBuilder;

	@LocalServerPort
	private int port;

	@BeforeEach
	void setup() {
		clientBuilder = clientBuilder.rootUri("http://localhost:" + port);
		clientController = new TestRestTemplate(clientBuilder);
	}

	@Test
	void testCreateByTypeCombustion() {
		ResponseEntity<Combustion> result = this.clientController.getForEntity("/api/car/Combustion", Combustion.class);

		assertEquals(HttpStatus.OK, result.getStatusCode());

		Combustion car = result.getBody();
		assertEquals(1L, car.getId());
		assertEquals("rojo", car.getColor());
	}

	@Test
	void testCreateByTypeHibrido() {
		ResponseEntity<Hibrido> result = this.clientController.getForEntity("/api/car/Hybrid", Hibrido.class);

		assertEquals(HttpStatus.OK, result.getStatusCode());

		Hibrido car = result.getBody();
		assertEquals(1L, car.getId());
		assertEquals("azul", car.getColor());
	}

	@Test
	void testCreateByTypeElectrico() {
		ResponseEntity<Electrico> result = this.clientController.getForEntity("/api/car/Electric", Electrico.class);

		assertEquals(HttpStatus.OK, result.getStatusCode());

		Electrico car = result.getBody();
		assertEquals(1L, car.getId());
		assertEquals("verde", car.getColor());
	}
}
