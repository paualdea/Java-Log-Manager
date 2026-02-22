package ut1.act1;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {
    // Variables para recopilar fecha y hora para añadir al log
    private LocalDateTime horaActual;
    private DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private File dirLog, log;
    private String mensaje;

    /**
     * Constructor de la clase que sirve para ir añadiendo registros al fichero de log de la aplicación.
     * Cuándo se cree un objeto de tipo Log, leera o creara el archivo.
     *
     * Sólo recibe cómo parametro la ruta del directorio de logs.
     * @param ruta
     */
    public Log (String ruta) {
        // Creamos un objeto de tipo File para la carpeta del log y un fichero que sera el log en sí
        dirLog = new File(ruta);
        log = new File(dirLog, "log.txt");

        // Si no existe el directorio o fichero, crearlos
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
     *
     * Recibe cómo parámetros el tipo de operación, resultado de la operación y mensaje
     * de la operación si es que ocurre
     * @param operacion
     * @param resultado
     * @param mensaje
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
        horaActual = LocalDateTime.now();
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
