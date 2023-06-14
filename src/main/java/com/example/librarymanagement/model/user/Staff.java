package com.example.librarymanagement.model.user;

import javax.persistence.Entity;

@Entity
public class Staff extends User{

    private String staffId;

    public Staff() {
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }
}
