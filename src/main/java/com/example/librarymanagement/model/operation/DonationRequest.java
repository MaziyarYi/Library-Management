package com.example.librarymanagement.model.operation;

import com.example.librarymanagement.model.book.Book;
import com.example.librarymanagement.model.user.Member;
import com.example.librarymanagement.util.Enum.RequestStatus;

import javax.persistence.*;
import java.util.Date;

@Entity
public class DonationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    private Member donator;

    @ManyToOne
    private Book book;

    private Date donationDate;
    private RequestStatus status ;

    public DonationRequest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getDonator() {
        return donator;
    }

    public void setDonator(Member donator) {
        this.donator = donator;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(Date donationDate) {
        this.donationDate = donationDate;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }
}
