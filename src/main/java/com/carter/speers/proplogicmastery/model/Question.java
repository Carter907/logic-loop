package com.carter.speers.proplogicmastery.model;

import java.util.List;

public class Question {
    private String question;
    private List<String> answers;
    private String correctAnswer;
    private String userChoice;

    public Question(String question, List<String> answers, String correctAnswer, String userChoice) {
        this.question = question;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
        this.userChoice = userChoice;
    }

    public Question() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getUserChoice() {
        return userChoice;
    }

    public void setUserChoice(String userChoice) {
        this.userChoice = userChoice;
    }
}
