package org.iiitb.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.iiitb.bean.Domain;
import org.iiitb.bean.Employee;
import org.iiitb.bean.Student;
import org.iiitb.util.SessionUtil;

import java.util.List;

public class EmployeeDao {
    public void save(Employee employee) {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        session.save(employee);

        transaction.commit();
        session.close();
    }

    public Employee find(Integer id) {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        Employee employee = session.get(Employee.class, id);

        transaction.commit();
        session.close();
        return employee;
    }

    public Employee findByUserName(String userName) {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM Employee WHERE userName = :user_name";
        Query query = session.createQuery(hql);
        query.setParameter("user_name", userName);
        Employee employee = (Employee) query.getSingleResult();

        transaction.commit();
        session.close();
        return employee;
    }
}
