package com.kodilla.good.patterns.food2door;

import java.util.Objects;

public class Admin {

    private String userName;

    Admin(final String userName ) {
        this.userName = userName;
    }
    public String getUserName() {
        return userName;
    }

}
