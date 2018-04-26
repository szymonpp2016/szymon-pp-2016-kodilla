package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.CompanyHQL;
import com.kodilla.hibernate.manytomany.EmployeeHQL;
import com.kodilla.hibernate.manytomany.dao.CompanyDaoHQL;
import com.kodilla.hibernate.manytomany.dao.EmployeeDaoHQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Service
public class EmployeeCompanyHQLServiceFacade {

    @Autowired
    private CompanyDaoHQL companyDaoHQL;

    @Autowired
    private EmployeeDaoHQL employeeDaoHQL;

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeCompanyHQLServiceFacade.class);

    private static final String ERR_UNEXPECTED = "Unexpected error";
    private static final String ERR_NULL_FRAGMENT = "Valoue contiains null fragment string";
    private static final String ERR_INVALID_TXT = "Input string valoue is in invalid format or no String input";
    private static final String MESSAGE_FIND_COMPANY = "Finding companies with name containing";
    private static final String MESSAGE_FIND_EMPLOYEE = "Finding employees with last name containing:";

    public Optional<List<CompanyHQL>> findCompanyByNameFragment(String partOfCompanyName) {
        List<CompanyHQL> nameOfSearachCompany = null;
        if (partOfCompanyName == null) {
            LOGGER.error(ERR_NULL_FRAGMENT);
        } else {
            LOGGER.info(MESSAGE_FIND_COMPANY + partOfCompanyName);
            try {
                nameOfSearachCompany = companyDaoHQL.retrieveCompanyNameByPartOfName(partOfCompanyName);
                if(nameOfSearachCompany.size()==0) LOGGER.info(ERR_INVALID_TXT);
            } catch (RuntimeException e) {
                LOGGER.error(ERR_UNEXPECTED, e);
            }
        }
        return ofNullable(nameOfSearachCompany);
    }

    public Optional<List<EmployeeHQL>> findEmployeeByLastNameFragment(String workerPartName) {
        List<EmployeeHQL> nameOfSearachWmployee = null;
        if (workerPartName == null) {
            LOGGER.error(ERR_NULL_FRAGMENT);
        } else {
            LOGGER.info(MESSAGE_FIND_EMPLOYEE + workerPartName);
            try {
                nameOfSearachWmployee = employeeDaoHQL.retrieveWorkerByPartOfName(workerPartName);
                if(nameOfSearachWmployee.size()==0) LOGGER.info(ERR_INVALID_TXT);
            } catch (RuntimeException e) {
                LOGGER.error(ERR_UNEXPECTED, e);
            }
        }
        return ofNullable(nameOfSearachWmployee);
    }
}

