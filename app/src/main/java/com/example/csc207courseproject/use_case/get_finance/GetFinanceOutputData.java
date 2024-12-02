package com.example.csc207courseproject.use_case.get_finance;

import com.example.csc207courseproject.entities.Station;

import java.util.List;

public class GetFinanceOutputData {
    private final List<String> financeEntries;

    /**
     * Construct a new GetFinanceOutputData with the given finance entries.
     *
     * @param financeEntries the finance entries.
     */
    public GetFinanceOutputData(List<String> financeEntries) {
        this.financeEntries = financeEntries;
    }

    /**
     * Get the finance entries.
     *
     * @return the finance entries.
     */
    public List<String> getFinanceEntries() {
        return financeEntries;
    }
}
