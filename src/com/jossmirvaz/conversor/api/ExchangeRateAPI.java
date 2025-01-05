package com.jossmirvaz.conversor.api;

import com.jossmirvaz.conversor.util.JsonUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class ExchangeRateAPI {
    private static final String API_KEY = "3a1cb3d0efaa7cb2810de613";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public Map<String, Double> getExchangeRates(String baseCurrency) throws IOException {
        String urlString = BASE_URL + API_KEY + "/latest/" + baseCurrency;
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try {
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) { // Éxito
                String jsonResponse = new String(connection.getInputStream().readAllBytes());
                ExchangeRateResponse response = JsonUtils.fromJson(jsonResponse, ExchangeRateResponse.class);
                return response.getConversionRates();
            } else { // Error en la respuesta
                System.err.println("Error al obtener tasas de cambio. Código HTTP: " + responseCode);
                throw new IOException("HTTP error: " + responseCode);
            }
        } catch (IOException e) {
            System.err.println("Error al conectar con la API: " + e.getMessage());
            throw e;
        } finally {
            connection.disconnect();
        }
    }
}




