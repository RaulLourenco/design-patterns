package br.com.design.patterns.creational.factorymethod.payment;

class PaymentFactory {
    private static PaymentProcessor paymentProcessor;

    static void initialize() {
        String paymentChoice = "Stripe";

        if(paymentChoice.equals("PayPal")) {
            paymentProcessor = new PayPalProcessor();
        } else {
            paymentProcessor = new StripeProcessor();
        }
    }

    public static void main(String[] args) {
        initialize();
        paymentProcessor.process();
    }
}

abstract class PaymentProcessor {
    public abstract PaymentMethod createPaymentMethod();

    public void process() {
        PaymentMethod pm = createPaymentMethod();
        pm.pay();
    };
}

class PayPalProcessor extends PaymentProcessor {

    @Override
    public PaymentMethod createPaymentMethod() {
        return new PayPalPayment();
    }
}

class StripeProcessor extends PaymentProcessor {

    @Override
    public PaymentMethod createPaymentMethod() {
        return new StripePayment();
    }
}

interface PaymentMethod {
    void pay();
}

class PayPalPayment implements PaymentMethod {

    @Override
    public void pay() {
        System.out.println("Paying by PayPal.");
    }
}

class StripePayment implements PaymentMethod {

    @Override
    public void pay() {
        System.out.println("Paying by Stripe");
    }
}