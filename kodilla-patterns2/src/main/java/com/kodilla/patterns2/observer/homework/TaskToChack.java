package com.kodilla.patterns2.observer.homework;


import java.util.ArrayList;
import java.util.List;

public class TaskToChack implements TaskServiceObservable{
    private final List<MentorObserver> mentorListObservers;
    private final List<String> message;
    private final String name;

    TaskToChack(String name) {
        mentorListObservers = new ArrayList<>();
        message=new ArrayList<>();
        this.name = name;
    }
    public void addTask(String post,Student student){

        message.add("\n"+post+"from student:"+student.getUserName()+", curs code: "+student.getKursKode());
    notifyObservers();
    }

    public List<String> getMessage() {
        return message;
    }

    public String getName() {
        return name;
    }

    @Override
    public void registerObserver(MentorObserver mentorObserver) {
        mentorListObservers.add(mentorObserver);
    }

    @Override
    public void notifyObservers() {
for(MentorObserver mentorObserver: mentorListObservers)
    mentorObserver.update(this);
    }

    @Override
    public void removeObservers(MentorObserver mentorObserver) {
        mentorListObservers.remove(mentorObserver);
    }
}
