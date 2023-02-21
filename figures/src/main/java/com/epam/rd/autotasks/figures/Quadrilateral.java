package com.epam.rd.autotasks.figures;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Quadrilateral extends Figure {

    private Point point1, point2, point3, point4;
    private double length1, length2, length3, length4;

    public Quadrilateral( Point point1, Point point2, Point point3, Point point4) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.point4 = point4;

        length1 = getLength(point1,point2);
        length2 = getLength(point2,point3);
        length3 = getLength(point3,point4);
        length4 = getLength(point4,point1);
    }
    private double getLength(Point start, Point end) {
        double length = abs(sqrt(pow((start.getX() - end.getX()), 2)+pow((start.getY() - end.getY()),2)));
        return length;
    }

    @Override
    public double area() {
        Triangle triandle1 = new Triangle(point1, point2, point4);
        Triangle triandle2 = new Triangle(point2, point3, point4);
        return triandle1.area() + triandle2.area();
    }

    @Override
    public String pointsToString() {
        return "(" + point1.getX() + "," + point1.getY() + ")(" + + point2.getX() + "," + point2.getY() + ")(" + + point3.getX() + "," + point3.getY()+ ")(" + point4.getX() + "," + point4.getY() + ")";
    }


    @Override
    public Point leftmostPoint() {
        Point[] points = {point1, point2, point3, point4};
        Point leftPoint = point1;
        for(Point point: points) {
            if(point.getX() < leftPoint.getX()) {
                leftPoint = point;
            }
        }
        return leftPoint;
    }

}