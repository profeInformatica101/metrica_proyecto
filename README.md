# 📘 Proyecto Integrado 1º DAW

Este proyecto se desarrollará aplicando la metodología **MÉTRICA v3** dentro del marco de la norma **ISO/IEC 12207**. Los alumnos deben seguir un ciclo de vida estructurado y entregar cada fase documentada en su repositorio personal.
## Técnicas y Prácticas Métrica v3 (PDF)
https://administracionelectronica.gob.es/pae_Home/en/dam/jcr:da7d91fa-d6bd-467c-be32-a72e27c603b3/METRICA_V3_Tecnicas.pdf


## 🎯 Objetivo General
Desarrollar una pequeña aplicación software con almacenamiento en base de datos y diseño orientado a objetos, aplicando buenas prácticas de análisis, diseño, implementación y pruebas, siguiendo el modelo de desarrollo de MÉTRICA v3.

## 🧰 Herramientas Obligatorias y Recomendadas

- ☕ Lenguaje de programación **Java**
- 📦 **Maven** como gestor de dependencias
- 🐬 **SQLite** como base de datos local
- 🧰 **DBeaver** (recomendado) para gestión visual de BBDD
- 🧱 **Umbrello** (obligatorio) para diagramas UML
- 🌐 **GitHub** para control de versiones y entrega del proyecto
- 🧪 **JUnit 5** para pruebas automatizadas

## 📂 Estructura del Proyecto

```
metrica_proyecto/
├── README.md
├── pom.xml
├── src/
│   ├── main/java/es/instituto/proyecto/
│   │   ├── App.java
│   │   └── db/Conexion.java
│   └── test/java/es/instituto/proyecto/
│       └── AppTest.java
├── docs/uml/
│   ├── Específicación requisitos del proyecto.doc
│   └── diagramas_umbrello.xmi
└── recursos/
    └── basedatos.db
```

## 🔁 Ciclo de Vida del Proyecto

Fases basadas en MÉTRICA v3 adaptadas a ISO 12207:

1. **PSI** – Estudio de viabilidad
2. **ASI** – Especificación de requisitos y análisis
3. **DSI + CSI** – Diseño lógico y físico
4. **IAS** – Implementación, pruebas y documentación técnica
5. **Evaluación final** – Informe de calidad y checklist

## ✅ Tareas de Entrega en Moodle

| Fase | Entrega en Moodle | Formato |
|------|--------------------|---------|
| PSI  | Estudio de Viabilidad | DOC  [OPCIONAL]|
| ASI  | Requisitos + Casos de uso | DOC + diagrama de Umbrello [OBLIGATORIO]|
| DSI  | Diagrama de clases y comportamiento | DOC + diagramas en Umbrello [OBLIGATORIO] |
| IAS + CSI | Código, pruebas, documentación | Repositorio GitHub [OBLIGATORIO] |
| Eval. | Informe de calidad y checklist | PDF [OPCIONAL]|

## 📘 README.md Recomendado

```markdown
# Proyecto Final - MÉTRICA v3 (ISO 12207)

Este proyecto forma parte del módulo de Entornos de Desarrollo.

## Tecnologías utilizadas
- Java
- Maven
- SQLite + DBeaver
- GitHub
- Umbrello (diagramas UML)
- JUnit 5 (pruebas unitarias)

## Estructura del repositorio
[Ver estructura recomendada más arriba]

## Fases del proyecto
- PSI: Estudio de viabilidad
- ASI: Requisitos y análisis
- DSI/CSI: Diseño técnico (diagramas)
- IAS: Implementación y pruebas

## Pruebas unitarias
El proyecto debe incluir pruebas automatizadas con **JUnit 5**. Se exige una **cobertura mínima del 50%** en las clases principales. Las pruebas deben estar bien organizadas en la carpeta `/test` y documentadas en el README.

## Autor
- Nombre: TU NOMBRE
- Repositorio: https://github.com/tu_usuario/metrica_proyecto
```

## 📦 Dependencias (`pom.xml`)

Incluye dependencias básicas para:

- SQLite (`sqlite-jdbc`)
- Pruebas con JUnit 5 (`junit-jupiter`)

Ver: https://github.com/profeInformatica101/maven
Ver: https://profeinformatica101.github.io/tareas/java/bbdd/SQLite.html

---

📁 **Recuerda:** Cada alumno debe tener su propio repositorio, aunque se trabaje en equipo. El repositorio se llamará:

```
https://github.com/<usuario>/metrica_proyecto
```

¡Buena suerte y a programar siguiendo una metodología!
