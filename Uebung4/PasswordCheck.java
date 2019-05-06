package Uebung4;

import java.util.Scanner;

public class PasswordCheck {

    public static final Scanner scanner = new Scanner(System.in);
    private static int MIN_LENGTH = 8;
    private static int MIN_DIGITS_COUNT = 2;

    public static void main(String[] args) {
        boolean validPassword;

        do {
            System.out.println("Enter a password: ");
            validPassword = isPasswordValid(scanner.next());
        }
        while (!validPassword);

        System.out.println("Password valid!");
    }

    public static boolean isPasswordValid(String password) {

        if (password.length()<MIN_LENGTH){
            return false;
        }

        int numberOfDigits = 0;

        for (int i = 0; i < password.length(); i++) {
            char currentSymbol = password.charAt(i);

            if (!Character.isLetterOrDigit(currentSymbol)){
                return  false;
            }

            if (Character.isDigit(currentSymbol)){
                numberOfDigits++;
            }
        }

        return numberOfDigits >= MIN_DIGITS_COUNT;
    }
}
