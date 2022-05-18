CREATE DATABASE wildlife_tracker ;

\c wildlife_tracker ;

CREATE TABLE animal(
    id SERIAL PRIMARY KEY,
    animalName VARCHAR,
    animalType VARCHAR,
    age VARCHAR,
    health VARCHAR

);

CREATE TABLE sightings (
    id SERIAL PRIMARY KEY,
    endangeredAnimal VARCHAR,
    location VARCHAR,
    rangerName VARCHAR
);



CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;
\c wildlife_tracker_test;
