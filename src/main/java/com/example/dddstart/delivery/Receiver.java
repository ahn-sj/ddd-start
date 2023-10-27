package com.example.dddstart.delivery;

import java.util.Objects;

public class Receiver {

    private String receiverName;
    private String receiverPhoneNumber;

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Receiver receiver = (Receiver) o;
        return Objects.equals(receiverName, receiver.receiverName) && Objects.equals(receiverPhoneNumber, receiver.receiverPhoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(receiverName, receiverPhoneNumber);
    }
}
