package com.example.csc207courseproject.use_case.select_phase;

import java.util.List;
import java.util.Map;

/**
 * The DAO for the select phase use case.
 */
public interface SelectPhaseDataAccessInterface {

    /**
     * Gets all phase IDs for a given event.
     * @param eventId The ID of the event
     * @return A map of all the phase IDs mapped to their name
     */
    Map<String, Integer> getPhaseIDs(int eventId);

    /**
     * Gets the seeding for the given phase.
     * @param phaseId The ID of the phase
     * @return A list of player IDs in seeded order
     */
    List<Integer> getSeedingInPhase(int phaseId);
}
