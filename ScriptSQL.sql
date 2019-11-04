CREATE DATABASE Escola
USE Escola

CREATE TABLE Aluno (
matricula varchar(7) PRIMARY KEY,
nome varchar(255) NOT NULL,
disciplina varchar(3) NOT NULL
)

SELECT * from Aluno;