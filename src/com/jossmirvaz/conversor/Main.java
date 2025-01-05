package com.jossmirvaz.conversor;

import com.jossmirvaz.conversor.service.CurrencyConverter;
import com.jossmirvaz.conversor.model.Currency;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter();
        int option;

        do {
            displayMenu();
            option = validateMenuOption(scanner);

            switch (option) {
                case 1 -> displayExchangeRates(converter);
                case 2 -> performConversion(scanner, converter);
                case 3 -> displayHistory(converter);
                case 5 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Entrada no válida. Por favor, ingresa un número correspondiente a una opción del menú.");
            }
        } while (option != 5);

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("===== Menú Principal =====");
        System.out.println("1. Consultar tasas de cambio");
        System.out.println("2. Convertir monedas");
        System.out.println("3. Mostrar historial de conversiones");
        System.out.println("5. Salir");
        System.out.print("Selecciona una opción: ");
    }

    private static int validateMenuOption(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada no válida. Por favor, ingresa un número correspondiente a una opción del menú.");
            System.out.print("Selecciona una opción: ");
            scanner.next(); // Descartar la entrada no válida
        }
        return scanner.nextInt();
    }

    private static void displayExchangeRates(CurrencyConverter converter) {
        System.out.println("===== Tasas de Cambio =====");
        converter.getExchangeRates().forEach((currency, rate) ->
                System.out.printf("%s: %.4f%n", currency, rate)
        );
    }

    private static void displaySupportedCurrencies() {
        System.out.println("===== Monedas Soportadas =====");
        System.out.println("USD - Dólar estadounidense");
        System.out.println("ARS - Peso argentino");
        System.out.println("BOB - Boliviano boliviano");
        System.out.println("BRL - Real brasileño");
        System.out.println("CLP - Peso chileno");
        System.out.println("COP - Peso colombiano");
    }

    private static Currency promptCurrency(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (true) {
            String input = scanner.next().toUpperCase();

            if (input.equalsIgnoreCase("jossmirvaz")) {
                System.out.println("¡Has encontrado el Easter egg! ;)");
                System.out.print(prompt); // Volver a pedir la entrada, sin mostrar las monedas nuevamente
                continue;
            }

            try {
                return Currency.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Moneda no válida. Intenta nuevamente.");
                System.out.print(prompt); // Volver a pedir la entrada, sin mostrar las monedas nuevamente
            }
        }
    }

    private static void performConversion(Scanner scanner, CurrencyConverter converter) {
        System.out.println("===== Monedas Soportadas =====");
        displaySupportedCurrencies(); // Mostrar monedas solo una vez al inicio
        Currency fromCurrency = promptCurrency(scanner, "Ingresa la moneda de origen (código): ");
        Currency toCurrency = promptCurrency(scanner, "Ingresa la moneda de destino (código): ");

        double amount = promptAmount(scanner, fromCurrency);
        double result = converter.convert(fromCurrency, toCurrency, amount);

        System.out.printf("%.2f %s son %.2f %s%n", amount, fromCurrency, result, toCurrency);
    }

    private static double promptAmount(Scanner scanner, Currency currency) {
        System.out.printf("Ingresa el monto a convertir (%s): ", currency);
        while (true) {
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            }

            String input = scanner.next();
            if (input.equalsIgnoreCase("jossmirvaz")) {
                System.out.println("¡Has encontrado el Easter egg! ;)");
                System.out.printf("Ingresa el monto a convertir (%s): ", currency); // Volver a pedir el monto
                continue;
            }

            System.out.println("Monto no válido. Intenta nuevamente.");
            System.out.printf("Ingresa el monto a convertir (%s): ", currency);
        }
    }

    private static void displayHistory(CurrencyConverter converter) {
        System.out.println("===== Historial de Conversiones =====");
        converter.getConversionHistory().forEach(System.out::println);
    }
}
