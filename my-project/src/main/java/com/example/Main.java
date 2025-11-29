package com.example;

public class Main {

    public static void main(String[] args) {
        // Skapar en order
        Order order1 = new Order();
        Order order2 = new Order();

        // Skapar en PaymentGateway som simulerar lyckad betalning
        PaymentGateway successGateway = new PaymentGateway() {
            @Override
            public boolean processPayment(Order order) {
                return true; // alltid lyckad
            }
        };

        // Skapar en PaymentGateway som simulerar misslyckad betalning
        PaymentGateway failGateway = new PaymentGateway() {
            @Override
            public boolean processPayment(Order order) {
                return false; // alltid misslyckad
            }
        };

        // Betalning med lyckad gateway
        PaymentService service1 = new PaymentService(successGateway);
        service1.pay(order1);
        System.out.println("Order1 status (should be BETALD): " + order1.getStatus());

        // Betalning med misslyckad gateway
        PaymentService service2 = new PaymentService(failGateway);
        service2.pay(order2);
        System.out.println("Order2 status (should be MISSLYCKAD): " + order2.getStatus());
    }
}
