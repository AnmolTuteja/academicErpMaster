package org.iiitb.bean;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Organisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer oID;

    @NotBlank
    @Column(unique = true)
    private String name;

//    @OneToMany(mappedBy = "organisation")
    @OneToOne(targetEntity = Offer.class,cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ofID")
    private Offer offer = new Offer();

    public Integer getoID() {
        return oID;
    }

    public void setoID(Integer oID) {
        this.oID = oID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }
}
