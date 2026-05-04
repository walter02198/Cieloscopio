package repository;

import dto.ClimaOpenWeatherMap;

public interface IClimaRepository {

    ClimaOpenWeatherMap consultarClima(String ciudad);
}
