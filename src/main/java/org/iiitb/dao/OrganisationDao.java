package org.iiitb.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.iiitb.bean.Organisation;
import org.iiitb.bean.Student;
import org.iiitb.util.SessionUtil;

import java.util.List;

public class OrganisationDao {
    public void save(Organisation organisation) {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        session.save(organisation);

        transaction.commit();
        session.close();
    }

    public Organisation find(Integer id) {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        Organisation organisation = session.get(Organisation.class, id);

        transaction.commit();
        session.close();
        return organisation;
    }

    public List<Organisation> findAll() {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM Organisation";
        Query query = session.createQuery(hql);
        List<Organisation> organisationList = query.list();

        transaction.commit();
        session.close();
        return organisationList;
    }
}
