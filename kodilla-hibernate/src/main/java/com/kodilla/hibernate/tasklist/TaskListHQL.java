package com.kodilla.hibernate.tasklist;

import com.kodilla.hibernate.task.TaskHQL;
import com.kodilla.hibernate.task.TaskHQL;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TASKLISTS")
public class TaskListHQL {
    private int id;
    private String listName;
    private String description;
    private List<TaskHQL> tasks = new ArrayList<>();

    public TaskListHQL() {

    }

    public TaskListHQL(String listName, String description) {
        this.listName = listName;
        this.description = description;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    @Column(name = "LISTNAME")
    public String getListName() {
        return listName;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    @OneToMany(
            targetEntity = TaskHQL.class,
            mappedBy = "taskList",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<TaskHQL> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskHQL> tasks) {
        this.tasks = tasks;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}