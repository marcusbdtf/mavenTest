package com.example;

public interface PaymentGateway {
    boolean processPayment(Order order);
}

