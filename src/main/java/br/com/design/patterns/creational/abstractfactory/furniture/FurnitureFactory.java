package br.com.design.patterns.creational.abstractfactory.furniture;

class Application {
    public static void main(String[] args) {
        FurnitureFactory factory;
        String furnitureStyle = "Victorian";

        if(furnitureStyle.equals("Modern")) {
            factory = new ModernFactory();
        } else {
            factory = new VictorianFactory();
        }

        Sofa sofa = factory.createSofa();
        Chair chair = factory.createChair();

        sofa.lieOn();
        chair.sitOn();
    }
}

abstract class FurnitureFactory {
    abstract Sofa createSofa();
    abstract Chair createChair();
}

class ModernFactory extends FurnitureFactory {
    @Override
    Sofa createSofa() {
        return new ModernSofa();
    }

    @Override
    Chair createChair() {
        return new ModernChair();
    }
}

class VictorianFactory extends FurnitureFactory {
    @Override
    Sofa createSofa() {
        return new VictorianSofa();
    }

    @Override
    Chair createChair() {
        return new VictorianChair();
    }
}

interface Sofa {
    void lieOn();
}

class ModernSofa implements Sofa {
    @Override
    public void lieOn() {
        System.out.println("Lying down on a Modern sofa.");
    }
}

class VictorianSofa implements Sofa {
    @Override
    public void lieOn() {
        System.out.println("Lying down on a Victorian sofa.");
    }
}

interface Chair {
    void sitOn();
}

class ModernChair implements Chair {
    @Override
    public void sitOn() {
        System.out.println("Sitting on a Modern chair.");
    }
}

class VictorianChair implements Chair {
    @Override
    public void sitOn() {
        System.out.println("Sitting on a Victorian chair.");
    }
}