package com.jossmirvaz.conversor.service;

import com.jossmirvaz.conversor.model.Currency;

import java.util.Map;

public interface CurrencyService {
    Map<Currency, Double> getExchangeRates();

    double convert(Currency fromCurrency, Currency toCurrency, double amount);
}
