package com.kodilla.hibernate.manytomany.dao;


import com.kodilla.hibernate.manytomany.CompanyHQL;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface CompanyDaoHQL extends CrudRepository<CompanyHQL, Integer> {

    @Query
    List<CompanyHQL> retrieveCompanyNameByTreeLetters(@Param("COMPANY_NAME") String companyName );

}