package com.example.csc207courseproject.use_case.export_finance;

import com.example.csc207courseproject.entities.Participant;

import java.util.HashMap;
import java.util.Map;

public interface ExportFinanceDataAccessInterface {
    Map<Integer, Participant> getParticipantPaymentStatus();
}