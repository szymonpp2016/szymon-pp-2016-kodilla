package com.kodilla.patterns2.observer.forum;

public class ForumUser implements Observer {
    private final String username;
    private int updateCount;

    public ForumUser(String username) {
        this.username = username;
    }

    @Override
    public void update(ForumTopic forumTopic) {

        System.out.printf("%1$s: New messages in topic %2$s\n(total: %3$d %4$s)\n",
                username,
                forumTopic.getName(),
                forumTopic.getMessage().size(),
                forumTopic.getMessage().size() == 1 ? "message" : "messages");
        updateCount++;
    }

    public String getUsername() {
        return username;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}