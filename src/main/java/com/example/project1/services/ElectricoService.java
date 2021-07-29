package com.example.project1.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.project1.models.Electrico;


@Service
public class ElectricoService implements IElectricoService{

	private static final Map<Long, Electrico> electric = new HashMap<>();

	static { 

		// se usa el CarFacade para inicializar la api con 3 coches electricos creados

		Electrico electric1 = CarFacade.createElectricCar(1L, "verde", 3, "Fiat 500");
		Electrico electric2 = CarFacade.createElectricCar(2L, "negro", 5, "Tesla");
		Electrico electric3 = CarFacade.createElectricCar(3L, "blanco", 5, "Nissan Leaf");

		electric.put(1L, electric1);
		electric.put(2L, electric2);
		electric.put(3L, electric3);
	}
	
	@Override
	public Integer count() {
		return electric.keySet().size(); // para ver el tamaño del map
	}

	@Override
	public List<Electrico> findAll() {
		return new ArrayList<>(electric.values());
	}

	@Override
	public Electrico save(Electrico electrics) {
		// asignar un id
        if (electrics.getId() == null || electrics.getId() == 0L) // nuevo electrico
        	electrics.setId(getLastId() + 1); // genera id y lo asigna 

        // en caso de actualizar primero lo eliminamos
        electric.remove(electrics.getId()); // en caso de que ya exista lo quita para actualizarlo
        
        //uso el Facade para añasirlo hashmap en vez del objeto que crea spring boot
        electrics = CarFacade.createElectricCar(electrics.getId(), electrics.getColor(), electrics.getNumberDoor(), electrics.getName());
        // guarda el coche de electrico en el map
        electric.put(electrics.getId(), electrics);
        return electrics;	
        }
	/**
     * Devuelve el último id del map de coches de electrico
     * @return
     */
	public Long getLastId() {
		if (electric.isEmpty())
			return 0L;

        return Collections.max(electric.entrySet(),
                (entry1, entry2) -> (int) (entry1.getKey() - entry2.getKey())
        ).getKey();
	}
	
	@Override
	public Electrico findOne(Long id) {
		return electric.get(id);
	}

	@Override
	public List<Electrico> findByColor(String color) {
		List<Electrico> listaElectrico = this.findAll();
		List<Electrico> listaColor = new ArrayList<>();
		for (Electrico car : listaElectrico) {

			if (car.getColor().equals(color)) {
				listaColor.add(car);
			}
		}
		return listaColor;
	}

	@Override
	public List<Electrico> findByDoorsNumber(int number) {
		List<Electrico> doors = this.findAll();
		List<Electrico> listaDoor = new ArrayList<>();
		for (Electrico car : doors) {

			if (car.getNumberDoor() == number) {
				listaDoor.add(car);
			}
		}
		return listaDoor;
	}

	@Override
	public List<Electrico> findByName(String name) {
		List<Electrico> nameCar = this.findAll();
		List<Electrico> listaName = new ArrayList<>();
		for (Electrico car : nameCar) {

			if (car.getName().equals(name)) {
				listaName.add(car);
			}
		}
		return listaName;
	}

	@Override
	public boolean delete(Long id) {
		if (id == null || !electric.containsKey(id)) {
			return false;
		} else {
			electric.remove(id);
			return true;
		}
	}

	@Override
	public void deleteAll() {
		if (!electric.isEmpty())
			electric.clear();
	}

}

