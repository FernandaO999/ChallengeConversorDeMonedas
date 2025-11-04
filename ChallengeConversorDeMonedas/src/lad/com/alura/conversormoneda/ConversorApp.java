package lad.com.alura.conversormoneda;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConversorApp {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        int opcion;

        System.out.println("=====================================");
        System.out.println("🌎  Sea bienvenido/a al Conversor de Monedas 💱");
        System.out.println("=====================================");

        do {
            System.out.println("\nMenú principal:");
            System.out.println("1. Convertir moneda");
            System.out.println("2. Mostrar tasa entre varias monedas");
            System.out.println("0. Salir");
            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> convertirMoneda(sc);
                case 2 -> mostrarTasas(sc);
                case 0 -> System.out.println("Gracias por usar el conversor. ¡Hasta luego! 👋");
                default -> System.out.println("Opción inválida. Intente nuevamente.");
            }

        } while (opcion != 0);
    }

    private static void convertirMoneda(Scanner sc) throws IOException, InterruptedException {
        System.out.println("\nSeleccione la moneda base:");
        String base = seleccionarMoneda(sc);

        System.out.println("\nSeleccione la moneda destino:");
        String destino = seleccionarMoneda(sc);

        System.out.print("Ingrese el monto a convertir: ");
        double monto = sc.nextDouble();

        double tasa = obtenerTasa(base, destino);
        double resultado = monto * tasa;

        System.out.println("\n💱 Tasa de cambio: 1 " + base + " = " + tasa + " " + destino);
        System.out.println("💰 Resultado: " + resultado + " " + destino);
    }

    private static void mostrarTasas(Scanner sc) throws IOException, InterruptedException {
        System.out.println("\nSeleccione la moneda base:");
        String base = seleccionarMoneda(sc);

        String[] monedas = {"ARS", "BOB", "BRL", "CLP", "COP", "USD"};

        System.out.println("\nTasas de cambio desde " + base + ":");
        for (String destino : monedas) {
            if (!destino.equals(base)) {
                double tasa = obtenerTasa(base, destino);
                System.out.println(" - " + base + " → " + destino + ": " + tasa);
            }
        }
    }

    private static String seleccionarMoneda(Scanner sc) {
        System.out.println("""
                1. ARS - Peso argentino
                2. BOB - Boliviano boliviano
                3. BRL - Real brasileño
                4. CLP - Peso chileno
                5. COP - Peso colombiano
                6. USD - Dólar estadounidense
                """);
        System.out.print("Ingrese el número de la moneda: ");
        int opcion = sc.nextInt();

        return switch (opcion) {
            case 1 -> "ARS";
            case 2 -> "BOB";
            case 3 -> "BRL";
            case 4 -> "CLP";
            case 5 -> "COP";
            case 6 -> "USD";
            default -> {
                System.out.println("Opción inválida, se usará USD por defecto.");
                yield "USD";
            }
        };
    }

    public static double obtenerTasa(String base, String destino) throws IOException, InterruptedException {
        String apiKey = "5f86efbce273ff851a6f047d";
        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + base + "/" + destino;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        JsonElement elemento = JsonParser.parseString(response.body());
        JsonObject objeto = elemento.getAsJsonObject();
        return objeto.get("conversion_rate").getAsDouble();
    }
}



