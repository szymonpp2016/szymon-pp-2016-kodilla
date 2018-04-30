package com.kodilla.patterns2.observer.homework;

import lombok.Getter;

@Getter
class Student {
    private String userName;
    private String kursKode;

    Student(String userName, String kursKode) {
        this.userName = userName;
        this.kursKode = kursKode;
    }
}
