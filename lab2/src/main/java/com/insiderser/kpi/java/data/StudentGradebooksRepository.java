package com.insiderser.kpi.java.data;

import com.insiderser.kpi.java.model.Exam;
import com.insiderser.kpi.java.model.StudentGradebook;

public class StudentGradebooksRepository {

    private static final StudentGradebook[] GRADEBOOKS = {
        new StudentGradebook("Oleksandr Vefew Bezushko", "ІП-9101", 2, new Exam[]{new Exam("Node.js", 5f)}, 5f),
        new StudentGradebook("Second Oojigroi Shrt", "ІП-9102", 2, new Exam[]{new Exam("Node.js", 4f)}, 4f),
        new StudentGradebook("Third Oojigroi Shrt", "ІП-9103", 2, new Exam[]{new Exam("Node.js", 4.2f)}, 4.2f),
        new StudentGradebook("Fourth Oojigroi Shrt", "ІП-8104", 3, new Exam[]{new Exam("History", 4.55f)}, 4.55f),
        new StudentGradebook("Fifth Oojigroi Shrt", "ІП-0105", 1, new Exam[]{new Exam("Java", 1f), new Exam("Psychology", 3.2f)}, 2.1f),
        new StudentGradebook("Sixth Oojigroi Shrt", "ІП-9106", 2, new Exam[]{new Exam("Node.js", 3.4f)}, 3.4f),
        new StudentGradebook("Seventh Oojigroi Shrt", "ІС-9107", 2, new Exam[]{new Exam("Node.js", 4.3f)}, 4.3f),
        new StudentGradebook("Eighth Oojigroi Shrt", "ІП-9108", 2, new Exam[]{new Exam("Node.js", 5f)}, 5f),
        new StudentGradebook("Ninth Oojigroi Shrt", "ІП-9109", 2, new Exam[]{new Exam("Node.js", 4.8f)}, 4.8f),
        new StudentGradebook("Tenth Oojigroi Shrt", "ІП-9110", 2, new Exam[]{new Exam("Node.js", 4.5f)}, 4.5f)
    };

    public static StudentGradebook[] getAll() {
        return GRADEBOOKS;
    }
}
