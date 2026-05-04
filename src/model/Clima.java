package model;

public class Clima {
    private String nombre;
    private String fechaConsulta;

    private double temperaturaActual;
    private String condicionClimatica;

    private double temperaturaMinima;
    private double temperaturaMaxima;
    private double humedad;

    public String getNombre() {
        return nombre;
    }

    public double getTemperaturaActual() {
        return temperaturaActual;
    }

    public String getCondicionClimatica() {
        return condicionClimatica;
    }

    public double getTemperaturaMinima() {
        return temperaturaMinima;
    }

    public double getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public double getHumedad() {
        return humedad;
    }
}
