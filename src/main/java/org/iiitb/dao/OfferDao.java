package org.iiitb.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.iiitb.bean.Offer;
import org.iiitb.util.SessionUtil;

public class OfferDao {
    public void save(Offer offer) {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        session.save(offer);

        transaction.commit();
        session.close();
    }
}
