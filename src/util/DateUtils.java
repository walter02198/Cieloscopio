package util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static String obtenerFechaHoraActual() {
        LocalDateTime ahora = LocalDateTime.now();
        // Definimos un formato amigable: "dd/MM/yyyy HH:mm"
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return ahora.format(formato);
    }
}
