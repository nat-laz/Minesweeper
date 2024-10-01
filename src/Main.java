import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Game.initializeBoard();
        Game.placeMines();
        Game.countMinesOnBoard();
        Game.checkMines();
        Game.printBoard(false);

        while (true) {
            System.out.println("Choose an action: ");
            System.out.println("1. Open a cell");
            System.out.println("2. Mark/unmark a cell as a mine");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    UI.openCell();
                    break;
                case 2:
                    UI.markMine();
                    break;
                default:
                    System.out.println("Invalid choice! Please select 1 or 2.");
                    break;
            }

            UI.determineWinner();
        }
    }
}