package com.example.project1.services;

import java.util.List;

import com.example.project1.models.Combustion;

public interface ICombustionService {
	
	Integer count(); //contador para llevar la cuenta de los id

	List<Combustion> findAll();

	Combustion save(Combustion combustion);

	boolean delete(Long id);

	void deleteAll();
	
	//Filtros
	Combustion findOne(Long id); 

	List<Combustion> findByColor(String color);
	
	List<Combustion> findByDoorsNumber(int number);
	
	List<Combustion> findByName(String name);
}

