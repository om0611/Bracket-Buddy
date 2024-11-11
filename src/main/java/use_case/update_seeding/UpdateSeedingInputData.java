package use_case.update_seeding;

import java.util.List;

/**
 * The Input Data for the Updating Seeding Locally Use Case.
 */
public class UpdateSeedingInputData {

    private String oldSeed;
    private String newSeed;
    private int maxSeed;

    public UpdateSeedingInputData(String oldSeed, String newSeed, int maxSeed) {
        this.oldSeed = oldSeed;
        this.newSeed = newSeed;
        this.maxSeed = maxSeed;
    }

    public String getOldSeed() {
        return oldSeed;
    }

    public String getNewSeed() {
        return newSeed;
    }

    public int getMaxSeed() {
        return maxSeed;
    }

}
