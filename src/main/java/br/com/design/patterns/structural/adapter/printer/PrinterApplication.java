package br.com.design.patterns.structural.adapter.printer;

public class PrinterApplication {
    public static void main(String[] args) {
        ColorfulPrinter printerAlpha = new LegacyPrinterAlphaAdapter(new LegacyPrinterAlpha());
        ColorfulPrinter printerBeta = new LegacyPrinterBetaAdapter(new LegacyPrinterBeta());

        printerAlpha.printWithColor("Adapter Pattern", "Blue");
        printerBeta.printWithColor("Hello, World!", "Red");
    }
}

interface ColorfulPrinter {
    void printWithColor(String message, String color);
}

class LegacyPrinterAlpha {
    public void printMessage(String message) {
        System.out.println("LegacyPrinterAlpha: " + message);
    }
}

class LegacyPrinterBeta {
    public void printMessage(String message) {
        System.out.println("LegacyPrinterBeta: " + message);
    }
}

// Adapting legacy printers to support color printing.
// (add common functionality to several existing subclasses
// that can't be added to the superclass)
class LegacyPrinterAlphaAdapter implements ColorfulPrinter {
    private final LegacyPrinterAlpha legacyPrinter;

    public LegacyPrinterAlphaAdapter(LegacyPrinterAlpha legacyPrinter) {
        this.legacyPrinter = legacyPrinter;
    }

    @Override
    public void printWithColor(String message, String color) {
        legacyPrinter.printMessage("[" + color + "] " + message);
    }
}

class LegacyPrinterBetaAdapter implements ColorfulPrinter {
    private final LegacyPrinterBeta legacyPrinter;

    public LegacyPrinterBetaAdapter(LegacyPrinterBeta legacyPrinter) {
        this.legacyPrinter = legacyPrinter;
    }

    @Override
    public void printWithColor(String message, String color) {
        legacyPrinter.printMessage("[" + color + "] " + message);
    }
}