package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Forum {

    final List<ForumUser> theUserList = new ArrayList<>();

    List<ForumUser> forumUser = new ArrayList<>();

    public Forum() {
        theUserList.add(new ForumUser("Dylan Murphy", 'M', LocalDate.of(2003, 10, 10), 11, 10));

        theUserList.add(new ForumUser("Phoebe Pearson", 'M',
                LocalDate.of(2012, 10, 10), 2, 30));

        theUserList.add(new ForumUser("Morgan Walsh", 'M',
                LocalDate.of(2001, 10, 10), 3, 25));

        theUserList.add(new ForumUser("Aimee Murphy", 'M',
                LocalDate.of(2015, 10, 10), 4, 0));
        theUserList.add(new ForumUser("Ryan Talley", 'F',
                LocalDate.of(2007, 7, 7), 5, 55));
        theUserList.add(new ForumUser("Madelynn Carson", 'F',
                LocalDate.of(2007, 12, 12), 6, 45));
        theUserList.add(new ForumUser("Giancarlo Guerrero", 'M',
                LocalDate.of(2009, 10, 10), 7, 35));
    }

    public List<ForumUser> getTheUserList() {
        return new ArrayList<>(theUserList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Forum forum = (Forum) o;
        return Objects.equals(forumUser, forum.forumUser);
    }

    @Override
    public int hashCode() {

        return Objects.hash(forumUser);
    }
}
