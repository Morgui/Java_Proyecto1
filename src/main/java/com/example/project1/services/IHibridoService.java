package com.example.project1.services;

import java.util.List;

import com.example.project1.models.Hibrido;

public interface IHibridoService {
	
	Integer count(); //contador para llevar la cuenta de los id

	List<Hibrido> findAll();

	Hibrido save(Hibrido hibrido);

	boolean delete(Long id);

	void deleteAll();
	
	//Filtros
	Hibrido findOne(Long id); //busca por modelType

	List<Hibrido> findByColor(String color);
	
	List<Hibrido> findByDoorsNumber(int number);
	
	List<Hibrido> findByName(String name);
}
