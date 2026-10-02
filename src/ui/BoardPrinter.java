package ui;

public class BoardPrinter {
    public static void printGrid(){
        for (int k = 0; k < 3; k++) {
            System.out.print("+-------".repeat(3) + "+");
            System.out.println();
            for (int j = 0; j < 3; j++) {

                for (int i = 0; i < 3; i++) {
                    System.out.print("| . . . ");
                }
                System.out.print("|");
                System.out.println();
            }
        }
        System.out.print("+-------".repeat(3) + "+");
    }
}
