package br.com.design.patterns.structural.adapter.weather;

public class WeatherApplication {
    public static void main(String[] args) {
        WeatherService weatherService = new WeatherServiceAdapter(new LegacyWeatherService());
        System.out.println("Temperature in Celsius: " + weatherService.getTemperatureInCelsius());
    }
}

interface WeatherService {
    double getTemperatureInCelsius();
}

class LegacyWeatherService {
    public double getTemperatureInFahrenheit() {
        return 77.0;
    }
}

// Adapting an incompatible WeatherService (interface)
class WeatherServiceAdapter implements WeatherService {

    private LegacyWeatherService legacyService;

    public WeatherServiceAdapter(LegacyWeatherService legacyService) {
        this.legacyService = legacyService;
    }
    @Override
    public double getTemperatureInCelsius() {
        double tempF = legacyService.getTemperatureInFahrenheit();
        return (tempF - 32) * 5 / 9; // Convert Fahrenheit to Celsius.
    }
}
