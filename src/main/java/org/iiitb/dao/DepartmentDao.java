package org.iiitb.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.iiitb.bean.Department;
import org.iiitb.util.SessionUtil;

public class DepartmentDao {
    public void save(Department department) {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        session.save(department);

        transaction.commit();
        session.close();
    }
}
