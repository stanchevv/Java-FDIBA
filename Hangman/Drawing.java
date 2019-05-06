package Hangman;

public class Drawing {

    public static void printDrawing(int mistakes)
    {
        switch (mistakes) {
            case 1:
                System.out.println("   _______");
                System.out.println("   |     |");
                System.out.println("   | ");
                System.out.println("   | ");
                System.out.println("   | ");
                System.out.println("   | ");
                System.out.println("   |   ");
                System.out.println("___|___");
                System.out.println("");
                break;
            case 2:
                System.out.println("   _______");
                System.out.println("   |     |");
                System.out.println("   |     O ");
                System.out.println("   | ");
                System.out.println("   | ");
                System.out.println("   | ");
                System.out.println("   |   ");
                System.out.println("___|___");
                System.out.println("");
                break;
            case 3:
                System.out.println("   _______");
                System.out.println("   |     |");
                System.out.println("   |     O");
                System.out.println("   |     |");
                System.out.println("   | ");
                System.out.println("   | ");
                System.out.println("   | ");
                System.out.println("___|___");
                System.out.println("");
                break;
            case 4:
                System.out.println("   _______");
                System.out.println("   |     |");
                System.out.println("   |     O");
                System.out.println("   | >---|");
                System.out.println("   |   ");
                System.out.println("   |   ");
                System.out.println("   |   ");
                System.out.println("___|___");
                System.out.println("");
                break;
            case 5:
                System.out.println("   _______");
                System.out.println("   |     |");
                System.out.println("   |     O");
                System.out.println("   | >---|---<");
                System.out.println("   |   ");
                System.out.println("   |   ");
                System.out.println("   |   ");
                System.out.println("___|___");
                System.out.println("");
                break;
            case 6:
                System.out.println("   _______");
                System.out.println("   |     |");
                System.out.println("   |     O");
                System.out.println("   | >---|---<");
                System.out.println("   |     |");
                System.out.println("   |   ");
                System.out.println("   |   ");
                System.out.println("___|___");
                System.out.println("");
                break;
            case 7:
                System.out.println("   _______");
                System.out.println("   |     |");
                System.out.println("   |     O");
                System.out.println("   | >---|---<");
                System.out.println("   |     |");
                System.out.println("   |    /");
                System.out.println("   |  _/");
                System.out.println("___|___  ");
                System.out.println("");
                break;
            case 8:
                System.out.println("   _______");
                System.out.println("   |     |");
                System.out.println("   |     O");
                System.out.println("   | >---|---<");
                System.out.println("   |     |");
                System.out.println("   |    / \\");
                System.out.println("   |  _/   \\_");
                System.out.println("___|___");
                System.out.println("");
                break;
            default:
                break;
        }
    }
}
