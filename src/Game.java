import java.util.Random;


public class Game {
    private static Cell[][] board;
    private static int boardSize;
    private static int safeCells;
    private static int amountOfMines;

    public static Cell[][] getBoard() {
        return board;
    }

    public static Cell getCell(int x, int y) {
        return board[x][y];
    }

    public static int getSafeCells() {
        return safeCells;
    }

    public static void initialize(int size, String difficulty) {
        boardSize = size;

        initializeBoard(size);
        calculateAmountOfMines(difficulty, size);
        placeMines(difficulty);
        safeCells = size * size - amountOfMines;
    }

    private static void initializeBoard(int size) {
        board = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Cell(i, j);
            }
        }
    }

    // 3 x 3 = 9 cells
    // 5 x 5 = 25 cells
    private static void calculateAmountOfMines(String difficulty, int size) {
        if (difficulty.equalsIgnoreCase("easy")) {
            amountOfMines = size;
        } else if (difficulty.equalsIgnoreCase("normal")) {
            amountOfMines = size + 2;
        } else if (difficulty.equalsIgnoreCase("hard")) {
            amountOfMines = size + size;
        }
    }

    private static void placeMines(String difficulty) {
        Random rand = new Random();
        int placedMines = 0;

        while (placedMines < amountOfMines) {
            int i = rand.nextInt(boardSize);
            int j = rand.nextInt(boardSize);

            if (!board[i][j].isMine()) {
                board[i][j].setMine(true);
                placedMines++;
                // Debugging purpose
                System.out.println("Mine placed at: (" + i + ", " + j + ")");
            }
        }
    }

    // Debugging purpose
    public static void countMinesOnBoard() {
        int mineCount = 0;
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (board[i][j].isMine()) {
                    mineCount++;
                }
            }
        }
        System.out.println("Total number of mines on the board: " + mineCount);
    }


    public static void checkMines() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (!board[i][j].isMine()) {  // If the cell isn't a mine, count nearby mines
                    int nearbyMines = countNearbyMines(i, j);
                    board[i][j].setMinesAround(nearbyMines);
                }
            }
        }
    }

    private static int countNearbyMines(int x, int y) {
        int count = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newRow = x + i;
                int newCol = y + j;

                if (isValid(newRow, newCol) && board[newRow][newCol].isMine()) {
                    count++;
                }
            }
        }
        return count;
    }


    public static void revealCells(int x, int y) {
        Cell cell = board[x][y];
        if (!cell.isHidden()) {
            return;
        }

        cell.reveal();
        safeCells--;
        if (cell.getMinesAround() == 0) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int newX = x + i;
                    int newY = y + j;
                    if (isValid(newX, newY)) {
                        revealCells(newX, newY);
                    }
                }
            }
        }
    }

    public static boolean isValid(int row, int col) {
        return row >= 0 && row < boardSize && col >= 0 && col < boardSize;
    }

    public static void printBoard(boolean gameOver) {
        System.out.println("Board right now:");
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                Cell cell = board[i][j];
                if (gameOver && cell.isMine()) {
                    System.out.print("M ");
                } else if (cell.isMarkedAsMine() && !gameOver) {
                    System.out.print("🚩");
                } else if (cell.isHidden()) {
                    System.out.print("- ");
                } else if (cell.isMine()) {
                    System.out.print("M ");
                } else {
                    System.out.print(cell.getMinesAround() + " ");
                }
            }
            System.out.println();
        }
    }

    public static void revealAllMines() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (board[i][j].isMine()) {
                    board[i][j].reveal();
                }
            }
        }
    }
}



