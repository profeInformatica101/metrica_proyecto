DROP TABLE Entrada;
DROP TABLE Sesion;
DROP TABLE Persona;
DROP TABLE Pelicula;
DROP TABLE Sala;

CREATE TABLE Persona (
    correo VARCHAR2(100) NOT NULL PRIMARY KEY,
    nombre VARCHAR2(50) NOT NULL,
    apellidos VARCHAR2(50) NOT NULL,
    contrasena VARCHAR2(50) NOT NULL,
    esEmpleado NUMBER(1) NOT NULL,
    esJefe NUMBER(1) NOT NULL
);

CREATE TABLE Pelicula (
    id_pelicula NUMBER PRIMARY KEY,
    titulo VARCHAR2(50) NOT NULL,
    duracion NUMBER NOT NULL,
    genero VARCHAR2(50) NOT NULL,
    clasificacionEdad VARCHAR2(10) NOT NULL,
    descripcion VARCHAR2(500)
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
    fechaHora DATE NOT NULL,
    precio NUMBER(10) NOT NULL,
    PRIMARY KEY (id_pelicula, numeroSala, fechaHora),
    FOREIGN KEY (id_pelicula) REFERENCES Pelicula(id_pelicula),
    FOREIGN KEY (numeroSala) REFERENCES Sala(numero)
);


CREATE TABLE Entrada (
    id_pelicula NUMBER,
    numeroSala NUMBER,
    fechaHora DATE NOT NULL,
    correoPersona VARCHAR2(100) UNIQUE NOT NULL,
    asiento VARCHAR2(10) NOT NULL,
    precioFinal NUMBER(10) NOT NULL,
    fechaCompra DATE DEFAULT SYSDATE,
    PRIMARY KEY (id_pelicula, numeroSala, fechaHora, correoPersona),
    FOREIGN KEY (id_pelicula, numeroSala, fechaHora) REFERENCES Sesion(id_pelicula, numeroSala, fechaHora),
    FOREIGN KEY (correoPersona) REFERENCES Persona(correo)
);



INSERT INTO Persona VALUES ('ana.garcia@email.com', 'Ana', 'García López', 'pass123', 0, 0);
INSERT INTO Persona VALUES ('luis.mr@email.com', 'Luis', 'Martínez Ruiz', 'luis456', 1, 0);
INSERT INTO Persona VALUES ('marta.pz@email.com', 'Marta', 'Pérez Soto', 'marta789', 0, 0);
INSERT INTO Persona VALUES ('carlos.gd@email.com', 'Carlos', 'Gómez Díaz', 'cg123', 1, 1);
INSERT INTO Persona VALUES ('lucia.tv@email.com', 'Lucía', 'Torres Vera', 'lucia456', 0, 0);
INSERT INTO Persona VALUES ('pedro.rl@email.com', 'Pedro', 'Reyes León', 'pedro789', 0, 0);
INSERT INTO Persona VALUES ('sofia.ms@email.com', 'Sofía', 'Molina Sáez', 'sofia321', 0, 0);
INSERT INTO Persona VALUES ('david.og@email.com', 'David', 'Ortega Gil', 'david111', 0, 0);
INSERT INTO Persona VALUES ('elena.nr@email.com', 'Elena', 'Navas Ruiz', 'elena777', 0, 0);
INSERT INTO Persona VALUES ('jorge.dp@email.com', 'Jorge', 'Delgado Pons', 'jorge888', 0, 0);


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


INSERT INTO Sesion VALUES (1, 1, TO_DATE('2025-05-15 18:00', 'YYYY-MM-DD HH24:MI'), 8.50);
INSERT INTO Sesion VALUES (2, 2, TO_DATE('2025-05-15 20:30', 'YYYY-MM-DD HH24:MI'), 7.00);
INSERT INTO Sesion VALUES (3, 3, TO_DATE('2025-05-16 17:00', 'YYYY-MM-DD HH24:MI'), 9.00);
INSERT INTO Sesion VALUES (4, 4, TO_DATE('2025-05-16 19:30', 'YYYY-MM-DD HH24:MI'), 6.50);
INSERT INTO Sesion VALUES (5, 5, TO_DATE('2025-05-17 21:00', 'YYYY-MM-DD HH24:MI'), 10.00);
INSERT INTO Sesion VALUES (6, 6, TO_DATE('2025-05-18 16:00', 'YYYY-MM-DD HH24:MI'), 9.50);
INSERT INTO Sesion VALUES (7, 7, TO_DATE('2025-05-18 18:30', 'YYYY-MM-DD HH24:MI'), 6.00);
INSERT INTO Sesion VALUES (8, 8, TO_DATE('2025-05-19 20:00', 'YYYY-MM-DD HH24:MI'), 8.00);
INSERT INTO Sesion VALUES (9, 9, TO_DATE('2025-05-20 17:30', 'YYYY-MM-DD HH24:MI'), 7.50);
INSERT INTO Sesion VALUES (10, 10, TO_DATE('2025-05-20 19:00', 'YYYY-MM-DD HH24:MI'), 9.00);


INSERT INTO Entrada VALUES (1, 1, TO_DATE('2025-05-15 18:00', 'YYYY-MM-DD HH24:MI'), 'ana.garcia@email.com', 'A1', 8.50, SYSDATE);
INSERT INTO Entrada VALUES (2, 2, TO_DATE('2025-05-15 20:30', 'YYYY-MM-DD HH24:MI'), 'luis.mr@email.com', 'B2', 7.00, SYSDATE);
INSERT INTO Entrada VALUES (3, 3, TO_DATE('2025-05-16 17:00', 'YYYY-MM-DD HH24:MI'), 'marta.pz@email.com', 'C3', 9.00, SYSDATE);
INSERT INTO Entrada VALUES (4, 4, TO_DATE('2025-05-16 19:30', 'YYYY-MM-DD HH24:MI'), 'carlos.gd@email.com', 'D4', 6.50, SYSDATE);
INSERT INTO Entrada VALUES (5, 5, TO_DATE('2025-05-17 21:00', 'YYYY-MM-DD HH24:MI'), 'lucia.tv@email.com', 'E5', 10.00, SYSDATE);
INSERT INTO Entrada VALUES (6, 6, TO_DATE('2025-05-18 16:00', 'YYYY-MM-DD HH24:MI'), 'pedro.rl@email.com', 'F6', 9.50, SYSDATE);
INSERT INTO Entrada VALUES (7, 7, TO_DATE('2025-05-18 18:30', 'YYYY-MM-DD HH24:MI'), 'sofia.ms@email.com', 'G7', 6.00, SYSDATE);
INSERT INTO Entrada VALUES (8, 8, TO_DATE('2025-05-19 20:00', 'YYYY-MM-DD HH24:MI'), 'david.og@email.com', 'H8', 8.00, SYSDATE);
INSERT INTO Entrada VALUES (9, 9, TO_DATE('2025-05-20 17:30', 'YYYY-MM-DD HH24:MI'), 'elena.nr@email.com', 'I9', 7.50, SYSDATE);
INSERT INTO Entrada VALUES (10, 10, TO_DATE('2025-05-20 19:00', 'YYYY-MM-DD HH24:MI'), 'jorge.dp@email.com', 'J10', 9.00, SYSDATE);
