CREATE DATABASE faculdade;

CREATE TABLE cursos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    carga_horaria INT NOT NULL
);