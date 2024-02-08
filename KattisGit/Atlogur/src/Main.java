import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Knight[] knights = getKnights();
        Knight winner = getWinner(knights);
        printWinner(winner);
    }

    public static Knight[] getKnights() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // buffer
        Knight[] list = new Knight[n];
        int index = 1;

        for (int i = 0; i < n; i++) {
            String[] properties = scanner.nextLine().split(" ");
            int health = Integer.parseInt(properties[0]);
            int strength = Integer.parseInt(properties[1]);
            list[i] = new Knight(health, strength, index);
            index++;
        }

        return list;
    }

    public static Knight getWinner(Knight[] knights) {
        if (knights.length > 1) {
            var first = knights[0];
            var second = knights[1];

            for (int i = 0; i < knights.length; i++) {
                while (first.isAlive() && second.isAlive()) {
                    first.attack(second);

                    if (!second.isAlive()) {
                        second = getNextKnight(knights, i);
                        break;
                    } else {
                        second.attack(first);
                        if (!first.isAlive()) {
                            first = second;
                            second = getNextKnight(knights, i);
                            break;
                        }
                    }
                }
            }

            if (first.isAlive()) {
                return first;
            } else {
                return second;
            }
        }

        return new Knight(1, 1, 1);
    }

    public static Knight getNextKnight(Knight[] knights, int i) {
        if (i + 2 >= knights.length) {
            return new Knight(0, 0, -1);
        } else {
            return knights[i + 2];
        }
    }

    public static void printWinner(Knight winner) {
        int index = winner.getIndex();
        System.out.println(index);
    }
}