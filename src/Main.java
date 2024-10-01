import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int size = getBoardSize(scanner);
            String difficulty = getDifficultyLevel(scanner);
            Game.initialize(size, difficulty);
            UI.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static int getBoardSize(Scanner scanner) {
        int size = 0;
        while (true) {
            System.out.println("Enter size of the board (between 3 and 10):");
            String input = scanner.nextLine();
            try {
                size = Integer.parseInt(input);
                if (size >= 3 && size <= 10) {
                    return size;
                } else {
                    System.out.println("Invalid size! Please enter a number between 3 and 10.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
    }


    private static String getDifficultyLevel(Scanner scanner) {
        String difficulty = "";
        while (true) {
            System.out.println("Enter difficulty (easy, normal, hard):");
            difficulty = scanner.nextLine().toLowerCase();
            if (difficulty.equals("easy") || difficulty.equals("normal") || difficulty.equals("hard")) {
                return difficulty;
            } else {
                System.out.println("Invalid difficulty! Please enter 'easy', 'normal', or 'hard'.");
            }
        }
    }
}
