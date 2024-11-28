package com.example.csc207courseproject.use_case.select_event;

import org.json.JSONException;

import java.util.List;

public interface SelectEventDataAccessInterface {
    /**
     * Get the events for a given tournament.
     * @return A list containing a list of event names and a list of event IDs.
     */
    List<List> getEventsInTournament(Integer tournamentID) throws JSONException;
}
