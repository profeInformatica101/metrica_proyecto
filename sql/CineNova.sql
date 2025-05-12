DROP TABLE Entrada;
DROP TABLE Sesion;
DROP TABLE Persona;
DROP TABLE Pelicula;
DROP TABLE Sala;
DROP SEQUENCE SEQ_pelicula;

CREATE TABLE Persona (
    correo VARCHAR(100) NOT NULL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellidos VARCHAR(50) NOT NULL,
    contrasena VARCHAR(50) NOT NULL,
    puntosGanados NUMBER DEFAULT 0 NOT NULL,
    dni VARCHAR(9),
    sueldo NUMBER(10,2),
    esEmpleado NUMBER(1) DEFAULT 0 NOT NULL,
    esJefe NUMBER(1) DEFAULT 0 NOT NULL
);


CREATE TABLE Pelicula (
    id_pelicula NUMBER PRIMARY KEY,
    titulo VARCHAR(50) NOT NULL,
    duracion NUMBER NOT NULL,
    genero VARCHAR(50) NOT NULL,
    clasificacionEdad VARCHAR(10) NOT NULL,
    descripcion VARCHAR(500)
);

CREATE SEQUENCE SEQ_pelicula START WITH 1;

CREATE OR REPLACE TRIGGER trg_pelicula
BEFORE INSERT ON Pelicula
FOR EACH ROW

BEGIN
  SELECT SEQ_pelicula.NEXTVAL
  INTO   :new.id_pelicula
  FROM   dual;
END;
/

CREATE TABLE Sala (
    numero NUMBER NOT NULL PRIMARY KEY,
    capacidad NUMBER NOT NULL,
    esVIP NUMBER(1) NOT NULL,
    es3D NUMBER(1) NOT NULL
);


CREATE TABLE Sesion (
    id_pelicula NUMBER,
    numeroSala NUMBER,
    fechaHora TIMESTAMP(0) NOT NULL,
    precio NUMBER(10, 2) NOT NULL,
    PRIMARY KEY (id_pelicula, numeroSala, fechaHora),
    FOREIGN KEY (id_pelicula) REFERENCES Pelicula(id_pelicula),
    FOREIGN KEY (numeroSala) REFERENCES Sala(numero)
);


CREATE TABLE Entrada (
    id_pelicula NUMBER,
    numeroSala NUMBER,
    fechaHora TIMESTAMP(0) NOT NULL,
    correoPersona VARCHAR(100) NOT NULL,
    asiento NUMBER NOT NULL,
    precioFinal NUMBER(10) NOT NULL,
    fechaCompra DATE DEFAULT SYSDATE,
    PRIMARY KEY (id_pelicula, numeroSala, fechaHora, correoPersona),
    FOREIGN KEY (id_pelicula, numeroSala, fechaHora) REFERENCES Sesion(id_pelicula, numeroSala, fechaHora),
    FOREIGN KEY (correoPersona) REFERENCES Persona(correo)
);



INSERT INTO Persona (correo, nombre, apellidos, contrasena, puntosGanados, dni, sueldo, esEmpleado, esJefe)
VALUES ('ana.perez@gmail.com', 'Ana', 'Pérez López', 'ana123', 120, NULL, NULL, 0, 0);

INSERT INTO Persona (correo, nombre, apellidos, contrasena, puntosGanados, dni, sueldo, esEmpleado, esJefe)
VALUES ('juan.garcia@gmail.com', 'Juan', 'García Ruiz', 'juan456', 75, NULL, NULL, 0, 0);

INSERT INTO Persona (correo, nombre, apellidos, contrasena, puntosGanados, dni, sueldo, esEmpleado, esJefe)
VALUES ('laura.martin@gmail.com', 'Laura', 'Martín Díaz', 'laura789', 200, NULL, NULL, 0, 0);

INSERT INTO Persona (correo, nombre, apellidos, contrasena, puntosGanados, dni, sueldo, esEmpleado, esJefe)
VALUES ('carlos.lopez@cine.com', 'Carlos', 'López Gómez', 'carlos123', 0, '12345678A', 1800.00, 1, 0);

