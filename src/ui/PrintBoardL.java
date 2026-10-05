package ui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import model.Board;

import java.io.IOException;

public class PrintBoardL {
    // selRow/selCol - pole pod kursorem, editing - czy wpisujemy liczbe, pending - wpisana a niezatwierdzona liczba (0 = brak)
    public void print(Board board, Screen screen, int selRow, int selCol, boolean editing, int pending) throws IOException {

        screen.clear();

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

                int value = board.getValue(j, i);
                if (j == selRow && i == selCol) {
                    if (editing) {
                        tg.setBackgroundColor(TextColor.ANSI.YELLOW);
                        value = pending;
                    } else {
                        tg.setBackgroundColor(TextColor.ANSI.WHITE);
                    }
                    tg.setForegroundColor(TextColor.ANSI.BLACK);
                }

                tg.putString(col, row, String.valueOf(value));
                tg.setForegroundColor(TextColor.ANSI.DEFAULT);
                tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
                tg.putString(col + 1, row, " ");
                col += 2;
            }

            tg.putString(col, row, "|");
            row++;
        }

        tg.putString(startCol, row, separator);
        screen.refresh();
    }
}
