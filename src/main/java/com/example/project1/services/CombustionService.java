package com.example.project1.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.project1.models.Combustion;

@Service
public class CombustionService implements ICombustionService {

	private static final Map<Long, Combustion> combustion = new HashMap<>();

	static { 
		// se usa el CarFacade para inicializar la api con 3 coches de combustion creados

		Combustion combustion1 = CarFacade.createCombustionCar(1L, "rojo", 5, "Opel Corsa");
		Combustion combustion2 = CarFacade.createCombustionCar(2L, "gris-plateado", 3, "Renault 5");
		Combustion combustion3 = CarFacade.createCombustionCar(3L, "azul", 5, "Ford Fiesta");

		combustion.put(1L, combustion1);
		combustion.put(2L, combustion2);
		combustion.put(3L, combustion3);
	}

	@Override
	public Integer count() {
		return combustion.keySet().size(); // para ver el tamaño del map
	}

	@Override
	public List<Combustion> findAll() {
		return new ArrayList<>(combustion.values());
	}

	@Override
	public Combustion save(Combustion combustions) {
		// asignar un id
        if (combustions.getId() == null || combustions.getId() == 0L) // nuevo combustion
            combustions.setId(getLastId() + 1); // genera id y lo asigna 

        // en caso de actualizar primero lo eliminamos
        combustion.remove(combustions.getId()); // en caso de que ya exista lo quita para actualizarlo
        
        //uso el Facade para añasirlo hashmap en vez del objeto que crea spring boot
        combustions = CarFacade.createCombustionCar(combustions.getId(), combustions.getColor(), combustions.getNumberDoor(), combustions.getName());
        // guarda el coche de combustion en el map
        combustion.put(combustions.getId(), combustions);
        return combustions;	}

	/**
     * Devuelve el último id del map de coches de combustion
     * @return
     */
	public Long getLastId() {
		if (combustion.isEmpty())
			return 0L;

        return Collections.max(combustion.entrySet(),
                (entry1, entry2) -> (int) (entry1.getKey() - entry2.getKey())
        ).getKey();
	}

	@Override
	public Combustion findOne(Long id) {
		return combustion.get(id);
	}

	@Override
	public List<Combustion> findByColor(String color) {
		List<Combustion> listaCombustion = this.findAll();
		List<Combustion> listaColor = new ArrayList<>();
		for (Combustion car : listaCombustion) {

			if (car.getColor().equals(color)) {
				listaColor.add(car);
			}
		}
		return listaColor;
	}

	@Override
	public List<Combustion> findByDoorsNumber(int number) {
		List<Combustion> listaDoor = new ArrayList<>();
		for (Combustion car : this.findAll()) {

			if (car.getNumberDoor() == number) {
				listaDoor.add(car);
			}
		}
		return listaDoor;
	}

	@Override
	public List<Combustion> findByName(String name) {
		List<Combustion> nameCar = this.findAll();
		List<Combustion> listaName = new ArrayList<>();
		for (Combustion car : nameCar) {

			if (car.getName().equals(name)) {
				listaName.add(car);
			}
		}
		return listaName;
	}

	@Override
	public boolean delete(Long id) {
		if (id == null || !combustion.containsKey(id)) {
			return false;
		} else {
			combustion.remove(id);
			return true;
		}
	}

	@Override
	public void deleteAll() {
		if (!combustion.isEmpty())
			combustion.clear();
	}

}
