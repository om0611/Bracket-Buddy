package entities;

import java.util.List;

/**
 * An entity containing all the data used for seeding
 */
public class SeedingData {
    private static List<String> seeding;

    public static void setSeeding(List<String> newSeeding) {
        seeding = newSeeding;
    }
    public static List<String> getSeeding() {
        return seeding;
    }
    public static void moveSeed(int oldSeed, int newSeed){
        String tempID = seeding.get(oldSeed - 1);
        seeding.remove(oldSeed - 1);
        seeding.add(newSeed - 1, tempID);
    }

}
