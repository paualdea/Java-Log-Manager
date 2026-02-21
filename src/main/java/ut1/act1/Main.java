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

        // ruta del directorio de logs y archivos
        String rutaLog = "./log";
        String rutaFiles = "./files";

        Boolean salir = false;

        // Creamos el objeto files y log
        Files files = new Files(rutaFiles);
        Log log = new Log(rutaLog);

        System.out.println("hola\nhola");
        System.out.println("hola");

        // Creamos el menú interactivo que permite hacer operaciones
        while (!salir) {
            limpiarPantalla();
            System.out.println("prueba");
            sc.next();
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