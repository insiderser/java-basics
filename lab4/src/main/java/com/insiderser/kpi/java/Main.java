package com.insiderser.kpi.java;

import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<Triangle> triangles = TrianglesDataSource.getAll();

        for (Triangle triangle : triangles) {
            System.out.println();
            System.out.println("Трикутник " + triangle + ":");
            System.out.println("    Прямокутний=" + triangle.isRight());
            System.out.println("    Рівносторонній=" + triangle.isEquilateral());
            System.out.println("    Рівнобедрений=" + triangle.isIsosceles());
            System.out.println("    Різносторонній=" + triangle.isVersatile());
        }
    }
}
