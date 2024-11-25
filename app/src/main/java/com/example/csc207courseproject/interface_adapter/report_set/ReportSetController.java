
package com.example.csc207courseproject.interface_adapter.report_set;

import com.example.csc207courseproject.use_case.report_set.ReportSetInputBoundary;
import com.example.csc207courseproject.use_case.report_set.ReportSetInputData;

/**
 * The controller for the Report Set Use case
 */
public class ReportSetController {


    private final ReportSetInputBoundary reportSetUseCaseInteractor;

    public ReportSetController(ReportSetInputBoundary reportSetUseCaseInteractor) {
        this.reportSetUseCaseInteractor = reportSetUseCaseInteractor;
    }

    /**
     * Execute the report set use case
     */
    public void execute() {

        final ReportSetInputData reportSetInputData = new ReportSetInputData();

        reportSetUseCaseInteractor.execute(reportSetInputData);
    }

}
