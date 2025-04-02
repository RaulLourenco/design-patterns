package br.com.design.patterns.behavioral.templatemethod.beverage;

public class BeverageApplication {
    public static void main(String[] args) {
        System.out.println("Preparing tea:");
        CaffeineBeverage tea = new Tea();
        tea.prepareRecipe();

        System.out.println("\nPreparing coffee:");
        CaffeineBeverage coffee = new Coffee();
        coffee.prepareRecipe();
    }
}

// Abstract class defining the template method
abstract class CaffeineBeverage {
    // Template method; marked final to prevent overriding
    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    // Steps with common implementation
    private void boilWater() {
        System.out.println("Boiling water");
    }
    private void pourInCup() {
        System.out.println("Pouring into cup");
    }

    // Steps to be implemented by subclasses
    abstract void brew();
    abstract void addCondiments();
}

// Concrete subclass
class Tea extends CaffeineBeverage {
    @Override
    public void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    public void addCondiments() {
        System.out.println("Adding lemon");
    }
}

class Coffee extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println("Dripping coffee through filter");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding sugar and milk");
    }
}