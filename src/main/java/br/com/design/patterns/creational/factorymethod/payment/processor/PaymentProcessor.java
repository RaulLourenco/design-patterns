package br.com.design.patterns.creational.factorymethod.payment.processor;

import br.com.design.patterns.creational.factorymethod.payment.service.PaymentMethod;

public abstract class PaymentProcessor {
    public abstract PaymentMethod createPaymentMethod();

    public void process() {
        PaymentMethod pm = createPaymentMethod();
        pm.pay();
    };
}