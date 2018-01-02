package com.app.darwish.tamaren.com.app.darwish.exam;

import java.util.ArrayList;

/**
 * Created by Darwish on 1/1/2018.
 */

public class Exam {
    private Question[] completQueton;
    private QuestionChoice[] questionChoices;

    public Question[] getCompletQueton() {
        return completQueton;
    }

    public void setCompletQueton(Question[] completQueton) {
        this.completQueton = completQueton;
    }

    public QuestionChoice[] getQuestionChoices() {
        return questionChoices;
    }

    public void setQuestionChoices(QuestionChoice[] questionChoices) {
        this.questionChoices = questionChoices;
    }
}
