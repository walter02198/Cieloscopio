package dto;

import com.google.gson.annotations.SerializedName;

public record RainPrecipitacion(
        @SerializedName("1h") Double unaHora,
        @SerializedName("3h") Double tresHoras
) {
}
