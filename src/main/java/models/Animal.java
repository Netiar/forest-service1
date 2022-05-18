package models;

import java.util.Objects;

public class Animal  {
    private int id;
    private String animalName;
    private String animalType;
    private String age;
    private String health;

    public Animal(String animalName) {
        this.animalName = animalName;
    }

    public static Object addAnimal() {
        return null;
    }

    public static Object getAnimals() {
        return null;
    }

    public static int findAnimalById(int animalId) {
        return animalId;
    }


    public String getCreatedBy() {
        return createdBy;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    private String createdBy;

    private String createdAt;

    public Animal(String animalName, String animalType, String age, String health, String createdBy, String createdAt) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.age = age;
        this.health = health;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if( o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return id == animal.id && createdBy == animal.createdBy && createdAt.equals(animal.createdAt) && animalName.equals(animal.animalName) && animalType.equals(animal.animalType) && age.equals(animal.age) && health.equals(animal.health);

    }
    
    @Override
    public int hashCode() {return Objects.hash(animalName, age, animalType, health); }
    
    public int getId() {
        return id;
    }

    public String getAnimalName() {
        return animalName;
    }

    public String getAnimalType() {
        return animalType;
    }

    public String getAge() {
        return age;
    }

    public String getHealth() {
        return health;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void save() {
    }


    public void add(Animal animal) {
    }
}

