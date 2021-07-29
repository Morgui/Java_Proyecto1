package com.example.project1.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.project1.models.Hibrido;


@Service
public class HibridoService implements IHibridoService{
	
	private static final Map<Long, Hibrido> hibrido = new HashMap<>();

	static {
		
		// se usa el CarFacade para inicializar la api con 3 coches hibridos creados

		Hibrido hibrido1 = CarFacade.createHybridCar(1L, "azul", 5, "Kia Niro");
		Hibrido hibrido2 = CarFacade.createHybridCar(2L, "pearl", 3, "Toyota Yaris");
		Hibrido hibrido3 = CarFacade.createHybridCar(3L, "snow", 5, "Hyundai Ioniq");

		hibrido.put(1L, hibrido1);
		hibrido.put(2L, hibrido2);
		hibrido.put(3L, hibrido3);
	}
	
	@Override
	public Integer count() {
		return hibrido.keySet().size(); // para ver el tamaño del map
	}

	@Override
	public List<Hibrido> findAll() {
		return new ArrayList<>(hibrido.values());
	}

	@Override
	public Hibrido save(Hibrido hibridos) {
		// asignar un id
        if (hibridos.getId() == null || hibridos.getId() == 0L) // nuevo hibrido
        	hibridos.setId(getLastId() + 1); // genera id y lo asigna 

        // en caso de actualizar primero lo eliminamos
        hibrido.remove(hibridos.getId()); // en caso de que ya exista lo quita para actualizarlo
        
        //uso el Facade para añasirlo hashmap en vez del objeto que crea spring boot
        hibridos = CarFacade.createHybridCar(hibridos.getId(), hibridos.getColor(), hibridos.getNumberDoor(), hibridos.getName());
        // guarda el coche de hibrido en el map
        hibrido.put(hibridos.getId(), hibridos);
        return hibridos;	
        }
	/**
     * Devuelve el último id del map de coches de hibrido
     * @return
     */
	public Long getLastId() {
		if (hibrido.isEmpty())
			return 0L;

        return Collections.max(hibrido.entrySet(),
                (entry1, entry2) -> (int) (entry1.getKey() - entry2.getKey())
        ).getKey();
	}
	
	@Override
	public Hibrido findOne(Long id) {
		return hibrido.get(id);
	}

	@Override
	public List<Hibrido> findByColor(String color) {
		List<Hibrido> listaHibrido = this.findAll();
		List<Hibrido> listaColor = new ArrayList<>();
		for (Hibrido car : listaHibrido) {

			if (car.getColor().equals(color)) {
				listaColor.add(car);
			}
		}
		return listaColor;
	}

	@Override
	public List<Hibrido> findByDoorsNumber(int number) {
		List<Hibrido> doors = this.findAll();
		List<Hibrido> listaDoor = new ArrayList<>();
		for (Hibrido car : doors) {

			if (car.getNumberDoor() == number) {
				listaDoor.add(car);
			}
		}
		return listaDoor;
	}

	@Override
	public List<Hibrido> findByName(String name) {
		List<Hibrido> nameCar = this.findAll();
		List<Hibrido> listaName = new ArrayList<>();
		for (Hibrido car : nameCar) {

			if (car.getName().equals(name)) {
				listaName.add(car);
			}
		}
		return listaName;
	}

	@Override
	public boolean delete(Long id) {
		if (id == null || !hibrido.containsKey(id)) {
			return false;
		} else {
			hibrido.remove(id);
			return true;
		}
	}

	@Override
	public void deleteAll() {
		if (!hibrido.isEmpty())
			hibrido.clear();
	}


}
