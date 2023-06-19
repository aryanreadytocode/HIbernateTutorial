package com.mapping.xml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Person pr = new Person(101, "Raj", "Patna", "8800");
        Transaction transaction = session.beginTransaction();
        session.save(pr);
        transaction.commit();
        session.close();
        factory.close();
    }
}
