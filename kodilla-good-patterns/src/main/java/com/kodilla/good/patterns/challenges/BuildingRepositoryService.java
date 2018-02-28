package com.kodilla.good.patterns.challenges;

public class BuildingRepositoryService implements RepositoryServiceRule{
    public boolean saveOrder(User user, Order order) {
        System.out.println("The order <buildingstuff> has been created");
        return true;
    }
}
