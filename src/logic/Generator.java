package logic;

import model.Board;

import java.net.Inet4Address;
import java.util.*;

public class Generator {
    public static Board generateBoard() {


//      initial state
        Board board = new Board();

        boolean isValid = false;

        while (isValid != true) {


            for (int i = 0; i < 9; i++) {
                Set<Integer> tried = new HashSet<>();
                HashMap<Integer, Set<Integer>> triedInCell = new HashMap<>();
                Set<Integer> listOfNumbersTried = new HashSet<>();
                System.out.println(Arrays.deepToString(board.getBoard()));
                for (int j = 0; j < 9; j++) {

                    int num = (int) (Math.random() * (10 - 1) + 1);
                    boolean canSet = Rules.canPlace(board, i, j, num);

                    if (canSet) board.setBoard(i, j, num);
                    if (canSet) System.out.println("row - " + i + " col - " + j + " value - " + num);
                    if (canSet) tried.clear();

                    if (!canSet) tried.add(num);
                    if (!canSet) listOfNumbersTried.add(num);
                    if (!canSet) triedInCell.put(j,listOfNumbersTried);

                    if (!canSet && tried.size() != 9){
                        if (j == 0){
                            i -= 1;
                            j = 9;
                        }
                        if (j > 0) j -= 1;

                    }
                    if (!canSet && tried.size() == 9){
                        listOfNumbersTried.add(num);
                        triedInCell.put(j - 1,listOfNumbersTried);
                        if (j > 0) board.setBoard(i, j -1, 0);
//                        if (j == 0) board.setBoard(i - 1,8,0);
                        j -= 2;

                    }

                }

            }

            isValid = true;

        }
        System.out.println(Arrays.deepToString(board.getBoard()));
        return board;
    }

}
