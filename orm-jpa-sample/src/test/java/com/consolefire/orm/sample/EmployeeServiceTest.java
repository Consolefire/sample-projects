package com.consolefire.orm.sample;

import com.consolefire.orm.config.OrmHelperPersistenceConfig;
import com.consolefire.orm.sample.entity.Employee;
import com.consolefire.orm.sample.service.EmployeeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;

/**
 * Created by sabuj.das on 14/04/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class, OrmHelperPersistenceConfig.class})
@TestPropertySource("classpath:application.properties")
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    private Random random = new Random();


    /*
    create database office_master;
    use office_master;
    create table employees ( id bigint not null auto_increment, email varchar(150) not null, name varchar(150) not null, primary key (id));
    alter table employees add constraint UK_hxpym1ml3cufk46aws6660klf unique (name, email);
    insert  into employees (email, name) values ('sabuj.das@gmail.com', 'Sabuj Das');
    create database office_slave;
    use office_slave;
    create table employees ( id bigint not null auto_increment, email varchar(150) not null, name varchar(150) not null, primary key (id));
    alter table employees add constraint UK_hxpym1ml3cufk46aws6660klf unique (name, email);
    insert  into employees (email, name) values ('sabuj.das@hotmail.com', 'Sabuj Das');
     */

    @Test
    @Rollback(true)
    public void testRegisterRandomEmployee(){
        Employee employee = new Employee();
        employee.setName("N_"+random.nextInt());
        employee.setEmail("E_"+random.nextInt());
        employeeService.writeToMaster(employee);
    }

    @Test
    public void testGet1stEmployeeFromMaster(){
        Employee employee = employeeService.readFromMaster(1L);
        System.out.println(employee);
        Assert.assertNotNull(employee);
        Assert.assertEquals("sabuj.das@gmail.com", employee.getEmail());
    }

    @Test
    public void test1stGetEmployeeFromSlave(){
        Employee employee = employeeService.readFromSlave(1L);
        System.out.println(employee);
        Assert.assertNotNull(employee);
        Assert.assertEquals("sabuj.das@hotmail.com", employee.getEmail());
    }

}
