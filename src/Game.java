import logic.Generator;
import logic.Rules;
import model.Board;
import ui.BoardPrinter;

import java.util.Arrays;

public class Game {

    static void run(){
        Board generatedBoard = Generator.generateBoard();
        System.out.println(Arrays.deepToString(generatedBoard.getBoard()));




    }


}
