package logic;

import model.Board;

import java.util.ArrayList;

public class MakePuzzle {
    public static Board makePuzzle(Board puzzleBoard, int lvl){

        int toRemove = 0;

        switch (lvl){
            case 1: toRemove = 15;
                break;
            case 2: toRemove = 20;
                break;
            case 3: toRemove = 30;
                break;
            case 4:
                toRemove = 40;
                break;
            case 5: toRemove = 50;
                break;
            default:
                toRemove = 35;
        }

        int row = 0;
        int col = 0;
        ArrayList<Integer> wasSeen = new ArrayList<>();
        for (int i = 0; i < toRemove; i++) {
            int randomPosToRemove = (int) (Math.random() * (81));


            while(wasSeen.contains(randomPosToRemove)){
                randomPosToRemove = (int) (Math.random() * (81));
            }
            wasSeen.add(randomPosToRemove);

            row = randomPosToRemove / 9;
            col = randomPosToRemove % 9;
            puzzleBoard.setBoard(row, col, 0);

        }
        return puzzleBoard;

    }

}
