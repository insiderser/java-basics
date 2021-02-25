package com.insiderser.kpi.java.model;

public class Exam {

    private final String text;

    public Exam(String text) {
        this.text = text;
    }

    public String getAsText() {
        return text;
    }

    @Override
    public String toString() {
        return getAsText();
    }
}
