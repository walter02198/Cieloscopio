package principal;

import model.Clima;
import repository.ClimaApiClient;
import repository.IClimaRepository;
import service.ClimaService;
import view.IntroducirDatos;

public class Principal {

    public static void main(String[] args) {
        // 1. Instanciamos la infraestructura (el "motor" de datos)
        IClimaRepository repository = new ClimaApiClient();

// 2. Instanciamos el servicio y le "inyectamos" el repositorio
        ClimaService climaService = new ClimaService(repository);

// 3. Instanciamos la Vista y le pasamos el Service
        IntroducirDatos app = new IntroducirDatos(climaService);

// 4. ¡Arrancamos!
        app.menu();
    }
}
