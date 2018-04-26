package com.kodilla.hibernate.task;  //teraz Reacja jeden do wielu


import com.kodilla.hibernate.tasklist.TaskListHQL;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@NamedQueries({
        @NamedQuery(
                name = "TaskHQL.retrieveLongTasks",
                query = "FROM TaskHQL WHERE duration > 10"
        ),
        @NamedQuery(
                name = "TaskHQL.retrieveShortTasks",
                query = "FROM TaskHQL WHERE duration <= 10"
        ),
        @NamedQuery(
                name = "TaskHQL.retrieveTasksWithDurationLongerThan",
                query = "FROM TaskHQL WHERE duration > :DURATION"
        )

})
@NamedNativeQuery(
        name = "TaskHQL.retrieveTasksWithEnoughTime",
        query = "SELECT * FROM TASKS" +
                " WHERE DATEDIFF(DATE_ADD(CREATED, INTERVAL DURATION DAY), NOW()) > 5",
        resultClass = TaskHQL.class
)

@Entity
@Table(name = "TASKS")
public final class TaskHQL {
    private int id;
    private String description;
    private Date created;
    private int duration;
    private TaskFinancialDetails taskFinancialDetails;
    private TaskListHQL taskList;

    public TaskHQL() {
    }

    public TaskHQL(String description, int duration) {
        this.description = description;
        this.created = new Date();
        this.duration = duration;
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

    @NotNull
    @Column(name = "CREATED")
    public Date getCreated() {
        return created;
    }

    @Column(name  = "DURATION")
    public int getDuration() {
        return duration;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "TASKS_FINANCIALS_ID")
    public TaskFinancialDetails getTaskFinancialDetails() {
        return taskFinancialDetails;
    }

    @ManyToOne
    @JoinColumn(name = "TASKLIST")
    public TaskListHQL getTaskList() {
        return taskList;
    }

    public void setTaskList(TaskListHQL taskList) {
        this.taskList = taskList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setTaskFinancialDetails(TaskFinancialDetails taskFinancialDetails) {
        this.taskFinancialDetails = taskFinancialDetails;
    }
}