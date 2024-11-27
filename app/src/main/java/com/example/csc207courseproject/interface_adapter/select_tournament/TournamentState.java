package com.example.csc207courseproject.interface_adapter.select_tournament;

import java.util.List;
import java.util.Map;

/**
 * A state containing the tournaments to be displayed to the user in the Select Tournament view.
 */
public class TournamentState {
    private Map<Integer, String> tournaments;

    public void setTournaments(Map<Integer, String> tournaments) {
        this.tournaments = tournaments;
    }
    public Map<Integer, String> getTournaments() {
        return tournaments;
    }
}
