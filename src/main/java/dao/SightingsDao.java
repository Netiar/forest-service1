package dao;

import models.Animal;
import models.Sightings;

import java.util.List;

public interface SightingsDao {



    //list all sightings
    static List<Sightings> getAllSightings() {
        return null;
    }

    static List<Animal> getAnimalIdsBySightings(int sightingsToFindId, Object animalType) {
        return null;
    }




    //create
    void addSightings(Sightings sightings);

    //find by id
    static Sightings findSightingsById(int id) {
        return null;
    }

    //get all sightings by location
    List<Sightings> getSightingsByLocation(String location);

    //get all sightings by date
    List<Sightings> getSightingsByDate(String date);

    //get all endangered species
    List<Sightings> getEndangeredAnimal();

    //get all endangered rangers by name
    List<Sightings> getEndangeredRangersByName(String name);

    //delete sightings by id
    static void deleteSightingsById(String id, int idOfSightingsToDelete) {

    }

    //delete all sightings
    void deleteAllSightings();
}