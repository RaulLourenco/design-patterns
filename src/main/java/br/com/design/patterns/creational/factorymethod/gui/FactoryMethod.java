package br.com.design.patterns.creational.factorymethod.gui;

abstract class Dialog {
    public abstract Button createButton();

    public void render() {
        Button button = createButton();
        button.render();
    }
}

class WindowsDialog extends Dialog {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}

class HTMLDialog extends Dialog {

    @Override
    public Button createButton() {
        return new HTMLButton();
    }
    
}

interface Button {
    void onClick();
    void render();
}

class WindowsButton implements Button {

    @Override
    public void onClick() {
        System.out.println("Windows button clicked!");
    }

    @Override
    public void render() {
        System.out.println("Hey!");
    }
    
}

class HTMLButton implements Button {

    @Override
    public void onClick() {
        System.out.println("HTML button clicked!");
    }

    @Override
    public void render() {
        System.out.println("Hello!");
    }
}

class FactoryMethod {
    private static Dialog dialog;

    private static void initialize() {
        String config = "Windows";

        if(config == "Windows") {
            dialog = new WindowsDialog();
        } else {
            dialog = new HTMLDialog();
        }
    }
    public static void main(String[] args) {
        initialize();
        dialog.render();
    }
}