package com.example.csc207courseproject.entities;

import java.util.ArrayList;
import java.util.List;

public class Station {
    private final List<String> tags = new ArrayList<>();
    private final int id;
    private final int stationNum;
    private boolean isStream;

    public Station(int stationId, int station) {
        id = stationId;
        stationNum = station;
    }

    public int getId() {
        return id;
    }

    public int getStationNum() {
        return stationNum;
    }

    /**
     * Adds the parameter tag to the station's tags.
     * @param tag The new tag
     */
    public void addTag(String tag) {

        if (tag.equals("Stream setup")) {
            isStream = true;
        } else if (!tags.contains(tag)) {
            tags.add(tag);
        }
    }

    /**
     * Removes the parameter tag from the station's tags.
     * @param tag The new tag
     */
    public void removeTag(String tag) {

        if (tag.equals("Stream setup")) {
            isStream = false;
        } else {
            tags.remove(tag);
        }
    }

    /**
     * Checks if a station has this tag.
     * @param tag The tag being checked
     * @return True if the station has the tag
     */
    public boolean hasTag(String tag) {
        return tags.contains(tag);
    }

    public boolean isStream() {
        return isStream;
    }

    public String tagsToString(){
        if (tags.isEmpty()) {
            return "";
        }
        String output = tags.get(0);
        for (int i = 1; i < tags.size(); i++) {
            output += ", " + tags.get(i);
        }
        return output;
    }
}
