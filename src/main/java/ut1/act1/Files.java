package ut1.act1;

import java.io.File;
import java.io.IOException;

public class Files {
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
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                System.err.println("No se pudo hacer la pausa de 1.5s");
            }
        }
    }
}
