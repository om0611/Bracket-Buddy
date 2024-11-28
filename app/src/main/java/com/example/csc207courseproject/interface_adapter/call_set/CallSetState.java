package com.example.csc207courseproject.interface_adapter.call_set;

import com.example.csc207courseproject.entities.SetData;
import com.example.csc207courseproject.entities.Station;

import java.util.ArrayList;
import java.util.List;

public class CallSetState {
        private SetData currentSet;
        private List<Station> stations;
        private List<SetData> upcomingSets;
        private int openStreams;

        // This Arraylist allows us to keep track of the recently called sets locally
        // so that the local menus are updated in real time rather than after the API
        // calls update which can take up to a minute
        private List<Integer> calledSetIDs = new ArrayList<>();

        public SetData getCurrentSet() {return currentSet;}

        public void setCurrentSet(SetData currentSet) {this.currentSet = currentSet;}

        public List<Integer> getCalledSetIDs() {return calledSetIDs;}

        public void addCalledSetID(int newID) {
                if (calledSetIDs.size() == 10) {
                        calledSetIDs.remove(0);
                }
                calledSetIDs.add(newID);
        }

        public void setUpcomingSets(List<SetData> upcomingSets) {
                this.upcomingSets = upcomingSets;
        }

        public List<SetData> getUpcomingSets() {
                return upcomingSets;
        }

        public List<Station> getStations() {
                return stations;
        }

        public void setStations(List<Station> stations) {
                this.stations = stations;
        }

        public void addStation(Station station) {
                stations.add(station);
        }

        public int getOpenStreams() {
                return openStreams;
        }

        public void addOpenStream() {
                openStreams++;
        }

        public void removeOpenStream() {
                openStreams--;
        }


}
