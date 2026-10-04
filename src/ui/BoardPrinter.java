package ui;

import model.Board;

public class BoardPrinter {
    public static void printGrid(Board boardGen){
            System.out.print("+-------".repeat(3) + "+");
            System.out.println();
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0){
                    System.out.print("+-------".repeat(3) + "+");
                    System.out.println();
                }

                for (int i = 0; i < 9; i++) {
                    if (i % 3 == 0) System.out.print("| ");

                    System.out.print(boardGen.getValue(j,i) + " ");

                }



                System.out.print("|");
                System.out.println();





            }

        System.out.print("+-------".repeat(3) + "+");
    }
}
