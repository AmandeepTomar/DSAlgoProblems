# Tic Tac To 


## Flow 


## Requirements
- 3*3 Metrics , We have assign x and o as two user 
- Winner 
  - Same sign in row , column and diagonal
- Piece
  - X and O and can add new symbols and should be extensible.
- Board N* N it should be scalable 
- Player. 

## Objects 
- Piece 
- Board N*N 
- Player 

## LLD

```java

import java.util.List;

class PlayingPiece {
    PiceType piceType;

    public PlayingPiece(PiceType piceType) {
        this.piceType = piceType
    }
}

// is-A relation.
class XPlayingPiece extends PlayingPiece {

    public XPlayingPiece() {
        super(PieceType.X);
    }
}

class OPlayingPiece extends PlayingPiece {
    public OPlayingPiece() {
        super(PieceType.O);
    }
}

enum PieceType {
    X, O
}

// =========Create Board 
// Board has PlayingPieces 

class Board {
    int size;
    PlayingPiece[][] board;

    public Board(int size) {
        this.size = size;
        board = new PlayingPiece[size][size];
    }
}

// Player has a piece
class Player {
    long playerId;
    String name, email;
    PlayingPiece playingPiece;

  public Player(String name,PlayingPiece playingPiece){
    this.name = name;
    this.playingPiece = playingPiece;
  }
}
// has list of players and has board.
class Game {
    List<Player> playersList;
    Board board;
}



```