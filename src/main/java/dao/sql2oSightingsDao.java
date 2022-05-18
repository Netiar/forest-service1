package dao;

import models.Sightings;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class sql2oSightingsDao implements SightingsDao {


    private final Sql2o sql2o;

    public void getDrivers(){
        try{
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public sql2oSightingsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }



    public List<Sightings> getAllSightings() {
        getDrivers();
        String sql = "SELECT * FROM sightings ";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .executeAndFetch(Sightings.class);
        }
    }

//            id serial PRIMARY KEY,
//            endangeredAnimal VARCHAR,
//            location VARCHAR,
//            rangerName VARCHAR
    @Override
    public void  addSightings(Sightings sightings) {
        getDrivers();
        String sql = "INSERT INTO sightings (id,endangeredAnimal,location, rangerName ) VALUES (:id, :endangeredAnimal, :location, :rangerName)";
        try(Connection conn = sql2o.open()){
            int id = (int) conn.createQuery(sql,true)
                    .bind(sightings)
                    .executeUpdate()
                    .getKey();
            sightings.setId(id);
        }catch(Sql2oException e){
            System.out.println(e);
        }

    }


    public Sightings findSightingsById(int id) {
        getDrivers();
        String sql = "SELECT * FROM sightings WHERE  id = :id";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetchFirst(Sightings.class);
        }
    }

    @Override
    public List<Sightings> getSightingsByLocation(String location) {
        getDrivers();
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM sightings WHERE location = :location")
                    .addParameter("location",location)
                    .executeAndFetch(Sightings.class);
        }
    }

    @Override
    public List<Sightings> getSightingsByDate(String date) {
        getDrivers();
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM sightings WHERE createdAt = :date")
                    .addParameter("createdAt",date)
                    .executeAndFetch(Sightings.class);
        }
    }

    @Override
    public List<Sightings> getEndangeredAnimal() {
        getDrivers();
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM sightings WHERE endangeredAnimal = :endangeredAnimal")
                    .addParameter("endangeredAnimal",true)
                    .executeAndFetch(Sightings.class);
        }
    }

    @Override
    public List<Sightings> getEndangeredRangersByName(String name) {
        getDrivers();
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM sightings WHERE rangerName = :name")
                    .addParameter("name",name)
                    .executeAndFetch(Sightings.class);
        }
    }


    public void deleteSightingsById(String id) {
        String sql = "DELETE FROM sightings WHERE id = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(sql)
                    .addParameter("id",id)
                    .executeUpdate();
        }catch(Sql2oException e){
            System.out.println(e);
        }
    }

    @Override
    public void deleteAllSightings() {
        getDrivers();
        String sql = "DELETE FROM sightings";
        try(Connection conn = sql2o.open()){
            conn.createQuery(sql)
                    .executeUpdate();
        }catch(Sql2oException e){
            System.out.println(e);
        }
    }
}
