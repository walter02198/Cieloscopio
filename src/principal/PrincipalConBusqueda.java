package principal;

import com.google.gson.Gson;
import dto.ClimaOpenWeatherMap;
import model.Clima;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalConBusqueda {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner lectura = new Scanner(System.in);
        System.out.println("Escriba el nmbre de una ciudad: ");
        var busqueda = lectura.nextLine();

        String direccion = "https://api.openweathermap.org/data/2.5/weather?q="
                + busqueda.replace(" ","+") + "&APPID=Apikey";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        System.out.println(json);

        Gson gson = new Gson();
        ClimaOpenWeatherMap miClima= gson.fromJson(json, ClimaOpenWeatherMap.class);

        //System.out.println(miClima);

        Clima miClimita = new Clima(miClima);

        System.out.println(miClimita);


    }
}
