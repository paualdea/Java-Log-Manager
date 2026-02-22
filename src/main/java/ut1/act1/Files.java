package ut1.act1;

// IMPORTS
import java.io.*;
import java.util.ArrayList;

public class Files {
    public static final int TIEMPO_ESPERA = 1250;

    private File dirFiles;

    public Files (String ruta) {
        // Creamos otro objeto de tipo File para la ruta de los ficheros que manejaremos
        dirFiles = new File(ruta);

        // Si no existe el directorio o fichero, crearlos
        if (!dirFiles.exists()) {
            dirFiles.mkdir();
        }
    }

    /**
     * Creamos una función que crea un nuevo archivo en la ruta ./files
     *
     * Recibe como párametro el nombre del fichero de texto a crear
     * @param nombre
     */
    public void nuevoFichero (String nombre) {
        File nuevoFichero = new File(dirFiles, nombre+".txt");

        if (!nuevoFichero.exists()) {
            try {
                nuevoFichero.createNewFile();
            } catch (IOException e) {
                System.err.println("No se pudo crear el nuevo fichero " + nuevoFichero + ".txt");
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
        ArrayList<String> listaFicheros = new ArrayList<String>();

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
     *
     * Recibe cómo parametro el numero de documento, que se quiere leer
     * @param opcion
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
        } catch (IOException e) {
            System.err.println("Error en la lectura del fichero a mostrar");
        }
    }
}
