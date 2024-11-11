package view;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeedingView extends JFrame implements ActionListener {
    private static JComboBox<String> comboBox;
    static JPanel dropBox;
    static JPanel bigList;
    static JPanel manualSeedingP;
    static JPanel playerAnalysis;

    public static void main(String[] args){
        createPhaseChoice();
        createPhaseView();
        createManualSeeding();
        createPlayerAnalysisOption();
        createBase();
    }

    public static void createPhaseChoice(){
        String[] options = {"Phase 1", "Phase 2"};
        comboBox = new JComboBox<>(options); // Assign to class-level comboBox
        JButton changeView = new JButton("View");

        comboBox.setBounds(60, 50, 150, 30);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) comboBox.getSelectedItem();
                System.out.println(selectedOption);
            }
        });
        comboBox.setEditable(true);
        comboBox.setSelectedIndex(0);

        dropBox = new JPanel(); // Assign to class-level dropBox
        dropBox.add(comboBox);
        dropBox.add(changeView);
        dropBox.setSize(300, 200);
    }

    public static void createPhaseView(){
        bigList = new JPanel(); // Assign to class-level bigList
    }

    public static void createManualSeeding() {
        JLabel changeSeed = new JLabel("Change Player Seed:");
        JLabel oldSeed = new JLabel("Change Seed");
        JLabel newSeed = new JLabel("To");
        JTextField oldSeedNum = new JTextField(5);
        JTextField newSeedNum = new JTextField(5);
        JButton confirm = new JButton("Confirm");

        manualSeedingP = new JPanel(); // Assign to class-level manualSeedingP
        manualSeedingP.add(changeSeed);
        manualSeedingP.add(oldSeed);
        manualSeedingP.add(oldSeedNum);
        manualSeedingP.add(newSeed);
        manualSeedingP.add(newSeedNum);
        manualSeedingP.add(confirm);
        manualSeedingP.setSize(500, 40);
    }

    public static void createPlayerAnalysisOption(){
        JLabel playerL = new JLabel("Seed of Player to Analyze: ");
        JTextField playerSeed = new JTextField(5);
        JButton confirmPlayerAnalysis = new JButton("Analyze Player");

        playerAnalysis = new JPanel(); // Assign to class-level playerAnalysis
        playerAnalysis.add(playerL);
        playerAnalysis.add(playerSeed);
        playerAnalysis.add(confirmPlayerAnalysis);
        playerAnalysis.setSize(500, 40);
    }

    public static void createBase() {
        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        main.add(dropBox); // Add initialized components to main panel
        main.add(bigList);
        main.add(manualSeedingP);
        main.add(playerAnalysis);

        JFrame frame = new JFrame("Seeding View");
        frame.setSize(500, 400);
        frame.setContentPane(main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == comboBox) {
            System.out.println(comboBox.getSelectedItem());
        }
    }
}
