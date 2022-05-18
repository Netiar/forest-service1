package dao;

import models.Animal;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class
sql2oAnimalDao implements AnimalDao{


    public Sql2o sql2o;

    public void getDrivers(){
        try{
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public sql2oAnimalDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public List<Animal> findAnimal() {
        getDrivers();
        try(Connection con = sql2o.open()){
            return con.createQuery(" SELECT * FROM animal")
                    .executeAndFetch(Animal.class);
        }
    }

//    CREATE TABLE animal(
//            id Serial PRIMARY KEY,
//            animalName VARCHAR,
//            animalType VARCHAR,
//            age VARCHAR,
//            health VARCHAR
//
//    );


    public void addAnimal(Animal animal) {
        getDrivers();
        String sql = "INSERT INTO animal(animalName, animalType, age, health ) VALUES (:animalName, :Age, :animalType, :health)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(animal)
                    .executeUpdate()
                    .getKey();
            animal.setId(id);
        } catch (Sql2oException e){
            System.out.println(e);
        }

    }


    public Animal findAnimalById(int id) {
        getDrivers();
        try(Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM animals WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Animal.class);
        }
    }


    public void deleteAnimalById(int id) {
        getDrivers();
        String sql = "DELETE FROM animals WHERE id -:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException e) {
            System.out.println(e);
        }
    }


    public void deleteAllAnimals() {
        getDrivers();
        String sql = "DELETE FROM animal";
        try(Connection con =  sql2o.open()){
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException e){
            System.out.println(e);
        }
    }


    public void updateAnimal(Animal animal) {
        getDrivers();
        String sql = "UPDATE FROM animals";
        try(Connection con =  sql2o.open()){
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException e){
            System.out.println(e);
        }
    } //end of updateAnimal

}
