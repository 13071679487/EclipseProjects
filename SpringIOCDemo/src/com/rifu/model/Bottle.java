package com.rifu.model;

public class Bottle {
	private Animal animal;

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
	public void beginDrink(){
		animal.drink();
	}
	
}
