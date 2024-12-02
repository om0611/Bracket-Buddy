package com.example.csc207courseproject.entities;

import org.jetbrains.annotations.NotNull;

public class Participant {
    private int participantId;
    private int userId;
    private String name;
    private String sponsor;
    private boolean hasPaid = false;
    private String cashPaid;
    private String eTransferPaid;
    private String specialNotes;

    public Participant(int participantId, int userId, String name, String sponsor) {
        this.participantId = participantId;
        this.userId = userId;
        this.name = name;
        this.sponsor = sponsor;
        this.cashPaid = "0";
        this.eTransferPaid = "0";
        this.specialNotes = "";
    }

    public int getParticipantId() {
        return participantId;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getSponsor() {
        return sponsor;
    }

    public boolean isPaid() {
        return hasPaid;
    }

    public void markAsPaid() {
        hasPaid = true;
    }

    public String getCashPaid() {
        return cashPaid;
    }

    public String geteTransferPaid() {
        return eTransferPaid;
    }

    public String getSpecialNotes() {
        return specialNotes;
    }

    public void setCashPaid(String cashPaid) {
        this.cashPaid = cashPaid;
    }

    public void seteTransferPaid(String eTransferPaid) {
        this.eTransferPaid = eTransferPaid;
    }

    public void setSpecialNotes(String specialNotes) {
        this.specialNotes = specialNotes;
    }

    @NotNull
    @Override
    public String toString() {
        return sponsor + " " + name;
    }
}
