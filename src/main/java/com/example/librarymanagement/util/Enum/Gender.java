package com.example.librarymanagement.util.Enum;

public enum Gender {
    Male("Male"), Female("Female");

    private final String value;

    Gender(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
