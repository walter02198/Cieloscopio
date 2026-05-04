package repository;

import com.google.gson.Gson;
import dto.ClimaOpenWeatherMap;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClimaApiClient implements IClimaRepository {

    private final String API_KEY = "c0cbd1c787c4b8f6e495732a58a9e29a";
    private final Gson gson = new Gson();

    @Override
    public ClimaOpenWeatherMap consultarClima(String ciudad) {
        var busquedaCiudad=ciudad.replace(" ","+");

        String url = "https://api.openweathermap.org/data/2.5/weather?q="
                +busquedaCiudad + "&appid=" + API_KEY;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            // Enviamos la petición
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            // Aquí es donde GSON hace su trabajo
            // Convierte el String JSON directamente en tu Record DTO
            String json = response.body();
            return gson.fromJson(json, ClimaOpenWeatherMap.class);

        } catch (Exception e) {
            // Lógica simple de manejo de errores
            throw new RuntimeException("Error al conectar con la API: " + e.getMessage());
        }
    }
}

