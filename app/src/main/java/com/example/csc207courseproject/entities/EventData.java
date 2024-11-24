package com.example.csc207courseproject.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * An entity representing an event in a tournament.
 */
public class EventData {
    private static int tournamentId;
    private static int eventId;
    private static String eventName;
    private static Entrant[] entrants;
    private static boolean hasCharacters;
    private static Map<Integer, String[]> idToNames;
    private static Map<Integer, String[]> idToSponsors;
    private static List<String> possibleTags = new ArrayList<String>();

    public static void createEventData(int tourneyId, int eId, String eName, Entrant[] es, boolean hCharacters) {
        tournamentId = tourneyId;
        eventId = eId;
        eventName = eName;
        entrants = es;
        hasCharacters = hCharacters;
        generateIDtoNamesAndSponsors();
    }

    /**
     * Adds the parameter tag to possible tags.
     * @param tag The new tag
     */
    public static void addPossibleTag(String tag) {
        possibleTags.add(tag);
    }

    /**
     * Creates maps that take in entrant IDs and returns entrant names and entrant IDs to sponsors.
     */
    public static void generateIDtoNamesAndSponsors(){
        Map<Integer, String[]> idMap = new HashMap<>();
        Map<Integer, String[]> sponsorMap = new HashMap<>();
        for (Entrant entrant : entrants) {
            idMap.put(entrant.getId(), entrant.getNames());
            sponsorMap.put(entrant.getId(), entrant.getSponsors());
        }
        idToNames = idMap;
        idToSponsors = sponsorMap;
    }

    /**
     * Converts an entrant id to their name.
     * @param id Entrant id
     * @return Entrant name
     */
    public static String idToString(int id){
        String currPlayer = idToSponsors.get(id)[0] + " " + idToNames.get(id)[0];
        String output = currPlayer.trim();
        String[] names = idToNames.get(id);
        String[] sponsors = idToSponsors.get(id);
        for (int i = 1; i < names.length; i++) {
            currPlayer = sponsors[i] + " " + names[i];
            output += " / " + currPlayer.trim();
        }
        return output;
    }

    public static String[] idToNames(int id){
        return idToNames.get(id);
    }

    public static int getEventId() {
        return eventId;
    }

    public static String getEventName() {
        return eventName;
    }

    public static Entrant[] getEntrants() {
        return entrants;
    }

    public static boolean hasCharacters() {
        return hasCharacters;
    }
}
