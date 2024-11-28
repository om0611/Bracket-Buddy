package com.example.csc207courseproject.interface_adapter.report_set;

import com.example.csc207courseproject.entities.SetData;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class ReportSetState {

    private SetData currentSet;
    private boolean setOver = false;
    private List<SetData> ongoingSets;

    // This Arraylist allows us to keep track of the recently reported sets locally
    // so that the local menus are updated in real time rather than after the API
    // calls update which can take up to a minute
    private List<Integer> reportedSetIDs = new ArrayList<>();
    public SetData getSetData() {return currentSet;}
    public void setCurrentSet(SetData currentSet) {
        this.currentSet = currentSet;
    }

    public void setOngoingSets(List<SetData> ongoingSets) {
        this.ongoingSets = ongoingSets;
    }

    public List<Integer> getReportedSetIDs() {return reportedSetIDs;}

    public void addReportedSetID(int newID) {
        // Only store 10 at any given time
        if (reportedSetIDs.size() == 10) {
            reportedSetIDs.remove(0);
        }
        reportedSetIDs.add(newID);
    }

    public List<SetData> getOngoingSets() {return ongoingSets;}

    public SetData getCurrentSet() {return currentSet;}
    public boolean getSetOver() {return setOver;}
    public void setSetOver(boolean setOver) {this.setOver = setOver;}

    // Reports the game into the game object, updates the player count scores, and checks if the set is done
    public void reportGame(int gameNumber, int winnerID, String p1Char, String p2Char, boolean p1Won) {
        currentSet.getGame(gameNumber - 1).report(winnerID, p1Char, p2Char);

        if (p1Won){
            currentSet.addP1Win();
        } else {
            currentSet.addP2Win();
        }

        setOver = currentSet.isSetOver();

        if (!setOver){
            currentSet.addGame();
        }

    }


}
