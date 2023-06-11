package com.example.librarymanagement.util.Enum;

public enum PaymentStatus {
    Paid("Paid"), Unpaid("Unpaid");

    private final String value;

    PaymentStatus(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
