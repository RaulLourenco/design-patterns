package br.com.design.patterns.behavioral.observer.weatherstation;

import java.util.ArrayList;
import java.util.List;

public class WeatherStationApplication {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();

        WeatherObserver display = new DisplayDevice("Display");
        WeatherObserver anotherDisplay = new DisplayDevice("Another Display");

        station.registerObserver(display);
        station.registerObserver(anotherDisplay);

        // Simulate new weather measurements
        station.setMeasurements(25.3f, 60.0f);
        station.setMeasurements(26.7f, 55.0f);
    }
}

// Observer interface
interface WeatherObserver {
    void update(float temperature, float humidity);
}

// Subject (Observable) interface
interface WeatherSubject {
    void registerObserver(WeatherObserver observer);
    void removeObserver(WeatherObserver observer);
    void notifyObservers();
}

// Concrete Subject
class WeatherStation implements WeatherSubject {
    private List<WeatherObserver> observers;
    private float temperature;
    private float humidity;

    public WeatherStation() {
        observers = new ArrayList<>();
    }
    @Override
    public void registerObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(temperature, humidity);
        }
    }

    // Method to update weather data
    public void setMeasurements(float temperature, float humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        notifyObservers();
    }
}

// Concrete Observer
class DisplayDevice implements WeatherObserver {
    private String name;

    public DisplayDevice(String name) {
        this.name = name;
    }
    @Override
    public void update(float temperature, float humidity) {
        System.out.println(name + " received update -> Temperature: "
                + temperature + ", Humidity: " + humidity);
    }
}