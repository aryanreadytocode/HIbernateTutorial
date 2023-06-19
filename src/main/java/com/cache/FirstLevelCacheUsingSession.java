package com.cache;

import org.aryan.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FirstLevelCacheUsingSession {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();

        Student s1 = session.get(Student.class, 1023);
        System.out.println(s1);

        Student s2 = session.get(Student.class, 1023);
        System.out.println(s2);

        System.out.println(session.contains(s1));
        session.close();
        factory.close();
    }
}
