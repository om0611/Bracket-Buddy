package app;

import data_access.APIDataAccessObject;
import entities.Entrant;
import entities.EventData;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Map;

public class MainApplication {
    public static void main(String[] args) {
        String eventLink = "tournament/skipping-classes-world-championship-start-gg-api-test/event/1v1-lecture-skipping-bracket";
        APIDataAccessObject dao = new APIDataAccessObject();
        int eventID = dao.getEventId(eventLink);
        Entrant[] entrants = dao.getEntrantsInEvent(eventID);
        EventData.createEventData(eventID, "singles", entrants, false);
        Map<String, Integer> nametoID = dao.getPhaseIDs(eventID);
        List<Integer> seeding = dao.getSeedinginPhase(nametoID.get("Top 6"));
        for(int seed : seeding) {
            System.out.println(EventData.idToString(seed));
        }
        int temp = seeding.get(0);
        seeding.remove(0);
        seeding.add(3, temp);
        temp = seeding.get(4);
        seeding.remove(4);
        seeding.add(5, temp);
        temp = seeding.get(2);
        seeding.remove(2);
        seeding.add(4, temp);
        for(int seed : seeding) {
            System.out.println(EventData.idToString(seed));
        }
        dao.setSeeding(seeding);

    }
}
