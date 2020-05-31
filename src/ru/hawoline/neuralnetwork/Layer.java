package ru.hawoline.neuralnetwork;

import java.util.ArrayList;

public abstract class Layer {

    private ArrayList<Neuron> listOfNeurons;
    private int numberOfNeuronsInLayer;

    public void printLayer() {
    }

    public ArrayList<Neuron> getListOfNeurons() {
        return listOfNeurons;
    }

    public void setListOfNeurons(ArrayList<Neuron> listOfNeurons) {
        this.listOfNeurons = listOfNeurons;
    }

    public int getNumberOfNeuronsInLayer() {
        return numberOfNeuronsInLayer;
    }

    public void setNumberOfNeuronsInLayer(int numberOfNeuronsInLayer) {
        this.numberOfNeuronsInLayer = numberOfNeuronsInLayer;
    }


}
