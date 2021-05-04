package com.insiderser.kpi.java.ui;

import com.insiderser.kpi.java.model.Exam;
import com.insiderser.kpi.java.model.StudentGradebook;
import com.insiderser.kpi.java.utils.StringUtils;

public class GradebooksView {

    public void showOptionsMenu() {
        System.out.println();
        System.out.println("Що ви хочете зробити?");
        System.out.println("    1 - Отримати список всіх студентів");
        System.out.println("    2 - Отримати список студентів, у яких середній бал за сесію більший за 4.5");
        System.out.println("    3 - Отримати список іспитів для вказаного студента");
        System.out.println("    4 - Вийти");
        System.out.print("Ваш вибір [1-4]: ");
    }

    public void showInvalidOptionChosen() {
        System.out.println("Невірний вибір");
    }

    public void showStudentGradebooks(StudentGradebook[] gradebooks) {
        if (gradebooks.length > 0) {
            System.out.printf("%-25s\t%-7s\t%-5s\t%-20s\t%s\n",
                "Студент", "Номер", "Курс", "Іспити/заліки", "Середній бал");
            for (StudentGradebook gradebook : gradebooks) {
                String exams = StringUtils.joinToString(gradebook.getExams(), ", ");
                System.out.format("%-25s\t%-7s\t%-5s\t%-20s\t%.2f\n",
                    gradebook.getStudentName(), gradebook.getGradebookNumber(), gradebook.getCourse(),
                    exams, gradebook.getMedianGrade());
            }
        } else {
            System.out.println("Не знайдено таких студентів");
        }
    }

    public void showEnterStudentNameMessage() {
        System.out.print("Введіть ПІБ студента: ");
    }

    public void showInvalidStudentNameEntered() {
        System.out.println("Невірне ім'я студента");
    }

    public void showStudentExams(Exam[] exams) {
        if (exams.length > 0) {
            for (Exam exam : exams) {
                System.out.println(String.format("%s = %.2f", exam.getName(), exam.getGrade()));
            }
        } else {
            showStudentExamsNotFound();
        }
    }

    public void showStudentExamsNotFound() {
        System.out.println("Не знайдено такого студента або він не має екзаменів/заліків");
    }
}
