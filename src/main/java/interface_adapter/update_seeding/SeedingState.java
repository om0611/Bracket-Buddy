package interface_adapter.update_seeding;

import java.util.List;

/**
 * A state containing all the data used for seeding
 */
public class SeedingState {
    private List<Integer> seeding;

    public void setSeeding(List<Integer> newSeeding) {
        seeding = newSeeding;
    }

    public List<Integer> getSeeding() {
        return seeding;
    }

    /**
     * Mutates the seeding to move a seed from oldSeed to newSeed.
     *
     * @param oldSeed The entrant's original seed
     * @param newSeed The entrant's updated seed
     */
    public void moveSeed(int oldSeed, int newSeed) {
        int tempID = seeding.get(oldSeed - 1);
        seeding.remove(oldSeed - 1);
        seeding.add(newSeed - 1, tempID);
    }
}