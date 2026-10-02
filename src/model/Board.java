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


}
