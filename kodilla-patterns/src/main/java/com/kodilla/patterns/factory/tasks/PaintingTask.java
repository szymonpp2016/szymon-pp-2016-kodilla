package com.kodilla.patterns.factory.tasks;

public class PaintingTask implements Task {
    private final String taskName;
    private final String color;
    private final String whatToPaint;
    private boolean taskExecuted=false;

    PaintingTask(String taskName, String color, String whatToPaint){
        this.taskName=taskName;
        this.color=color;
        this.whatToPaint=whatToPaint;
    }

    @Override
    public void executeTask() {
        System.out.println("Maluje buchomaz o kolorze "+color+", pod tytułem: "+whatToPaint);
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
