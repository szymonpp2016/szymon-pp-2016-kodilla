package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public static final String DRIVINGTASK = "DRIVINGTASK";
    public static final String PAINTINGTASK = "PAINTINGTASK";
    public static final String SHOPPINGTASK = "SHOPPINGTASK";

    public final Task makeTask(final String makeTask) {
        switch (makeTask) {
            case DRIVINGTASK:
                return new DrivingTask("DRIVINGTASK", "Honolulu", "deskorolce");
            case PAINTINGTASK:
                return new PaintingTask("PAINTINGTASK", "biały", "biel");
            case SHOPPINGTASK:
                return new ShoppingTask("SHOPPINGTASK", "buty", 2.50);
            default:
                return null;
        }

    }
}
