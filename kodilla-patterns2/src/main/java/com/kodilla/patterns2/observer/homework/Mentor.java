package com.kodilla.patterns2.observer.homework;

public class Mentor implements MentorObserver {
    private final String username;
    private int updateCount;

    Mentor(String username) {
        this.username = username;
    }


    public String getUsername() {
        return username;
    }

    public int getUpdateCount() {
        return updateCount;
    }

    @Override
    public void update(TaskToChack taskToChack) {
        System.out.printf("\n %1$s: you have new task to check %2$s \n %3$s \n (total task to check!!!: %4$d %5$s)\n",
                username,
                taskToChack.getName(),
                taskToChack.getMessage(),
                taskToChack.getMessage().size(),
                taskToChack.getMessage().size() == 1 ? "task" : "tasks");
        updateCount++;
    }
}