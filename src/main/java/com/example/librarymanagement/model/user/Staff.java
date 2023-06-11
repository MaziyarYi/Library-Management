package com.example.librarymanagement.model.user;

import com.example.librarymanagement.model.account.UserAccount;
import com.example.librarymanagement.util.Enum.Gender;

public class Staff extends User{

    private int staffId;

    public Staff() {
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }
}
