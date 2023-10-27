package com.example.dddstart.order;

public enum OrderState {
    PAYMENT_WAITING,
    PREPARING,
    SHIPPED,
    DELIVERING,
    DELIVERY_COMPLETED,
    CANCELED;
}