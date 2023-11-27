CREATE SCHEMA IF NOT EXISTS spring;
USE spring;

CREATE TABLE IF NOT EXISTS spring.usuarios(
    id_usuarios integer unsigned auto_increment primary key,
    nombre varchar(50),
    edad integer,
    nacionalidad varchar(50)
);

INSERT IGNORE INTO spring.usuarios(nombre, edad, nacionalidad) VALUES
    ('David', 28, 'España'),
    ('Matias', 33, 'Colombia'),
    ('Juan', 65, 'Francia');

SELECT * FROM spring.usuarios;