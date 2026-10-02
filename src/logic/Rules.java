package logic;

import model.Board;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Rules {
    public static boolean canPlace(Board board, int row, int col, int value){
//        test is empty and value 1-9
        if (board.isEmpty(row,col) && value >= 1 && value <= 9){
//            System.out.println("It's valid to place value = " + value + " in row = " + row + " and col = " + col);
            return true;
        }else{
//            System.out.println("Not valid to place value = " + value + " in row = " + row + " and col = " + col);
            return false;
        }
    }
    public static boolean isNumbersInRowsValid(Board generatedBoard){

        ArrayList<Integer> used = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                used.add(generatedBoard.getValue(i,j));
            }
            if (used.size() != new HashSet<>(used).size()){
//                System.out.println("Used in rows : ");
//                System.out.println(used);
//                System.out.println("wyszlo ze sie powtarza w rows false nowa proba wstawiania");
                return false;
            }
            used.clear();
        }
        return true;
    }

    public static boolean isNumberInColsValid(Board generatedBoard){
        ArrayList<Integer> usedInCols = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                usedInCols.add(generatedBoard.getValue(j,i));
            }
            if (usedInCols.size() != new HashSet<>(usedInCols).size()){
//                System.out.println("Used in col : ");
//                System.out.println(usedInCols);
//                System.out.println("wyszlo ze sie powtarza w cols false nowa proba wstawiania");
                return false;
            }
            usedInCols.clear();
        }
        return true;
    }

    public static boolean isValidInBox(Board generatedBoard){

        ArrayList<Integer> usedInBox = new ArrayList<>();

        for (int boxRow = 0; boxRow < 9; boxRow += 3) {
            for (int boxCol = 0; boxCol < 9; boxCol += 3) {
                for (int i = boxRow; i < boxRow + 3; i++) {
                    for (int j = boxCol; j < boxCol + 3; j++) {
                        usedInBox.add(generatedBoard.getValue(i, j));
                    }
                }
                if (usedInBox.size() != new HashSet<>(usedInBox).size()){
//                    System.out.println("Box not valid rows cols valid !");
                    return false;
                }
                usedInBox.clear();
            }
        }
        return true;
    }

    public static boolean isValidGeneratedSudoku(Board generatedBoard){
        if(!isNumbersInRowsValid(generatedBoard)){
//            System.out.println("rows valid");
            return false;
        }

        else if (!isNumberInColsValid(generatedBoard)){
//            System.out.println("rows and cols valid");
            return false;
        }
        else if (!isValidInBox(generatedBoard)){
//            System.out.println("Valid all !!!");
            return false;
        }


        return true;
    }
    //        to chceck if its correct i nned to haave solved copy in memony to valiadte is this correct
    //        so first i need to create generator witch will remember the board and will validate by checking pos in solved board
    //        after generate remove x (less then 18) elements and present to usuer missing board

}
