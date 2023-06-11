package com.example.librarymanagement.model.operation;

import com.example.librarymanagement.util.Enum.PaymentStatus;

public class Payment {

    private Long id;
    private PaymentStatus status;
    private Long price;

    public Payment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public boolean isPaid(){
        return this.status.equals(PaymentStatus.Paid);
    }
}
