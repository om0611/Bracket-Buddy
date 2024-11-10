package use_case.main;

import entities.Entrant;

/**
 *  The DAO for API calls that must be run on startup
 */
public interface MainDataAccessInterface {

    /**
     * Get entrants in a given event.
     * @param EventID The ID of the event
     * @return A list of entrants
     */
    Entrant[] getEntrantsInEvent(String EventID);
}
