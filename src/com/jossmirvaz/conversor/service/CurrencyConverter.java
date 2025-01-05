package com.jossmirvaz.conversor.service;

import com.jossmirvaz.conversor.api.ExchangeRateAPI;
import com.jossmirvaz.conversor.model.ConversionRecord;
import com.jossmirvaz.conversor.model.Currency;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CurrencyConverter {
    private final ExchangeRateAPI exchangeRateAPI;
    private final Map<Currency, Double> exchangeRates;
    private final List<ConversionRecord> conversionHistory;

    public CurrencyConverter() {
        this.exchangeRateAPI = new ExchangeRateAPI();
        this.exchangeRates = new HashMap<>();
        this.conversionHistory = new ArrayList<>();
        loadExchangeRates(Currency.USD);
    }

    private void loadExchangeRates(Currency baseCurrency) {
        try {
            Map<String, Double> rates = exchangeRateAPI.getExchangeRates(baseCurrency.name());
            for (Currency currency : Currency.values()) {
                if (rates.containsKey(currency.name())) {
                    exchangeRates.put(currency, rates.get(currency.name()));
                }
            }
        } catch (IOException e) {
            System.err.println("Error al cargar las tasas de cambio: " + e.getMessage());
        }
    }

    public double convert(Currency fromCurrency, Currency toCurrency, double amount) {
        if (!exchangeRates.containsKey(fromCurrency) || !exchangeRates.containsKey(toCurrency)) {
            throw new IllegalArgumentException("Moneda no soportada.");
        }

        double rate = exchangeRates.get(toCurrency) / exchangeRates.get(fromCurrency);
        double result = amount * rate;

        // Registrar la conversión
        conversionHistory.add(new ConversionRecord(fromCurrency, toCurrency, amount, rate));
        return result;
    }

    public Map<Currency, Double> getExchangeRates() {
        return exchangeRates;
    }

    public List<ConversionRecord> getConversionHistory() {
        return new ArrayList<>(conversionHistory);
    }
}
