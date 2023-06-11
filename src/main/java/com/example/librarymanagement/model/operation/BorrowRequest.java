package com.example.librarymanagement.model.operation;

import com.example.librarymanagement.model.book.Book;
import com.example.librarymanagement.model.user.Member;
import com.example.librarymanagement.util.Enum.RequestStatus;

import java.util.Date;

public class BorrowRequest {

    private Long id;
    private Member borrower;
    private Book book;
    private Date fromDate;
    private Date toDate;
    private Long period;
    private RequestStatus status ;

    public BorrowRequest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getBorrower() {
        return borrower;
    }

    public void setBorrower(Member borrower) {
        this.borrower = borrower;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Long getPeriod() {
        return period;
    }

    public void setPeriod(Long period) {
        this.period = period;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }
}
