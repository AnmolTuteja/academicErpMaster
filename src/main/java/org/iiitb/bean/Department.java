package org.iiitb.bean;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dID;

    @NotBlank
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "dID")
    private Set<Employee> employees = new HashSet<>();

    public Integer getdID() {
        return dID;
    }

    public void setdID(Integer dID) {
        this.dID = dID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
