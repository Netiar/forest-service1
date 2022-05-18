
import dao.sql2oAnimalDao;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import spark.resource.ExternalResource;

public class DatabaseRule extends ExternalResource {

    private static final sql2oAnimalDao DB = new sql2oAnimalDao(new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker", "postgres", "postgres"));

    /**
     * Constructor
     *
     * @param path the path to the external resource
     */
    public DatabaseRule(String path) {
        super(path);
    }

    protected void before(){
        DB.sql2o =new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", "moringa", "netiar");
    }


    protected void after() {
        try (Connection con = DB.sql2o.open()) {
            String deleteAnimalsQuery = "DELETE FROM animals *;";
            String deleteSightingsQuery = "DELETE FROM sightings *;";
            con.createQuery(deleteAnimalsQuery).executeUpdate();
            con.createQuery(deleteSightingsQuery).executeUpdate();
        }
    }
}
