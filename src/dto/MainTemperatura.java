package dto;

import com.google.gson.annotations.SerializedName;

public record MainTemperatura(
        @SerializedName("temp")
        double temperaturaActual,
        @SerializedName("temp_min")
        double temperaturaMinima,
        @SerializedName("temp_max")
        double temperaturaMaxima
) {
}
