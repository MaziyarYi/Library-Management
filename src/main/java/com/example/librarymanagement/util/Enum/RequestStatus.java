package com.example.librarymanagement.util.Enum;

public enum RequestStatus {
    Approved("Approved"), Pending("Pending") , Rejected("Rejected");

    private final String value;

    RequestStatus(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
