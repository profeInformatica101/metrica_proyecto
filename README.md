# 📘 Proyecto Integrado 1º DAW – Aplicación según MÉTRICA v3  
*(Adaptado a la norma ISO/IEC 12207)*

---

## 🧩 Descripción del Proyecto

Este proyecto forma parte del módulo **Entornos de Desarrollo** (1º DAW).  
El alumnado desarrollará una aplicación software con **diseño orientado a objetos**, almacenamiento en base de datos y control de versiones, siguiendo la metodología **MÉTRICA v3** en el marco de la norma **ISO/IEC 12207**.

El desarrollo debe realizarse siguiendo un **ciclo de vida estructurado**, documentando cada fase y subiendo las entregas al **repositorio personal de GitHub**.

📄 Referencia:  
[Técnicas y Prácticas Métrica v3 (PDF)](https://administracionelectronica.gob.es/pae_Home/en/dam/jcr:da7d91fa-d6bd-467c-be32-a72e27c603b3/METRICA_V3_Tecnicas.pdf)

---

## 🎯 Objetivo General

Desarrollar una aplicación completa aplicando buenas prácticas de **análisis, diseño, implementación y pruebas**, siguiendo los principios del modelo **MÉTRICA v3**.

El producto final incluirá:
- Documentación técnica y de usuario.  
- Diagramas UML elaborados con Umbrello.  
- Base de datos funcional con SQLite.  
- Código Java probado con JUnit 5.  
- Control de versiones mediante GitHub.

---

## 🧰 Herramientas Obligatorias y Recomendadas

| Categoría | Herramienta | Obligatoria | Descripción |
|------------|--------------|--------------|--------------|
| Lenguaje | ☕ **Java** | ✅ | Lenguaje principal del proyecto |
| Dependencias | 📦 **Maven** | ✅ | Gestión de librerías y compilación |
| Base de datos | 🐬 **SQLite** | ✅ | Almacenamiento local de datos |
| BBDD visual | 🧰 **DBeaver** | Recomendado | Gestión gráfica de la base de datos |
| Modelado | 🧱 **Umbrello** | ✅ | Creación de diagramas UML |
| Control de versiones | 🌐 **GitHub** | ✅ | Repositorio y seguimiento de versiones |
| Pruebas | 🧪 **JUnit 5** | ✅ | Pruebas unitarias automatizadas |

---

## 📂 Estructura del Proyecto

```bash
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
│   ├── Especificacion_Requisitos_Proyecto.docx
│   └── diagramas_umbrello.xmi
└── recursos/
    └── basedatos.db
```

> 💡 *Asegúrate de mantener esta estructura para facilitar la revisión y evaluación.*

---

## 🔁 Ciclo de Vida del Proyecto  
Basado en **MÉTRICA v3** y alineado con la **ISO/IEC 12207**:

| Fase | Descripción | Entregable |
|------|--------------|------------|
| **PSI** | Estudio de viabilidad del sistema | Informe de viabilidad |
| **ASI** | Especificación de requisitos y análisis | Documento + Diagrama de casos de uso |
| **DSI / CSI** | Diseño lógico y físico del sistema | Diagramas de clases y de comportamiento |
| **IAS** | Implementación, pruebas y documentación | Código en GitHub + Pruebas unitarias |
| **Evaluación Final** | Informe de calidad y checklist | PDF opcional |

---

## ✅ Tareas de Entrega en Moodle

| Fase | Entrega | Formato |
|------|----------|----------|
| PSI | Estudio de Viabilidad | `.docx` / `.pdf` *(opcional)* |
| ASI | Requisitos + Casos de uso | `.docx` + `.xmi` *(obligatorio)* |
| DSI | Diseño UML completo | `.docx` + `.xmi` *(obligatorio)* |
| IAS + CSI | Código, pruebas, documentación | Repositorio GitHub *(obligatorio)* |
| Evaluación | Informe de calidad | `.pdf` *(opcional)* |

---

## 🧱 Fases Detalladas del Proyecto

### 1️⃣ PSI – Planificación del Sistema de Información
- Estudio de viabilidad técnica, económica y operativa.
- Justificación del proyecto y planificación general.

### 2️⃣ ASI – Análisis del Sistema de Información
- Especificación de requisitos funcionales y no funcionales.
- Modelado de casos de uso y diagramas de actividades.
- Identificación de actores y flujos de datos.

### 3️⃣ DSI / CSI – Diseño y Construcción
- Diseño de clases, base de datos y estructura de carpetas.
- Creación de diagramas UML (clases, secuencia, componentes).
- Implementación en Java con conexión a SQLite.

### 4️⃣ IAS – Implantación y Pruebas
- Integración de componentes.
- Pruebas automatizadas con **JUnit 5**.
- Elaboración del manual técnico y de usuario.

### 5️⃣ Evaluación Final
- Checklist de calidad del software.
- Conclusiones y valoración del proyecto.

---

## 🧪 Pruebas Unitarias

Las pruebas se realizarán con **JUnit 5**.  
Se exige una **cobertura mínima del 50%** en las clases principales.

Ubicación de las pruebas:
```
src/test/java/es/instituto/proyecto/
```

Cada clase probada debe incluir su test correspondiente.  
Ejemplo: `App.java` → `AppTest.java`.

---

## ⚙️ Dependencias mínimas (`pom.xml`)

```xml
<dependencies>
    <!-- SQLite -->
    <dependency>
        <groupId>org.xerial</groupId>
        <artifactId>sqlite-jdbc</artifactId>
        <version>3.45.1.0</version>
    </dependency>

    <!-- JUnit 5 -->
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.10.2</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

📚 Recurso útil:  
- [Repositorio Maven de ejemplo](https://github.com/profeInformatica101/maven)  
- [Tutorial SQLite con Java](https://profeinformatica101.github.io/tareas/java/bbdd/SQLite.html)

---

## 📘 Ejemplo de README interno del proyecto

```markdown
# Proyecto Final – MÉTRICA v3 (ISO 12207)

## Tecnologías utilizadas
- Java + Maven  
- SQLite + DBeaver  
- Umbrello (UML)  
- GitHub  
- JUnit 5 (pruebas)

## Fases
- PSI → Viabilidad  
- ASI → Requisitos y casos de uso  
- DSI / CSI → Diseño técnico  
- IAS → Implementación y pruebas

## Autor
**Nombre:** [Tu nombre completo]  
**Repositorio:** [https://github.com/tu_usuario/metrica_proyecto](https://github.com/tu_usuario/metrica_proyecto)
```

---

## 📎 Enlaces de Referencia

- 📘 [MÉTRICA v3 – Técnicas y Prácticas (Ministerio de Política Territorial)](https://administracionelectronica.gob.es/pae_Home/en/dam/jcr:da7d91fa-d6bd-467c-be32-a72e27c603b3/METRICA_V3_Tecnicas.pdf)
- 🧩 [Resumen de MÉTRICA v3 – Preparatic.org](https://www.preparatic.org/material/20100918/Metrica_v3.pdf)
- 🌐 [Norma ISO/IEC 12207 – Ciclo de vida del software](https://es.wikipedia.org/wiki/ISO/IEC_12207)

---

## 👨‍💻 Autor / Equipo

- **Nombre:** TU NOMBRE  
- **Usuario GitHub:** `tu_usuario`  
- **Repositorio:** [https://github.com/tu_usuario/metrica_proyecto](https://github.com/tu_usuario/metrica_proyecto)

---

> ⚠️ *Recuerda:* Cada alumno debe tener su propio repositorio aunque trabaje en equipo.  
> El nombre del repositorio debe ser:  
> `https://github.com/<usuario>/metrica_proyecto`

---

🎯 **¡Buena suerte!**  
Aplica las fases de MÉTRICA v3, documenta tu proceso y desarrolla con rigor profesional.
