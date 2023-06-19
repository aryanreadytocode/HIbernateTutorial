package com.hql;

import com.manytoone.Answer;
import com.manytoone.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CascadeExample {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();

        Question question = new Question();

        question.setQuestionId(111);
        question.setQuestion("Why we need to learn Hibernate");
        question.setAnswer(List.of(new Answer(501, "Answer 1"), new Answer(502, "Answer 2"),
                new Answer(503, "Answer 3")));

        Transaction transaction = session.beginTransaction();
        session.save(question);
        transaction.commit();


        session.close();
        factory.close();
    }
}
