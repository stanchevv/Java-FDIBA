package uebung5;

public class FelderBeispiele {
    public static void main(String[] args) {


        int[] zahlen = new int[100];

        for (int i = 0; i < zahlen.length; i++) {
            zahlen[i]=i;
        }

        for (int i = 0; i < zahlen.length; i++) {
            System.out.println(zahlen[i]);
        }
    }
}
