package com.epam.rd.autotasks.intersection;

public class Line {
    private int x,y,k,b;
    public Line(int k, int b) {
        this.k = k;
        this.b = b;
    }

    public Point intersection(Line other) {
        if(this.k == other.k) {
            return null;
        }
        x = (b-other.b)/(other.k-k);
        y = k*x+b;

        Point point = new Point(x,y);
        return point;
    }

}