package com.example.csc207courseproject.use_case.get_finance;

public class GetFinanceInputData {
    private final int eventID;

    /**
     * Construct a new GetFinanceInputData with the given event ID.
     *
     * @param eventID the ID of the event.
     */
    public GetFinanceInputData(int eventID) {
        this.eventID = eventID;
    }

    /**
     * Get the event ID.
     *
     * @return the event ID.
     */
    public int getEventID() {
        return eventID;
    }
}
