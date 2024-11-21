//package com.example.csc207courseprojectandroid.app;
//
//import data_access.APIDataAccessObject;
//import data_access.UserDataAccessObject;
//import interface_adapter.ViewManagerModel;
//import interface_adapter.login.LoginController;
//import interface_adapter.login.LoginPresenter;
//import interface_adapter.login.LoginViewModel;
//import interface_adapter.main.MainViewModel;
//import interface_adapter.mutate_seeding.MutateSeedingController;
//import interface_adapter.mutate_seeding.MutateSeedingPresenter;
//import interface_adapter.select_phase.SelectPhaseController;
//import interface_adapter.select_phase.SelectPhasePresenter;
//import interface_adapter.update_seeding.SeedingViewModel;
//import interface_adapter.update_seeding.UpdateSeedingController;
//import interface_adapter.update_seeding.UpdateSeedingPresenter;
//import use_case.login.LoginInputBoundary;
//import use_case.login.LoginInteractor;
//import use_case.login.LoginOutputBoundary;
//import use_case.mutate_seeding.MutateSeedingInputBoundary;
//import use_case.mutate_seeding.MutateSeedingInteractor;
//import use_case.mutate_seeding.MutateSeedingOutputBoundary;
//import use_case.select_phase.SelectPhaseInputBoundary;
//import use_case.select_phase.SelectPhaseInteractor;
//import use_case.select_phase.SelectPhaseOutputBoundary;
//import use_case.update_seeding.UpdateSeedingInputBoundary;
//import use_case.update_seeding.UpdateSeedingInteractor;
//import use_case.update_seeding.UpdateSeedingOutputBoundary;
//import view.LoginView;
//import view.SeedingView;
//import view.ViewManager;
//
//import java.util.SortedMap;
//
//public class MainBuilder {
//    private final JPanel cardPanel = new JPanel();
//    private final CardLayout cardLayout = new CardLayout();
//    private final ViewManagerModel viewManagerModel = new ViewManagerModel();
//    private final ViewManager viewManager = new ViewManager(cardPanel, cardLayout, viewManagerModel);
//
//    private final APIDataAccessObject apiDataAccessObject = new APIDataAccessObject();
//    private final UserDataAccessObject userDataAccessObject = new UserDataAccessObject();
//
//    private LoginView loginView;
//    private SeedingView seedingView;
//    private LoginViewModel loginViewModel;
//    private SeedingViewModel seedingViewModel;
//    private MainViewModel mainViewModel;
//
//    public MainBuilder() {
//        cardPanel.setLayout(cardLayout);
//    }
//
//    /**
//     * Adds the Login View to the application.
//     * @return this builder
//     */
//    public MainBuilder addLoginView() {
//        loginViewModel = new LoginViewModel();
//        loginView = new LoginView(loginViewModel);
//        cardPanel.add(loginView, loginView.getViewName());
//        return this;
//    }
//
//    /**
//     * Adds the Seeding View to the application.
//     * @return this builder
//     */
//    public MainBuilder addSeedingView() {
//        // TEMPORARY FIX
//        String eventLink = "tournament/skipping-classes-world-championship-start-gg-api-test/event/1v1-lecture-skipping-bracket";
//        int eventID = apiDataAccessObject.getEventId(eventLink);
//        SortedMap<String, Integer> phaseIds = apiDataAccessObject.getPhaseIDs(eventID);
//
//        seedingViewModel = new SeedingViewModel();
//        seedingView = new SeedingView(seedingViewModel, phaseIds);
//        cardPanel.add(seedingView, seedingView.getViewName());
//        return this;
//    }
//
//    /**
//     * Adds the Main View to the application. INCOMPLETE
//     * @return this builder
//     */
//    public MainBuilder addMainView() {
//
//        mainViewModel = new MainViewModel();
//        return this;
//    }
//
//    /**
//     * Adds the login use case to the application.
//     * @return this builder
//     */
//    public MainBuilder addLoginUseCase() {
//        final LoginOutputBoundary loginPresenter = new LoginPresenter(
//                loginViewModel, viewManagerModel);
//        final LoginInputBoundary loginInteractor = new LoginInteractor(
//                userDataAccessObject, loginPresenter);
//        final LoginController controller = new LoginController(loginInteractor);
//        loginView.setLoginController(controller);
//        return this;
//    }
//
//    /**
//     * Adds the phase select Use Case to the application.
//     * @return this builder
//     */
//    public MainBuilder addSelectPhaseUseCase() {
//        final SelectPhaseOutputBoundary selectPhaseOutputBoundary = new SelectPhasePresenter(
//                seedingViewModel, viewManagerModel);
//        final SelectPhaseInputBoundary selectPhaseInteractor = new SelectPhaseInteractor(
//                apiDataAccessObject, selectPhaseOutputBoundary);
//
//        final SelectPhaseController controller = new SelectPhaseController(selectPhaseInteractor,
//                seedingViewModel.getState());
//        seedingView.setSelectPhaseController(controller);
//        return this;
//    }
//
//    /**
//     * Adds the update seeding Use Case to the application.
//     * @return this builder
//     */
//    public MainBuilder addUpdateSeedingUseCase() {
//        final UpdateSeedingOutputBoundary updateSeedingOutputBoundary = new UpdateSeedingPresenter(
//                seedingViewModel, viewManagerModel);
//        final UpdateSeedingInputBoundary updateSeedingInteractor = new UpdateSeedingInteractor(
//                updateSeedingOutputBoundary);
//
//        final UpdateSeedingController controller = new UpdateSeedingController(updateSeedingInteractor,
//                seedingViewModel.getState());
//        seedingView.setUpdateSeedingController(controller);
//        return this;
//    }
//
//    /**
//     * Adds the mutate seeding Use Case to the application.
//     * @return this builder
//     */
//    public MainBuilder addMutateSeedingUseCase() {
//        final MutateSeedingOutputBoundary mutateSeedingOutputBoundary = new MutateSeedingPresenter(
//                mainViewModel, seedingViewModel, viewManagerModel);
//        final MutateSeedingInputBoundary mutateSeedingInteractor = new MutateSeedingInteractor(
//                apiDataAccessObject, mutateSeedingOutputBoundary);
//
//        final MutateSeedingController controller = new MutateSeedingController(mutateSeedingInteractor,
//                seedingViewModel.getState());
//        seedingView.setMutateSeedingController(controller);
//        return this;
//    }
//
//    /**
//     * Creates the JFrame for the application and initially sets the SeedingView to be displayed.
//     * @return the application
//     */
//    public JFrame build() {
//        final JFrame application = new JFrame("Start gg Demo");
//        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        application.add(cardPanel);
//
//        viewManagerModel.setState(loginView.getViewName());
//        viewManagerModel.firePropertyChanged();
//
//        return application;
//    }
//}
