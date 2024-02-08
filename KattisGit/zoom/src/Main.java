import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/Users/atm/Desktop/ITU/Algorithms/Kattis/zoom/src/input.txt"));
        String[] firstLine = scanner.nextLine().split(" ");
        String[] numbers = scanner.nextLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int k = Integer.parseInt(firstLine[1]);
        int counter = 0;
        StringBuilder output = new StringBuilder();

        for (int i = k-1; i < numbers.length; i += k) {
            output.append(numbers[i]).append(" ");
        }

        System.out.print(output.toString().trim());
    }
}