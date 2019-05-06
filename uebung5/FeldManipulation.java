package uebung5;

import java.util.HashSet;
import java.util.Scanner;

public class FeldManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = new int[5];

        eingabe(array);
        ausgabe(array);
        System.out.println("maximum number = "+max(array));
        System.out.println("index of min number = "+indexOfMin(array));
        array = reverse(array);
        ausgabe(array);
        linearSearch(array,2);
        linearSearch(array,6);
        array = removeDuplicates(array);
        ausgabe(array);

    }

    public static void eingabe(int[] array) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter a number:");
            array[i]=scanner.nextInt();
        }
    }

    public static void ausgabe(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(i+"  "+array[i]);
        }
    }

    public static int max(int[] array){
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i]>max){
                max=array[i];
            }
        }
        return max;
    }

    public static int indexOfMin(int[] array){
        int min = array[0];
        int index = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i]<min){
                min=array[i];
                index = i;
            }
        }
        return index;
    }

    public static int[] reverse(int[] array){
        int[] reversedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversedArray[i]=array[array.length-1-i];
        }

        return  reversedArray;
    }

    public static int linearSearch(int[] array, int element){
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i]==element){
                index=i;
            }
        }
        return  index;
    }

    public static int[] removeDuplicates(int[] array){
        HashSet<Integer> uniqueValues = new HashSet<Integer>();


        for (int i = 0; i < array.length; i++) {
            uniqueValues.add(array[i]);
        }

        int[] result = new int[uniqueValues.size()];
        int counter = 0;

        for (int u:uniqueValues ) {
            result[counter]=u;
        }

        return result;
    }

}
