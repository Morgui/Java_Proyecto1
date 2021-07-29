package com.example.project1.models.components;

import com.example.project1.models.components.interfaces.Arranque;

/**
 * 
 * @author Luz D. Delgado
 *
 */
public class ElectricCarBattery implements Arranque {
	/**
	 * Encendido del componente
	 */
	private boolean on;

	@Override
	public void start() {
		this.on = true;
	}

	@Override
	public void stop() {
		this.on = false;
	}

	public boolean isOn() {
		return on;
	}

}
