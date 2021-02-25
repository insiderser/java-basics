package com.insiderser.kpi.java.model;

import java.util.Collections;
import java.util.List;

public final class DummyStudentGradebooksProvider {

    private DummyStudentGradebooksProvider() {
        throw new AssertionError("No instances");
    }

    public static List<StudentGradebook> get() {
        return List.of(
            new StudentGradebook(new Student("Oleksandr", "Vefew", "Bezushko"),
                "ІП-9101", 2, Collections.emptyList(), 5f),
            new StudentGradebook(new Student("Second", "Oojigroi", "Shrt"),
                "ІП-9102", 2, Collections.emptyList(), 4f),
            new StudentGradebook(new Student("Third", "Oojigroi", "Shrt"),
                "ІП-9103", 2, List.of(new Exam("Node.js")), 4.2f),
            new StudentGradebook(new Student("Fourth", "Oojigroi", "Shrt"),
                "ІП-8104", 3, List.of(new Exam("History")), 4.55f),
            new StudentGradebook(new Student("Fifth", "Oojigroi", "Shrt"),
                "ІП-0105", 1, List.of(new Exam("Java"), new Exam("Psychology")), 2.1f),
            new StudentGradebook(new Student("Sixth", "Oojigroi", "Shrt"),
                "ІП-9106", 2, Collections.emptyList(), 3.4f),
            new StudentGradebook(new Student("Seventh", "Oojigroi", "Shrt"),
                "ІС-9107", 2, Collections.emptyList(), 4.3f),
            new StudentGradebook(new Student("Eighth", "Oojigroi", "Shrt"),
                "ІП-9108", 2, Collections.emptyList(), 5f),
            new StudentGradebook(new Student("Ninth", "Oojigroi", "Shrt"),
                "ІП-9109", 2, Collections.emptyList(), 4.8f),
            new StudentGradebook(new Student("Tenth", "Oojigroi", "Shrt"),
                "ІП-9110", 2, Collections.emptyList(), 4.5f)
        );
    }
}
