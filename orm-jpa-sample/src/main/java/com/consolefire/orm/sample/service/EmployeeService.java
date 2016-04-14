package com.consolefire.orm.sample.service;

import com.consolefire.orm.sample.entity.Employee;

/**
 * Created by sabuj.das on 14/04/16.
 */
public interface EmployeeService {

    Employee writeToMaster(Employee employee) ;
    Employee readFromMaster(Long id);
    Employee readFromSlave(Long id);

}
