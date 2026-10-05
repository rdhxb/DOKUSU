package ui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Menu {

    private static final String[] LEVELS = {
            "Poczatkujacy",
            "Srednio poczatkujacy",
            "Sredni",
            "Zaawansowany",
            "Ekspert"
    };

    public int show(Screen screen) throws IOException {
        screen.startScreen();
        screen.setCursorPosition(null);

        int selected = 0;

        while (true) {
            screen.clear();
            TextGraphics tg = screen.newTextGraphics();

            TerminalSize size = screen.getTerminalSize();
            int row = (size.getRows() - (LEVELS.length + 2)) / 2;

            String title = "MENU";
            tg.setForegroundColor(TextColor.ANSI.RED);
            tg.putString((size.getColumns() - title.length()) / 2, row, title);
            row += 2;

            for (int i = 0; i < LEVELS.length; i++) {
                String text = LEVELS[i];
                if (i == selected) {
                    text = "> " + text + " <";
                    tg.setForegroundColor(TextColor.ANSI.BLACK);
                    tg.setBackgroundColor(TextColor.ANSI.WHITE);
                } else {
                    tg.setForegroundColor(TextColor.ANSI.DEFAULT);
                    tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
                }
                tg.putString((size.getColumns() - text.length()) / 2, row + i, text);
            }
            screen.refresh();

            KeyStroke key = screen.readInput();
            if (key.getKeyType() == KeyType.ArrowUp) {
                selected = (selected - 1 + LEVELS.length) % LEVELS.length;
            } else if (key.getKeyType() == KeyType.ArrowDown) {
                selected = (selected + 1) % LEVELS.length;
            } else if (key.getKeyType() == KeyType.Enter) {
                return selected + 1;
            }
        }
    }
}
