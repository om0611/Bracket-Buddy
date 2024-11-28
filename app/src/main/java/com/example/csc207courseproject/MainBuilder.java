package com.example.csc207courseproject;//package com.example.csc207courseprojectandroid.app;

import com.example.csc207courseproject.data_access.APIDataAccessObject;
import com.example.csc207courseproject.entities.Entrant;
import com.example.csc207courseproject.entities.EventData;
import com.example.csc207courseproject.entities.Participant;
import com.example.csc207courseproject.interface_adapter.ViewManagerModel;
import com.example.csc207courseproject.interface_adapter.get_stations.GetStationsController;
import com.example.csc207courseproject.interface_adapter.get_stations.GetStationsPresenter;
import com.example.csc207courseproject.interface_adapter.login.LoginViewModel;
import com.example.csc207courseproject.interface_adapter.main.MainViewModel;
import com.example.csc207courseproject.interface_adapter.mutate_seeding.MutateSeedingController;
import com.example.csc207courseproject.interface_adapter.mutate_seeding.MutateSeedingPresenter;
import com.example.csc207courseproject.interface_adapter.ongoing_sets.OngoingSetsController;
import com.example.csc207courseproject.interface_adapter.ongoing_sets.OngoingSetsPresenter;
import com.example.csc207courseproject.interface_adapter.report_set.ReportSetController;
import com.example.csc207courseproject.interface_adapter.report_set.ReportSetPresenter;
import com.example.csc207courseproject.interface_adapter.select_phase.SelectPhaseController;
import com.example.csc207courseproject.interface_adapter.select_phase.SelectPhasePresenter;
import com.example.csc207courseproject.interface_adapter.upcoming_sets.UpcomingSetsController;
import com.example.csc207courseproject.interface_adapter.upcoming_sets.UpcomingSetsPresenter;
import com.example.csc207courseproject.ui.call.CallViewModel;
import com.example.csc207courseproject.ui.report.ReportFragment;
import com.example.csc207courseproject.ui.report.ReportSetFragment;
import com.example.csc207courseproject.ui.report.ReportViewModel;
import com.example.csc207courseproject.ui.seeding.SeedingViewModel;
import com.example.csc207courseproject.interface_adapter.update_seeding.UpdateSeedingController;
import com.example.csc207courseproject.interface_adapter.update_seeding.UpdateSeedingPresenter;
import com.example.csc207courseproject.ui.seeding.SeedingFragment;
import com.example.csc207courseproject.ui.call.CallFragment;
import com.example.csc207courseproject.use_case.get_stations.GetStationsInputBoundary;
import com.example.csc207courseproject.use_case.get_stations.GetStationsInteractor;
import com.example.csc207courseproject.use_case.get_stations.GetStationsOutputBoundary;
import com.example.csc207courseproject.use_case.mutate_seeding.MutateSeedingInputBoundary;
import com.example.csc207courseproject.use_case.mutate_seeding.MutateSeedingInteractor;
import com.example.csc207courseproject.use_case.mutate_seeding.MutateSeedingOutputBoundary;
import com.example.csc207courseproject.use_case.ongoing_sets.OngoingSetsInputBoundary;
import com.example.csc207courseproject.use_case.ongoing_sets.OngoingSetsInteractor;
import com.example.csc207courseproject.use_case.ongoing_sets.OngoingSetsOutputBoundary;
import com.example.csc207courseproject.use_case.report_set.ReportSetInputBoundary;
import com.example.csc207courseproject.use_case.report_set.ReportSetInteractor;
import com.example.csc207courseproject.use_case.report_set.ReportSetOutputBoundary;
import com.example.csc207courseproject.use_case.select_phase.SelectPhaseInputBoundary;
import com.example.csc207courseproject.use_case.select_phase.SelectPhaseInteractor;
import com.example.csc207courseproject.use_case.select_phase.SelectPhaseOutputBoundary;
import com.example.csc207courseproject.use_case.upcoming_sets.UpcomingSetsInputBoundary;
import com.example.csc207courseproject.use_case.upcoming_sets.UpcomingSetsInteractor;
import com.example.csc207courseproject.use_case.upcoming_sets.UpcomingSetsOutputBoundary;
import com.example.csc207courseproject.use_case.update_seeding.UpdateSeedingInputBoundary;
import com.example.csc207courseproject.use_case.update_seeding.UpdateSeedingInteractor;
import com.example.csc207courseproject.use_case.update_seeding.UpdateSeedingOutputBoundary;
import com.example.csc207courseproject.view.ViewManager;

import java.util.Map;
import java.util.SortedMap;

public class MainBuilder {
    private final ViewManagerModel viewManagerModel = new ViewManagerModel();
    private final ViewManager viewManager = new ViewManager(viewManagerModel);

    private final APIDataAccessObject apiDataAccessObject = new APIDataAccessObject();

    private LoginViewModel loginViewModel;
    private SeedingViewModel seedingViewModel;
    private MainViewModel mainViewModel;
    private CallViewModel callViewModel;
    private ReportViewModel reportViewModel;

    // MOVE THIS TO EVENT SELECT VIEW INTERACTOR
    public MainBuilder createEventData(){
        // Create Event Data
        String eventLink = "tournament/skipping-classes-world-championship-start-gg-api-test/event/1v1-lecture-skipping-bracket";
        APIDataAccessObject dao = new APIDataAccessObject();
        int eventID = dao.getEventId(eventLink);
        Object[] entrants = dao.getEntrantsandParticipantsInEvent(eventID);
        SortedMap<String, Integer> phaseIds = apiDataAccessObject.getPhaseIDs(eventID);
        EventData.createEventData(1, eventID, "singles", (Map<Integer, Entrant>) entrants[0],
                (Map<Integer, Participant>) entrants[1], false, phaseIds);
        return this;
    }
    /**
     * Adds the Seeding View to the application.
     * @return this builder
     */
    public MainBuilder addSeedingView() {
        seedingViewModel = new SeedingViewModel();
        SeedingFragment.setSeedingViewModel(seedingViewModel);
        return this;
    }

