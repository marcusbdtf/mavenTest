package com.example;
//
import com.example.RegisterOrder.PaymentStatus;

public class Order {
    private PaymentStatus status = PaymentStatus.OBETALD;

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }
}

