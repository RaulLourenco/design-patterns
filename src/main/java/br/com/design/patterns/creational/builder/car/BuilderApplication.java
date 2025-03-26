package br.com.design.patterns.creational.builder.car;

public class BuilderApplication {
    static void makeCar() {
        Director director = new Director();

        CarBuilder builder = new CarBuilder();
        director.constructSportsCar(builder);
        Car car = builder.getProduct();
        System.out.printf("This is the car %s\n", car);

        CarManualBuilder manualBuilder = new CarManualBuilder();
        director.constructSportsCar(manualBuilder);
        Manual manual = manualBuilder.getProduct();
        System.out.printf("This is the car's manual %s\n", manual);

        director.constructSUV(builder);
    }
    public static void main(String[] args) {
        makeCar();
    }
}

class Car {
    private int seats;

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Car{" +
                "seats=" + seats +
                '}';
    }
}
class Manual {
    private int seats;

    public void setSeats(int seats) {
        this.seats = seats;
    }
    @Override
    public String toString() {
        return "Manual{" +
                "seats=" + seats +
                '}';
    }
}
abstract class Builder {
    abstract void reset();
    abstract void setSeats(int seats);
    abstract void setEngine(String engine);
    abstract void setTripComputer(boolean tripComputer);
    abstract void setGPS(boolean gps);
}

class CarBuilder extends Builder {
    private Car car;

    CarBuilder() {
        this.reset();
    }
    @Override
    void reset() {
        this.car = new Car();
    }

    @Override
    void setSeats(int seats) {
        car.setSeats(seats);
    }

    @Override
    void setEngine(String engine) {}

    @Override
    void setTripComputer(boolean tripComputer) {}

    @Override
    void setGPS(boolean gps) {}

    public Car getProduct() {
        Car product = this.car;
        this.reset();
        return product;
    }
}

class CarManualBuilder extends Builder {
    private Manual manual;

    CarManualBuilder() {
        this.reset();
    }
    @Override
    void reset() {
        this.manual = new Manual();
    }

    @Override
    void setSeats(int seats) {
        manual.setSeats(seats);
    }

    @Override
    void setEngine(String engine) {}

    @Override
    void setTripComputer(boolean tripComputer) {}

    @Override
    void setGPS(boolean gps) {}

    public Manual getProduct() {
        Manual product = this.manual;
        this.reset();
        return product;
    }
}

class Director {
    void constructSportsCar(Builder builder) {
        builder.reset();
        builder.setSeats(2);
        builder.setEngine("Sport");
        builder.setTripComputer(true);
        builder.setGPS(true);
    }

    void constructSUV(Builder builder) {
        System.out.println("Creating SUV...");
    }
}
