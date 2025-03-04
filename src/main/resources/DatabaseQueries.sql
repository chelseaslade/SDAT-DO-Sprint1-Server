CREATE TABLE cities (
                        id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
                        name VARCHAR(255)
);

CREATE TABLE airports (
                          id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
                          name VARCHAR(255),
                          airportcode VARCHAR(3),
                          city_id INT,
                          FOREIGN KEY (city_id) REFERENCES cities(id)
);

CREATE TABLE aircraft (
                          id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
                          name VARCHAR(255)
);

CREATE TABLE passengers (
                            id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
                            name VARCHAR(255),
                            aircraft_id INT,
                            FOREIGN KEY (aircraft_id) REFERENCES aircraft(id)
);

INSERT INTO airports (name, airportcode, city_id) VALUES
                                      ("Halifax Stanfield International Airport", "YHZ", 1),
                                      ("St. John's International Airport", "YYT", 2),
                                      ("Toronto Pearson International Airport", "YYZ", 3),
                                      ("Calgary International Airport", "YYC", 4),
                                      ("Gander International Airport", "YQZ", 5),
                                      ("Vancouver International Airport", "YVR", 6);

INSERT INTO aircraft (name) VALUES
                                ("Airbus 320"),
                                ("Airbus 310"),
                                ("Boeing 777"),
                                ("Boeing 757"),
                                ("Airbus 330"),
                                ("Boeing 737");


INSERT INTO cities (name) VALUES
                              ("Halifax"),
                              ("St. John's"),
                              ("Toronto"),
                              ("Calgary"),
                              ("Gander"),
                              ("Vancouver");

INSERT INTO passengers (name, aircraft_id) VALUES
                                  ("John Doe", 1),
                                  ("Alice Sassy", 2),
                                  ("Jane Doe", 3),
                                  ("Pip Cat", 4),
                                  ("Suki Dog", 5),
                                  ("Bif Cat", 6);