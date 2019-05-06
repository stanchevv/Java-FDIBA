package uebung3;

import java.util.Scanner;

public class Nummernzaehler {
    public static void main(String[] args) {

        double average = 0;
        int sum = 0;
        int positiveNumbersCount = 0;
        int negativeNumbersCount = 0;
        int counter = 0;
        Scanner scanner = new Scanner(System.in);

        int currentNum = scanner.nextInt();

        while (currentNum != 0) {
            sum += currentNum;

            if (currentNum > 0) {
                positiveNumbersCount++;
            }
            else{
                negativeNumbersCount++;
            }
            counter++;
            currentNum=scanner.nextInt();
        }

        average=sum/counter;

        System.out.println("Negative Numbers: "+negativeNumbersCount);
        System.out.println("Positive Numbers: "+positiveNumbersCount);
        System.out.println("Sum: "+sum);
        System.out.println("Average: "+average);

    }
}
