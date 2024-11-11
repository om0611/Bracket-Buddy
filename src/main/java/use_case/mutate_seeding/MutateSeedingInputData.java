package use_case.mutate_seeding;

import java.util.List;

/**
 * The Input Data for the Mutate Seeding to Start.gg Use Case.
 */
public class MutateSeedingInputData {

    private int phaseID;
    private List<Integer> finalSeeds;

    public MutateSeedingInputData(int phaseID, List<Integer> finalSeeds) {
        this.phaseID = phaseID;
        this.finalSeeds = finalSeeds;
    }

    public int getPhaseID() {
        return phaseID;
    }

    public List<Integer> getFinalSeeds() {
        return finalSeeds;
    }

}
