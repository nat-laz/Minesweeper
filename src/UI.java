import java.util.Scanner;

public class UI {

    private static Scanner scanner = new Scanner(System.in);

    public static void openCell() {
        System.out.println("Enter the row and column of the cell to reveal (e.g., '2 3'):");
        int row = scanner.nextInt();
        int col = scanner.nextInt();

        if (Game.isValid(row, col)) {
            if (Game.board[row][col].isMine()) {
                System.out.println("You hit a mine! Game over.");
                Game.revealAllMines();
                Game.printBoard(true);
                System.exit(0);
            } else {
                Game.revealCells(row, col);
                Game.printBoard(false);
            }
        } else {
            System.out.println("Invalid input! Try again.");
        }
    }

    public static void markMine() {
        System.out.println("Enter the row and column of the cell to mark/unmark as a mine (e.g., '2 3'):");
        int row = scanner.nextInt();
        int col = scanner.nextInt();

        if (Game.isValid(row, col)) {
            Cell cell = Game.board[row][col];
            if (cell.isHidden()) {
                cell.setMarkedAsMine(!cell.isMarkedAsMine());
                System.out.println("Cell marked/unmarked as a mine.");
                Game.printBoard(false);
            } else {
                System.out.println("This cell is already revealed! You can't mark it.");
            }
        } else {
            System.out.println("Invalid input! Try again.");
        }
    }

    public static void determineWinner() {
        if (Game.safeCells == 0) {
            System.out.println("Congratulations! You've won the game!");
            Game.printBoard(false);
            System.exit(0);
        }
    }

}
