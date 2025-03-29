package br.com.design.patterns.structural.decorator.beverage;

public class BeverageApplication {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage anotherBeverage = new HouseBlend();
        anotherBeverage = new Milk(anotherBeverage);
        anotherBeverage = new Mocha(anotherBeverage);
        System.out.println(anotherBeverage.getDescription() + " $" + anotherBeverage.cost());
    }
}

// Component
abstract class Beverage {
    String description = "Unknown beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}

// Concrete component
class Espresso extends Beverage {
    public Espresso() {
        description = "Espresso";
    }
    @Override
    public double cost() {
        return 1.99;
    }
}

class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "House Blend coffee";
    }
    @Override
    public double cost() {
        return 0.89;
    }
}

// The Decorator abstract class
abstract class CondimentDecorator extends Beverage {
    public abstract String getDescription();
}

// Concrete Decorator
class Milk extends CondimentDecorator {
    private Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }
    @Override
    public double cost() {
        return beverage.cost() + 0.20;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }
}

class Mocha extends CondimentDecorator {
    private Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }
    @Override
    public double cost() {
        return beverage.cost() + 0.50;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }
}