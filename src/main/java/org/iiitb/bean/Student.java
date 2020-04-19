package org.iiitb.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sID;
    
    @Column(unique = true)
    private String rollNumber;
    
    @NotBlank
    private String firstName;
    private String middleName;
    private String lastName;
    
    @Column(unique = true)
    private String emailId;

    private Double grade = 0.0;

    @ManyToOne
//    @JsonIgnore
    private Domain domain = new Domain();
    
    public Student() {
    }
    
    public Student(Integer id) {
        this.sID = id;
    }
    
    public Student(String rollNumber, String firstName, String middleName, String lastName, String emailId,  Domain domain) {
        this.rollNumber = rollNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.domain = domain;
    }
    
    public String getRollNumber() {
        return rollNumber;
    }
    
    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getMiddleName() {
        return middleName;
    }
    
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getEmailId() {
        return emailId;
    }
    
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Domain getDomain() {
        return domain;
    }
    
    public void setDomain(Domain domain) {
        this.domain = domain;
    }

    public Integer getsID() {
        return sID;
    }

    public void setsID(Integer sID) {
        this.sID = sID;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
}
