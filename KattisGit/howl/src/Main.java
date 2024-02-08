import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int wolfHowlLength = new Scanner(System.in).nextLine().split("").length;
        System.out.print(recursiveAdd(new StringBuilder(), wolfHowlLength));
    }

    public static String nextLetter(StringBuilder howl) {
        ArrayList<String> validLetters = new ArrayList<>(Arrays.asList("H", "A", "O", "W"));

        if (howl.length() == 0) {
            return "A";
        } else {
            char lastChar = howl.charAt(howl.length() - 1);

            if (lastChar == 'W') validLetters.remove("W");

            if (lastChar == 'H') {
                validLetters.remove("H");
                validLetters.remove("W");
                validLetters.remove("A");
            }

            if (firstOccurrenceOfO(howl)) {
                validLetters.remove("A");
            }

            Random random = new Random();
            int randomIndex = random.nextInt(validLetters.size());
            return validLetters.get(randomIndex);
        }
    }

    public static String recursiveAdd(StringBuilder howl, int length) {
        if (howl.length() <= length || !containsAllLetters(howl)) {
            howl.append(nextLetter(howl));
            recursiveAdd(howl, length);
        }
        return howl.toString();
    }

    public static boolean containsAllLetters(StringBuilder howl) {
        boolean containsA = false, containsH = false, containsO = false, containsW = false;

        for (int i = 0; i < howl.length(); i++) {
            char c = howl.charAt(i);
            if (c == 'A') containsA = true;
            else if (c == 'H') containsH = true;
            else if (c == 'O') containsO = true;
            else if (c == 'W') containsW = true;

            // Early exit
            if (containsA && containsH && containsO && containsW) {
                return true;
            }
        }

        return containsA && containsH && containsO && containsW;
    }

    public static boolean firstOccurrenceOfO(StringBuilder howl) {
        int counter = 0;

        for (String character : howl.toString().split("")) {
            if (character.equals("O")) counter++;
        }

        return counter > 0;
    }
}