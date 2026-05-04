package view;

import model.Clima;
import service.ClimaService;

import java.util.Scanner;

public class IntroducirDatos {

    private Scanner teclado = new Scanner(System.in);
    private Integer opcion = -1;

    private final ClimaService service;

    public IntroducirDatos(ClimaService service) {
        this.service = service;
    }

    public void menu() {

        while (opcion != 7) {

            var menu = """
                    Challenge Cieloscopio:
                    --------------------------------------------------------
                    Elige una ciudad para obtener los datos meteorologicos:
                    1. Ciudad de Mexico
                    2. Buenos Aires
                    3. Bogota
                    4. Lima
                    5. Santiago
                    6. Deseo consultar otra ciudad 
                    7. Salir
                    --------------------------------------------------------
                    """;
            System.out.println(menu);
            if (teclado.hasNextInt()) {
                opcion = teclado.nextInt();
                teclado.nextLine();// Limpiamos el buffer SIEMPRE que sea un entero exitoso
                if (opcion >= 1 && opcion <= 7) {
                    switch (opcion) {
                        case 1 -> ejecutarConsulta("Mexico city");
                        case 2 -> ejecutarConsulta("Buenos Aires");
                        case 3 -> ejecutarConsulta("Bogota");
                        case 4 -> ejecutarConsulta("Lima");
                        case 5 -> ejecutarConsulta("Santiago");
                        case 6 -> {
                            System.out.println("Escribe el nombre de la ciudad:");
                            String ciudad = teclado.nextLine();
                            ejecutarConsulta(ciudad);
                        }
                        case 7 -> System.out.println("Saliendo del programa Cieloscopio, hasta luego...");
                        default -> System.out.println("Opción no válida");
                    }
                } else {
                    System.out.println("⚠️ Por favor, elige un número entre 1 y 7.");
                }
            } else {
                System.out.println("Opcion no valida");
                teclado.next();//consumimos el error del bucle para que continue
            }
        }
    }
    private void ejecutarConsulta(String nombreCiudad) {
        try {
            Clima clima = service.obtenerClimaPorCiudad(nombreCiudad);
            System.out.println(clima);
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}
