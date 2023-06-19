package com.manytoone;

import javax.persistence.*;
import java.util.List;

@Entity
public class Question {
    @Id
    @Column(name = "question_id")
    private int questionId;
    private String question;
    @OneToMany(mappedBy = "question", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Answer> answerList;

    public Question() {
    }

    public Question(int questionId, String question, List<Answer> answerList) {
        this.questionId = questionId;
        this.question = question;
        this.answerList = answerList;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer> getAnswer() {
        return answerList;
    }

    public void setAnswer(List<Answer> answerList) {
        this.answerList = answerList;
    }
}
