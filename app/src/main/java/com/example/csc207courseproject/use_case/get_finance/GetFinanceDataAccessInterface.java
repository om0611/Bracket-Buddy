package com.example.csc207courseproject.use_case.get_finance;

import com.example.csc207courseproject.entities.Participant;

import java.util.HashMap;

public interface GetFinanceDataAccessInterface {

    HashMap<Integer, Participant> fetchParticipantPaymentStatus(int eventID);

    String getTournamentSlug(String eventID);
}
