package com.manytomanymap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory factory = configuration.buildSessionFactory();

        Emp e1 = new Emp();
        Emp e2 = new Emp();

        e1.setEid(101);
        e1.setName("Raj");

        e2.setEid(102);
        e2.setName("Aryan");

        Project p1 = new Project();
        p1.setPid(201);
        p1.setName("HP Project");

        Project p2 = new Project();
        p2.setPid(202);
        p2.setName("Common Project");

        List<Emp> emps = new ArrayList<>();
        emps.add(e1);
        emps.add(e2);
        List<Project> projects = new ArrayList<>();
        projects.add(p1);
        projects.add(p2);

        e1.setProjects(projects);
        p2.setEmps(emps);

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(e1);
        session.save(e2);
        session.save(p1);
        session.save(p2);
        tx.commit();

        session.close();
        factory.close();
    }


}
