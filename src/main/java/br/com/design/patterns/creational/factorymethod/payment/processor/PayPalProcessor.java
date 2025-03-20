package br.com.design.patterns.creational.factorymethod.payment.processor;

import br.com.design.patterns.creational.factorymethod.payment.service.PayPalPayment;
import br.com.design.patterns.creational.factorymethod.payment.service.PaymentMethod;

public class PayPalProcessor extends PaymentProcessor {

    @Override
    public PaymentMethod createPaymentMethod() {
        return new PayPalPayment();
    }
}