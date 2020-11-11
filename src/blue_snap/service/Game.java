package blue_snap.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Game {

    //Winning is -> if you chose move and the opponent do not have path to win
    public boolean win(int number, Integer[] possibleMoves) throws IOException {
        if (null == possibleMoves || possibleMoves.length < 1) {
            throw new IOException("No valid- possibleMoves is not valid.");
        }
        //Sort "possible moves" by size before send to the reclusive methode.
        //like that we know possibleMoves[0] is the smallest
        Arrays.sort(possibleMoves);
        Integer smallestMove = possibleMoves[0];

        //Later in the recursive methode i like to check if contain in O(1)
        Set<Integer> possibleMovesSet = new HashSet<>(Arrays.asList(possibleMoves));

        for (Integer move : possibleMovesSet) {
            if (move <= number) {
                if (!isThereOptionToWin(number - move, possibleMovesSet, smallestMove)) {
                    System.out.println("Move that win by doing the first step is: " + move);
                    return true;
                }
            }
        }
        return false;
    }


    private boolean isThereOptionToWin
            (int number, Set<Integer> possibleMoves, Integer smallestMove) {

        if (possibleMoves.contains(number)) {
            return true;
        }

        if (number < smallestMove) {
            return false;
        }

        for (Integer possibleMove : possibleMoves) {
            if (possibleMove <= number) {
                int updateNumber = number - possibleMove;
                boolean isTharOptionToWinNextIteration = isThereOptionToWin(updateNumber, possibleMoves, smallestMove);
                if (isTharOptionToWinNextIteration) {
                    return false;
                }
            }
        }
        return true;
    }
}



