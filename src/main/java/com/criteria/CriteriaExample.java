package com.criteria;

import org.aryan.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.sql.Struct;
import java.util.List;

public class CriteriaExample {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Criteria c = session.createCriteria(Student.class);
//        c.add(Restrictions.eq("certificate.course", "Android"));
//        c.add(Restrictions.gt("id", 1000));
//        c.add(Restrictions.lt("id", 1000));
        c.add(Restrictions.like("certificate.course", "course%"));


        c.list().forEach(System.out::println);



        session.close();
        factory.close();
    }
}