    /**
     * Adds the Call Set View to the application.
     * @return this builder
     */
    public MainBuilder addCallView() {

        // Set seeding view args
        callViewModel = new CallViewModel();
        CallFragment.setCallViewModel(callViewModel);
        return this;
    }

    /**
     * Adds the Report Set View to the application.
     * @return this builder
     */
    public MainBuilder addReportView() {

        // Set report view args
        reportViewModel = new ReportViewModel();
        ReportFragment.setReportViewModel(reportViewModel);
        return this;
    }

    /**
     * Adds the upcoming sets Use Case to the application.
     * @return this builder
     */
    public MainBuilder addUpcomingSetsUseCase() {
        final UpcomingSetsOutputBoundary upcomingSetsOutputBoundary = new UpcomingSetsPresenter(
                callViewModel, viewManagerModel);
        final UpcomingSetsInputBoundary upcomingSetsInteractor = new UpcomingSetsInteractor(
                apiDataAccessObject, upcomingSetsOutputBoundary);

        final UpcomingSetsController controller = new UpcomingSetsController(upcomingSetsInteractor,
                callViewModel.getState());
        CallFragment.setUpcomingSetsController(controller);
        return this;
    }

    /**
     * Adds the get stations Use Case to the application.
     * @return this builder
     */
    public MainBuilder addGetStationsUseCase() {
        final GetStationsOutputBoundary getStationsOutputBoundary = new GetStationsPresenter(
                callViewModel);
        final GetStationsInputBoundary getStationsInteractor = new GetStationsInteractor(
                apiDataAccessObject, getStationsOutputBoundary);

        final GetStationsController controller = new GetStationsController(getStationsInteractor);
        CallFragment.setGetStationsController(controller);
        return this;
    }

    /**
     * Adds the ongoing sets Use Case to the application.
     * @return this builder
     */
    public MainBuilder addOngoingSetsUseCase() {
        final OngoingSetsOutputBoundary ongoingSetsOutputBoundary = new OngoingSetsPresenter(
                reportViewModel, viewManagerModel);
        final OngoingSetsInputBoundary ongoingSetsInteractor = new OngoingSetsInteractor(
                apiDataAccessObject, ongoingSetsOutputBoundary);

        final OngoingSetsController controller = new OngoingSetsController(ongoingSetsInteractor,
                reportViewModel.getState());
        ReportFragment.setOngoingSetsController(controller);
        return this;
    }

    /**
     * Adds the Report Set Use Case to the application.
     * @return this builder
     */
    public MainBuilder addReportSetUseCase() {
        //Figure out why this takes in two things, then do the api testing
        final ReportSetOutputBoundary reportSetOutputBoundary = new ReportSetPresenter(
                reportViewModel, viewManagerModel);
        final ReportSetInputBoundary reportSetInteractor = new ReportSetInteractor(
                apiDataAccessObject, reportSetOutputBoundary);

        final ReportSetController controller = new ReportSetController(reportSetInteractor,
                reportViewModel.getState());
        ReportSetFragment.setReportSetController(controller);
        return this;
    }

    /**
     * Adds the Main View to the application. INCOMPLETE
     * @return this builder
     */
    public MainBuilder addMainView() {

        mainViewModel = new MainViewModel();
        return this;
    }

    /**
     * Adds the phase select Use Case to the application.
     * @return this builder
     */
    public MainBuilder addSelectPhaseUseCase() {
        final SelectPhaseOutputBoundary selectPhaseOutputBoundary = new SelectPhasePresenter(
                seedingViewModel, viewManagerModel);
        final SelectPhaseInputBoundary selectPhaseInteractor = new SelectPhaseInteractor(
                apiDataAccessObject, selectPhaseOutputBoundary);

        final SelectPhaseController controller = new SelectPhaseController(selectPhaseInteractor,
                seedingViewModel.getState());
        SeedingFragment.setSelectPhaseController(controller);
        return this;
    }

    /**
     * Adds the update seeding Use Case to the application.
     * @return this builder
     */
    public MainBuilder addUpdateSeedingUseCase() {
        final UpdateSeedingOutputBoundary updateSeedingOutputBoundary = new UpdateSeedingPresenter(
                seedingViewModel, viewManagerModel);
        final UpdateSeedingInputBoundary updateSeedingInteractor = new UpdateSeedingInteractor(
                updateSeedingOutputBoundary);

        final UpdateSeedingController controller = new UpdateSeedingController(updateSeedingInteractor,
                seedingViewModel.getState());
        SeedingFragment.setUpdateSeedingController(controller);
        return this;
    }

    /**
     * Adds the mutate seeding Use Case to the application.
     * @return this builder
     */
    public MainBuilder addMutateSeedingUseCase() {
        final MutateSeedingOutputBoundary mutateSeedingOutputBoundary = new MutateSeedingPresenter(
                mainViewModel, seedingViewModel, viewManagerModel);
        final MutateSeedingInputBoundary mutateSeedingInteractor = new MutateSeedingInteractor(
                apiDataAccessObject, mutateSeedingOutputBoundary);

        final MutateSeedingController controller = new MutateSeedingController(mutateSeedingInteractor,
                seedingViewModel.getState());
        SeedingFragment.setMutateSeedingController(controller);
        return this;
    }
}
