package dao;

import org.sql2o.Sql2o;



public class DB {
   // public static Sql2o sql2o = new Sql2o("jdbc:postgresql://ec2-54-165-184-219.compute-1.amazonaws.com:5432/de628vumdppjbg", "gnmbajntavgjjh", "1657aaf26a2eb7b84bf5e7caaf8f0b64f67055dbe4ac9a2284fd1200bf78fb25");
    public static Sql2o sql2o = new  Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker", "moringa", "access" );

}








