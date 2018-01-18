package com.kodilla.testing.forum.statistics;

import java.util.*;

public class CalculateStatistic {

    private int userCount;
    private int postsCount;
    private int commentCount;
    private double averagePostPerUser;
    private double averageCommentsPerUser;
    private double averageCommentsPerPost;

    public List<String> usersNames() {
        return Collections.emptyList();
    }

    public int postsCount() {
        return 0;
    }
    public int commentsCount() {
        return 0;
    }
    public void  calculateAdvStatistics(Statistics statistics) {
        userCount = statistics.usersNames().size();
        postsCount = statistics.postsCount();
        commentCount = statistics.commentsCount();
        this.userCount = userCount;
        if (userCount == 0) {
            averagePostPerUser = 0;
            averageCommentsPerPost = 0;
            averageCommentsPerUser = 0;
        } else {
            if (postsCount == 0) {
                averagePostPerUser = 0;
            } else {
                averagePostPerUser = postsCount / userCount;
            }
            if (commentCount == 0) {
                averageCommentsPerPost = 0;
                averageCommentsPerUser = 0;
            } else {
                averageCommentsPerUser = commentCount / userCount;
                averageCommentsPerPost = commentCount / postsCount;
            }
        }
    }
    public int getUserCount(){
            return userCount;
    }
    public int getPostsCount(){
        return postsCount;
    }
    public int getCommentCount(){
        return commentCount;
    }
    public double getAveragePostPerUser(){
        return averagePostPerUser;
    }
    public double getAverageCommentsPerUser(){
        return averageCommentsPerUser;
    }
    public double getAverageCommentsPerPost(){
        return averageCommentsPerPost;
    }
}



