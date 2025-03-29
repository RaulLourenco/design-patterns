package br.com.design.patterns.structural.decorator.window;

public class WindowApplication {
    public static void main(String[] args) {
        Window window = new SimpleWindow();
        System.out.println(window.getDescription());
        window.draw();

        System.out.println("\nDecorating window with vertical scrollbar");
        window = new VerticalScrollBarDecorator(window);
        System.out.println(window.getDescription());
        window.draw();

        System.out.println("\nDecorating window with horizontal scrollbar");
        window = new HorizontalScrollBarDecorator(window);
        System.out.println(window.getDescription());
        window.draw();
    }
}

// Component
interface Window {
    void draw();
    String getDescription();
}

// Concrete component
class SimpleWindow implements Window {
    @Override
    public void draw() {
        System.out.println("Drawing simple window.");
    }

    @Override
    public String getDescription() {
        return "Simple Window";
    }
}

// The Decorator abstract class
abstract class WindowDecorator implements Window {
    protected Window decoratedWindow;

    public WindowDecorator(Window decoratedWindow) {
        this.decoratedWindow = decoratedWindow;
    }

    @Override
    public void draw() {
        decoratedWindow.draw();
    }

    @Override
    public String getDescription() {
        return decoratedWindow.getDescription();
    }
}

// Concrete Decorator
class VerticalScrollBarDecorator extends WindowDecorator {
    public VerticalScrollBarDecorator(Window decoratedWindow) {
        super(decoratedWindow);
    }

    @Override
    public void draw() {
        super.draw();
        drawVerticalScrollBar();
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with vertical scrollbar";
    }

    private void drawVerticalScrollBar() {
        System.out.println("Adding vertical scrollbar.");
    }
}

class HorizontalScrollBarDecorator extends WindowDecorator {
    public HorizontalScrollBarDecorator(Window decoratedWindow) {
        super(decoratedWindow);
    }

    @Override
    public void draw() {
        super.draw();
        drawHorizontalScrollBar();
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with horizontal scrollbar";
    }

    private void drawHorizontalScrollBar() {
        System.out.println("Adding horizontal scrollbar.");
    }
}