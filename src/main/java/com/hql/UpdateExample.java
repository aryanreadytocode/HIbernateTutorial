package com.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class UpdateExample {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        String sQuery = "update Student set city=:c where name=:n";
        Query query = session.createQuery(sQuery);
        query.setParameter("c", "Bengaluru");
        query.setParameter("n", "John");

        int rowUpdated = query.executeUpdate();
        transaction.commit();

        System.out.println(rowUpdated);
        session.close();
        sessionFactory.close();

    }
}
