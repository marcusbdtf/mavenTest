package com.example;
import java.util.ArrayList;
//
public class RegisterOrder 
{
    int orderNumber;
    boolean takeAway;
    int tableNumber;
    ArrayList<String> customerName = new ArrayList<>();
    ArrayList<String> orderItems = new ArrayList<>();

    public enum PaymentStatus {
    OBETALD,
    VÄNTAR,
    BETALD,
    MISSLYCKAD
}
public PaymentStatus status;

    public RegisterOrder(int orderNumber, boolean takeAway,
     PaymentStatus status
    ){
        this.orderNumber = orderNumber;
        this.takeAway = takeAway;
        this.status = PaymentStatus.OBETALD;
    }

}
