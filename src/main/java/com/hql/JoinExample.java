package com.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

public class JoinExample {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();

//        String query = "Select q.question, a.answer from Question as q INNER JOIN " +
//                "Answer as a on a.question.questionId = q.questionId";
        /* So here we are not giving like join on q*/
        String query = "Select q.question, q.questionId, a.answer from Question as q INNER JOIN q.answerList  `  as a";
        Query q = session.createQuery(query)  ;

        List<Object[]> objects = q.getResultList();
        objects.forEach(q1 -> System.out.println(Arrays.toString(q1)));
        session.close();
    }
}
