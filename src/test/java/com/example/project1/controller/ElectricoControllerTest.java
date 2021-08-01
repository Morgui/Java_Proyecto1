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

import com.example.project1.models.Electrico;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ElectricoControllerTest {

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
		ResponseEntity<Electrico[]> result = this.clientController.getForEntity("/api/electrico", Electrico[].class);

		assertEquals(HttpStatus.OK, result.getStatusCode());
	}

	@Test
	void testFindOne() {
		ResponseEntity<Electrico> result = this.clientController.getForEntity("/api/electrico/1", Electrico.class);

		assertEquals(HttpStatus.OK, result.getStatusCode());

		Electrico car = result.getBody();
		assertEquals(1L, car.getId());
		assertEquals("verde", car.getColor());
	}

}
