import models.Animal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalTest {


    @Test
    public void animal_instantiatesCorrectly_true() {
        Animal animal = new Animal("Lion", "carnivore", "adult", "healthy", "netiar", "14.00HRS 6/7/2019");
        assertEquals(true, animal instanceof Animal);
    }

    @Test
    public void getName_returnsName_String() {
        Animal animal = new Animal("Lion", "carnivore", "adult", "healthy", "netiar", "14.00HRS 6/7/2019");
        assertEquals("Lion", animal.getAnimalName());
    }

    @Test
    public void getType_returnsType_String() {
        Animal animal = new Animal("Lion", "carnivore", "adult", "healthy", "netiar", "14.00HRS 6/7/2019");
        assertEquals("carnivore", animal.getAnimalType());
    }

    @Test
    public void getAge_returnsAge_String() {
        Animal animal = new Animal("Lion", "carnivore", "adult", "healthy", "netiar", "14.00HRS 6/7/2019");
        assertEquals("adult", animal.getAge());
    }

    @Test
    public void getHealth_returnsHealth_String() {
        Animal animal = new Animal("Lion", "carnivore", "adult", "healthy", "netiar", "14.00HRS 6/7/2019");
        assertEquals("healthy", animal.getHealth());
    }

   @Test
    public void getCreatedBy_returnsStatus_String() {
        Animal animal = new Animal("Lion", "carnivore", "adult", "healthy", "netiar", "14.00HRS 6/7/2019");
        assertEquals("netiar", animal.getCreatedBy());
    }
}