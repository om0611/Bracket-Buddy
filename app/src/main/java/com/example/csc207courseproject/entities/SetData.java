package com.example.csc207courseproject.entities;


import org.jetbrains.annotations.NotNull;

/**
 * Represents a set in an event and contains all the data for its corresponding set.
 */
public abstract class SetData {

    private int setID;
    private Entrant[] players;


    public SetData(int setID, Entrant[] players) {
        this.setID = setID;
        this.players = players;

    }

    public int getSetID() {return setID;}

    public Entrant[] getPlayers() {return players;}

    @NotNull
    @Override
    public String toString() {
        return players[0].toString() + " vs. " + players[1].toString();
    }

}