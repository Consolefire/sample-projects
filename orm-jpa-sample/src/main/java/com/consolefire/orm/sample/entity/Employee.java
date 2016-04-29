package com.consolefire.orm.sample.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import com.consolefire.orm.entity.AuditProperties;
import com.consolefire.orm.entity.Auditable;
import com.consolefire.orm.entity.AuditableEntityListener;

import java.util.Objects;

/**
 * Created by sabuj.das on 14/04/16.
 */
@Getter
@Setter
@Entity
@Table(name = "employees", uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "email"})})
@Auditable
@EntityListeners({AuditableEntityListener.class})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false, length = 150)
    private String name;
    @Column(name = "email", nullable = false, length = 150)
    private String email;

    @Embedded
    private AuditProperties auditProperties;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(email, employee.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Employee{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
