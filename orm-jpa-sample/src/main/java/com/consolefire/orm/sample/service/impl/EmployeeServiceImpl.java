package com.consolefire.orm.sample.service.impl;

import com.consolefire.orm.sample.dao.EmployeeDao;
import com.consolefire.orm.sample.entity.Employee;
import com.consolefire.orm.sample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sabuj.das on 14/04/16.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Employee writeToMaster(Employee employee) {
        return employeeDao.save(employee);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Employee readFromMaster(Long id) {
        return employeeDao.find(id);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public Employee readFromSlave(Long id) {
        return employeeDao.find(id);
    }
}
