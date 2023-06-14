package org.aryan;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        System.out.println( "Project Started" );
        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory factory = configuration.buildSessionFactory();

        // creating student
        Student student = new Student(101, "RAJ", "Patna");
        System.out.println(student);

        // creating object of address class
        Address ad = new Address();
        ad.setStreet("street1");
        ad.setCity("Patna");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(258);
        // reading image
        FileInputStream fileInputStream = new FileInputStream("src/main/java/pic.png");
        byte[] image = new byte[fileInputStream.available()];
        ad.setImage(image);

        Session session = factory.openSession();

        session.beginTransaction();
        Transaction tx = session.getTransaction();

        session.save(student);
        session.save(ad);
        tx.commit();
        session.close();


    }
}
