package com.sql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class SQLExample {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();

        // SQL query
        String q = "select * from student";
        NativeQuery nq = session.createNativeQuery(q);

        List<Object[]> list = nq.list();

        list.forEach(s -> System.out.println(s[0] +" "+ s[1]));
        session.close();
        factory.close();
    }
}
