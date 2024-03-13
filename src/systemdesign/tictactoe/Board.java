package systemdesign.tictactoe;

import kotlin.Pair;
import systemdesign.tictactoe.playingpiect.PlayingPiece;

import java.util.ArrayList;
import java.util.List;

public class Board {
    int size;
    PlayingPiece[][] boards;

    public Board(int size) {
        this.size = size;
        boards = new PlayingPiece[size][size];
    }

    public boolean addPiece(int row, int column, PlayingPiece playingPiece) {
        if (boards[row][column] != null) {
            return false;
        }
        boards[row][column] = playingPiece;
        return true;
    }

    public List<Pair<Integer, Integer>> getFreeCells() {
        List<Pair<Integer, Integer>> freeCells = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (boards[i][j] == null) {
                    freeCells.add(new Pair(i, j));
                }
            }
        }
        return freeCells;
    }

    public void printBoards() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (boards[i][j] != null) {
                    System.out.print(boards[i][j].getPieceType().name() + "   ");
                } else {
                    System.out.print("  ");
                }
                System.out.print(" | ");
            }
            System.out.println();
        }
    }

}
