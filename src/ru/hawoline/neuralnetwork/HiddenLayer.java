package ru.hawoline.neuralnetwork;

import java.util.ArrayList;
import java.util.Arrays;

public class HiddenLayer extends Layer {

    public ArrayList<HiddenLayer> initLayer(HiddenLayer hiddenLayer,
                                            ArrayList<HiddenLayer> listOfHiddenLayers,
                                            InputLayer inputLayer,
                                            OutputLayer outputLayer) {

        ArrayList<Double> listOfWeightIn = new ArrayList<>();
        ArrayList<Double> listOfWeightOut = new ArrayList<>();
        ArrayList<Neuron> listOfNeurons = new ArrayList<>();

        int numberOfHiddenLayers = listOfHiddenLayers.size();

        for (int i = 0; i < numberOfHiddenLayers; i++) {
            for (int j = 0; j < hiddenLayer.getNumberOfNeuronsInLayer(); j++) {
                Neuron neuron = new Neuron();

                int limitIn;
                int limitOut;

                if (i == 0) { // first
                    limitIn = inputLayer.getNumberOfNeuronsInLayer();
                    if (numberOfHiddenLayers > 1) {
                        limitOut = listOfHiddenLayers.get(i + 1).getNumberOfNeuronsInLayer();
                    } else {
                        limitOut = listOfHiddenLayers.get(i).getNumberOfNeuronsInLayer();
                    }
                } else if (i == numberOfHiddenLayers - 1) { // last
                    limitIn = listOfHiddenLayers.get(i - 1).getNumberOfNeuronsInLayer();
                    limitOut = outputLayer.getNumberOfNeuronsInLayer();
                } else { // middle
                    limitIn = listOfHiddenLayers.get(i - 1).getNumberOfNeuronsInLayer();
                    limitOut = listOfHiddenLayers.get(i + 1).getNumberOfNeuronsInLayer();
                }

                for (int k = 0; k < limitIn; k++) {
                    listOfWeightIn.add(neuron.initNeuron());
                }
                for (int k = 0; k < limitOut; k++) {
                    listOfWeightOut.add(neuron.initNeuron());
                }

                neuron.setListOfWeightIn(listOfWeightIn);
                neuron.setListOfWeightOut(listOfWeightOut);
                listOfNeurons.add(neuron);

                listOfWeightIn = new ArrayList<>();
                listOfWeightOut = new ArrayList<>();
            }

            listOfHiddenLayers.get(i).setListOfNeurons(listOfNeurons);

            listOfNeurons = new ArrayList<>();

        }

        return listOfHiddenLayers;

    }

    public void printLayer(ArrayList<HiddenLayer> listOfHiddenLayers) {
        System.out.println("### HIDDEN LAYER ###");
        int h = 1;
        for (HiddenLayer hiddenLayer : listOfHiddenLayers) {
            System.out.println("Hidden Layer #" + h);
            int n = 1;
            for (Neuron neuron : hiddenLayer.getListOfNeurons()) {
                System.out.println("Neuron #" + n);
                System.out.println("Input Weights:");
                System.out.println(Arrays.deepToString(neuron.getListOfWeightIn().toArray()));
                System.out.println("Output Weights:");
                System.out.println(Arrays.deepToString(neuron.getListOfWeightOut().toArray()));
                n++;
            }
            h++;
        }
    }
}
