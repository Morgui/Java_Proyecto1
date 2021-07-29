package com.example.project1.models;

import com.example.project1.models.components.AirAconditioner;
import com.example.project1.models.components.Battery;
import com.example.project1.models.components.Motor;
import com.example.project1.models.components.interfaces.Arranque;

/**
 * 
 * @author Luz D. Delgado
 *
 */
public abstract class Car implements Arranque {

	private String color;
	private int numberDoor;
	private String name;
	private String modelType;
	private Boolean on;
	private Motor motor;
	private AirAconditioner air;
	private Battery battery;
	private Long id;

	/**
	 * 
	 * @param id         identificador
	 * @param color      color
	 * @param numberDoor numero de puertas
	 * @param name       nombre
	 * @param modelType  modelo
	 */
	protected Car(Long id, String color, int numberDoor, String name, String modelType) {
		super();
		this.id = id;
		this.color = color;
		this.numberDoor = numberDoor;
		this.name = name;
		this.modelType = modelType;
		this.on = false;

	}

	@Override
	public void start() {
		this.battery.start();
		this.air.start();
		this.motor.start();
		this.on = true;
	}

	@Override
	public void stop() {
		this.on = false;
	}

	/**
	 * Get Id
	 * 
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Set Id
	 * 
	 * @param id Id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Get Motor
	 * 
	 * @return motor
	 */
	public Motor getMotor() {
		return motor;
	}

	/**
	 * Set Motor
	 * 
	 * @param motor motor
	 */
	public void setMotor(Motor motor) {
		this.motor = motor;
	}

	/**
	 * Get AirAconditioner
	 * 
	 * @return air
	 */
	public AirAconditioner getAir() {
		return air;
	}

	/**
	 * Set AirAconditioner
	 * 
	 * @param air aire acondicionado
	 */
	public void setAir(AirAconditioner air) {
		this.air = air;
	}

	/**
	 * Get Battery
	 * 
	 * @return battery
	 */
	public Battery getBattery() {
		return battery;
	}

	/**
	 * Set Battery
	 * 
	 * @param battery bateria
	 */
	public void setBattery(Battery battery) {
		this.battery = battery;
	}

	/**
	 * Get color
	 * 
	 * @return color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Set Color
	 * 
	 * @param color color
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Get Doors
	 * 
	 * @return numberDoor
	 */
	public int getNumberDoor() {
		return numberDoor;
	}

	/**
	 * Set NumberDoor
	 * 
	 * @param numberDoor numero de puertas
	 */
	public void setNumberDoor(int numberDoor) {
		this.numberDoor = numberDoor;
	}

	/**
	 * Get name
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set Name
	 * 
	 * @param name nombre
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get ModelType
	 * 
	 * @return modelType
	 */
	public String getModelType() {
		return modelType;
	}

	/**
	 * Set ModelType
	 * 
	 * @param modelType modelo
	 */
	public void setModelType(String modelType) {
		this.modelType = modelType;
	}

	/**
	 * Get On
	 * 
	 * @return on
	 */
	public Boolean getOn() {
		return on;
	}

	/**
	 * Set on
	 * 
	 * @param on encendido
	 */
	public void setOn(Boolean on) {
		this.on = on;
	}

	@Override
	public String toString() {
		return "Car [color=" + color + ", numberDoor=" + numberDoor + ", name=" + name + ", modelType=" + modelType
				+ ", on=" + on + ", motor=" + motor + ", air=" + air + ", battery=" + battery + ", id=" + id + "]";
	}

}