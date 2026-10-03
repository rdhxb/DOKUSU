package logic;

import model.Board;

import javax.swing.*;
import java.net.Inet4Address;
import java.util.*;

public class Generator {
    public static Board generateBoard() {

        Board board = new Board();


        ArrayList<Set<Integer>> position = new ArrayList<>();

        for (int i = 0; i < 81; i++) {
            position.add(new HashSet<>());
        }

        int pos = 0;
        while (pos < 81) {

            int row = (int)(pos / 9);
            int col = pos % 9 ;

            int num = (int) (Math.random() * (10 - 1) + 1);
            boolean canSet = Rules.canPlace(board, row, col , num);

            position.get(pos).add(num);

            if (canSet){
                board.setBoard(row,col,num);
                pos++;
            }else{
                if (position.get(pos).size() == 9){
                    position.get(pos).clear();
                    pos--;
                    board.setBoard(pos / 9,pos % 9 ,0);

                }
            }

            }

        System.out.println(Arrays.deepToString(board.getBoard()));
        return board;
    }

}
