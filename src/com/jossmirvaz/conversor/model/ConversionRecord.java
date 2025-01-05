package com.jossmirvaz.conversor.model;

import java.time.LocalDateTime;

public class ConversionRecord {
    private final Currency fromCurrency;
    private final Currency toCurrency;
    private final double amount;
    private final double rate;
    private final LocalDateTime timestamp;

    public ConversionRecord(Currency fromCurrency, Currency toCurrency, double amount, double rate) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.amount = amount;
        this.rate = rate;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return String.format("[%s] %.2f %s -> %.2f %s (Tasa: %.4f)",
                timestamp, amount, fromCurrency, amount * rate, toCurrency, rate);
    }
}
