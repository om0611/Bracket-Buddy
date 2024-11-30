package com.example.csc207courseproject.entities;


import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
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

    public void reportGameWinner(int gameNum, int playerNum) {
        int gameWinnerID = players[playerNum - 1].getId();
        this.games.get(gameNum - 1).reportWinner(gameWinnerID);
        boolean over = isSetOver();
        //Add or remove games from the menu
        if (!over) {
            //Only add another game to the menu if all the current ones are reported
            if (games.get(games.size() - 1).isReported()) {
                games.add(new Game());
            }
        } else {
            setWinnerID(gameWinnerID);
            // Remove unnecessary games
            int i = games.size() - 1;
            List<Game> uselessGames = new ArrayList<>();
            while (games.get(i).getWinnerID() != gameWinnerID){
                uselessGames.add(games.get(i));
                i -= 1;
            }

            games.removeAll(uselessGames);

            // If a player now has an extra win, remove the extra win at the end from the games list
            if (countWins(winnerID) > firstTo) {
                games.remove(games.size() - 1);
            }

        }
    }

    public void reportCharacter(int gameNum, int playerNum, String character) {

        this.games.get(gameNum - 1).setCharacter(playerNum - 1, EventData.getCharacterIds().get(character));

    }

    public boolean isSetOver() {
        return countWins(players[0].getId()) >= firstTo ||
                countWins(players[1].getId()) >= firstTo;
    }

    public int countWins(int winnerID){
        int count = 0;
        for (Game g : games) {
            if (g.getWinnerID() == winnerID) {
                count++;
            }
        }
        return count;
    }

    public Game getGame(int gameNumber) { return games.get(gameNumber - 1);}

    public List<Game> getGames() {return games;}

    public boolean didPlayerWin(int position, int playerNum) {
        return games.get(position).getWinnerID() == players[playerNum - 1].getId();
    }


    @NotNull
    @Override
    public String toString() {
        return players[0].toString() + " vs. " + players[1].toString();
    }

}