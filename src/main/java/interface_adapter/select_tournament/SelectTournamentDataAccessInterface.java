package interface_adapter.select_tournament;

import java.util.List;

public interface SelectTournamentDataAccessInterface {
    /**
     * Gets a list of tournaments organized by the user.
     * @return a list of tournaments
     */
    List getTournaments();
}
