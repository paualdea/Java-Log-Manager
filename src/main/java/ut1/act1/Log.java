package ut1.act1;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {
    final private DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    final private File log;

    /**
     * Constructor de la clase que sirve para ir añadiendo registros al fichero de log de la aplicación.
     * Cuándo se cree un objeto de tipo Log, leera o creara el archivo.

     * @param ruta
     * Contiene la ruta del fichero de log
     */
    public Log (String ruta) {
        // Creamos un objeto de tipo File para la carpeta del log y un fichero que sera el log en sí
        File dirLog = new File(ruta);
        log = new File(dirLog, "log.txt");

        // Si no existe el directorio o fichero, crearlos
        String mensaje;
        if (!dirLog.exists()) {
            try {
                dirLog.mkdir();
                crearLog("escritura", true, "Se ha creado el directorio" + dirLog + " correctamente");
            } catch (Exception e) {
                mensaje = "No se ha podido crear el directorio " + dirLog;

                System.err.println(mensaje);
                crearLog("escritura", false, mensaje);
            }
        }

        // Ahora, comprobamos si existe el fichero de log
        if(!log.exists()) {
            try {
                log.createNewFile();
                crearLog("escritura", true, "Se ha creado el fichero " + log + " correctamente");
            }
            catch (IOException e) {
                mensaje = "No se ha podido crear el fichero " + log;

                System.err.println(mensaje);
                crearLog("escritura", false, mensaje);
            }
        }
    }

    /**
     * Esta función crea un log dentro del fichero de logs para determinar el estado de una acción sobre
     * el sistema de ficheros

     * @param operacion
     * Contiene el tipo de operación que se registra
     * @param resultado
     * Contiene un booleano de resultado
     * @param mensaje
     * Contiene el mensaje que va a ir junto al log
     */
    public void crearLog (String operacion, boolean resultado, String mensaje) {
        String estado;
        if (resultado) {
            estado = "completado";
        } else {
            estado = "fallido";
        }

        // Creamos el objeto que escribira en el log
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(this.log, true));
        } catch (IOException e) {
            System.err.println("No se ha podido crear el BufferedWriter");
        }

        // Obtenemos la hora actual y la formateamos correctamente
        // Variables para recopilar fecha y hora para añadir al log
        LocalDateTime horaActual = LocalDateTime.now();
        String hora = horaActual.format(FORMATO);

        String formatoLog =  hora + " | " + operacion + " | " + estado + " | " + mensaje + "\n";

        // Escribimos el log dentro del fichero de logs
        try {
            bw.write(formatoLog);
            bw.close();
        } catch (IOException e) {
            System.err.println("No se ha podido escribir en el log");
        }
    }
}
