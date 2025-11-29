package com.example;

import com.example.RegisterOrder.PaymentStatus;

public class PaymentService { 

    private final PaymentGateway gateway;

    public PaymentService(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    public void pay(Order order) {

        boolean success = gateway.processPayment(order);

        if (success) {
            order.setStatus(PaymentStatus.BETALD);
        } else {
            order.setStatus(PaymentStatus.MISSLYCKAD);
        }
    }
}
