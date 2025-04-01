package br.com.design.patterns.behavioral.strategy.payment;

public class PaymentApplication {
    public static void main(String[] args) {
        // Process payment using Credit Card
        PaymentProcessor creditCard = new CreditCardProcessor("1234567812345678");
        PaymentService paymentService = new PaymentService(creditCard);
        paymentService.pay(150.00);

        // Switch to PayPal for payment
        PaymentProcessor payPal = new PayPalProcessor("customer@example.com");
        paymentService.setPaymentProcessor(payPal);
        paymentService.pay(150.00);
    }
}

// Strategy interface
interface PaymentProcessor {
    void processPayment(double amount);
}

// Concrete Strategy
class CreditCardProcessor implements PaymentProcessor {
    private String cardNumber;

    public CreditCardProcessor(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount + " for card ending with "
                + cardNumber.substring(cardNumber.length() - 4));
    }
}

class PayPalProcessor implements PaymentProcessor {
    private String email;

    public PayPalProcessor(String email) {
        this.email = email;
    }
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount + " for account " + email);
    }
}

// Context
class PaymentService {
    private PaymentProcessor paymentProcessor;

    public PaymentService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void setPaymentProcessor(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void pay(double amount) {
        paymentProcessor.processPayment(amount);
    }
}