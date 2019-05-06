package Uebung4;

import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter a number: ");
        int number = scanner.nextInt();

        System.out.println("When we reverse the digits the number is: " + Integer.toString(Reverse(number)));
        System.out.println("Prime: "+isPrime(number));
        System.out.println("Palindrome: "+isPalindrome(number));

    }

    public static boolean isPrime(int number) {

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number%i==0){
                return  false;
            }
        }

        return true;
    }

    public static boolean isPalindrome(int number) {

        String stringNumber = Integer.toString(number);
        String endPart = "";

        for (int i = stringNumber.length()-1; i > stringNumber.length()/2; i--) {
            endPart += stringNumber.charAt(i);
        }

        if (endPart.equals(stringNumber.substring(0,stringNumber.length()/2))){
            return true;
        }
        else {
            return false;
        }

    }

    public static int Reverse(int number) {
        String stringNumber = Integer.toString(number);
        String reverseNumber = "";

        for (int i = stringNumber.length()-1; i >= 0; i--) {
            reverseNumber += stringNumber.charAt(i);
        }

        return Integer.parseInt(reverseNumber);
    }
}
