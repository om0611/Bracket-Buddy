package com.example.csc207courseproject.entities;


public class Game {

    private Integer winnerID;

    private String player1Character;
    private String player2Character;


    public Game() {
        player1Character = "";
        player2Character = "";
    }

    public void report(Integer winnerID, String p1Character, String p2Character) {
        this.winnerID = winnerID;
        this.player1Character = p1Character;
        this.player2Character = p2Character;
    }

    public Integer getWinnerID() {
        return winnerID;
    }
    public String getPlayer1Character() {
        return player1Character;
    }

    public String getPlayer2Character() {
        return player2Character;
    }

    public boolean isReported() {
        return winnerID != null;
    }
}
