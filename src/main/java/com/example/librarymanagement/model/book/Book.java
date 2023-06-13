package com.example.librarymanagement.model.book;

import com.example.librarymanagement.util.Enum.BookStatus;
import com.example.librarymanagement.util.Enum.PaymentStatus;

public class Book {

    private Long id;
    private String name;
    private Subject subject;
    private Writer writer;
    private Publisher publisher;
    private Long price;
    private BookStatus status;

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Writer getWriter() {
        return writer;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public boolean isBorrowed(){
        return this.status.equals(BookStatus.Borrowed);
    }
}
