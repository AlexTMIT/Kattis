import java.util.Scanner;

public class coffeecupcombo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine().split("")[0]);
        int lectures = 0;
        int toGoCoffees = 0;
        String[] coffeeMachines = scanner.nextLine().split("");

        for (String coffeeMachine : coffeeMachines) {
            if (coffeeMachine.equals("1")) {
                toGoCoffees = 2;
                lectures++;
            } else {
                if (toGoCoffees > 0) {
                    toGoCoffees--;
                    lectures++;
                }
            }
        }

        System.out.print(lectures);
    }
}