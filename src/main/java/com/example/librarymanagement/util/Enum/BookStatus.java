package com.example.librarymanagement.util.Enum;

public enum BookStatus {
    Available("Available"), Borrowed("Borrowed");

    private final String value;

    BookStatus(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
