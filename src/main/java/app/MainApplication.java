package app;

import data_access.APIDataAccessObject;

public class MainApplication {
    public static void main(String[] args) {
        APIDataAccessObject dao = new APIDataAccessObject();
        System.out.println(dao.getEventId("tournament/st-george-scramble-26/event/ultimate-singles"));
        //dao.getEntrantsInEvent(dao.getEventId("/tournament/st-george-scramble-26/event/ultimate-singles"));
    }
}
