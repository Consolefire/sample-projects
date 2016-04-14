package com.consolefire.orm.sample.dao;

import com.consolefire.orm.GenericDao;
import com.consolefire.orm.sample.entity.Employee;
import org.springframework.stereotype.Repository;

/**
 * Created by sabuj.das on 14/04/16.
 */
public interface EmployeeDao extends GenericDao<Employee, Long> {
}
