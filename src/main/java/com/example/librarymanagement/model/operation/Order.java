package com.example.librarymanagement.model.operation;

import com.example.librarymanagement.model.book.Book;
import com.example.librarymanagement.model.user.Member;
import com.example.librarymanagement.util.Enum.RequestStatus;

import java.util.Date;

public class Order {

    private Long id;
    private Member buyer;
    private Book book;
    private Date orderDate;
    private RequestStatus status;

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getBuyer() {
        return buyer;
    }

    public void setBuyer(Member buyer) {
        this.buyer = buyer;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
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
}
