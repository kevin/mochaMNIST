package mochamnist;

import io.github.kevin.mocha.NeuralNetwork;
import io.github.kevin.mocha.Trainer;
import io.github.kevin.mocha.learning.GradientDescent;

public class Main {

    public static void main(String[] args) {

        NeuralNetwork nn = new NeuralNetwork(new int[] { 784, 16, 16, 10 });
//        System.out.println(nn);
//        System.out.println(nn.getNeuron(2, 14).getOut(9) == nn.getNeuron(3, 9).getIn(14));

        NeuralNetwork simple = new NeuralNetwork(new int[] { 3, 1 });

        float[][] trainingData = new float[10][3];
        float[][] expectedData = new float[10][1];
        // generate random cases for this
        for (int i = 0; i < trainingData.length; i++) {
            for (int j = 0; j < trainingData[i].length; j++) {
                trainingData[i][j] = Math.random() < 0.5 ? 0 : 1;
            }
            expectedData[i][0] = trainingData[i][0];
        }

        Trainer gd = new GradientDescent(simple, trainingData, expectedData);
        gd.train();

        float[][] testData = new float[10][3];
        // generate random cases for this
        for (int i = 0; i < testData.length; i++) {
            for (int j = 0; j < testData[i].length; j++) {
                testData[i][j] = Math.random() < 0.5 ? 0 : 1;
            }
            expectedData[i][0] = testData[i][0];
        }

        for (int i = 0; i < testData.length; i++) {
            System.out.println(simple.predict(testData[i])[0] + " Actual: " + expectedData[i][0]);
        }

    }

}
