import java.util.Scanner;

public abstract class UI {

    private static Scanner scanner = new Scanner(System.in);

    public static void start() {
        while (true) {
            Game.printBoard(false);
            printOptions();
            switch (scanner.nextLine()) {
                case "1":
                    handleRevealCellOption();
                    break;
                case "2":
                    handleMarkMineOption();
                    break;
                case "3":
                    System.exit(0);
                default:
                    System.out.println("Wrong input");
            }
            determineWinner();
        }
    }

    private static void printOptions() {
        System.out.println("1 - Reveal cell");
        System.out.println("2 - Mark/Unmark mine");
        System.out.println("3 - exit");
    }

    public static void handleRevealCellOption() {
        System.out.println("Enter the row of the cell to reveal (e.g., '2'):");
        int row = handleIntInput() - 1;
        if (row < 0) {
            return;
        }

        System.out.println("Enter the column of the cell to reveal (e.g., '2'):");
        int col = handleIntInput() - 1;
        if (col < 0) {
            return;
        }

        if (!Game.isValid(row, col)) {
            System.out.println("This cell doesn't exists");
            return;
        }

        if (!Game.getCell(row, col).isHidden()) {
            System.out.println("This cell is already open");
            return;
        }

        if (Game.getCell(row, col).isMine()) {
            System.out.println("You hit a mine! Game over.");
            Game.revealAllMines();
            Game.printBoard(true);
            System.exit(0);
        } else {
            Game.revealCell(row, col);
        }
    }

    private static void handleMarkMineOption() {
        System.out.println("Enter the row of the cell to mark/unmark as a mine (e.g., '2'):");
        int row = handleIntInput() - 1;
        if (row < 0) {
            return;
        }

        System.out.println("Enter the column of the cell to mark/unmark as a mine (e.g., '2'):");
        int col = handleIntInput() - 1;
        if (col < 0) {
            return;
        }

        if (!Game.isValid(row, col)) {
            System.out.println("This cell doesn't exists");
            return;
        }

        Cell cell = Game.getCell(row, col);

        if (!cell.isHidden()) {
            System.out.println("This cell is already open");
            return;
        }

        cell.setMarkedAsMine(!cell.isMarkedAsMine());
        System.out.println("Cell marked/unmarked as a mine.");
    }

    private static void determineWinner() {
        if (Game.getSafeCells() == 0) {
            System.out.println("Congratulations! You've won the game!");
            Game.printBoard(true);
            System.exit(0);
        }
    }

    private static int handleIntInput() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Can't parse this number");
            return -1;
        }
    }

}
