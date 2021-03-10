package com.insiderser.kpi.java.model;

import java.util.Arrays;

public class StudentGradebook {

    private final String studentName;
    private final String gradebookNumber;
    private final int course;
    private final Exam[] exams;
    private final float medianGrade;

    public StudentGradebook(String studentName, String gradebookNumber, int course,
        Exam[] exams, float medianGrade) {
        this.studentName = studentName;
        this.gradebookNumber = gradebookNumber;
        this.course = course;
        this.exams = exams;
        this.medianGrade = medianGrade;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getGradebookNumber() {
        return gradebookNumber;
    }

    public int getCourse() {
        return course;
    }

    public Exam[] getExams() {
        return exams;
    }

    public float getMedianGrade() {
        return medianGrade;
    }

    @Override
    public String toString() {
        return "StudentGradebook{" +
            "studentName='" + studentName + '\'' +
            ", gradebookNumber='" + gradebookNumber + '\'' +
            ", course=" + course +
            ", exams=" + Arrays.toString(exams) +
            ", medianGrade=" + medianGrade +
            '}';
    }
}
