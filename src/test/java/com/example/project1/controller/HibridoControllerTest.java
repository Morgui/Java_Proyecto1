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

import com.example.project1.models.Hibrido;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class HibridoControllerTest {

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
		ResponseEntity<Hibrido[]> result = this.clientController.getForEntity("/api/hibrido", Hibrido[].class);

		assertEquals(HttpStatus.OK, result.getStatusCode());
	}

//	@Test
//	void testFindOne() {
//		ResponseEntity<Hibrido> result = this.clientController.getForEntity("/api/hibrido/1", Hibrido.class);
//
//		assertEquals(HttpStatus.OK, result.getStatusCode());
//
//		Hibrido car = result.getBody();
//		assertEquals(1L, car.getId());
//		assertEquals("azul", car.getColor());
//	}

}
