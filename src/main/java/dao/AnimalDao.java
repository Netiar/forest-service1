package dao;

import models.Animal;

import java.util.List;



public interface AnimalDao {


    List<Animal> animal = getAllAnimal();

    static List<Animal> getAllAnimal() {
        return animal;
    }

    static void addAnimal(Animal newAnimal) {
    }

    static Animal findAnimalById(int idd) {
        return null;
    }

    static void deleteAnimalById(int idOfAnimalToDeleteToDelete) {
    }

    static void deleteAllAnimals() {
    }

    // list animals
    List<Animal> findAnimal();





}
