package com.example.project1.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.project1.models.Combustion;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class CombustionControllerTest {

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
	void testFindAll() {
		ResponseEntity<Combustion[]> result = this.clientController.getForEntity("/api/combustion", Combustion[].class);

		assertEquals(HttpStatus.OK, result.getStatusCode());
	}

	@Test
	void testFindOne() {
		ResponseEntity<Combustion> result = this.clientController.getForEntity("/api/combustion/1", Combustion.class);

		assertEquals(HttpStatus.OK, result.getStatusCode());

		Combustion car = result.getBody();
		assertEquals(1L, car.getId());
		assertEquals("rojo", car.getColor());
	}

}
