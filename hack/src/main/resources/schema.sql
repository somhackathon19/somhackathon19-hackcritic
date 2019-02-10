CREATE TABLE ciutat (
    id_ciutat INT PRIMARY KEY,
    nom VARCHAR NOT NULL,
    num_habitats INT NOT NULL
);

CREATE TABLE barri (
    id_barri INT PRIMARY KEY,
    nom VARCHAR NOT NULL,
    num_habitats INT NOT NULL,
    kilograms FLOAT NOT NULL
);

CREATE TABLE historial (
  id_barri INT not null,
  year INT not null,
  kilograms float not null,
  PRIMARY KEY (id_barri,year),
  FOREIGN KEY (id_barri) REFERENCES barri(id_barri)
);