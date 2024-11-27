package com.example.csc207courseproject.use_case.report_game;

import com.example.csc207courseproject.use_case.report_set.ReportSetInputData;

public interface ReportGameInputBoundary {

    /**
     * Executes the report set to Start.gg case.
     * @param reportGameInputData the input data
     */
    void execute(ReportGameInputData reportGameInputData);

}
