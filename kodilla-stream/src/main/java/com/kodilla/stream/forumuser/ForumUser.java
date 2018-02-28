package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public class ForumUser {

    private int userID;
    private String userName;
    private char userSex;
    private LocalDate birthDate;
    private int postNumber;

    public ForumUser(final String userName,final char userSex, final LocalDate birthDate, final int userID, final int postNumber ) {
        this.userID=userID;
        this.userName=userName;
        this.userSex=userSex;
        this.birthDate=birthDate;
        this.postNumber=postNumber;
    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public char getUserSex() {
        return userSex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPostNumber() {
        return postNumber;
    }

    @Override
    public String toString() {
        return "UserId: " + userID + '\'' +
                ", username='" + userName + '\'' +
                ", userSex=" + userSex + '\''+ ", birthDate=" + birthDate + '\''+
                ", postNumber='" + postNumber;
    }
}


