package app;

import data_access.APIDataAccessObject;
import entities.Entrant;
import entities.EventData;

import javax.swing.*;

public class MainApplication {
    public static void main(String[] args) {
        // Create Event Data
        String eventLink = "tournament/skipping-classes-world-championship-start-gg-api-test/event/1v1-lecture-skipping-bracket";
        APIDataAccessObject dao = new APIDataAccessObject();
        int eventID = dao.getEventId(eventLink);
        Entrant[] entrants = dao.getEntrantsInEvent(eventID);
        EventData.createEventData(eventID, "singles", entrants, false);

        // Create Main
        final MainBuilder mainBuilder = new MainBuilder();
        final JFrame application = mainBuilder
                .addSeedingView()
                .addMainView()
                .addSelectPhaseUseCase()
                .addUpdateSeedingUseCase()
                .addMutateSeedingUseCase()
                .build();

        application.pack();
        application.setVisible(false);
    }
}
