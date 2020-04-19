package org.iiitb.bean;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ofID;

//    @OneToMany(mappedBy = "offer")
    @ManyToMany(targetEntity = Domain.class, cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(joinColumns = { @JoinColumn(name = "ofID") },
        inverseJoinColumns = { @JoinColumn(name = "dID") })
    private Set<Domain> domains = new HashSet<>();

    private Double minGrade = 0.0;

    @NotBlank
    private Integer maxIntake;

//    @ManyToOne
//    private Organisation organisation;

    @JoinTable(name = "Application",
            joinColumns = { @JoinColumn(name = "ofID") },
            inverseJoinColumns = { @JoinColumn(name = "sID") })
    @ManyToMany(targetEntity = Student.class, fetch = FetchType.EAGER)
    private Set<Student> appliedStudents = new HashSet<>();

    public Integer getOfID() {
        return ofID;
    }

    public void setOfID(Integer ofID) {
        this.ofID = ofID;
    }

    public Set<Domain> getDomains() {
        return domains;
    }

    public void setDomains(Set<Domain> domains) {
        this.domains = domains;
    }

    public Double getMinGrade() {
        return minGrade;
    }

    public void setMinGrade(Double minGrade) {
        this.minGrade = minGrade;
    }

    public Integer getMaxIntake() {
        return maxIntake;
    }

    public void setMaxIntake(Integer maxIntake) {
        this.maxIntake = maxIntake;
    }

//    public Organisation getOrganisation() {
//        return organisation;
//    }
//
//    public void setOrganisation(Organisation organisation) {
//        this.organisation = organisation;
//    }

    public Set<Student> getAppliedStudents() {
        return appliedStudents;
    }

    public void setAppliedStudents(Set<Student> appliedStudents) {
        this.appliedStudents = appliedStudents;
    }
}
