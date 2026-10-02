import model.Board;
import ui.BoardPrinter;

import java.util.Arrays;

public class Game {

    static void run(){
//        BoardPrinter.printGrid();
        Board board = new Board();
        System.out.println(Arrays.deepToString(board.getBoard()));

        board.setBoard(0,0,3);
        System.out.println(Arrays.deepToString(board.getBoard()));

        System.out.println(board.isEmpty(0,0));

    }


}
