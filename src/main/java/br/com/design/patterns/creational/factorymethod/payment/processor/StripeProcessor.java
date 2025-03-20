package br.com.design.patterns.creational.factorymethod.payment.processor;

import br.com.design.patterns.creational.factorymethod.payment.service.PaymentMethod;
import br.com.design.patterns.creational.factorymethod.payment.service.StripePayment;

public class StripeProcessor extends PaymentProcessor {

    @Override
    public PaymentMethod createPaymentMethod() {
        return new StripePayment();
    }
}