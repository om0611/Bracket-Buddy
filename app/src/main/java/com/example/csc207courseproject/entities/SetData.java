package com.example.csc207courseproject.entities;


import java.util.ArrayList;
import java.util.List;

public class SetData {

    private int setID;
    private int stationNum;
    private int firstTo;
    private int p1Wins;
    private int p2Wins;
    private List<Game> games;
    private Entrant[] players;


    public SetData(int setID, int stationNum, Entrant[] players, int firstTo) {
        this.setID = setID;
        this.stationNum = stationNum;
        this.players = players;
        this.games = new ArrayList<>();
        this.firstTo = firstTo;
        this.p1Wins = 0;
        this.p2Wins = 0;
    }

    public int getSetID() {return setID;}

    public int getStationNum() {return stationNum;}
    public Entrant[] getPlayers() {return players;}

    public void addGame() {
        this.games.add(new Game());
    }

    public void addP1Win() {
        this.p1Wins += 1;
    }

    public void addP2Win() {
        this.p2Wins += 1;
    }

    public boolean isSetOver() {
        return p1Wins >= firstTo || p2Wins >= firstTo;
    }

    public Game getGame(int gameNumber) { return games.get(gameNumber - 1);}

}