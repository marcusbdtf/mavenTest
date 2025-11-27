package com.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
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
}
