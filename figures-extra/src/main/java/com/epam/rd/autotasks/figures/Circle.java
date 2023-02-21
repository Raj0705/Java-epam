package com.epam.rd.autotasks.figures;

import java.util.Objects;

class Circle extends Figure{

    private Point point;
    private double radius;

    public Circle(Point point, double radius) {
        checkValues(point, radius);
        this.point = point;
        this.radius = radius;
    }

    private void checkValues(Point point, double radius) {
        if(point == null || radius <= 0) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public double area() {
        return Math.PI*radius*radius;
    }

    @Override
    public String pointsToString() {
        return "(" + point.getX() + "," + point.getY()+ ")";
    }

    @Override
    public Point leftmostPoint() {
        Point leftpoint = new Point((point.getX()-radius), point.getY());
        return leftpoint;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[" + pointsToString() + radius + "]";
    }
    @Override
    public Point centroid() {
        return point;
    }


    public boolean isTheSame(Figure obj) {
        if (this == obj)
            return true;
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Circle other = (Circle) obj;
        if( roundParametr(this.radius)!= roundParametr(other.radius)) {
            return false;
        }
        if(!this.point.equals(other.point)) {
            return false;
        }

        return true;
    }
    private double roundParametr(double d) {
        return ((double)Math.round(d*100))/100;
    }

    @Override
    public int hashCode() {
        return Objects.hash(point, radius);
    }



}