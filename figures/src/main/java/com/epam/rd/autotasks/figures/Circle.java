package com.epam.rd.autotasks.figures;

class Circle extends Figure{

    private Point point;
    private double radius;

    public Circle(Point point, double radius) {
        this.point = point;
        this.radius = radius;
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


}