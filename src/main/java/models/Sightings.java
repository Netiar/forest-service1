package models;

import java.awt.*;
import java.util.Objects;

public class Sightings {
//    CREATE TABLE sightings (
//            id serial PRIMARY KEY,
//            endangeredAnimal VARCHAR,
//            location VARCHAR,
//            rangerName VARCHAR
    private int id;
    private String endangeredAnimal;
    private String location;
    private String rangerName;
    private Integer date;

    public static void newSightings(int animal, String rangerName, String location, String health, String age) {
    }

    public static List getAll() {
        return null;
    }


    public int getCreatedBy() {
        return createdBy;
    }

    public int getCreatedAt() {
        return createdAt;
    }

    private int createdBy;

    private int createdAt;

    public Sightings(Integer animalId, String endangeredAnimal, String location, String rangerName, int createdAt) {
        this.id = animalId;
        this.endangeredAnimal = endangeredAnimal;
        this.location = location;
        this.rangerName = rangerName;
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if( o == null || getClass() != o.getClass()) return false;
        Sightings sightings = (Sightings)  o;
        return id == sightings.id && Objects.equals(endangeredAnimal, sightings.endangeredAnimal) && Objects.equals(location, sightings.location) && Objects.equals(rangerName, sightings.rangerName) && Objects.equals(createdAt, sightings.createdAt);


    }

    @Override
    public int hashCode() {return Objects.hash(id,endangeredAnimal ,location , rangerName, createdAt ); }

    public int getId() {
        return id;
    }

    public String getEndangeredAnimal() {
        return endangeredAnimal;
    }



    public String getLocation() {
        return location;
    }

    public String getRangerName() {
        return rangerName;
    }

    public Integer getDate() {
        return date;
    }


    public void setId(int id) {
    }


}


