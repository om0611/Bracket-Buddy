package use_case.mutate_seeding;

/**
 * The DMO for the mutate seeding use case.
 */
public interface MutateSeedingDataMutationInterface {

    /**
     * Mutates the seeding on start gg to match the parameter seeding.
     * @param seededEntrants A list in seeded order of player IDs for each entrant
     */
    void setSeeding(String[] seededEntrants);
}
