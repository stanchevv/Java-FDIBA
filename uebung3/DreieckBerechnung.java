package uebung3;

import java.util.Scanner;

public class DreieckBerechnung {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a, b, c;

        a = scanner.nextDouble();
        b = scanner.nextDouble();
        c = scanner.nextDouble();

        boolean correctTriengle = false;

        if (a!=0&&b!=0&&c!=0&&(a+b>c)&&(a+c>b)&&(b+c>a&&a>0&&b>0&&c>0)){
            correctTriengle = true;
        }

        while (correctTriengle){

            double p = a+b+c;
            double s = Math.sqrt(p*(p-a)*(p-b)*(p-c));
            System.out.println("Flaeche: "+s);

            System.out.print("Das Dreieck ist: ");
            if (a==b&& b==c){
                System.out.println("gleichseitig");
            }
            else if (a==b||a==c||b==c){
                System.out.println("gleichschenklig");
            }
            else{
                System.out.println("ungleichseitig");
            }

            a = scanner.nextDouble();
            b = scanner.nextDouble();
            c = scanner.nextDouble();

            correctTriengle = false;

            if (a!=0&&b!=0&&c!=0&&(a+b>c)&&(a+c>b)&&(b+c>a&&a>0&&b>0&&c>0)){
                correctTriengle = true;
            }
        }

        System.out.println("Die Werte sind nicht korrekt!");
    }
}
