package com.example.csc207courseproject.interface_adapter.get_finance;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.io.File;
import java.util.List;
import java.util.Map;

public class GetFinanceState {

    // Get Finance State fields
    private List<String> partcipantPaymentStatus;
    private int eventID;

    // Maps to store participant payment details
    private Map<String, String> participantCashAmountMap;
    private Map<String, String> participanteTransferAmountMap;
    private Map<String, String> participantSpecialNotesMap;

    // Modify Finance State fields
    private String cashAmount;
    private String eTransferAmount;

    private String specialNote;
    private String participantID;
    private File file;

    private final MutableLiveData<List<String>> financialEntries = new MutableLiveData<>();

    /**
     * Get the event ID.
     *
     * @return the event ID.
     */
    public int getEventID() {
        return eventID;
    }

    /**
     * Get the participant payment status.
     *
     * @return the participant payment status.
     */
    public List<String> getPartcipantPaymentStatus() {
        return partcipantPaymentStatus;
    }

    /**
     * Set the participant payment status.
     *
     * @param partcipantPaymentStatus the participant payment status.
     */
    public void setPartcipantPaymentStatus(List<String> partcipantPaymentStatus) {
        this.partcipantPaymentStatus = partcipantPaymentStatus;
    }

    // Modify Finance State methods

    /**
     * Get the cash amount.
     *
     * @return the cash amount.
     */
    public String getCashAmount() {
        return cashAmount;
    }

    /**
     * Get the eTransfer amount.
     *
     * @return the eTransfer amount.
     */
    public String geteTransferAmount() {
        return eTransferAmount;
    }

    /**
     * Get the special note.
     *
     * @return the special note.
     */
    public String getSpecialNote(){
        return specialNote;
    }

    /**
     * Get the participant ID.
     *
     * @return the participant ID.
     */
    public String getParticipantID() {
        return participantID;
    }

    public void setEventID(int inputEventID){
        eventID = inputEventID;
    }

    /**
     * Set the cash amount.
     *
     * @param cashAmount the cash amount.
     */
    public void setCashAmount(String cashAmount) {
        this.cashAmount = cashAmount;
    }

    /**
     * Set the special note.
     *
     * @param specialNote the special note.
     */
    public void setSpecialNote(String specialNote){
        this.specialNote = specialNote;
    }

    /**
     * Set the eTransfer amount.
     *
     * @param eTransferAmount the eTransfer amount.
     */
    public void seteTransferAmount(String eTransferAmount) {
        this.eTransferAmount = eTransferAmount;
    }

    /**
     * Set the participant ID.
     *
     * @param participantID the participant ID.
     */
    public void setParticipantID(String participantID) {
        this.participantID = participantID;
    }

    /**
     * Set the file.
     *
     * @param file the file.
     */
    public void setFile(File file) {
        this.file = file;
    }

    /**
     * Get the file.
     *
     * @return the file.
     */
    public File getFile() {
        return file;
    }

    /**
     * Set the financial entries.
     *
     * @param inputFinancialEntries the financial entries.
     */
    public void setFinancialEntries(List<String> inputFinancialEntries){
        financialEntries.setValue(inputFinancialEntries);
    }

    /**
     * Get the financial entries.
     *
     * @return the financial entries.
     */
    public LiveData<List<String>> getFinancialEntries(){
        return financialEntries;
    }

    // Get Participant Payment Details methods

    /**
     * Get the participant cash amount map.
     *
     * @return the participant cash amount map.
     */
    public Map<String, String> getParticipantCashAmountMap() {
        return participantCashAmountMap;
    }

    /**
     * Get the participant eTransfer amount map.
     *
     * @return the participant eTransfer amount map.
     */
    public Map<String, String> getParticipanteTransferAmountMap() {
        return participanteTransferAmountMap;
    }

    /**
     * Get the participant special notes map.
     *
     * @return the participant special notes map.
     */
    public Map<String, String> getParticipantSpecialNotesMap() {
        return participantSpecialNotesMap;
    }

    // Set Participant Payment Details methods

    /**
     * Set the participant cash amount map.
     *
     * @param participantCashAmountMap the participant cash amount map.
     */
    public void setParticipantCashAmountMap(Map<String, String> participantCashAmountMap) {
        this.participantCashAmountMap = participantCashAmountMap;
    }

    /**
     * Set the participant eTransfer amount map.
     *
     * @param participanteTransferAmountMap the participant eTransfer amount map.
     */
    public void setParticipanteTransferAmountMap(Map<String, String> participanteTransferAmountMap) {
        this.participanteTransferAmountMap = participanteTransferAmountMap;
    }

    /**
     * Set the participant special notes map.
     *
     * @param participantSpecialNotesMap the participant special notes map.
     */
    public void setParticipantSpecialNotesMap(Map<String, String> participantSpecialNotesMap) {
        this.participantSpecialNotesMap = participantSpecialNotesMap;
    }
}
