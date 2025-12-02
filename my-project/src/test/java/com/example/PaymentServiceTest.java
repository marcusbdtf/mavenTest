package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.RegisterOrder.PaymentStatus;

public class PaymentServiceTest {
    //
    //Given: Användaren vill betala
    //When: Transaktionen går igenom
    //Then: Visas status som betald
    //
    @Test
    void SuccessfulPayment() {
        Order order = new Order();
        // Mockar PaymentGateway och simulerar att betalning alltid lyckas
        PaymentGateway gatewayMock = mock(PaymentGateway.class);
        when(gatewayMock.processPayment(order)).thenReturn(true); // mock: betalning lyckas
        PaymentService service = new PaymentService(gatewayMock);
        service.pay(order);
        assertEquals(PaymentStatus.BETALD, order.getStatus());
        verify(gatewayMock).processPayment(order); // verifierar att gateway anropas.
    }
}
