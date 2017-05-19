
CREATE TABLE Autor (
  nombre         VARCHAR(30) PRIMARY KEY,
  nacionalidad VARCHAR(30),
  comentarios  VARCHAR(250)
);

CREATE TABLE Editorial (
  nif  			VARCHAR(9) PRIMARY KEY,
  nombre         VARCHAR(40),
  direccion VARCHAR(250)
);

CREATE TABLE Libro (
  isbn 	VARCHAR(40) PRIMARY KEY,
  titulo VARCHAR(250),
  autores  VARCHAR(50),
  Editorial VARCHAR (250),
  publicacion INTEGER,
  precio DOUBLE,
  descripcion VARCHAR(250)
);

CREATE TABLE Direccion (
  calle varchar(50) ,
  numero INTEGER,
  poblacion VARCHAR(50) ,
  cp INTEGER,
  provincia VARCHAR(50)
);