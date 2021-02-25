package com.insiderser.kpi.java.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StudentGradebook {

    private final Student student;
    private final String number;
    private final int course;

    private final List<? extends Exam> exams;
    private final float medianGrade;

    public StudentGradebook(Student student, String number, int course, List<? extends Exam> exams, float medianGrade) {
        assert course >= 1 && course <= 6;
        assert medianGrade <= 5 && medianGrade >= 0;

        this.student = student;
        this.number = number;
        this.course = course;
        this.exams = exams;
        this.medianGrade = medianGrade;
    }

    public Student getStudent() {
        return student;
    }

    public int getCourse() {
        return course;
    }

    public String getNumber() {
        return number;
    }

    public List<Exam> getExams() {
        return Collections.unmodifiableList(exams);
    }

    public float getMedianGrade() {
        return medianGrade;
    }

    @Override
    public String toString() {
        return "StudentGradebook{" +
            "student=" + student +
            ", number='" + number + '\'' +
            ", course=" + course +
            ", exams=" + exams +
            ", medianGrade=" + medianGrade +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StudentGradebook)) {
            return false;
        }
        StudentGradebook that = (StudentGradebook) o;
        return course == that.course
            && Float.compare(that.medianGrade, medianGrade) == 0
            && Objects.equals(student, that.student)
            && Objects.equals(number, that.number)
            && Objects.equals(exams, that.exams);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, number, course, exams, medianGrade);
    }
}
