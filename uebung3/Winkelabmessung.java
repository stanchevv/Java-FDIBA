package uebung3;

import java.util.Scanner;

public class Winkelabmessung {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        double winkel = Double.parseDouble(input[0]);
        String einheit = input[1];

        while (einheit.equals("r")||einheit.equals("g")){

            if (einheit.equals("g")){
                Double neuWinkel= winkel*Math.PI/180;
                System.out.println("Winkel: "+neuWinkel+" r");
            }
            else{
                Double neuWinkel = winkel/Math.PI*180;
                System.out.println("Winkel: "+neuWinkel+" g");
            }

            input = scanner.nextLine().split(" ");
            winkel = Integer.parseInt(input[0]);
            einheit = input[1];

        }



    }
}
