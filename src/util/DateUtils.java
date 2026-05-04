package util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static String obtenerFechaActual() {
        LocalDate ahora = LocalDate.now();
        // Definimos un formato amigable: "dd/MM/yyyy"
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return ahora.format(formato);
    }
    public static String obtenerHoraActual() {
        LocalTime ahora = LocalTime.now();
        // Definimos un formato amigable: "HH:mm"
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
        return ahora.format(formato);
    }
}
