package com.example.csc207courseproject.entities;


public class SetData {

    private int setID;
    private int stationNum;

    private Entrant[] players;


    public SetData(int setID, int stationNum, Entrant[] players) {
        this.setID = setID;
        this.stationNum = stationNum;
        this.players = players;
    }
}