# ProyectoFinalPOO

## Instalación y Ejecución

1. **Clona el Proyecto**:
   Abre una terminal y ejecuta el siguiente comando para clonar el proyecto:

    ```bash
    git clone https://github.com/FaberGG/UltimoParcialPOO.git
    ```

2. **Accede a la Carpeta del Proyecto**:
   
    ```bash
    cd UltimoParcialPOO
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
