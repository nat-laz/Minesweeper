import java.util.Scanner;

public abstract class GameUI {

    public static void start(Scanner s) {
        while (true) {
            Game.printBoard();

            printOptions();

            switch (s.nextLine()) {
                case "1" -> handleRevealCellOption(s);
                case "2" -> handleMarkMineOption(s);
                case "3" -> handleUnmarkMineOption(s);
                case "4" -> System.exit(0);
            }
        }
    }

    private static void printOptions() {
        System.out.println("1 - reveal cell");
        System.out.println("2 - Mark mine");
        System.out.println("3 - Unmark mine");
        System.out.println("4 - exit");
    }

    private static void handleRevealCellOption(Scanner s) {
        System.out.println("Which cell do u want to open?");
        System.out.println("Enter x coordinate");
        int x = Integer.parseInt(s.nextLine());
        System.out.println("Enter y coordinate");
        int y = Integer.parseInt(s.nextLine());

        if (!Game.isValid(x, y)){
            System.out.println("This cell doesn't exists");
            return;
        }

        if (!Game.board[x][y].isHidden()){
            System.out.println("This cell is already open");
            return;
        }

        Game.revealCells(x, y);

        if (Game.board[x][y].isMine()) {
            foundMine();
        }
    }

    private static void printBoard() {

    }

    private static void foundMine() {
        System.out.println("U step over the mine");
        System.out.println("Game over");
        //Game.revealAllMines();
        //Game.printBoard();
        System.exit(0);
    }

    private static void handleMarkMineOption(Scanner s) {
        System.out.println("Which cell do u want to mark as mine?");
        System.out.println("Enter x coordinate");
        int x = Integer.parseInt(s.nextLine());
        System.out.println("Enter y coordinate");
        int y = Integer.parseInt(s.nextLine());
    }

    private static void handleUnmarkMineOption(Scanner s) {
        System.out.println("Which cell do u want to unmark?");
        System.out.println("Enter x coordinate");
        int x = Integer.parseInt(s.nextLine());
        System.out.println("Enter y coordinate");
        int y = Integer.parseInt(s.nextLine());
    }


}
