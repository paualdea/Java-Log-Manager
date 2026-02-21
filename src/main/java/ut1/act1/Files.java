package ut1.act1;

import java.io.File;

public class Files {
    public Files (String ruta) {
        // Creamos otro objeto de tipo File para la ruta de los ficheros que manejaremos
        File dirFiles = new File(ruta);

        // Si no existe el directorio o fichero, crearlos
        if (!dirFiles.exists()) {
            dirFiles.mkdir();
        }
    }
}
