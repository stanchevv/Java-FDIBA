package Hangman;

import java.util.ArrayList;

public class InputHandling {
    private ArrayList<Character> typedLetters = new ArrayList<Character>();
    private int mistakes = 0;

    public String getWord() {
        return word;
    }

    private String word;

    public InputHandling(String word) {
        this.word = word;
    }

    public void printTypedLetters()
    {
        for (int i = 0; i < this.typedLetters.size(); i++) {
            System.out.print(this.typedLetters.get(i).toString()+" ");
        }
        System.out.println();
    }

    public StringBuilder findLetterInWord(char letter, String hiddenWord) {

        String newHiddenWord = "";

        if (!alreadyTriedLetter(letter)){
            for (int i = 0; i < word.length(); i++) {
                if (letter==word.charAt(i)){
                    newHiddenWord+= word.charAt(i);
                }
                else {
                    newHiddenWord+= hiddenWord.charAt(i);
                }
            }
        }
        else {
            StringBuilder result = new StringBuilder(hiddenWord);
            return result;
        }

        if (newHiddenWord.equals(hiddenWord))
        {
            mistakes++;
        }

        StringBuilder result = new StringBuilder(newHiddenWord);
        return result;
    }

    private boolean alreadyTriedLetter(char letter) {

        boolean alreadyTried = typedLetters.contains(letter);

        if (letter < 97 || letter > 122) {
            return true;
        }
        if (!alreadyTried && (letter >= 97 && letter <= 122)) {
            typedLetters.add(letter);
        }

        return alreadyTried;
    }

    public static boolean notGuessed(StringBuilder hiddenWord) {

        boolean notGuessed = false;

        if (hiddenWord.toString().contains("_")) {
            notGuessed = true;
        }
        return notGuessed;
    }

    public int getMistakesCount() {
        return mistakes;
    }

}