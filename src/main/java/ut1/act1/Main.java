package ut1.act1;

import java.util.Scanner;

/**
 * @author Pau Aldea Batista
 * @version 1.0.0
 * @since 21/02/2025
 * @see Log
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        // ruta del directorio de logs y archivos
        String rutaLog = "./log";
        String rutaFiles = "./files";

        Boolean salir = false;

        // Creamos el objeto files y log
        Files files = new Files(rutaFiles);
        Log log = new Log(rutaLog);

        // Creamos el menú interactivo que permite hacer operaciones
        while (!salir) {
            limpiarPantalla();

            // Mostramos el menú interactivo y pedimos una opción que recogemos con un Scanner
            System.out.print("\t\t.:MENU FICHEROS:.\n1. Crear fichero\n2. Leer fichero\n3. Editar fichero\n4. Borrar fichero\n5. Salir\n\nQue quieres hacer: ");

            // Hacemos también una estructura de control por si el usuario no introduce un numero entero
            try {
                opcion = sc.nextInt();

                // Si el numero no esta dentro del rango, también lo mandamos al catch
                if (opcion > 0 && opcion <= 5) {
                    switch (opcion) {
                        case 1:
                            limpiarPantalla();

                            System.out.print("\t\t.:CREACIÓN FICHERO:.\n\nNombre del fichero: ");
                            String nombre = sc.next();

                            // Creamos el nuevo fichero de texto a partir del nombre
                            files.nuevoFichero(nombre);

                            // Añadimos un segundo de delay
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                System.err.println("Error haciendo la pausa de 1s");
                            }
                            break;
                        case 2:

                            break;
                        case 3:

                            break;
                        case 4:

                            break;
                        case 5:
                            salir = true;
                            break;
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (Exception e) {
                System.err.println("Solo se pueden introducir valores entre 1-5\n");

                // Pasamos la linea del escaner para que no entre en bucles de error
                sc.nextLine();
            }
        }
    }

    /**
     * Esta función limpia la pantalla dependiendo del sistema operativo que tengas
     */
    public static void limpiarPantalla() {
        try {
            // Obtenemos el sistema operativo desde el que se ejecuta el programa
            String so = System.getProperty("os.name").toLowerCase();

            // Si es windows lanzamos el comando cls para borrar la pantalla
            if (so.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            // Si es Linux o Mac, lanzamos una secuencia de caracteres ANSI que limpia y borra la pantalla
            else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.err.println("Error al limpiar la pantalla.\n" + e.getMessage());
        }
    }
}