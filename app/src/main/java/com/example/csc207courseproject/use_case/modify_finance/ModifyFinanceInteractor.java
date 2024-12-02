package com.example.csc207courseproject.use_case.modify_finance;

import com.example.csc207courseproject.entities.EventData;
import com.example.csc207courseproject.entities.Participant;

import java.util.ArrayList;
import java.util.List;

public class ModifyFinanceInteractor implements ModifyFinanceInputBoundary {

    private final ModifyFinanceOutputBoundary presenter;

    /**
     * Construct a new ModifyFinanceInteractor with the given data access and presenter.
     *
     * @param presenter the output boundary.
     */
    public ModifyFinanceInteractor(ModifyFinanceOutputBoundary presenter) {
        this.presenter = presenter;
    }

    /**
     * Execute the logic for the modify finance use case.
     * @param inputData The input data containing event information
     */
    @Override
    public void execute(ModifyFinanceInputData inputData) {

        if (inputData.geteTransferAmount() > 0 || inputData.getCashAmount() > 0) {
            Participant participant = EventData.getEventData().getParticipant(inputData.getParticipantID());
            participant.markAsPaid();
            participant.setCashPaid(String.valueOf(inputData.getCashAmount()));
            participant.seteTransferPaid(String.valueOf(inputData.geteTransferAmount()));
            participant.setSpecialNotes(String.valueOf(inputData.getSpecialNote()));
                
            List<Participant> participants = new ArrayList<>(EventData.getEventData().getParticipants().values());

            List<String> output = new ArrayList<>();

            for (Participant p : participants) {
                output.add(p.getFinancialEntry());
            }
            ModifyFinanceOutputData outputData = new ModifyFinanceOutputData(output, participant.getParticipantId());

                // update the view
            presenter.prepareSuccessView(outputData);
        }
    }
}
