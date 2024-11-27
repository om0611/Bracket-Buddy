package com.example.csc207courseproject.use_case.upcoming_sets;

import com.example.csc207courseproject.entities.SetData;

import java.util.List;

public class UpcomingSetsOutputData {

    private final List<SetData> upcomingSets;


    public UpcomingSetsOutputData(List<SetData> upcomingSets) {
        this.upcomingSets = upcomingSets;
    }

    public List<SetData> getUpcomingSets() {
        return upcomingSets;
    }
}
