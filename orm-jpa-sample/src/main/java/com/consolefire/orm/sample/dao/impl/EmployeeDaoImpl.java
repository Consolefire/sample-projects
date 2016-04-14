package com.consolefire.orm.sample.dao.impl;

import com.consolefire.orm.helper.GenericJpaDao;
import com.consolefire.orm.sample.dao.EmployeeDao;
import com.consolefire.orm.sample.entity.Employee;
import org.springframework.stereotype.Repository;

/**
 * Created by sabuj.das on 14/04/16.
 */
@Repository
public class EmployeeDaoImpl extends GenericJpaDao<Employee, Long> implements EmployeeDao {

}
