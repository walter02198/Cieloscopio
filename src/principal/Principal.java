package principal;

import model.Clima;
import repository.ClimaApiClient;
import repository.IClimaRepository;
import service.ClimaService;

public class Principal {

    public static void main(String[] args) {
        // 1. Instanciamos la infraestructura (el "motor" de datos)
        IClimaRepository repository = new ClimaApiClient();

// 2. Instanciamos el servicio y le "inyectamos" el repositorio
        ClimaService climaService = new ClimaService(repository);

// 3. Pedimos el clima (el Service nos devuelve un objeto Model listo)
        Clima miClima = climaService.obtenerClimaPorCiudad("Buenos Aires");

// 4. Mostramos el resultado (usando el toString que definiste)
        System.out.println(miClima);
    }
}
