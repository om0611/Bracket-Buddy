package view;
import app.MainBuilder;
import interface_adapter.mutate_seeding.MutateSeedingController;
import interface_adapter.select_phase.SelectPhaseController;
import interface_adapter.update_seeding.SeedingState;
import interface_adapter.update_seeding.SeedingViewModel;
import interface_adapter.update_seeding.UpdateSeedingController;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;

public class SeedingView extends JPanel implements ActionListener, PropertyChangeListener {

    private final String viewName = "seeding";
    private final SeedingViewModel seedingViewModel;
    private SelectPhaseController selectPhaseController;
    private UpdateSeedingController updateSeedingController;
    private MutateSeedingController mutateSeedingController;

    private JFrame frame = new JFrame("Seeding View");
    private JPanel main;
    private final JLabel errorField = new JLabel();
    private JComboBox<String> comboBox;
    private JPanel bigList;
    private JPanel dropBox;
    private JPanel manualSeedingP;
    private JPanel playerAnalysis;
    private JPanel mutateSeeding;
    private JScrollPane scrollPane;
    private String oldSeedValue;
    private String newSeedValue;

    public SeedingView(SeedingViewModel seedingViewModel, SortedMap<String, Integer> temporaryFix) {
        this.seedingViewModel = seedingViewModel;
        this.seedingViewModel.addPropertyChangeListener(this);
        this.seedingViewModel.getState().setPhases(temporaryFix);
        createPhaseChoice();
        createPhaseView();
        createManualSeeding();
        createPlayerAnalysisOption();
        createMutateButton();
        createBase();
    }
    public void createPhaseChoice(){
        final SeedingState currentState = seedingViewModel.getState();
        Set<String> phases = currentState.getPhases();
        String[] options = new String[phases.size()];
        options = phases.toArray(options);
        comboBox = new JComboBox<>(options); // Assign to class-level comboBox
        JButton changePhase = new JButton("Select");

        comboBox.setBounds(60, 50, 150, 30);

        changePhase.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(changePhase)) {
                            String selectedOption = (String) comboBox.getSelectedItem();
                            mutateSeedingController.execute();
                            selectPhaseController.execute(selectedOption);
                        }
                    }
                }
        );

        comboBox.setSelectedIndex(0);

        dropBox = new JPanel();
        dropBox.add(comboBox);
        dropBox.add(changePhase);
        dropBox.setSize(300, 200);
    }

    public void createPhaseView(){
        final SeedingState currentState = seedingViewModel.getState();
        List<Integer> seeding = currentState.getSeeding();
        bigList = new JPanel();
        bigList.setLayout(new BoxLayout(bigList, BoxLayout.Y_AXIS));
        if(seeding != null) {
            for (int i = 0; i < seeding.size(); i++) {
                bigList.add(new JLabel((i + 1) + ". " + currentState.playerIdToString(seeding.get(i))));
            }
        }
        scrollPane = new JScrollPane(bigList);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

    }

    public void createManualSeeding() {
        JLabel changeSeed = new JLabel("Change Player Seed:");
        JLabel oldSeed = new JLabel("Change Seed");
        JLabel newSeed = new JLabel("To");
        JTextField oldSeedNum = new JTextField(5);
        JTextField newSeedNum = new JTextField(5);
        JButton confirm = new JButton("Confirm");

        // Confirm listener
        confirm.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(confirm)) {
                            updateSeedingController.execute(
                                    oldSeedValue, newSeedValue
                            );
                        }
                    }
                }
        );

        // Old Seed Listener
        oldSeedNum.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                oldSeedValue = oldSeedNum.getText();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                documentListenerHelper();
            }
        });

        // New Seed Listener
        newSeedNum.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                newSeedValue = newSeedNum.getText();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                documentListenerHelper();
            }
        });

        manualSeedingP = new JPanel(); // Assign to class-level manualSeedingP
        manualSeedingP.add(changeSeed);
        manualSeedingP.add(oldSeed);
        manualSeedingP.add(oldSeedNum);
        manualSeedingP.add(newSeed);
        manualSeedingP.add(newSeedNum);
        manualSeedingP.add(confirm);
        manualSeedingP.setSize(500, 40);
    }

    public void createPlayerAnalysisOption(){
        JLabel playerL = new JLabel("Seed of Player to Analyze: ");
        JTextField playerSeed = new JTextField(5);
        JButton confirmPlayerAnalysis = new JButton("Analyze Player");

        playerAnalysis = new JPanel(); // Assign to class-level playerAnalysis
        playerAnalysis.add(playerL);
        playerAnalysis.add(playerSeed);
        playerAnalysis.add(confirmPlayerAnalysis);
        playerAnalysis.setSize(500, 40);

        // Confirm listener
        confirmPlayerAnalysis.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(confirmPlayerAnalysis)) {
                            System.out.println("Not Implemented Yet");
                        }
                    }
                }
        );
    }

    public void createMutateButton(){
        JButton mutateButton = new JButton("Upload to Start gg");

        mutateSeeding = new JPanel();
        mutateSeeding.add(mutateButton);
        mutateSeeding.setSize(500, 40);

        // Confirm listener
        mutateButton.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(mutateButton)) {
                            mutateSeedingController.execute();
                            createMutateFrame("The seeding has been successfully mutated on Start gg!");
                        }
                    }
                }
        );
    }

    //TEMPORARY SUCCESS STATE
    public void createMutateFrame(String output){
        JFrame mutateView = new JFrame();
        JLabel message = new JLabel(output);
        JPanel mainPanel = new JPanel();
        mainPanel.add(message);
        frame.setSize(500, 400);
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void updateSeeds(){
        errorField.setText("");
        main.removeAll();
        main.add(dropBox);
        main.add(scrollPane);
        main.add(errorField);
        main.add(manualSeedingP);
        main.add(playerAnalysis);
        main.add(mutateSeeding);
        frame.setContentPane(main);
    }

    public void createBase() {
        main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        main.add(dropBox); // Add initialized components to main panel
        main.add(scrollPane);
        main.add(errorField);
        main.add(manualSeedingP);
        main.add(playerAnalysis);
        main.add(mutateSeeding);

        frame.setSize(500, 400);
        frame.setContentPane(main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case "seedfail" -> errorField.setText("Error finding seeds.");
            case "seedsuccess", "updatesuccess" -> {
                createPhaseView();
                updateSeeds();
            }
            case "mutatefail" -> errorField.setText("");
            case "mutatesuccess" -> errorField.setText("");
            case "updatefail" -> errorField.setText("Invalid seed. Try again.");
        }
    }

    public String getViewName() {
        return viewName;
    }

    public void setUpdateSeedingController(UpdateSeedingController controller) {
        this.updateSeedingController = controller;
    }

    public void setSelectPhaseController(SelectPhaseController controller) {
        this.selectPhaseController = controller;
    }

    public void setMutateSeedingController(MutateSeedingController controller) {
        this.mutateSeedingController = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
