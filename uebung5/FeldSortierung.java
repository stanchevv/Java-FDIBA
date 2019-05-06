package uebung5;

import java.util.Arrays;

public class FeldSortierung {
    public static void main(String[] args) {

        int[] array1 = {8,5,2,6,13};
        int[] array2 = {4,7,2,9,1};
        int[] array3 = {24,1,12,5,8};

        selectionSort(array1);
        bubbleSort(array2);
        Arrays.sort(array3);

        FeldManipulation.ausgabe(array1);
        FeldManipulation.ausgabe(array2);
        FeldManipulation.ausgabe(array3);

    }

    public static void bubbleSort(int[] array) {

        for (int i = 0; i < array.length-1; i++) {

            for (int j = 0; j < array.length-1-i; j++) {

                int currentNumber = array[j];

                if (currentNumber>array[j+1]) {
                    array[j] = array[j+1];
                    array[j+1] = currentNumber;
                }
            }
        }
    }

    public static void selectionSort(int[] array) {

        for (int i = 0; i < array.length; i++) {

            int minIndex = i;

            for (int j = i+1; j < array.length; j++) {
                if (array[j]<array[minIndex]){
                    minIndex = j;
                }
            }

            int temporary = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temporary;
        }
    }
}
