package com.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class DeleteExample {
    public static void main(String[] args) {
        SessionFactory factory = FactoryProvider.getFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        String queryString = "delete from Student where city =: c";
        Query query = session.createQuery(queryString);
        query.setParameter("c", "Delhi");

        int deletedRecord = query.executeUpdate();
        tx.commit();
        System.out.println(deletedRecord);

        session.close();
        factory.close();
    }
}
