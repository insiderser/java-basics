package com.insiderser.kpi.java.ui;

import com.insiderser.kpi.java.domain.model.Exam;
import com.insiderser.kpi.java.domain.model.StudentGradebook;
import com.insiderser.kpi.java.utils.StringUtils;

public class GradebooksView {

    public void showEnterOperationsOutputFile() {
        System.out.print("Введіть шлях до файлу для виводу результатів операції (залиште пустим, щоб виводити тільки в консоль): ");
    }

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
            System.out.printf("%-25s\t%-7s\t%-5s\t%-30s\t%s\n",
                "Студент", "Номер", "Курс", "Іспити/заліки", "Середній бал");
            for (StudentGradebook gradebook : gradebooks) {
                String exams = StringUtils.joinToString(gradebook.getExams(), ", ");
                System.out.format("%-25s\t%-7s\t%-5s\t%-30s\t%.2f\n",
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

    public void showDataFileNotFound() {
        System.err.println("Немає доступу до даних!");
    }

    public void showUnknownError() {
        System.err.println("Невідома помилка. Повідомте адміністраторів.");
    }
}
