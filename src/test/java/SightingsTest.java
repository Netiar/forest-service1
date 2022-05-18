import models.Sightings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SightingsTest {
    @Test
    public void sightings_instantiatesCorrectly_true() {
        Sightings sightings = new Sightings(001, "yes", "zone1", "netiar", 3/3/2019);
        assertEquals(true, sightings instanceof Sightings);
    }

    @Test
    public void getAnimalId_returnsId_Integer() {
        Sightings sightings = new Sightings(001, "yes", "zone1", "netiar", 3/3/2019);
        assertEquals(001, sightings.getId());
    }

    @Test
    public void getEndangeredAnimal_returns_yes() {
        Sightings sightings = new Sightings(001, "yes", "zone1", "netiar", 3/3/2019);
        assertEquals("yes", sightings.getEndangeredAnimal());
    }

    @Test
    public void getLocation_returns_zone1() {
        Sightings sightings = new Sightings(001, "yes", "zone1", "netiar", 3/3/2019);
        assertEquals("zone1", sightings.getLocation());
    }

    @Test
    public void getRangerName_returns_netiar() {
        Sightings sightings = new Sightings(001, "yes", "zone1", "netiar", 3/3/2019);
        assertEquals("netiar", sightings.getRangerName());
    }

}