INSERT INTO Persona (correo, nombre, apellidos, contrasena, puntosGanados, dni, sueldo, esEmpleado, esJefe)
VALUES ('maria.sanchez@cine.com', 'María', 'Sánchez Ramos', 'maria456', 0, '87654321B', 2000.00, 1, 1);

INSERT INTO Persona (correo, nombre, apellidos, contrasena, puntosGanados, dni, sueldo, esEmpleado, esJefe)
VALUES ('david.fernandez@cine.com', 'David', 'Fernández Cano', 'david789', 0, '11223344C', 1700.00, 1, 0);

INSERT INTO Persona (correo, nombre, apellidos, contrasena, puntosGanados, dni, sueldo, esEmpleado, esJefe)
VALUES ('lucia.moreno@gmail.com', 'Lucía', 'Moreno Vidal', 'lucia321', 50, NULL, NULL, 0, 0);

INSERT INTO Persona (correo, nombre, apellidos, contrasena, puntosGanados, dni, sueldo, esEmpleado, esJefe)
VALUES ('sergio.alonso@gmail.com', 'Sergio', 'Alonso Castro', 'sergio654', 90, NULL, NULL, 0, 0);

INSERT INTO Persona (correo, nombre, apellidos, contrasena, puntosGanados, dni, sueldo, esEmpleado, esJefe)
VALUES ('ines.torres@cine.com', 'Inés', 'Torres Ortega', 'ines987', 0, '99887766D', 1850.00, 1, 0);

INSERT INTO Persona (correo, nombre, apellidos, contrasena, puntosGanados, dni, sueldo, esEmpleado, esJefe)
VALUES ('alberto.romero@cine.com', 'Alberto', 'Romero Nieto', 'alberto000', 0, '55667788E', 2200.00, 1, 1);



INSERT INTO Pelicula VALUES (1, 'Inception', 148, 'Ciencia Ficción', '13+', 'Un ladrón roba secretos del subconsciente.');
INSERT INTO Pelicula VALUES (2, 'Titanic', 195, 'Romance', '12+', 'Una historia de amor a bordo del Titanic.');
INSERT INTO Pelicula VALUES (3, 'Avengers: Endgame', 181, 'Acción', '13+', 'Los Vengadores enfrentan a Thanos.');
INSERT INTO Pelicula VALUES (4, 'Coco', 105, 'Animación', '7+', 'Un niño descubre la Tierra de los Muertos.');
INSERT INTO Pelicula VALUES (5, 'Joker', 122, 'Drama', '18+', 'Origen del icónico villano de DC.');
INSERT INTO Pelicula VALUES (6, 'Interstellar', 169, 'Ciencia Ficción', '13+', 'Viaje espacial en busca de un nuevo hogar.');
INSERT INTO Pelicula VALUES (7, 'Frozen', 102, 'Animación', '6+', 'La historia de dos hermanas en un reino congelado.');
INSERT INTO Pelicula VALUES (8, 'The Matrix', 136, 'Acción', '16+', 'Un hacker descubre la verdad sobre su mundo.');
INSERT INTO Pelicula VALUES (9, 'Up', 96, 'Animación', '7+', 'Un anciano vuela con su casa a Sudamérica.');
INSERT INTO Pelicula VALUES (10, 'La La Land', 128, 'Musical', '13+', 'Un músico y una actriz persiguen sus sueños.');


INSERT INTO Sala VALUES (1, 100, 0, 0);
INSERT INTO Sala VALUES (2, 80, 1, 0);
INSERT INTO Sala VALUES (3, 60, 0, 1);
INSERT INTO Sala VALUES (4, 120, 1, 1);
INSERT INTO Sala VALUES (5, 90, 0, 0);
INSERT INTO Sala VALUES (6, 70, 1, 0);
INSERT INTO Sala VALUES (7, 50, 0, 1);
INSERT INTO Sala VALUES (8, 110, 1, 1);
INSERT INTO Sala VALUES (9, 95, 0, 0);
INSERT INTO Sala VALUES (10, 85, 1, 1);


