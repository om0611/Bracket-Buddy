//package com.example.csc207courseprojectandroid.app;
//
//import com.example.csc207courseprojectandroid.data_access.APIDataAccessObject;
//import com.example.csc207courseprojectandroid.entities.Entrant;
//import com.example.csc207courseprojectandroid.entities.EventData;
//
//public class MainApplication {
//    public static void main(String[] args) {
//        // Create Event Data
//        String eventLink = "tournament/skipping-classes-world-championship-start-gg-api-test/event/1v1-lecture-skipping-bracket";
//        APIDataAccessObject dao = new APIDataAccessObject();
//        int eventID = dao.getEventId(eventLink);
//        Entrant[] entrants = dao.getEntrantsInEvent(eventID);
//        EventData.createEventData(eventID, "singles", entrants, false);
//
//        // Create Main
//        final MainBuilder mainBuilder = new MainBuilder();
//        final JFrame application = mainBuilder
//                .addLoginView()
//                .addSeedingView()
//                .addMainView()
//                .addLoginUseCase()
//                .addSelectPhaseUseCase()
//                .addUpdateSeedingUseCase()
//                .addMutateSeedingUseCase()
//                .build();
//
//        application.pack();
//        application.setMinimumSize(new Dimension(200, 200));
//        application.setVisible(true);
//    }
//}
