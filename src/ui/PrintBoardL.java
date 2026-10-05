package ui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import model.Board;

import java.io.IOException;

public class PrintBoardL {
    public void print(Board board) throws IOException {

        Screen screen = new TerminalScreen(new DefaultTerminalFactory().createTerminal());
        screen.startScreen();
        screen.setCursorPosition(null);

        TextGraphics tg = screen.newTextGraphics();
        String separator = "+-------".repeat(3) + "+";

        TerminalSize size = screen.getTerminalSize();
        int startCol = (size.getColumns() - separator.length()) / 2;
        int row = (size.getRows() - 13) / 2;

        tg.putString(startCol, row, separator);
        row++;

        for (int j = 0; j < 9; j++) {
            if (j % 3 == 0 && j != 0) {
                tg.putString(startCol, row, separator);
                row++;
            }

            int col = startCol;
            for (int i = 0; i < 9; i++) {
                if (i % 3 == 0) {
                    tg.putString(col, row, "| ");
                    col += 2;
                }

                tg.putString(col, row, board.getValue(j, i) + " ");
                col += 2;
            }

            tg.putString(col, row, "|");
            row++;
        }

        tg.putString(startCol, row, separator);
        screen.refresh();

        screen.readInput();
        screen.stopScreen();
    }
}
