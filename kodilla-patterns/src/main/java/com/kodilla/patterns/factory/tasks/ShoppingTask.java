package com.kodilla.patterns.factory.tasks;

public class ShoppingTask implements Task{
    private final String taskName;
    private final String whatToBuy;
    private final double quantity;
    private boolean taskExecuted=false;


    ShoppingTask(String taskName, String whatToBuy, double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
    }

    @Override
    public void executeTask() {
        System.out.println("Zakupy - ulubiona dyscyplina sportowa kobiet. Do kupienia "+whatToBuy+" w ilosci: "+quantity);
        taskExecuted=true;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public Boolean isTaskExecuted() {
        return taskExecuted;

    }
}
