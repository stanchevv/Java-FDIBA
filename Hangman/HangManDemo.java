package Hangman;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.Scanner;

public class HangManDemo {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String anotherGame;
        System.out.println("Hangman - Guess the hidden word to win the game.\n");
        do {
            game();
            System.out.println("Do you want to play another game (Type \"Ja\" or \"Nein\"):");
            do {
                anotherGame = scanner.next().toLowerCase();
                if (!anotherGame.toLowerCase().equals("ja")&&!anotherGame.toLowerCase().equals("nein")){
                    System.out.println("Invalid input.");
                }
            }
            while (!anotherGame.toLowerCase().equals("ja")&&!anotherGame.toLowerCase().equals("nein"));
        } while (anotherGame.equals("ja"));

    }

    public static void game() {
        Random random = new Random();
        int randomNumber = random.nextInt(300);

        WordHandling wordHandling = new WordHandling(WordHandling.getWordFromFile(randomNumber));
        InputHandling inputHandling = new InputHandling(WordHandling.getWordFromFile(randomNumber));

        StringBuilder output = wordHandling.hiddenWord();
        System.out.println(WordHandling.formatWord(output));
        Instant startTime = Instant.now();
        char input = scanner.next().toLowerCase().charAt(0);

        do {
            output = inputHandling.findLetterInWord(input, output.toString());
            System.out.println(WordHandling.formatWord(output).toString());

            if (InputHandling.notGuessed(output)) {
                System.out.println("\nMistakes: " + inputHandling.getMistakesCount());
                Drawing.printDrawing(inputHandling.getMistakesCount());

                if (inputHandling.getMistakesCount() == 8) {
                    System.out.println("You didn't guess the word. The word is: " + wordHandling.getWord());
                    Duration time = Duration.between(startTime, Instant.now());
                    System.out.println(formatTime(time));
                    break;
                }
                inputHandling.printTypedLetters();
                input = scanner.next().toLowerCase().charAt(0);
            } else {
                System.out.println("Congratulations, you won the game!");
                Duration time = Duration.between(startTime, Instant.now());
                System.out.println(formatTime(time));
            }
        } while (InputHandling.notGuessed(output));
    }

    public static String formatTime(Duration time) {
        if (time.getSeconds() < 60) {
            return String.format("Time played: %d sec", time.getSeconds());
        } else {
            return String.format("Time played: %d min, %d sec", time.getSeconds() / 60,
                    time.getSeconds() % 60);
        }
    }
}

