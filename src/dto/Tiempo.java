package dto;


import com.google.gson.annotations.SerializedName;

public record Tiempo(
        @SerializedName("description")
        String condicionClimatica
) {
}
