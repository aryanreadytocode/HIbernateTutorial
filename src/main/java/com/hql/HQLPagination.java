package com.hql;

import org.aryan.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HQLPagination {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();

        Query query = session.createQuery("from Student");
        // implementing pagination using hibernate

        query.setFirstResult(18);
        query.setMaxResults(8);

        List<Student> students = query.list();

        students.forEach( System.out::println);


        session.close();
        factory.close();
    }
}
