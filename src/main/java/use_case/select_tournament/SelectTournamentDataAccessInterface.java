package use_case.select_tournament;

import java.util.List;
import java.util.Map;

public interface SelectTournamentDataAccessInterface {
    /**
     * Gets a list of tournaments organized by the user.
     * @return a list of tournaments
     */
    List <Map<Integer, String>> getTournaments();
}
