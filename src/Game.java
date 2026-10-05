import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import logic.Generator;
import logic.IsSolvedCorrectly;
import logic.MakePuzzle;
import model.Board;
import ui.GameScreen;
import ui.Menu;
import ui.PrintBoardL;

import java.io.IOException;


public class Game {
    static void run() throws IOException {

        Screen screen = new TerminalScreen(new DefaultTerminalFactory().createTerminal());
        int lvl = new Menu().show(screen);


        Board generatedBoard = Generator.generateBoard();

        Board puzzleBoard = generatedBoard.makeCopy();


        puzzleBoard = MakePuzzle.makePuzzle(puzzleBoard,lvl);

        new GameScreen().play(puzzleBoard, screen);

        screen.stopScreen();
        int mistakes = IsSolvedCorrectly.isCorrect(generatedBoard,puzzleBoard);
        if (mistakes > 0 ){
            System.out.println("You lose with ... " + mistakes + " ... mistakes !");
        }else{
            System.out.println("You WON !!!! wow");
        }
    }



}
