package ut1.act1;

// IMPORTS
import java.io.*;
import java.util.ArrayList;

public class Files {
    final private File dirFiles;
    final private String rutaLog = "./log";
    final private Log log = new Log(rutaLog);
    private String mensaje;

    public Files (String ruta) {
        // Creamos otro objeto de tipo File para la ruta de los ficheros que manejaremos
        dirFiles = new File(ruta);

        // Si no existe el directorio o fichero, crearlos
        if (!dirFiles.exists()) {
            try {
                dirFiles.mkdir();
                log.crearLog("escritura", true, "Se ha creado el directorio " + dirFiles + " correctamente");
            } catch (Exception e) {
                System.err.println("No se ha podido crear el directorio");
            }

        }
    }

    /**
     * Creamos una función que crea un nuevo archivo en la ruta ./files

     * @param nombre
     * Recibe como párametro el nombre del fichero de texto a crear
     */
    public void nuevoFichero (String nombre) {
        File nuevoFichero = new File(dirFiles, nombre+".txt");

        if (!nuevoFichero.exists()) {
            try {
                nuevoFichero.createNewFile();
                log.crearLog("escritura", true, "Se ha creado el fichero " + nuevoFichero + " correctamente");
            } catch (IOException e) {
                mensaje = "No se pudo crear el nuevo fichero " + nuevoFichero + ".txt";

                System.err.println(mensaje);
                log.crearLog("escritura", false, mensaje);
            }
        } else {
            System.out.println("El fichero " + nuevoFichero + ".txt, ya existe, no se creará");
            Main.espera();
        }
    }

    /**
     * Función que devuelve un numero entero en función de la cantidad de ficheros que haya en la carpeta del programa ./files
     *
     * @return numeroFicheros
     */
    public ArrayList<String> listarFicheros () {
        ArrayList<String> listaFicheros = new ArrayList<>();

        // Comprobamos que la ruta de los ficheros sea un directorio
        if (dirFiles.isDirectory()) {
            // Volcamos todos los archivos a un array de clase File
            File[] listaTemporal = dirFiles.listFiles();

            // Usamos un for para recorrer el array y añadir cada entrada al arraylist
            for (File file : listaTemporal) {
                // Comprobamos que la entrada del array sea un archivo
                if (file.isFile()){
                    listaFicheros.add(file.getName());
                }
            }
        } else {
            System.err.println("La ruta de archivos no es un directorio");
            Main.espera();
        }

        return listaFicheros;
    }

    /**
     * Esta función muestra por pantalla el contenido de un documento seleccionado

     * @param ruta
     * Contiene la ruta del fichero a mostrar
     * @param lista
     * El arraylist que contiene todos los ficheros del directorio ./files
     * @param opcion
     * Contiene la opción que ha seleccionado el usuario
     */
    public void mostrarFichero (String ruta, ArrayList<String> lista, String opcion) {
        // Obtenemos la ruta del fichero y creamos un bufferedReader
        File ficheroLeer = new File(ruta, lista.get(Integer.parseInt(opcion) - 1));
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(ficheroLeer));
        } catch (FileNotFoundException e) {
            System.err.println("Fichero no encontrado");
        }

        String linea;
        // Si la siguiente linea del documento no esta vacía, seguir imprimiendo
        try {
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            log.crearLog("lectura", true, "Se ha leido el fichero " + ficheroLeer + " correctamente");
        } catch (IOException e) {
            mensaje = "Error en la lectura del fichero a mostrar";

            System.err.println(mensaje);
            log.crearLog("lectura", false, mensaje);
        }
    }

    /**
     * Esta función elimina el fichero seleccionado por el usuario, pasado por parametro

     * @param ruta
     * Contiene la ruta del fichero a mostrar
     * @param lista
     * El arraylist que contiene todos los ficheros del directorio ./files
     * @param opcion
     * Contiene la opción que ha seleccionado el usuario
     */
    public void eliminarFichero (String ruta, ArrayList<String> lista, String opcion) {
        File ficheroBorrar = new File(ruta, lista.get(Integer.parseInt(opcion) - 1));

        // Eliminamos el fichero
        try {
            ficheroBorrar.delete();
            log.crearLog("borrado", true, "Fichero " + ficheroBorrar + " eliminado");
        } catch (Exception e) {
            mensaje = "Error al borrar el fichero" + ficheroBorrar;

            System.err.println(mensaje);
            log.crearLog("borrado", false, mensaje);
        }
    }
}
