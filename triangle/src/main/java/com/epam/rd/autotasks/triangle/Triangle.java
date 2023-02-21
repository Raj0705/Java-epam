package com.epam.rd.autotasks.triangle;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Triangle {
    private Point a,b,c;
    private double length1, length2,  length3;
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;

        length1 = getLength(a,b);
        length2 = getLength(b,c);
        length3 = getLength(c,a);

        System.out.println("length1 = "+ length1 + ", length2 = " + length2 + ", length3 = " + length3 );
        if((length1 + length2) <= length3 | (length2 + length3) <= length1 | (length1 + length3) <= length2) {
            throw new IllegalArgumentException();
        }

    }
    public double getLength(Point start, Point end) {

        double length = abs(sqrt(pow((start.getX() - end.getX()), 2)+pow((start.getY() - end.getY()),2)));
        return length;
    }

    public double area() {

        double p = (length1 + length2 + length3)/2;
        double areaValue = Math.sqrt(p*(p-length1)*(p -length2)*(p - length3));
        System.out.println("s = " + areaValue);
        return areaValue;
    }

    public Point centroid(){

        double centrX = (a.getX() + b.getX() + c.getX())/3;
        double centrY = (a.getY() + b.getY() + c.getY())/3;

        Point centroid = new Point(centrX, centrY);
        return centroid;
    }

}