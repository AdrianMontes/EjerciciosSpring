CREATE SCHEMA IF NOT EXISTS springg;
USE springg;

CREATE TABLE IF NOT EXISTS springg.usuarios(
    id_usuarios integer unsigned auto_increment primary key,
    nombre varchar(50),
    edad integer,
    nacionalidad varchar(50)
);

INSERT IGNORE INTO springg.usuarios(nombre, edad, nacionalidad) VALUES
    ('David', 28, 'España'),
    ('Matias', 33, 'Colombia'),
    ('Juan', 65, 'Francia');

SELECT * FROM springg.usuarios;