package com.example.csc207courseproject.entities;

import java.util.*;

/**
 * An entity representing an event in a tournament.
 */
public class EventData {
    private static int tournamentId;
    private static int eventId;
    private static String eventName;
    private static Map<Integer, Entrant> entrants;
    private static Map<Integer, Participant> participants;
    private static boolean hasCharacters;
    private static SortedMap<String, Integer> phaseIds;
    private static List<String> possibleTags = new ArrayList<>();

    public static void createEventData(int tourneyId, int eId, String eName, Map<Integer, Entrant> es, Map<Integer,
                                        Participant> ps, boolean hCharacters, SortedMap<String, Integer> phases) {
        tournamentId = tourneyId;
        eventId = eId;
        eventName = eName;
        entrants = es;
        participants = ps;
        hasCharacters = hCharacters;
        phaseIds = phases;
    }

    /**
     * Adds the parameter tag to possible tags.
     * @param tag The new tag
     */
    public static void addPossibleTag(String tag) {
        possibleTags.add(tag);
    }

    /**
     * Converts an entrant id to their name.
     * @param id Entrant id
     * @return Entrant name
     */
    public static String entrantIdToString(int id){
        return entrants.get(id).toString();
    }

    /**
     * Converts a participant id to their name.
     * @param id Participant id
     * @return Participant name
     */
    public static String participantIdToString(int id){
        return participants.get(id).toString();
    }

    public static SortedMap<String, Integer> getPhaseIds() {
        return phaseIds;
    }

    public static int getEventId() {
        return eventId;
    }

    public static String getEventName() {
        return eventName;
    }

    public static Map<Integer, Entrant> getEntrants() {
        return entrants;
    }

    public static Map<Integer, Participant> getParticipants() {return participants;}

    public static boolean hasCharacters() {
        return hasCharacters;
    }

    public static int getTournamentId() {
        return tournamentId;
    }
}
