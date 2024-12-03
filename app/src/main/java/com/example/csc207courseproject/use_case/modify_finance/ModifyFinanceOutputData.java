package com.example.csc207courseproject.use_case.modify_finance;

import java.util.List;

public class ModifyFinanceOutputData {
    private final int participantID;
    private final List<String> updatedPaymentStatuses;


    /**
     * Construct a new ModifyFinanceOutputData with the given updated payment statuses and participant ID.
     *
     * @param updatedPaymentStatuses the updated payment statuses.
     * @param participantID the participant ID.
     */
    public ModifyFinanceOutputData(List<String> updatedPaymentStatuses, int participantID) {
        this.updatedPaymentStatuses = updatedPaymentStatuses;
        this.participantID = participantID;
    }

    /**
     * Get the updated payment statuses.
     *
     * @return the updated payment statuses.
     */
    public List<String> getUpdatedPaymentStatuses() {
        return updatedPaymentStatuses;
    }

    /**
     * Get the participant ID.
     *
     * @return the participant ID.
     */
    public int getParticipantID() {
        return participantID;
    }
}
