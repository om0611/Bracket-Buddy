package com.example.csc207courseproject.use_case.select_tournament;

import java.util.List;

/**
 * Output data for the Select Tournament Use Case.
 */
public class SelectTournamentOutputData {

    private final List<String> eventNames;
    private final List<Integer> eventIds;

    public SelectTournamentOutputData(List<List> events) {
        eventNames = events.get(0);
        eventIds = events.get(1);
    }

    public List<String> getEventNames() {
        return eventNames;
    }

    public List<Integer> getEventIds() {
        return eventIds;
    }
}
