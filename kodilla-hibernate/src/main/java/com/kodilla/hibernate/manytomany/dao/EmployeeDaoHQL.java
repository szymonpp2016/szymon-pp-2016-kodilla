package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.EmployeeHQL;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface EmployeeDaoHQL extends CrudRepository<EmployeeHQL, Integer> {

    @Query
    List<EmployeeHQL> retrieveWorkerByLastName(@Param("WORKERLASTNAME") String workerLastName);

    @Query
    List<EmployeeHQL> retrieveWorkerByPartOfName(@Param("WORKER_PART_OF_NAME") String workerPartName);
}

