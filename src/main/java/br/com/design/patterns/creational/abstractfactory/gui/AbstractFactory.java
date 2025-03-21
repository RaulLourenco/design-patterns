package br.com.design.patterns.creational.abstractfactory.gui;

public class AbstractFactory {
    private static GUIFactory factory;
    static void initialize() {
        String UIChoice = "Mac";

        if(UIChoice.equals("Windows")) {
            factory = new WinFactory();
        } else {
            factory = new MacFactory();
        }
    }
    public static void main(String[] args) {
        initialize();
        Application application = new Application(factory);
        application.createUI();
        application.paint();
    }
}

class Application {
    private GUIFactory factory;
    private Button button;
    private Checkbox checkbox;

    Application(GUIFactory factory) {
        this.factory = factory;
    }

    void createUI() {
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
    }

    void paint() {
        button.paint();
        checkbox.paint();
    }
}

abstract class GUIFactory {
    abstract Button createButton();
    abstract Checkbox createCheckbox();
}

class WinFactory extends GUIFactory {

    @Override
    Button createButton() {
        return new WinButton();
    }

    @Override
    Checkbox createCheckbox() {
        return new WinCheckbox();
    }
}

class MacFactory extends GUIFactory {

    @Override
    Button createButton() {
        return new MacButton();
    }

    @Override
    Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

interface Button {
    void paint();
}

class WinButton implements Button {

    @Override
    public void paint() {
        System.out.println("Button with Windows style.");
    }
}

class MacButton implements Button {

    @Override
    public void paint() {
        System.out.println("Button with Mac style.");
    }
}
interface Checkbox {
    void paint();
}

class WinCheckbox implements Checkbox {

    @Override
    public void paint() {
        System.out.println("Checkbox with Windows style.");
    }
}

class MacCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Checkbox with Mac style.");
    }
}