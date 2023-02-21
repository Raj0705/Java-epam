package com.epam.rd.autotasks.segments;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Segment {

    private Point start, end;
    private double startX, endX, startY,endY;

    public Segment(Point start, Point end) {
        if( start == null | end == null) {
            throw new IllegalArgumentException();
        }else {
            this.startX = start.getX();
            this.endX = end.getX();
            this.startY = start.getY();
            this.endY = end.getY();
            if (startX == endX & startY == endY) {
                throw new IllegalArgumentException();
            }
            this.start = start;
            this.end = end;
        }
    }

    double length() {
        double length1 = abs(sqrt(pow((startX - endX), 2)+pow((startY - endY),2)));
        return length1;
    }

    Point middle() {

        double x = (endX - startX)/2 + startX;
        double y = (endY - startY)/2 + startY;
        Point middlePoint = new Point(x , y);

        return middlePoint;
    }

    Point intersection(Segment another) {

        double startX2 = another.start.getX();
        double endX2 = another.end.getX();
        double startY2 = another.start.getY();
        double endY2 = another.end.getY();

        double k,b,k2,b2,x,y;
        k = (startY - endY)/(startX - endX);
        b = startY - k*startX;
        k2 = (startY2 - endY2)/(startX2 - endX2);
        b2 = startY2 - k*startX2;
        if(k == k2) {
            return null;
        }


        double a1 = endY - startY;
        double b1 = startX - endX;
        double c1 = -a1*startX - b1*startY;

        double a2 = endY2 - startY2;
        double bb2 = startX2 - endX2;
        double c2 = -a2*startX2 - bb2*startY2;

        double f1 = a1 * startX2 + b1 * startY2 + c1;
        double f2 = a1 * endX2 + b1 * endX2 + c1;
        double f3 = a2 * startX + bb2 * startY + c2;
        double f4 = a2 * endX + bb2 * endY + c2;

        if(f1*f2 > 0 | f3*f4 > 0) {
            return null;
        }

        if((k == k2) ) {
            return null;
        }
        x = (b2-b)/(k-k2);
        y = (k*x + b);


        Point point = new Point(x,y);
        return point;

    }

}