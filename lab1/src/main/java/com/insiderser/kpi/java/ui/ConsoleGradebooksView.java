package com.insiderser.kpi.java.ui;

import com.insiderser.kpi.java.model.Exam;
import com.insiderser.kpi.java.model.GradebookOption;
import com.insiderser.kpi.java.model.Student;
import com.insiderser.kpi.java.model.StudentGradebook;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleGradebooksView implements GradebooksView {

    private final GradebooksPresenter presenter = new GradebooksPresenter(this);

    public void run() {
        boolean exiting = false;
        while (!exiting) {
            var option = chooseOption();
            switch (option) {
                case LIST_ALL_STUDENTS:
                    presenter.onListAllStudents();
                    break;

                case LIST_EXCELLENT:
                    presenter.onListExcellentStudents();
                    break;

                case LIST_EXAMS_FOR_STUDENT:
                    var student = getStudentFromInput();
                    if (student != null) {
                        presenter.onListExamsForStudent(student);
                    }
                    break;

                case EXIT:
                    exiting = true;
                    break;

                case INVALID:
                    // Ignored
                    break;
            }
        }
    }

    private GradebookOption chooseOption() {
        System.out.println();
        System.out.println("Що ви хочете зробити?");
        System.out.println("    1 - Отримати список всіх студентів");
        System.out.println("    2 - Отримати список студентів, у яких середній бал за сесію більший за 4.5");
        System.out.println("    3 - Отримати список іспитів для вказаного студента");
        System.out.println("    4 - Вийти");
        System.out.print("Ваш вибір [1-4]: ");

        var input = new Scanner(System.in);
        int choice;
        try {
            choice = input.nextInt();
        } catch (Exception e) {
            System.out.println("Невірні дані");
            return GradebookOption.INVALID;
        }

        switch (choice) {
            case 1:
                return GradebookOption.LIST_ALL_STUDENTS;

            case 2:
                return GradebookOption.LIST_EXCELLENT;

            case 3:
                return GradebookOption.LIST_EXAMS_FOR_STUDENT;

            case 4:
                return GradebookOption.EXIT;

            default:
                System.out.println("Невірний вибір");
                return GradebookOption.INVALID;
        }
    }

    private Student getStudentFromInput() {
        var input = new Scanner(System.in);

        try {
            System.out.print("Ім'я: ");
            var firstName = input.next();

            System.out.print("По батькові: ");
            var middleName = input.next();

            System.out.print("Прізвище: ");
            var lastName = input.next();

            return new Student(firstName, middleName, lastName);
        } catch (Exception e) {
            System.out.println("Введено невірні дані");
            return null;
        }
    }

    @Override
    public void listStudentGradebooks(List<StudentGradebook> gradebooks) {
        if (gradebooks.isEmpty()) {
            System.out.println("Не знайдено таких студентів");
        } else {
            System.out.printf("%-25s\t%-7s\t%-5s\t%-20s\t%s\n", "Студент", "Номер", "Курс", "Іспити", "Середній бал");
            for (StudentGradebook gradebook : gradebooks) {
                var exams = gradebook.getExams().stream().map(exam -> exam.getAsText())
                    .collect(Collectors.joining(", "));
                System.out.format("%-25s\t%-7s\t%-5s\t%-20s\t%.2f\n",
                    gradebook.getStudent().getName(), gradebook.getNumber(), gradebook.getCourse(),
                    exams, gradebook.getMedianGrade());
            }
        }
    }

    @Override
    public void showStudentNotFound() {
        System.out.println("Не знайдено такого студента");
    }

    @Override
    public void showStudentExams(List<Exam> exams) {
        if (exams.isEmpty()) {
            System.out.println("Студент не має екзаменів");
        } else {
            for (Exam exam : exams) {
                System.out.println("    " + exam.getAsText());
            }
        }
    }
}
