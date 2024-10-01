import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            setGameParameters(s);

            GameUI.start(s);
        }
    }

    private static void setGameParameters(Scanner s) {
//        System.out.println("Enter board size");
//        int size = Integer.parseInt(s.nextLine());
//        System.out.println("Choose difficulty");
//        System.out.println("(e)asy, (n)ormal, (h)ard");
//        String c = s.nextLine();
            Game.initializeBoard();

    }


}