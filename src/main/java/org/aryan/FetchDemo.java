package org.aryan;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

    public static void main(String[] args) {
        // get load
        Configuration cnf = new Configuration();
        cnf.configure("hibernate.cfg.xml");
        SessionFactory factory = cnf.buildSessionFactory();
        Session session = factory.openSession();

        // get student :101
        Student student = session.load(Student.class, 101);
        System.out.println(student);

//        Address address = session.get(Address.class, 1);
//        System.out.println(address.getStreet());

        session.close();
        factory.close();
    }
}
