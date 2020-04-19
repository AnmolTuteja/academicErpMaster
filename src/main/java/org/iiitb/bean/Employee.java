package org.iiitb.bean;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eID;

    @NotBlank
    @Column(unique = true)
    private String userName;

    @NotBlank
    private String password;

    @ManyToOne
    @JoinColumn(name="dID")
    private Department department;

    public Integer geteID() {
        return eID;
    }

    public void seteID(Integer eID) {
        this.eID = eID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

        public Department getDepartment() {
            return department;
        }

        public void setDepartment(Department department) {
            this.department = department;
        }
}
