package entities;

/**
 * An entity representing an entrant in an event
 */
public class Entrant {
    private final String name;
    private final String sponsor;
    private final int id;

    /**
     * Entrant constructor.
     * @param name Entrant name
     * @param sponsor Entrant sponsor
     * @param id Entrant ID
     */
    public Entrant(String name, String sponsor, int id) {
        this.name = name;
        this.sponsor = sponsor;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getSponsor() {
        return sponsor;
    }

    public int getId() {
        return id;
    }
}
