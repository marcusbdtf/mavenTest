package com.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import com.example.RegisterOrder.PaymentStatus;

public class FailedPaymentTest {
    //
    // Given: Användaren vill betala
    // When: Transaktionen misslyckas
    // Then: Visas status som misslyckad
    //
    @Test
    void FailedPayment() {
        Order order = new Order();
        // Mockar PaymentGateway och simulerar att betalning alltid misslyckas
        PaymentGateway gatewayMock = mock(PaymentGateway.class);
        when(gatewayMock.processPayment(order)).thenReturn(false); // mock: betalning misslyckas

        PaymentService service = new PaymentService(gatewayMock);
        service.pay(order);

        assertEquals(PaymentStatus.MISSLYCKAD, order.getStatus());
        verify(gatewayMock).processPayment(order); // verifierar att gateway anropas
    }

}
