package com.example.csc207courseproject.entities;


import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class SetData {

    private int setID;
    private Station station;
    private int firstTo;
    private int winnerID;

    private List<Game> games;
    private Entrant[] players;


    public SetData(int setID, Entrant[] players, int bestOf) {
        this.setID = setID;
        this.players = players;
        this.games = new ArrayList<>();
        games.add(new Game());
        this.firstTo = (bestOf + 1) / 2;

    }

    public int getSetID() {return setID;}

    public void setWinnerID(int winnerID) {this.winnerID = winnerID;}
    public int getWinnerID() {return winnerID;}

    public Station getStation() {return station;}
    public Entrant[] getPlayers() {return players;}

    public int getFirstTo() {
        return firstTo;
    }

    public Game getGame(int gameNumber) { return games.get(gameNumber - 1);}

    public List<Game> getGames() {return games;}



    @NotNull
    @Override
    public String toString() {
        return players[0].toString() + " vs. " + players[1].toString();
    }

}