INSERT INTO Sesion VALUES (1, 1, TO_TIMESTAMP('2025-05-15 18:00', 'YYYY-MM-DD HH24:MI'), 8.50);
INSERT INTO Sesion VALUES (2, 2, TO_TIMESTAMP('2025-05-15 20:30', 'YYYY-MM-DD HH24:MI'), 7.00);
INSERT INTO Sesion VALUES (3, 3, TO_TIMESTAMP('2025-05-16 17:00', 'YYYY-MM-DD HH24:MI'), 9.00);
INSERT INTO Sesion VALUES (4, 4, TO_TIMESTAMP('2025-05-16 19:30', 'YYYY-MM-DD HH24:MI'), 6.50);
INSERT INTO Sesion VALUES (5, 5, TO_TIMESTAMP('2025-05-17 21:00', 'YYYY-MM-DD HH24:MI'), 10.00);
INSERT INTO Sesion VALUES (6, 6, TO_TIMESTAMP('2025-05-18 16:00', 'YYYY-MM-DD HH24:MI'), 9.50);
INSERT INTO Sesion VALUES (7, 7, TO_TIMESTAMP('2025-05-18 18:30', 'YYYY-MM-DD HH24:MI'), 6.00);
INSERT INTO Sesion VALUES (8, 8, TO_TIMESTAMP('2025-05-19 20:00', 'YYYY-MM-DD HH24:MI'), 8.00);
INSERT INTO Sesion VALUES (9, 9, TO_TIMESTAMP('2025-05-20 17:30', 'YYYY-MM-DD HH24:MI'), 7.50);
INSERT INTO Sesion VALUES (10, 10, TO_TIMESTAMP('2025-05-20 19:00', 'YYYY-MM-DD HH24:MI'), 9.00);


INSERT INTO Entrada VALUES (1, 1, TO_DATE('2025-05-15 18:00', 'YYYY-MM-DD HH24:MI'), 'ana.perez@gmail.com', 1, 8.50, SYSDATE);
INSERT INTO Entrada VALUES (2, 2, TO_DATE('2025-05-15 20:30', 'YYYY-MM-DD HH24:MI'), 'juan.garcia@gmail.com', 2, 7.00, SYSDATE);
INSERT INTO Entrada VALUES (3, 3, TO_DATE('2025-05-16 17:00', 'YYYY-MM-DD HH24:MI'), 'laura.martin@gmail.com', 3, 9.00, SYSDATE);
INSERT INTO Entrada VALUES (4, 4, TO_DATE('2025-05-16 19:30', 'YYYY-MM-DD HH24:MI'), 'lucia.moreno@gmail.com', 4, 6.50, SYSDATE);
INSERT INTO Entrada VALUES (5, 5, TO_DATE('2025-05-17 21:00', 'YYYY-MM-DD HH24:MI'), 'sergio.alonso@gmail.com', 5, 10.00, SYSDATE);
INSERT INTO Entrada VALUES (6, 6, TO_DATE('2025-05-18 16:00', 'YYYY-MM-DD HH24:MI'), 'carlos.lopez@cine.com', 6, 9.50, SYSDATE);
INSERT INTO Entrada VALUES (7, 7, TO_DATE('2025-05-18 18:30', 'YYYY-MM-DD HH24:MI'), 'maria.sanchez@cine.com', 7, 6.00, SYSDATE);
INSERT INTO Entrada VALUES (8, 8, TO_DATE('2025-05-19 20:00', 'YYYY-MM-DD HH24:MI'), 'david.fernandez@cine.com', 8, 8.00, SYSDATE);
INSERT INTO Entrada VALUES (9, 9, TO_DATE('2025-05-20 17:30', 'YYYY-MM-DD HH24:MI'), 'ines.torres@cine.com', 9, 7.50, SYSDATE);
INSERT INTO Entrada VALUES (10, 10, TO_DATE('2025-05-20 19:00', 'YYYY-MM-DD HH24:MI'), 'alberto.romero@cine.com', 10, 9.00, SYSDATE);

