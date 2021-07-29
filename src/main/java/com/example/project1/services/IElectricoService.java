package com.example.project1.services;

import java.util.List;

import com.example.project1.models.Electrico;

public interface IElectricoService {

	Integer count(); //contador para llevar la cuenta de los id

	List<Electrico> findAll();

	Electrico save(Electrico electric);

	boolean delete(Long id);

	void deleteAll();
	
	//Filtros
	Electrico findOne(Long id); //busca por modelType

	List<Electrico> findByColor(String color);
	
	List<Electrico> findByDoorsNumber(int number);
	
	List<Electrico> findByName(String name);
}
