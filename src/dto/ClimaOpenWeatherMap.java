package dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public record ClimaOpenWeatherMap(
        @SerializedName("name")
        String nombre,
        @SerializedName("main")
        MainTemperatura main,
        @SerializedName("weather")
        List<Tiempo> condicion
) {

}
