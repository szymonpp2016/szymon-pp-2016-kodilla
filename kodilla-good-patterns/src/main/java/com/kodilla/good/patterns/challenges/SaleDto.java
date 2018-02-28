package com.kodilla.good.patterns.challenges;

class SaleDto {

    User user;
    private boolean isSold;

    SaleDto(User user, boolean isSold) {
        this.user = user;
        this.isSold = isSold;
    }
}
