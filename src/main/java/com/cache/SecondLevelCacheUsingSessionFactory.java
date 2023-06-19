package com.cache;

import org.aryan.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SecondLevelCacheUsingSessionFactory {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session s1 = factory.openSession();
        Student std = s1.get(Student.class, 1032);
        System.out.println(std);
        s1.close();

        Session s2 = factory.openSession();
        Student std2 = s2.get(Student.class, 1032);
        System.out.println(std2);
        s2.close();

        factory.close();
    }
}
