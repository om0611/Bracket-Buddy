package com.example.csc207courseproject.entities;

import java.util.ArrayList;
import java.util.List;

public class Station {
    private final List<String> tags = new ArrayList<>();
    private final int id; // -1 if it is a new station
    private final int stationNum;

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
        tags.add(tag);
    }

    /**
     * Checks if a station has this tag.
     * @param tag The tag being checked
     * @return True if the station has the tag
     */
    public boolean hasTag(String tag) {
        return tags.contains(tag);
    }
}
