package com.example.csc207courseproject.interface_adapter.report_set;

import com.example.csc207courseproject.entities.SetData;

import java.util.ArrayList;
import java.util.List;


public class ReportSetState {

    private SetData currentSet;
    private List<SetData> ongoingSets;

    // This Arraylist allows us to keep track of the recently reported sets locally
    // so that the local menus are updated in real time rather than after the API
    // calls update, which can take up to a minute
    private List<Integer> reportedSetIDs = new ArrayList<>();
    public void setCurrentSet(SetData currentSet) {
        this.currentSet = currentSet;
    }

    public void setOngoingSets(List<SetData> ongoingSets) {
        this.ongoingSets = ongoingSets;
    }

    public List<Integer> getReportedSetIDs() {return reportedSetIDs;}

    public List<SetData> getOngoingSets() {return ongoingSets;}

    public SetData getCurrentSet() {return currentSet;}


}
