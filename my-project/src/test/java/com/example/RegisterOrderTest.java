package com.example;

import org.junit.jupiter.api.Test;

import com.example.RegisterOrder.PaymentStatus;

import static org.junit.jupiter.api.Assertions.*;


// Given en ny beställning
// When beställningen registreras
// Then status = OBETALD

class RegisterOrderTest {

    @Test
    void RegisterUnpaidOrder() {
        RegisterOrder regOrder = new RegisterOrder(
            18,true, PaymentStatus.OBETALD);

        assertEquals(PaymentStatus.OBETALD, regOrder.status);
    }
}





