package com.insiderser.kpi.java;

import java.util.Objects;

public class Triangle {

    private static final double PRECISION = 1.0E-10;

    private final double x1;
    private final double y1;

    private final double x2;
    private final double y2;

    private final double x3;
    private final double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    public double getX1() {
        return x1;
    }

    public double getY1() {
        return y1;
    }

    public double getX2() {
        return x2;
    }

    public double getY2() {
        return y2;
    }

    public double getX3() {
        return x3;
    }

    public double getY3() {
        return y3;
    }

    public double getSide1Length() {
        return length(x1, y1, x2, y2);
    }

    public double getSide2Length() {
        return length(x2, y2, x3, y3);
    }

    public double getSide3Length() {
        return length(x1, y1, x3, y3);
    }

    private double length(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    /**
     * Рівносторонній
     */
    public boolean isEquilateral() {
        return Math.abs(getSide1Length() - getSide2Length()) <= PRECISION && Math.abs(getSide2Length() - getSide3Length()) <= PRECISION;
    }

    /**
     * Рівнобедренний
     */
    public boolean isIsosceles() {
        return Math.abs(getSide1Length() - getSide2Length()) <= PRECISION ||
            Math.abs(getSide2Length() - getSide3Length()) <= PRECISION ||
            Math.abs(getSide1Length() - getSide3Length()) <= PRECISION;
    }

    /**
     * Різносторонній
     */
    public boolean isVersatile() {
        return !isIsosceles();
    }

    /**
     * Прямокутний
     */
    public boolean isRight() {
        double c = Math.max(Math.max(getSide1Length(), getSide2Length()), getSide3Length());
        double a = Math.min(Math.min(getSide1Length(), getSide2Length()), getSide3Length());
        double b = findB(a, c);

        return Math.abs(Math.pow(c, 2) - Math.pow(a, 2) - Math.pow(b, 2)) <= PRECISION;
    }

    private double findB(double a, double c) {
        long aBits = Double.doubleToLongBits(a);
        long cBits = Double.doubleToLongBits(c);
        long side1Bits = Double.doubleToLongBits(getSide1Length());
        long side2Bits = Double.doubleToLongBits(getSide2Length());
        long side3Bits = Double.doubleToLongBits(getSide3Length());

        long bBits = side1Bits ^ side2Bits ^ side3Bits ^ aBits ^ cBits;
        return Double.longBitsToDouble(bBits);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.x1, x1) == 0 && Double.compare(triangle.y1, y1) == 0
            && Double.compare(triangle.x2, x2) == 0 && Double.compare(triangle.y2, y2) == 0
            && Double.compare(triangle.x3, x3) == 0 && Double.compare(triangle.y3, y3) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x1, y1, x2, y2, x3, y3);
    }

    @Override
    public String toString() {
        return "(" + x1 + ", " + y1 + "), (" + x2 + ", " + y2 + "), (" + x3 + ", " + y3 + ")";
    }
}
