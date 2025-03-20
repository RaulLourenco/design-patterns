package br.com.design.patterns.creational.factorymethod.payment.factory;

import br.com.design.patterns.creational.factorymethod.payment.processor.PayPalProcessor;
import br.com.design.patterns.creational.factorymethod.payment.processor.PaymentProcessor;
import br.com.design.patterns.creational.factorymethod.payment.processor.StripeProcessor;

//Structured using Clean Architecture style with processor, service and factory modules
public class PaymentFactory {
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