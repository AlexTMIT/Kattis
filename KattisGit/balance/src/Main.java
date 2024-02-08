import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var input = new Scanner(System.in).nextLine().split("");
        HashMap<String, Integer>[] bracketsByLevel = new HashMap[input.length];
        if (isValid(0, input, bracketsByLevel, 0)) System.out.print(1);
        else System.out.print(0);
    }

    public static boolean isValid(int characterIndex, String[] input, HashMap<String, Integer>[] bracketsByLevel,
                                  int currentLevel) {
        if (characterIndex >= input.length) {
            return currentLevel == 0 && hasEqualAmountsOfBrackets(bracketsByLevel);
        }

        var character = input[characterIndex];

        // Handling a closing bracket
        if (character.equals(")") || character.equals("]")) {
            if (currentLevel <= 0 || getOpenAmountAtLevel(bracketsByLevel[currentLevel], character) <= 0) {
                return false;
            }
            bracketsByLevel[currentLevel].merge(matchingOpeningBracket(character), -1, Integer::sum);
            currentLevel--;
            return isValid(characterIndex + 1, input, bracketsByLevel, currentLevel);
        }
        // Handling an opening bracket
        else {
            currentLevel++;
            if (currentLevel >= input.length) return false;
            bracketsByLevel[currentLevel] = new HashMap<>();
            bracketsByLevel[currentLevel].merge(character, 1, Integer::sum);
            return isValid(characterIndex + 1, input, bracketsByLevel, currentLevel);
        }
    }

    public static String matchingOpeningBracket(String closingBracket) {
        if (closingBracket.equals(")")) return "(";
        return "[";
    }

    public static int getOpenAmountAtLevel(HashMap<String, Integer> brackets, String character) {
        if (character.equals(")") || character.equals("(")) return brackets.getOrDefault("(", 0);
        return brackets.getOrDefault("[", 0);
    }

    public static int getClosedAmountAtLevel(HashMap<String, Integer> brackets, String character) {
        if (character.equals("]") || character.equals("[")) return brackets.getOrDefault("[", 0);
        return brackets.getOrDefault("]", 0);
    }

    public static boolean hasEqualAmountsOfBrackets(HashMap<String, Integer>[] bracketsByLevel) {
        var roundiesEquivalence = 0;
        var squareEquivalence = 0;
        for (HashMap<String, Integer> brackets : bracketsByLevel) {
            if (brackets != null) {
                roundiesEquivalence += getClosedAmountAtLevel(brackets, ")") - getOpenAmountAtLevel(brackets, ")");
                squareEquivalence += getClosedAmountAtLevel(brackets, "]") - getOpenAmountAtLevel(brackets, "]");
            }
        }
        return roundiesEquivalence == 0 && squareEquivalence == 0;
    }
}