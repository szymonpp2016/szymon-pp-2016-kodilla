package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import com.kodilla.hibernate.tasklist.TaskListHQL;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface TaskListDaoHQL extends CrudRepository<TaskListHQL, Integer> {
    List<TaskListHQL> findByListName(String listName);
    int countByListName(String listName);
}