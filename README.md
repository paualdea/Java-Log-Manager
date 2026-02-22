# Acceso a Datos: Gestión de Ficheros y _Logs_

Este proyecto es una aplicación de consola en **Java** desarrollada como parte de la **Actividad 1: "Creación de un Diario de Registros (Logs)"** de la Unidad de Trabajo 1 (UT1) del módulo **Acceso a Datos**.

El sistema consiste en un gestor del sistema de archivos mientras un sistema de _log_ registra cada acción. El objetivo principal es aplicar el control de excepciones para crear un sistema estable.

## Características Principales

* **Persistencia Robusta de Logs**: Implementación de _logging_ con almacenamiento modo *append*, garantizando que las nuevas entradas no sobrescriban el historial existente.
* **Columnas de Información Estructurada**: Cada registro del _log_ cumple con un formato estándar que contiene: Fecha y hora, Tipo de operación, Resultado y Mensaje de error.
* **Gestión Automática de Entorno**: El programa crea y gestiona los directorios (`./log` y `./files`) para de realizar cualquier operación sobre el sistema.
* **Control de Excepciones**: Uso de `try-catch` para capturar errores de entrada/salida (`IOException`), ficheros no encontrados y errores lógicos.
* **Interfaz de Usuario Dinámica**: Menú interactivo por terminal con funciones para gestionar un sistema de archivos simple.

## Estructura del Proyecto

* **`Main.java`**: Gestiona el ciclo de la aplicación y el menú principal.
* **`Files.java`**: Controla las acciones sobre el sistema de archivos (lectura, escritura y borrado).
* **`Log.java`**: Clase que controla las acciones sobre el _log_.

## Ejecución

Para ejecutar este programa, basta con descargar el fichero `Java-Log-Manager_vx.x.x.jar` de las _releases_ y ejecutarlo con `java -jar Java-Log-Manager_vx.x.x.jar` desde cualquier sistema con Java instalado.

Funciona con Windows, Mac y Linux.

___
Este proyecto sirve como control de versiones y evidencia del trabajo realizado para la asignatura de Acceso a Datos.
