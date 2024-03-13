package systemdesign.tictactoe.player;

import systemdesign.tictactoe.playingpiect.PlayingPiece;

public class Player {
    long userId;
    String userName;

    PlayingPiece playingPiece;

    public Player(String name,PlayingPiece playingPiece){
        this.userName = name;
        this.playingPiece = playingPiece;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public PlayingPiece getPlayingPiece() {
        return playingPiece;
    }

    public void setPlayingPiece(PlayingPiece playingPiece) {
        this.playingPiece = playingPiece;
    }
}
