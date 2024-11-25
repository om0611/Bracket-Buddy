package com.example.csc207courseproject.interface_adapter.call_set;

import com.example.csc207courseproject.entities.SetData;
import com.example.csc207courseproject.entities.Station;

import java.util.List;

public class CallSetState {
        private SetData currentSet;
        private List<Station> stations;
        private List<SetData> upcomingSets;
        private boolean setOver;

        public SetData getCurrentSet() {return currentSet;}
        public List<SetData> getUpcomingSets() {
                return upcomingSets;
        }


}
