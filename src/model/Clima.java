package model;

import dto.ClimaOpenWeatherMap;
import util.DateUtils;

public class Clima {
    private String nombre;
    private String fechaConsulta;

    private String horaConsulta;

    private double temperaturaActual;
    private String condicionClimatica;

    private double temperaturaMinima;
    private double temperaturaMaxima;
    private double humedad;

    public Clima(ClimaOpenWeatherMap dto) {
        this.nombre = dto.nombre();
        this.temperaturaActual=kelvinACelsius(dto.temp().temperaturaActual());
        if (dto.condicion() != null && !dto.condicion().isEmpty()) {
            this.condicionClimatica = dto.condicion().get(0).condicionClimatica();
        }
        this.fechaConsulta= DateUtils.obtenerFechaActual();
        this.horaConsulta=DateUtils.obtenerHoraActual();
        this.temperaturaMinima =kelvinACelsius(dto.temp().temperaturaMinima()) ;
        this.temperaturaMaxima=kelvinACelsius(dto.temp().temperaturaMaxima());
        this.humedad = dto.temp().humedad();
    }

    public String getNombre() {
        return nombre;
    }

    public String getTemperaturaActual() {
        return String.format("%.2f",temperaturaActual);
    }

    public String getCondicionClimatica() {
        return condicionClimatica;
    }

    public String getFechaConsulta() {
        return fechaConsulta;
    }

    public String getHoraConsulta() {
        return horaConsulta;
    }

    public String getTemperaturaMinima() {

        return String.format("%.2f",temperaturaMinima);
    }

    public String getTemperaturaMaxima() {
        return String.format("%.2f",temperaturaMaxima);
    }

    public double getHumedad() {
        return humedad;
    }

    private double kelvinACelsius(double kelvin) {
        return kelvin - 273.15;
    }

    @Override
    public String toString() {
        return String.format("-----------------------------------------%nRespuesta:%n" +
                "Ciudad: %s%nFecha: %s%nHorario: %s%n%nTemperatura Actual: %sºC%n" +
                        "Condicion climatica: %s%n%nTemperatura minima: %sºC%n" +
                        "Temperatura maxima: %sºC%nHumedad: %.1f%%%n" +
                        "-----------------------------------------"
                ,getNombre(),getFechaConsulta(),getHoraConsulta(),getTemperaturaActual()
        ,getCondicionClimatica(),getTemperaturaMinima(),getTemperaturaMaxima()
        ,getHumedad());
    }
}
