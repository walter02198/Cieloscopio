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
    private Double precipitacion;

    public Clima(ClimaOpenWeatherMap dto) {
        this.nombre = dto.nombre();
        this.temperaturaActual = kelvinACelsius(dto.temp().temperaturaActual());
        if (dto.condicion() != null && !dto.condicion().isEmpty()) {
            this.condicionClimatica = dto.condicion().get(0).condicionClimatica();
        } else {
            System.out.println("Valor no informado");
        }
        this.fechaConsulta = DateUtils.obtenerFechaActual();
        this.horaConsulta = DateUtils.obtenerHoraActual();
        this.temperaturaMinima = kelvinACelsius(dto.temp().temperaturaMinima());
        this.temperaturaMaxima = kelvinACelsius(dto.temp().temperaturaMaxima());
        if (dto.prec() != null) {
            if (dto.prec().unaHora() != null) {
                this.precipitacion = dto.prec().unaHora();
            } else if (dto.prec().tresHoras() != null) {
                this.precipitacion = dto.prec().tresHoras();
            } else {
                this.precipitacion = null; // Si no hay objeto 'rain', es null
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getTemperaturaActual() {
        return String.format("%.2f", temperaturaActual);
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

        return String.format("%.2f", temperaturaMinima);
    }

    public String getTemperaturaMaxima() {
        return String.format("%.2f", temperaturaMaxima);
    }

    public String getPrecipitacion() {
        if (this.precipitacion == null) {
            return "Valor no informado";
        }
        return String.format("%.2f mm", precipitacion);
    }


    private double kelvinACelsius(double kelvin) {
        return kelvin - 273.15;
    }

    @Override
    public String toString() {
        return String.format("-----------------------------------------%nRespuesta:%n" +
                        "Ciudad: %s%nFecha: %s%nHorario: %s%n%nTemperatura Actual: %sºC%n" +
                        "Condicion climatica: %s%n%nTemperatura minima: %sºC%n" +
                        "Temperatura maxima: %sºC%nPrecipitacion: %s%n" +
                        "-----------------------------------------"
                , getNombre(), getFechaConsulta(), getHoraConsulta(), getTemperaturaActual()
                , getCondicionClimatica(), getTemperaturaMinima(), getTemperaturaMaxima()
                , getPrecipitacion());
    }
}
