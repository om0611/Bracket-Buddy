package com.example.csc207courseproject.interface_adapter.modify_finance;

import com.example.csc207courseproject.use_case.modify_finance.ModifyFinanceInputBoundary;
import com.example.csc207courseproject.use_case.modify_finance.ModifyFinanceInputData;
import com.example.csc207courseproject.interface_adapter.get_finance.GetFinanceState;

public class ModifyFinanceController {
    private final ModifyFinanceInputBoundary interactor;

    private final GetFinanceState state;

    /**
     * Construct a new ModifyFinanceController with the given interactor and state.
     *
     * @param interactor the interactor for the modify finance use case.
     * @param state the state for the modify finance use case.
     */
    public ModifyFinanceController(ModifyFinanceInputBoundary interactor, GetFinanceState state) {
        this.interactor = interactor;
        this.state = state;
    }

    /**
     * Execute the logic for the modify finance use case.
     */
    public void execute() {
        int cashAmount = safeParseInt(state.getCashAmount());
        int eTransferAmount = safeParseInt(state.geteTransferAmount());
        int participantID = safeParseInt(extractUntilFirstComma(state.getParticipantID()));
        String specialNote = state.getSpecialNote();
        ModifyFinanceInputData inputData = new ModifyFinanceInputData(cashAmount, eTransferAmount, participantID, specialNote);
        interactor.execute(inputData);
    }

    /**
     * Extract the participant ID from the participant ID string.
     *
     * @param input the participant ID string.
     * @return the participant ID.
     */
    private static String extractUntilFirstComma(String input) {
        if (input == null || input.isEmpty()) {
            return ""; // Handle null or empty string
        }

        int commaIndex = input.indexOf(',');
        if (commaIndex == -1) {
            return input; // No comma found, return the entire string
        }

        return input.substring(0, commaIndex); // Extract until the first comma
    }

    /**
     * Safely parse an integer from a string.
     *
     * @param input the string to parse.
     * @return the parsed integer.
     */
    private int safeParseInt(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            return 0; // Return default value for invalid inputs
        }
    }
}
