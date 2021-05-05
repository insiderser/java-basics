package com.insiderser.kpi.java;

import static java.lang.Math.sqrt;

import java.util.HashSet;
import java.util.Set;

public class TrianglesDataSource {

    public static Set<Triangle> getAll() {
        return new HashSet<>() {{
            add(new Triangle(0, 0, 3, 0, 0, 3));
            add(new Triangle(0, 0, 4, 0, 0, 3));
            add(new Triangle(0, 0, 4, 1, 0, 3));
            add(new Triangle(0, 0, 3, 1, (3 - sqrt(3)) / 2, (1 + 3 * sqrt(3)) / 2));
        }};
    }
}
