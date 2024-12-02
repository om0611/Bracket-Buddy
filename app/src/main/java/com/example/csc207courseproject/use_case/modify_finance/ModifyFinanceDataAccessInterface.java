package com.example.csc207courseproject.use_case.modify_finance;

import com.example.csc207courseproject.entities.Participant;

import java.util.HashMap;
import java.util.Map;

public interface ModifyFinanceDataAccessInterface {
    void modifyParticipantPaymentStatus(int participantID);
    void modifyParticipantCashPaid(int participantID, String cashPaid);
    void modifyParticipanteTransferPaid(int participantID, String eTransferPaid);
    void modifyParticipantSpecialNotes(int participantID, String specialNotes);
    Map<Integer, Participant> getParticipantPaymentStatus();
}