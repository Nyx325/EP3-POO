DROP DATABASE IF EXISTS Agenda;
CREATE DATABASE Agenda;
    USE Agenda;

CREATE TABLE Contact(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    sex VARCHAR(10) NOT NULL,
    age VARCHAR(3) NOT NULL
);

CREATE TABLE Phone(
    id INT PRIMARY KEY AUTO_INCREMENT,
    number VARCHAR(45) NOT NULL,
    lada VARCHAR(4) NOT NULL,
    type VARCHAR(20) NOT NULL,
    idContact INT,
    FOREIGN KEY (idContact) REFERENCES Contact (id)
);

DROP USER IF EXISTS 'usuario'@'localhost';
CREATE USER 'usuario'@'localhost' IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON Agenda.* TO 'usuario'@'localhost';
FLUSH PRIVILEGES;

-- Contactos
INSERT INTO Contact (name, sex, age) VALUES
('Malcus Praderas', 'Hombre', '21'),
('Omicron Ramon', 'Hombre', '20'),
('Mazapan Toledo', 'Mujer', '19'),
('Luna Martinez', 'Mujer', '22'),
('Jairo Nuñez', 'Hombre', '23'),
('Camila Ortiz', 'Mujer', '24'),
('Dario Gomez', 'Hombre', '25'),
('Nina Rosales', 'Mujer', '20'),
('Ignacio Flores', 'Hombre', '21'),
('Emilia Vega', 'Mujer', '22'),
('Oscar Salinas', 'Hombre', '23'),
('Valeria Campos', 'Mujer', '24'),
('Pablo Santos', 'Hombre', '25'),
('Lucia Marquez', 'Mujer', '19');

-- Telefonos
INSERT INTO Phone (number, lada, type, idContact) VALUES 
('7771234567', '+52', 'Fijo', 1),
('6669876543', '+52', 'Celular', 2),
('6661234567', '+52', 'Trabajo', 2),
('5552345678', '+52', 'Trabajo', 3),
('4448765432', '+52', 'Celular', 4),
('3337654321', '+52', 'Casa', 5),
('3331234567', '+52', 'Celular', 5),
('3339876543', '+52', 'Trabajo', 5),
('2226543210', '+52', 'Celular', 6),
('1112345678', '+52', 'Casa', 7),
('1118765432', '+52', 'Celular', 7),
('9999876543', '+52', 'Celular', 8),
('8882345678', '+52', 'Casa', 9),
('7778765432', '+52', 'Celular', 10),
('7776543210', '+52', 'Trabajo', 10),
('6667654321', '+52', 'Casa', 11),
('5553456789', '+52', 'Celular', 12),
('4444567890', '+52', 'Casa', 13),
('4442345678', '+52', 'Celular', 13),
('3335678901', '+52', 'Celular', 14);
