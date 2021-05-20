package com.insiderser.kpi.java;

import static java.lang.Math.sqrt;

import java.util.HashSet;
import java.util.Set;

public class TrianglesDataSource {

    private static final int GENERATED_TRIANGLES_COUNT = 5;
    private static final double COORDINATE_UPPER_BOUND = 10;

    public static Set<Triangle> getAll() {
        return new HashSet<>() {{
            add(new Triangle(0, 0, 3, 0, 0, 3));
            add(new Triangle(0, 0, 4, 0, 0, 3));
            add(new Triangle(0, 0, 4, 1, 0, 3));
            add(new Triangle(0, 0, 3, 1, (3 - sqrt(3)) / 2, (1 + 3 * sqrt(3)) / 2));

            for (int i = 0; i < GENERATED_TRIANGLES_COUNT; i++) {
                //noinspection StatementWithEmptyBody
                while (!add(generateTriangle())) {
                }
            }
        }};
    }

    private static Triangle generateTriangle() {
        return new Triangle(
            generateCoordinate(), generateCoordinate(), generateCoordinate(), generateCoordinate(), generateCoordinate(), generateCoordinate()
        );
    }

    private static double generateCoordinate() {
        return Math.random() * COORDINATE_UPPER_BOUND;
    }
}
