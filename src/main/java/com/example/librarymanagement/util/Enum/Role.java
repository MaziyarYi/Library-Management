package com.example.librarymanagement.util.Enum;

public enum Role {
    Customer("Customer"), Staff("Staff") , Manager("Manager");

    private final String value;

    Role(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
