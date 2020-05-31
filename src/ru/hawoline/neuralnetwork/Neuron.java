package ru.hawoline.neuralnetwork;

import java.util.ArrayList;
import java.util.Random;

public class Neuron {

	private ArrayList<Double> listOfWeightIn;
	private ArrayList<Double> listOfWeightOut;
	
	public double initNeuron(){
		Random r = new Random();
		return r.nextDouble();
	}

	public ArrayList<Double> getListOfWeightIn() {
		return listOfWeightIn;
	}

	public void setListOfWeightIn(ArrayList<Double> listOfWeightIn) {
		this.listOfWeightIn = listOfWeightIn;
	}

	public ArrayList<Double> getListOfWeightOut() {
		return listOfWeightOut;
	}

	public void setListOfWeightOut(ArrayList<Double> listOfWeightOut) {
		this.listOfWeightOut = listOfWeightOut;
	}
	
}
