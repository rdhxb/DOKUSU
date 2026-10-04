package model;

import java.util.Arrays;

public class Board {
     private int[][] board = new int[9][9];


    public int[][] getBoard() {
        return board;
    }

    public int getValue(int row, int col){
        return board[row][col];
    }

    public void setBoard(int row, int col , int value) {
        board[row][col] = value;
    }

    public boolean isEmpty(int row, int col){
        return board[row][col] == 0;
    }

    public Board makeCopy(){

        Board newCopy = new Board();

        for (int i = 0; i < 81; i++) {
            int row = i / 9;
            int col = i % 9;

            int value = getValue(row, col);

            newCopy.setBoard(row,col,value);
        }
        return newCopy;
    }


}
