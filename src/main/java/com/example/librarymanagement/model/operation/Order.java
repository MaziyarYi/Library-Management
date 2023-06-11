package com.example.librarymanagement.model.operation;

import com.example.librarymanagement.util.Enum.RequestStatus;

import java.util.Date;

public class Order {

    private Long id;
    private Date orderDate;
    private RequestStatus status;
    private Payment payment;

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
