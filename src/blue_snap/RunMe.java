package blue_snap;

import blue_snap.service.Game;
import blue_snap.service.MatrixService;

import java.io.IOException;

public class RunMe {

    static String[][] matrixExample = {
            {"q", "w", "e", "r"},
            {"a", "s", "d", "f"},
            {"z", "x", "c", "v"}
    };
    static Integer[] possibleMoves = {1, 2, 4};
    static int number = 3;


    public static void main(String[] args) {
        Game game = new Game();
        MatrixService matrix = new MatrixService();

        System.out.println("\nPrint matrix spiral:");
        if (matrixExample.length > 0 && matrixExample[0].length > 0) {
            matrix.printSpiral(matrixExample, matrixExample.length, matrixExample[0].length);
        } else {
            System.out.println("Matrix not valid");
        }


        try {
            System.out.println("\n\nPlay:)");
            if (game.win(number, possibleMoves)) {
                System.out.println("True - the player making the first move won");
            } else {
                System.out.println("False – the player making the first move lost");
            }
        } catch (IOException e) {
            System.out.println("Game setting not valid ");
        }

    }
}
