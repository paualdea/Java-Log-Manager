package ut1.act1;

// IMPORTS
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Pau Aldea Batista
 * @version 1.0.0
 * @since 21/02/2025
 * @see Log
 */
public class Main {
    public static final int TIEMPO_ESPERA = 1250;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        // ruta del directorio de archivos
        String rutaFiles = "./files";

        Boolean salir = false;

        // Creamos el objeto files y log
        Files files = new Files(rutaFiles);

        // Creamos el menú interactivo que permite hacer operaciones
        while (!salir) {
            limpiarPantalla();

            // Mostramos el menú interactivo y pedimos una opción que recogemos con un Scanner
            System.out.print("\t\t.:MENU FICHEROS:.\n1. Crear fichero\n2. Leer fichero\n3. Borrar fichero\n4. Salir\n\nQue quieres hacer: ");

            // Hacemos también una estructura de control por si el usuario no introduce un numero entero
            try {
                opcion = sc.nextInt();

                // Si el numero no esta dentro del rango, también lo mandamos al catch
                if (opcion > 0 && opcion <= 4) {
                    switch (opcion) {
                        // Creación fichero
                        case 1:
                            limpiarPantalla();

                            System.out.print("\t\t.:CREACIÓN FICHERO:.\n\nNombre del fichero: ");
                            String nombre = sc.next();

                            // Creamos el nuevo fichero de texto a partir del nombre
                            files.nuevoFichero(nombre);

                            // Añadimos un segundo de delay
                            espera();
                            break;
                        // Lectura fichero
                        case 2:
                            String opcion_aux = null;

                            // Creamos un ArrayList para guardar los ficheros de la carpeta ./files
                            ArrayList<String> listaFicheros = files.listarFicheros();

                            limpiarPantalla();
                            System.out.println("\t\t.:LISTA FICHEROS:.\n");

                            // Listamos todos los ficheros del ArrayList
                            int i;
                            for (i=0; i<listaFicheros.size(); i++) {
                                System.out.println((i+1) + ". " + listaFicheros.get(i));
                            }
                            System.out.println((i + 1) + ". Salir");

                            System.out.print("Que fichero quieres consultar: ");
                            opcion_aux = sc.next();

                            /*
                                Comprobamos que la opción que se haya leido sea un numero mayor que cero y menos
                                que el tamaño de la lista de ficheros.
                             */
                            if (Integer.parseInt(opcion_aux) > 0 && Integer.parseInt(opcion_aux) <= listaFicheros.size()) {
                                limpiarPantalla();

                                // Llamamos a la función que nos imprime por pantalla el contenido del documento
                                files.mostrarFichero(rutaFiles, listaFicheros, opcion_aux);

                                espera();
                            } else {
                                System.err.println("Saliendo...");
                                espera();
                            }

                            break;
                        case 3:
                            String opcion_auxx = null;

                            // Creamos un ArrayList para guardar los ficheros de la carpeta ./files
                            ArrayList<String> listaFicheross = files.listarFicheros();

                            limpiarPantalla();
                            System.out.println("\t\t.:LISTA FICHEROS:.\n");

                            // Listamos todos los ficheros del ArrayList
                            int j;
                            for (j=0; j<listaFicheross.size(); j++) {
                                System.out.println((j+1) + ". " + listaFicheross.get(j));
                            }
                            System.out.println((j + 1) + ". Salir");

                            System.out.print("Que fichero quieres eliminar: ");
                            opcion_auxx = sc.next();

                            /*
                                Comprobamos que la opción que se haya leido sea un numero mayor que cero y menos
                                que el tamaño de la lista de ficheros.
                             */
                            if (Integer.parseInt(opcion_auxx) > 0 && Integer.parseInt(opcion_auxx) <= listaFicheross.size()) {
                                limpiarPantalla();

                                // Llamamos a la función que nos imprime por pantalla el contenido del documento
                                files.eliminarFichero(rutaFiles, listaFicheross, opcion_auxx);

                                espera();
                            } else {
                                System.err.println("Saliendo...");
                                espera();
                            }
                            break;
                        case 4:
                            salir = true;
                            break;
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (Exception e) {
                System.err.println("Solo se pueden introducir valores entre 1-4\n");
                espera();

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

    /**
     * Esta función ejecuta un bloque de código que para la ejecución de espera TIEMPO_ESPERA segundos
     */
    public static void espera() {
        try {
            Thread.sleep(TIEMPO_ESPERA);
        } catch (InterruptedException e) {
            System.err.println("No se ha podido hacer la pausa de " + TIEMPO_ESPERA);
        }
    }
}