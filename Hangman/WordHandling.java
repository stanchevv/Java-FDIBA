package Hangman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WordHandling{

    private final static Path words = Paths.get("src/words.txt");
    private String word;

    public WordHandling(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public StringBuilder hiddenWord() {

        StringBuilder builder = new StringBuilder();

        if (getWord() != null) {
            for (int i = 0; i < getWord().length(); i++) {
                builder.append("_");
            }
        }
        return builder;
    }

    public static String getWordFromFile(int randomNumber) {

        BufferedReader reader = null;
        String[] parts = null;
        String word = null;

        try {
            reader = new BufferedReader(new FileReader(words.toFile()));
            String line = "";
            while ((line = reader.readLine()) != null) {
                parts = line.split(" ");
                if (Integer.valueOf(parts[0]) == randomNumber) {
                    word = parts[1];
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return word;

    }

    public static StringBuilder formatWord(StringBuilder input) {

        StringBuilder formatedString = new StringBuilder();

        for (char letter : input.toString().toCharArray()) {
            formatedString.append(letter);
            formatedString.append(" ");
        }
        return formatedString;
    }
}