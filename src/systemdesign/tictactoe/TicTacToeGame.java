package systemdesign.tictactoe;

import kotlin.Pair;
import systemdesign.tictactoe.player.Player;
import systemdesign.tictactoe.playingpiect.OPlayingPiece;
import systemdesign.tictactoe.playingpiect.PieceType;
import systemdesign.tictactoe.playingpiect.XPlayingPiece;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    Deque<Player> playersList; // we have remove from top and put it in end FIFO
    Board gameBoard;

    TicTacToeGame(){
        initializeGame();
    }

    private void initializeGame() {

        playersList  = new LinkedList<>();

        XPlayingPiece xPlayingPiece = new XPlayingPiece();
        OPlayingPiece oPlayingPiece = new OPlayingPiece();

        Player player1 = new Player("Player1",xPlayingPiece);
        Player player2 = new Player("Player2",oPlayingPiece);

        playersList.add(player1);
        playersList.add(player2);

        gameBoard = new Board(3);
    }


    public String startGame() {
        boolean noWinner = true;

        while (noWinner){

            // take first player from list
            Player playerTurn = playersList.removeFirst();
            gameBoard.printBoards();

            List<Pair<Integer , Integer>> freeCells = gameBoard.getFreeCells();

            if (freeCells.isEmpty()){
                noWinner = false;
                continue;
            }

            //read the user input
            System.out.print("Player:" + playerTurn.getUserName() + " Enter row,column: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputColumn = Integer.valueOf(values[1]);

            //place the piece
            boolean pieceAddedSuccessfully = gameBoard.addPiece(inputRow,inputColumn, playerTurn.getPlayingPiece());
            if(!pieceAddedSuccessfully) {
                //player can not insert the piece into this cell, player has to choose another cell
                System.out.println("Incorredt possition chosen, try again");
                playersList.addFirst(playerTurn);
                continue;
            }
            playersList.addLast(playerTurn);

            boolean winner = isThereWinner(inputRow, inputColumn, playerTurn.getPlayingPiece().getPieceType());
            if(winner) {
                return playerTurn.getUserName();
            }

        }
        return "tie";
    }


    public boolean isThereWinner(int row, int column, PieceType pieceType) {

        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        //need to check in row
        for(int i=0;i<gameBoard.size;i++) {

            if(gameBoard.boards[row][i] == null || gameBoard.boards[row][i].getPieceType() != pieceType) {
                rowMatch = false;
            }
        }

        //need to check in column
        for(int i=0;i<gameBoard.size;i++) {

            if(gameBoard.boards[i][column] == null || gameBoard.boards[i][column].getPieceType() != pieceType) {
                columnMatch = false;
            }
        }

        //need to check diagonals
        for(int i=0, j=0; i<gameBoard.size;i++,j++) {
            if (gameBoard.boards[i][j] == null || gameBoard.boards[i][j].getPieceType() != pieceType) {
                diagonalMatch = false;
            }
        }

        //need to check anti-diagonals
        for(int i=0, j=gameBoard.size-1; i<gameBoard.size;i++,j--) {
            if (gameBoard.boards[i][j] == null || gameBoard.boards[i][j].getPieceType() != pieceType) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }

}
