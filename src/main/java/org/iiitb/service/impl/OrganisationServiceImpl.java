package org.iiitb.service.impl;

import org.iiitb.bean.Organisation;
import org.iiitb.dao.OrganisationDao;
import org.iiitb.service.OrganisationService;

import java.util.List;

public class OrganisationServiceImpl implements OrganisationService {

    public List<Organisation> findAll(){
        OrganisationDao organisationDao = new OrganisationDao();
        List<Organisation> organisationList = organisationDao.findAll();
        return organisationList;
    }

    public Organisation find(Integer oID){
        OrganisationDao organisationDao = new OrganisationDao();
        Organisation organisation = organisationDao.find(oID);
        return organisation;
    }
}
