package com.example.csc207courseproject.interface_adapter.report_set;

import com.example.csc207courseproject.entities.SetData;

import java.util.List;


public class ReportSetState {

    private SetData currentSet;
    private boolean setOver = false;
    private int selectedSetIndex;
    private List<SetData> ongoingSets;

    public SetData getSetData() {return currentSet;}
    public void setCurrentSet(SetData currentSet) {
        this.currentSet = currentSet;
    }

    public void setOngoingSets(List<SetData> ongoingSets) {
        this.ongoingSets = ongoingSets;
    }

    public List<SetData> getOngoingSets() {return ongoingSets;}

    public SetData getCurrentSet() {return currentSet;}
    public boolean getSetOver() {return setOver;}

    public void setSelectedSetIndex(int selectedSetIndex) {
        this.selectedSetIndex = selectedSetIndex;
    }

    public int getSelectedSetIndex() {return selectedSetIndex;}

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
