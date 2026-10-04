import logic.Generator;
import logic.MakePuzzle;
import logic.Rules;
import model.Board;
import ui.BoardPrinter;

import java.util.Arrays;

public class Game {

    static void run(){
        Board generatedBoard = Generator.generateBoard();
        System.out.println(Arrays.deepToString(generatedBoard.getBoard()));

        BoardPrinter.printGrid(generatedBoard);

        Board puzzleBoard = generatedBoard.makeCopy();

//        BoardPrinter.printGrid(puzzleBoard);

        puzzleBoard = MakePuzzle.makePuzzle(puzzleBoard,1);

        BoardPrinter.printGrid(puzzleBoard);
        BoardPrinter.printGrid(generatedBoard);







    }


}
