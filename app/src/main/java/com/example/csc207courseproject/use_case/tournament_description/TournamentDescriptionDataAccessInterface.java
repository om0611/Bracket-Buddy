package com.example.csc207courseproject.use_case.tournament_description;

import java.util.List;

/**
 * The DAO for the tournament description use case.
 */
public interface TournamentDescriptionDataAccessInterface {

    /**
     * Returns the AI generated description of the select event in the tournament.
     * @param eventName The Name of the event
     * @param noOfPlayers the number of players in the event
     * @return The AI generated description
     */
    String generateTournamentDescription(String eventName, int noOfPlayers);
}