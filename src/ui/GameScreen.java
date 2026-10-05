package ui;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import model.Board;

import java.io.IOException;

public class GameScreen {

    private int selectedRow = 0;
    private int selectedCol = 0;
    private boolean editing = false;
    private int pending = 0;

    public void play(Board board, Screen screen) throws IOException {
        PrintBoardL printer = new PrintBoardL();

        while (true) {
            printer.print(board, screen, selectedRow, selectedCol, editing, pending);

            KeyStroke key = screen.readInput();
            KeyType type = key.getKeyType();

            if (editing) {
                if (type == KeyType.Character && key.getCharacter() >= '1' && key.getCharacter() <= '9') {
                    pending = key.getCharacter() - '0';
                } else if (type == KeyType.Enter && pending != 0) {
                    board.setBoard(selectedRow, selectedCol, pending);
                    editing = false;
                    pending = 0;
                } else if (type == KeyType.Escape) {
                    editing = false;
                    pending = 0;
                }
            } else {
                if (type == KeyType.ArrowUp) {
                    selectedRow = (selectedRow + 8) % 9;
                } else if (type == KeyType.ArrowDown) {
                    selectedRow = (selectedRow + 1) % 9;
                } else if (type == KeyType.ArrowLeft) {
                    selectedCol = (selectedCol + 8) % 9;
                } else if (type == KeyType.ArrowRight) {
                    selectedCol = (selectedCol + 1) % 9;
                } else if (type == KeyType.Enter && board.isEmpty(selectedRow, selectedCol)) {
                    editing = true;
                } else if (type == KeyType.Escape || type == KeyType.EOF) {
                    return;
                }
            }
        }
    }
}
