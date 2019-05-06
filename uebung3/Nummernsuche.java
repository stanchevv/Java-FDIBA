package uebung3;

public class Nummernsuche {
    public static void main(String[] args) {

        int rowCounter = 0;

        for (int i = 100; i < 1001; i++) {

            if (i%5==0&&i%6==0){
                rowCounter++;
                if (rowCounter % 10 == 0) {
                    System.out.println(i);
                }
                else{
                    System.out.print(i+" ");
                }
            }
        }
    }
}
