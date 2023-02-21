package com.epam.rd.autotasks.figures;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

import java.util.Objects;

class Quadrilateral extends Figure {

    private Point point1, point2, point3, point4;

    public Quadrilateral( Point point1, Point point2, Point point3, Point point4) {
        if (point1 == null || point2 == null || point3 == null || point4 == null) {
            throw new IllegalArgumentException();
        }
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.point4 = point4;

        checkConvext();
    }

    private void checkConvext() {
        Point[] points = {point1,  point2,  point3,  point4} ;
        for (int i = 0; i< points.length-1; i++) {
            for(int j = i+1; j<points.length; j++ ) {
                if(points[i].equals(points[j])) {
                    throw new IllegalArgumentException();
                }
            }
        }
        double ab = (point1.getX()-point2.getX())/(point2.getY()-point1.getY());
        if(ab == (point1.getX()-point3.getX())/(point3.getY()-point1.getY()) || ab == (point1.getX()-point4.getX())/(point4.getY()-point1.getY())) {
            throw new IllegalArgumentException();
        }


        Point intersec = intersection(point2, point4, point1, point3);
        if(intersec == null) {
            throw new IllegalArgumentException();
        }
        if(getLength(point1, point3) < getLength(point1, intersec)) {
            throw new IllegalArgumentException();
        }
        if(getLength(point2, point4) < getLength(point2, intersec)) {
            throw new IllegalArgumentException();
        }


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


    @Override
    public Point centroid() {
        Triangle triangle1 = new Triangle(point1,point2,point4);
        Triangle triangle2 = new Triangle(point2,point3,point4);
        Triangle triangle3 = new Triangle(point1,point2,point3);
        Triangle triangle4 = new Triangle(point3,point4,point1);
        Point pointСentroid1 = triangle1.centroid();
        Point pointСentroid2 = triangle2.centroid();
        Point pointСentroid3 = triangle3.centroid();
        Point pointСentroid4 = triangle4.centroid();
        Point pointСentroid =  intersection(pointСentroid1, pointСentroid2, pointСentroid3, pointСentroid4);

        return pointСentroid;
    }

    Point intersection(Point start1,Point end1,Point start2,Point end2) {
        double m1 = (start1.getY()-end1.getY())/(start1.getX() - end1.getX());
        double b1 = m1*start1.getX()-start1.getY();
        double m2 = 0;
        if(start2.getX() - end2.getX() == 0) {
            m2 = (start2.getY()-end2.getY())/1;
        }else {
            m2 = (start2.getY()-end2.getY())/(start2.getX() - end2.getX());;
        }
        double b2 = m2*start2.getX()-start2.getY();

        if (m1 == m2) {
            return null;
        }
        double x = -(b2 - b1) / (m1 - m2);
        double y = m1 * x - b1;
        return new Point(x,y);
    }


    @Override
    public int hashCode() {
        return Objects.hash(point1, point2, point3, point4);
    }
    @Override
    public boolean isTheSame(Figure figure) {
        if (this == figure)
            return true;
        if (figure == null)
            return false;
        if (getClass() != figure.getClass())
            return false;
        Quadrilateral other = (Quadrilateral) figure;
        boolean same1 = (point1.equals(other.point1) && point2.equals(other.point2) && point3.equals(other.point3) && point4.equals(other.point4));
        boolean same2 = (point2.equals(other.point1) && point3.equals(other.point2) && point4.equals(other.point3) && point1.equals(other.point4));
        boolean same3 = (point3.equals(other.point1) && point4.equals(other.point2) && point1.equals(other.point3) && point2.equals(other.point4));
        boolean same4 = (point4.equals(other.point1) && point1.equals(other.point2) && point2.equals(other.point3) && point3.equals(other.point4));
        boolean same5 = (point2.equals(other.point1) && point1.equals(other.point2) && point4.equals(other.point3) && point3.equals(other.point4));
        boolean same6 = (point3.equals(other.point1) && point2.equals(other.point2) && point1.equals(other.point3) && point4.equals(other.point4));

        return same1 || same2 || same3 || same4 || same5 || same6;
    }


}