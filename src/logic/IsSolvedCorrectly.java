package logic;

import model.Board;

public class IsSolvedCorrectly {
    public static int isCorrect(Board board, Board puzzleBoard){

        int mistakes = 0;
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board.getValue(row,col) != puzzleBoard.getValue(row,col)){
                    mistakes ++;
                }
            }
        }
        return mistakes;
    }

}
