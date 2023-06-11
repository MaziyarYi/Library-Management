package com.example.librarymanagement.model.book;

public class Publisher {

    private Long id;
    private String name;
    private String country;
    private Long publisherCode;

    public Publisher() {
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getPublisherCode() {
        return publisherCode;
    }

    public void setPublisherCode(Long publisherCode) {
        this.publisherCode = publisherCode;
    }
}
