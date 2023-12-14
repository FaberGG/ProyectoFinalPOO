# Proyecto final POO

---

## Descripción

La complejidad de la gestión en los centros de salud cardiológicos ha destacado la necesidad de optimizar los procesos relacionados con el diagnóstico y tratamiento de los pacientes, garantizando así la máxima calidad de atención. La falta de una solución eficiente ha llevado a situaciones donde la información médica no se gestiona de manera óptima, afectando directamente la calidad de vida de los pacientes.

Se requiere abordar la necesidad de conservar información detallada de los pacientes y del personal médico y administrativo, así como acceder al estado de estos en cualquier momento. Por otro lado, se necesita generar un resultado rápido sobre el estado del paciente con la información médica de cada uno que permita tomar la decisión de remitir, medicar, o dar de alta al paciente.

Para abordar este problema, se propone el desarrollo de un programa basado en programación orientada a objetos (POO), aplicando dos principios SOLID que facilitaran el manejo de la información y utilizando la estructura de un proyecto de java con Maven.

---

### Principios SOLID aplicados

Los principios SOLID son un conjunto de principios de diseño de software que nos ayudan a crear código limpio, modular y mantenible. A continuación, se describen la aplicación de los dos principios SOLID usados en el proyecto:

- **S** - Principio de Responsabilidad Única (Single Responsibility Principle): La clase [PersonalAdministrativo.java](https://github.com/FaberGG/ProyectoFinalPOO/blob/main/src/main/java/Logica/PersonalAdministrativo.java) tiene solo una razón para cambiar y solo por esa razón será modificada para el código, si hay que modificar algo dentro de ella, solo afectará el funcionamiento de la clase más no de todo el codigo.
- **D** - Principio de Inversión de Dependencias (Dependency Inversion Principle): La clase abstracta [Persona.java](https://github.com/FaberGG/ProyectoFinalPOO/blob/main/src/main/java/Logica/Persona.java) no depende de las clases hijas. La interfaz funcion biologica no depende de las clases que utilizan el método, pues ella existe independiente de ellas.

---

## UML

Un UML (Lenguaje de Modelado Unificado) es una herramienta gráfica utilizada en la programación orientada a objetos para representar visualmente la estructura y el comportamiento de un sistema. A continuación se presenta el diagrama de clases UML del proyecto construido.

![Proyecto%20final%20POO%20aac4e631568f4fef8150570c7d8148b8/image2.png](https://github.com/FaberGG/ProyectoFinalPOO/blob/main/ReadmeImages/image2.png)

---

## Requisitos

- **********************Java JDK 17:********************** Asegúrate de tener Java JDK 18 instalado en tu sistema en caso contrario puedes modificar el archivo [pom.xml](https://github.com/FaberGG/ProyectoFinalPOO/blob/main/pom.xml)
- ************Maven:************ Necesitarás Maven para compilar y ejecutar el proyecto.

---

## Instalación y Ejecución

1. **Clona el Proyecto**: Abre una terminal y ejecuta el siguiente comando para clonar el proyecto:
    
    ```bash
    git clone https://github.com/FaberGG/ProyectoFinalPOO.git
    ```
    
2. **Accede a la Carpeta del Proyecto**:
    
    ```bash
    cd ProyectoFinalPOO
    ```
    
3. **Ejecuta `clean install` con Maven**:
    
    Antes de ejecutar la aplicación, es recomendable realizar una limpieza del proyecto y construirlo. Utiliza el siguiente comando Maven:
    
    ```bash
    mvn clean install
    ```
    
    Este comando eliminará cualquier compilación anterior, descargar las dependencias necesarias y compilará el proyecto. Además, generará los artefactos en la carpeta `target`.
    
4. **Ejecuta la Aplicación**:
    
    Una vez completado el paso anterior, puedes ejecutar la aplicación con el siguiente comando:
    
    ```bash
    mvn exec:java
    ```
    
    Esto iniciará la aplicación.
    
    ¡Listo! Ahora has clonado, limpiado, construido y ejecutado el proyecto correctamente.
    

---

## Contribución al Proyecto

### Instrucciones para Colaborar

1. **Clonar el Repositorio**: Abre una terminal y ejecuta el siguiente comando para clonar el proyecto:
    
    ```bash
    git clone https://github.com/FaberGG/ProyectoFinalPOO.git
    ```
    
2. **Acceder a la Carpeta del Proyecto**:
    
    ```bash
    cd ProyectoFinalPOO
    ```
    
3. **Realizar Cambios y Verificar Estado**: Haz las modificaciones necesarias en el código. Para verificar el estado de tus cambios, utiliza el siguiente comando:
    
    ```bash
    git status
    ```
    
4. **Agregar Cambios al Staging Area**: Añade los archivos modificados al área de preparación con el siguiente comando:
    
    ```bash
    git add .
    ```
    
5. **Realizar Commit con Mensaje Descriptivo**: Realiza un commit con un mensaje claro que describa tus cambios:
    
    ```bash
    git commit -m "Descripción detallada de los cambios realizados"
    ```
    
6. **Subir Cambios al Repositorio Remoto**: Sube tus cambios al repositorio remoto en GitHub:
    
    ```bash
    git push origin nombre-de-tu-rama
    ```
    
7. **Solicitar Pull Request**: Si estás trabajando en una rama diferente, ve a GitHub y crea un Pull Request para que tus cambios se fusionen con la rama principal.

Siguiendo estos pasos, podrás colaborar de manera segura y efectiva en el proyecto. ¡Gracias por tu contribución!
