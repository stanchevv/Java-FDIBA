package uebung3;

import java.util.Scanner;

public class SchleifenBeispiele {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a;
        int b;

        do {
            System.out.println("Geben Sie zwei Zahlen ein: ");
            a = scanner.nextInt();
            b = scanner.nextInt();

            System.out.println("Positive Zahlen: " + (a > 0 && b > 0));

        }

        while (a != 0 || b != 0);
        {
            System.out.println("Geben Sie eine Zahl n (n>2) ein: ");
            long number = scanner.nextLong();
            long divider = 2;
            boolean numberPrime = true;

            while (divider <= Math.sqrt(number)) {
                if (number % divider == 0) {
                    numberPrime = false;
                    break;
                }
                divider++;
            }

            System.out.println("Primzahl: " + numberPrime);

            System.out.println("Geben Sie Ihren Namen ein: ");
            String name = scanner.nextLine();

            for (int i = 0; i < name.length(); i++) {
                System.out.println("*" + name.charAt(i) + "*");
            }
        }
    }
}
