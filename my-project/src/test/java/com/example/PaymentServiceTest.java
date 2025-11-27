package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.RegisterOrder.PaymentStatus;

public class PaymentServiceTest {

    //Given: Användaren vill betala
    //When: Transaktionen går igenom
    //Then: Visas status som betald
    @Test
    void paymentShouldSetStatusToPaidWhenSuccessful() {
        Order order = new Order();
        PaymentGateway gatewayMock = mock(PaymentGateway.class);
        when(gatewayMock.processPayment(order)).thenReturn(true);
        PaymentService service = new PaymentService(gatewayMock);
        service.pay(order);
        assertEquals(PaymentStatus.BETALD, order.getStatus());
        verify(gatewayMock).processPayment(order);
    }
    // Given: Användaren vill betala
    //When: Transaktionen går inte igenom
    //Then: Visas status som misslyckad

    @Test
    void paymentShouldSetStatusToFailedWhenFailed() {
        Order order = new Order();
        PaymentGateway gatewayMock = mock(PaymentGateway.class);
        when(gatewayMock.processPayment(order)).thenReturn(false);
        PaymentService service = new PaymentService(gatewayMock);
        service.pay(order);
        assertEquals(PaymentStatus.MISSLYCKAD, order.getStatus());
        verify(gatewayMock).processPayment(order);

    }
}
