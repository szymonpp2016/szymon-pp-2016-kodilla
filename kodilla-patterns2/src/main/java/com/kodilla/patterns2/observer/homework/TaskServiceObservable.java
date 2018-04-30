package com.kodilla.patterns2.observer.homework;

import com.kodilla.patterns2.observer.forum.Observer;

public interface TaskServiceObservable {
    void registerObserver(MentorObserver mentorObserver);
    void notifyObservers();
    void removeObservers(MentorObserver mentorObserver);

}
