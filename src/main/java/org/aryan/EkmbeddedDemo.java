package org.aryan;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EkmbeddedDemo {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory factory = configuration.buildSessionFactory();

        Student s1 = new Student();
        s1.setId(123);
        s1.setName("Ankit Tiwari");
        s1.setCity("lucknow");
        s1.setCertificate(new Certificate("Android", "2 months"));

        Student s2 = new Student();
        s2.setId(121);
        s2.setName("Nikita Tiwari");
        s2.setCity("Delhi");
        s2.setCertificate(new Certificate("Core Java", "6 months"));

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(s1);
        session.save(s2);

        tx.commit();
        session.close();
        factory.close();
    }
}
