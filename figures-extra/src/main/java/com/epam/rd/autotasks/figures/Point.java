package com.epam.rd.autotasks.figures;

import java.util.Objects;

class Point {
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Point other = (Point) obj;
        if(roundParametr(this.x) != roundParametr(other.x) ){
            return false;
        }
        if(roundParametr(this.y) != roundParametr(other.y)){
            return false;
        }

        return true;
    }
    private double roundParametr(double d) {
        return ((double)Math.round(d*100))/100;
    }

    private double x;
    private double y;

    public Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point [x=" + x + ", y=" + y + "]";
    }

}