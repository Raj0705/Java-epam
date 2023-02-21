package com.epam.rd.autotasks.figures;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

import java.util.Objects;

class Triangle extends Figure {
    private Point point1, point2, point3;
    private double length1, length2, length3;

    public Triangle(Point point1, Point point2, Point point3) {
        if (point1 == null || point2 == null || point3 == null) {
            throw new IllegalArgumentException();
        }

        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;

        length1 = getLength(point1,point2);
        length2 = getLength(point2,point3);
        length3 = getLength(point3,point1);

        if((length1 + length2) <= length3 || (length2 + length3) <= length1 || (length1 + length3) <= length2) {
            throw new IllegalArgumentException();
        }
        checkIspointsOntheLine();
    }
    private void checkIspointsOntheLine() {
        Point start1 = point1;
        Point end1 = point2;
        Point start2 = point2;
        Point end2 = point3;
        double m1 = (start1.getY()-end1.getY())/(start1.getX() - end1.getX());
        double m2 = 0;
        if(start2.getX() - end2.getX() == 0) {
            m2 = (start2.getY()-end2.getY())/1;
        }else {
            m2 = (start2.getY()-end2.getY())/(start2.getX() - end2.getX());;
        }
        if (m1 == m2) {
            throw new IllegalArgumentException();
        }
    }

    private double getLength(Point start, Point end) {
        double length = abs(sqrt(pow((start.getX() - end.getX()), 2)+pow((start.getY() - end.getY()),2)));
        return length;
    }



    @Override
    public double area() {
        double p = (length1 + length2 + length3)/2;
        double areaValue = Math.sqrt(p*(p-length1)*(p -length2)*(p - length3));
        return areaValue;
    }

    @Override
    public String pointsToString() {
        return "(" + point1.getX() + "," + point1.getY() + ")(" + + point2.getX() + "," + point2.getY() + ")(" + + point3.getX() + "," + point3.getY()+ ")" ;
    }

    @Override
    public Point leftmostPoint() {
        Point[] points = {point1, point2, point3};
        Point leftPoint = point1;
        for(Point point: points) {
            if(point.getX() < leftPoint.getX()) {
                leftPoint = point;
            }
        }
        return leftPoint;
    }

    @Override
    public Point centroid() {
        double centrX = (point1.getX() + point2.getX() + point3.getX())/3;
        double centrY = (point1.getY() + point2.getY() + point3.getY())/3;

        Point centroid = new Point(centrX, centrY);
        return centroid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(point1, point2, point3);
    }

    @Override
    public boolean isTheSame(Figure figure){
        if (this == figure)
            return true;
        if (figure == null)
            return false;
        if (getClass() != figure.getClass())
            return false;
        Triangle other = (Triangle) figure;

        return Objects.equals(point1, other.point1) && Objects.equals(point2, other.point2)
                && Objects.equals(point3, other.point3);
    }



}