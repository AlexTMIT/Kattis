import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int inputLength = new Scanner(System.in).nextLine().split("").length;
        var howl = new StringBuilder("AWAWHOO");
        howl.append("WHOO".repeat(40));
        while (howl.length() <= inputLength) howl.append("WHOO");
        System.out.print(howl);
    }
}