package service;

import dto.ClimaOpenWeatherMap;
import model.Clima;
import repository.IClimaRepository;

public class ClimaService {

    // Dependemos de la INTERFAZ, no de la implementación (Principio D de SOLID)
    private final IClimaRepository climaRepository;

    // Constructor que recibe el repositorio (Inyección de dependencias)
    public ClimaService(IClimaRepository climaRepository) {
        this.climaRepository = climaRepository;
    }
    /*
     * Este método es el corazon de la logica del negocio
     * Coordina el flujo: Pedir DTO -> Convertir a Model -> Retornar.
     */
    public Clima obtenerClimaPorCiudad(String ciudad) {
        // 1. Llamamos al repositorio para obtener los datos crudos (DTO)
        ClimaOpenWeatherMap dto = climaRepository.consultarClima(ciudad);

        // 2. Si el DTO es nulo o hay un error, aquí podrías gestionar la lógica
        if (dto == null || dto.nombre() == null) {
            throw new RuntimeException("No se encontró información para la ciudad: " + ciudad);
        }
        return new Clima(dto);
    }
}

