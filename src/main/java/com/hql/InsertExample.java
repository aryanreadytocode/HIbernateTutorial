package com.hql;

import org.aryan.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;


public class InsertExample {

    public static void main(String[] args) {

        SessionFactory factory = FactoryProvider.getFactory();
        Session session = factory.openSession();
        // HQL0.
        // Syntax
        // Add without where clause
//        String query = "from Student where city = 'Lucknow'";
        String query = "from Student where city =:c and name=:n";
        Query q = session.createQuery(query);
        q.setParameter("c", "Boston");
        q.setParameter("n", "John");
        //single
        // multiple

        List<Student> students = q.list();

        students.forEach(student -> System.out.println(student.getName()));

        session.close();
    }
}
