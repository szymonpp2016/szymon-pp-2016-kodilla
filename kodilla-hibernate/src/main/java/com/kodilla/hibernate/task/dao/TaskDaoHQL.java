package com.kodilla.hibernate.task.dao;


import com.kodilla.hibernate.task.TaskHQL;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface TaskDaoHQL extends CrudRepository<TaskHQL, Integer> {
List<TaskHQL> findByDuration(int duration);

    @Query
    List<TaskHQL> retrieveLongTasks();

    @Query
    List<TaskHQL> retrieveShortTasks();

    @Query(nativeQuery = true)
    List<TaskHQL> retrieveTasksWithEnoughTime();

    @Query
    List<TaskHQL> retrieveTasksWithDurationLongerThan(@Param("DURATION") int duration);
}