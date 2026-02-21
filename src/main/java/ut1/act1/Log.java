package ut1.act1;

import java.io.File;
import java.io.IOException;

public class Log {
    /**
     * Constructor de la clase que sirve para ir añadiendo registros al fichero de log de la aplicación.
     * Cuándo se cree un objeto de tipo Log, leera o creara el archivo.
     *
     * Sólo recibe cómo parametro la ruta del directorio de logs.
     * @param ruta
     */
    public Log (String ruta) {
        // Creamos un objeto de tipo File para la carpeta del log y un fichero que sera el log en sí
        File dirLog = new File(ruta);
        File log = new File(dirLog, "log.txt");

        // Si no existe el directorio o fichero, crearlos
        if (!dirLog.exists()) {
            dirLog.mkdir();
        }

        // Ahora, comprobamos si existe el fichero de log
        if(!log.exists()) {
            try {
                log.createNewFile();
            }
            catch (IOException e) {
                System.err.println("No se ha podido crear el fichero para los logs");
            }
        }
    }
}
