import dao.DB;
import dao.sql2oAnimalDao;
import dao.sql2oSightingsDao;
import models.Animal;
import models.Sightings;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {static int getHerokuAssignedPort() {
ProcessBuilder processBuilder = new ProcessBuilder();
    if (processBuilder.environment().get("PORT") != null) {
        return Integer.parseInt(processBuilder.environment().get("PORT"));
    }
    return 4567;
}
    public static void main(String[] args) {

        port(getHerokuAssignedPort());
        staticFileLocation("/public");


        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/animal", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("Animal", Animal.getAnimals());
            return new ModelAndView(model, "animal.hbs");
        }, new HandlebarsTemplateEngine());

        post("/create/animal/new", (request, response) -> {
            Map<String, Object> model= new HashMap<>();

            int id = Integer.parseInt(request.queryParams("id"));

            String animalName = request.queryParams("animalName");
            String animalType = request.queryParams("animalType");
            String age = request.queryParams("age");
            String health = request.queryParams("health");
            String createdBy = request.queryParams("createdBy");

            //sightings
            int animalId = Animal.findAnimalById(id);
            String rangerName = request.queryParams("ranger");
            String location = request.queryParams("location");
            String date = request.queryParams("date");



                Animal animal = new Animal(animalName, animalType, age, health, createdBy, date);
                new sql2oAnimalDao(DB.sql2o).addAnimal(animal);

                Sightings newSightings = new Sightings(animalId, rangerName, location, health, 3 / 31 / 2019);
              new sql2oSightingsDao(DB.sql2o).addSightings(newSightings);

            response.redirect("/sightings");
            return null;


        }, new HandlebarsTemplateEngine());

        get("/sightings", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            List Sightings = new sql2oSightingsDao(DB.sql2o).getAllSightings();
            model.put("sightings", Sightings);
            return new ModelAndView(model, "sightings.hbs");
        }, new HandlebarsTemplateEngine());

    }



}