package org.iiitb.service;

import org.iiitb.bean.Organisation;

import java.util.List;

public interface OrganisationService {
    public List<Organisation> findAll();
    public Organisation find(Integer oID);
}
