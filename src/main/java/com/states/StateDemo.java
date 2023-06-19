package com.states;

import org.aryan.Certificate;
import org.aryan.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StateDemo {
    public static void main(String[] args) {
        // Practical of Hibernate States
        // Transient State
        // Persistent
        // Detached
        // Removed
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Student student = new Student();
        student.setId(9632);
        student.setName("Peter");
        student.setCity("Boston");
        student.setCertificate(new Certificate("Java Hibernate","2 months"));
        // student : Transient

        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();
        s.save(student);
//         student : Persistent - session, database
        student.setName("John");

        tx.commit();
        s.close();
        // student : Detached
        student.setName("Raja");
        factory.close();
    }
}
