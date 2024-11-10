package entities;

import java.util.HashMap;
import java.util.Map;

/**
 * An entity representing an event in a tournament.
 */
public class EventData {
    private final String eventID;
    private final String eventName;
    private final Entrant[] entrants;
    private final boolean hasCharacters;
    private Map<String, String> idToName;

    /**
     * Constructs event data object.
     * @param eventID The ID of the event
     * @param eventName The name of the event
     * @param entrants The entrants in an event
     * @param hasCharacters True if an event has characters on start gg
     */
    public EventData(String eventID, String eventName, Entrant[] entrants, boolean hasCharacters) {
        this.eventID = eventID;
        this.eventName = eventName;
        this.entrants = entrants;
        this.hasCharacters = hasCharacters;
    }

    /**
     * Creates a map that takes in entrant IDs and returns eantrant names.
     */
    public void generateIDtoName(){
        Map<String, String> idMap = new HashMap<>();
        for (Entrant entrant : entrants) {
            idMap.put(entrant.getId(), entrant.getName());
        }
        idToName = idMap;
    }

    /**
     * Converts an entrant id to their name.
     * @param id Entrant id
     * @return Entrant name
     */
    public String idToName(String id){
        return idToName.get(id);
    }

    public String getEventID() {
        return eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public Entrant[] getEntrants() {
        return entrants;
    }

    public boolean hasCharacters() {
        return hasCharacters;
    }
}
