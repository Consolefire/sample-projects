package com.consolefire.samples.multids.model;

import java.util.HashSet;
import java.util.Set;

public class Employee {

    private Long id;
    private String name;
    private String email;
    
    private Employee manager;
    private Set<Employee> subordinates = new HashSet<>(0);
}
