package com.insiderser.kpi.java.domain.model;

public class Exam {

    private final String name;
    private final float grade;

    public Exam(String name, float grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public float getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Exam{" +
            "name='" + name + '\'' +
            ", grade=" + grade +
            '}';
    }
}
