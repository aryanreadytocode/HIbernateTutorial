package com.manytoone;

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
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        /*Transaction tx = session.beginTransaction();

        Question q = new Question();
        q.setQuestion("What is your name?");
        q.setQuestionId(101);
        List<Answer > answerList = new ArrayList<>();
        Answer a = new Answer(1001, "My Name is Raj Aryan",  q);
        Answer a1 = new Answer(1002, "My Name is Raj Aryan",  q);
        answerList.add(a);
        answerList.add(a1);
        q.setAnswer(answerList);

        Question q1 = new Question();
        q1.setQuestion("Where do you live?");
        q1.setQuestionId(102);
        Answer a2 = new Answer(1003, "I live in Patna", q1);
        Answer a3 = new Answer(1004, "I live in Delhi", q1);
        answerList = new ArrayList<>();
        answerList.add(a2);
        answerList.add(a3);
        q1.setAnswer(answerList);*/

        /*session.save(q);
        session.save(a);
        session.save(a1);
        session.save(q1);
        session.save(a2);
        session.save(a3);
        tx.commit();*/

        Question newQ = session.get(Question.class,  102);
        System.out.println(newQ.getQuestionId());
        System.out.println(newQ.getQuestion());
        System.out.println(newQ.getAnswer().size());
//        List<Answer> answers = newQ.getAnswer();
//        answers.forEach(answer -> System.out.println((answer.getAnswer())));
//        Question newQ = session.get(Question.class,102);
//        System.out.println(newQ.getQuestion());
//        System.out.println(newQ.getAnswer().toString());


        session.close();
        sessionFactory.close();
    }
}
