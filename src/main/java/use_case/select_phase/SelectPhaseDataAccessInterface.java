package use_case.select_phase;

import java.util.List;

/**
 * The DAO for the select phase use case.
 */
public interface SelectPhaseDataAccessInterface {

    /**
     * Gets all phase IDs for a given event.
     * @param eventID The ID of the event
     * @return A list of all the phase IDs
     */
    String[] getPhaseIDs(String eventID);

    /**
     * Gets the seeding for the given phase.
     * @param phaseID The ID of the phase
     * @return A list of player IDs in seeded order
     */
    List<String> getSeedinginPhase(String phaseID);
}
