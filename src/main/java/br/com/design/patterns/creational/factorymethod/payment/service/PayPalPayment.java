package br.com.design.patterns.creational.factorymethod.payment.service;

public class PayPalPayment implements PaymentMethod {

    @Override
    public void pay() {
        System.out.println("Paying by PayPal.");
    }
}