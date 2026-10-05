import logic.Generator;
import logic.MakePuzzle;
import model.Board;
import ui.BoardPrinter;

import java.util.Scanner;

public class Game {

    static void run(){
        Board generatedBoard = Generator.generateBoard();
//        System.out.println(Arrays.deepToString(generatedBoard.getBoard()));

//        BoardPrinter.printGrid(generatedBoard);

        Board puzzleBoard = generatedBoard.makeCopy();

//        BoardPrinter.printGrid(puzzleBoard);

        puzzleBoard = MakePuzzle.makePuzzle(puzzleBoard,1);

        BoardPrinter.printGrid(puzzleBoard);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter row you wanna use to place the num");
        int inprow = scanner.nextInt();
        System.out.println("Please enter col you wanna use to place the num");
        int inpcol = scanner.nextInt();
        System.out.println("NUm u wanna place");
        int inpnum = scanner.nextInt();




        System.out.println(isMoveCorrect(generatedBoard,puzzleBoard,inpnum,inprow,inpcol));






    }

//    najpierw niech sprawdzi czy isEmpty bo jak nie to od razu rtrzeba powiedziec zeby smienil miejscee bo tam nie mozna nadpisac
//    raczej nie ismovecor tylko raczej movement albo cos w tym stylu bo to tez bedzie wstawiac ruch gracza
//    generalnie sposob wstawiania mozna przemyslec moze zeby sie jezdzilo sterzalkami po planszy i to autionmatycznie
//    bedzie wybierac row i col a nbei ze wpisuwac jeszcze nie wiem generanie malo przyjemne (game expiriencve na koncu damy )
//    i jeszcze trzeba bedzie przede wsztyskim ogarnac to aby lvl sie wprowadzalo wiec jakias game menu od ktorego sir wychodzi i gdzie sie wrava po grze bedzie milo
//    muzyka ? xD do sudkyu no nie wiem moze cos pomysle
    public static boolean isMoveCorrect(Board boardGen, Board puzzle, int row, int col, int num){

        int ans = boardGen.getValue(row, col);

        if (num == ans){
            System.out.println("poprawnie udzielona odpowiedz wstawiam i tutaj puzzleGen.set i tak dalej ");
            puzzle.setBoard(row,col,num);
            return true;
        } else if (num != ans) {
            System.out.println("zla odpowiedz +1 blad");
            return false;
        }

        return false;

    }


}
