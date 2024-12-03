package com.example.csc207courseproject.use_case.modify_finance;

public class ModifyFinanceInputData {
    private final int cashAmount;
    private final int eTransferAmount;
    private final String specialNote;
    private final int participantID;

    /**
     * Construct a new ModifyFinanceInputData with the given cash amount, eTransfer amount, participant ID, and special note.
     *
     * @param cashAmount the cash amount.
     * @param eTransferAmount the eTransfer amount.
     * @param participantID the participant ID.
     * @param specialNote the special note.
     */
    public ModifyFinanceInputData(int cashAmount, int eTransferAmount, int participantID, String specialNote) {
        this.cashAmount = cashAmount;
        this.eTransferAmount = eTransferAmount;
        this.participantID = participantID;
        this.specialNote = specialNote;
    }

    /**
     * Get the cash amount.
     *
     * @return the cash amount.
     */
    public int getCashAmount() {
        return cashAmount;
    }

    /**
     * Get the eTransfer amount.
     *
     * @return the eTransfer amount.
     */
    public int geteTransferAmount() {
        return eTransferAmount;
    }

    /**
     * Get the special note.
     *
     * @return the special note.
     */
    public String getSpecialNote() {
        return specialNote;
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
