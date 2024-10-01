import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeGame(scanner);
        UI.start();
    }

    private static void initializeGame(Scanner s) {
        System.out.println("Enter size of the board");
        int size = Integer.parseInt(s.nextLine()); // add exception handling and input validation and while loop

        System.out.println("Enter difficulty (easy, normal, hard)");
        String difficulty = s.nextLine(); // add exception handling and input validation and while loop

        Game.initialize(size, difficulty);
    }
}