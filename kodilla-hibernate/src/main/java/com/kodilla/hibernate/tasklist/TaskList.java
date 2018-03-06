package com.kodilla.hibernate.tasklist;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "TASKSLIST")
public class TaskList {

    private int id;
    private  String listName;
    private String description;

    public TaskList() {
    }
    public TaskList( String listName, String description) {

        this.listName = listName;
        this.description = description;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    @Column(name="LISTNAME")
    public String getlistName() {
        return listName;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    private void setListName(String listName) {
        this.listName = listName;
    }



}
