package Uebung4;

import java.util.Scanner;

public class DigitsSum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter a number: ");

        int number = scanner.nextInt();

        System.out.println("The sum of the numbers digits is: " + SumDigits(number));
    }

    private static int SumDigits(int number) {

        int sum = 0;
        int lastDigit = number%10;

        while (lastDigit!=0){

            sum+=lastDigit;
            number-=lastDigit;
            number/=10;
            lastDigit = number%10;
        }

        return sum;
    }
}
