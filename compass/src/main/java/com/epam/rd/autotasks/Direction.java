package com.epam.rd.autotasks;

import java.util.Optional;

public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);
    private int degrees;

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    private static int changeDegreesToCorrect(int degrees) {
        if(degrees <0) {
            degrees = 360+degrees;
        }
        while (degrees >= 360) {
            degrees = degrees-360;
        }
        if(degrees > 337) {
            return 315;
        }
        return degrees;
    }

    public static Direction ofDegrees(int degrees) {
        degrees = changeDegreesToCorrect(degrees);
        for(Direction direction : Direction.values()) {
            if (direction.degrees == degrees) {
                return direction;
            }
        }
        return null;
    }

    public static Direction closestToDegrees(int degrees) {
        degrees = changeDegreesToCorrect(degrees);
        int position = degrees/45;
        if(position !=0) {
            if( (degrees - (position*45)) > 22) {
                position = position+1;
            }
        }else {
            if( degrees > 22)
                position = position+1;
        }
        System.out.println("degrees = " + degrees + ", position = " + position);////////////////////
        for(Direction direction : Direction.values()) {
            if (direction.ordinal() == position) {
                return direction;
            }
        }
        return null;
    }

    public Direction opposite() {
        for(Direction direction : Direction.values()) {
            if (Math.abs(this.compareTo(direction)) == 4) {
                return direction;
            }
        }
        return null;
    }

    public int differenceDegreesTo(Direction direction) {
        //returns the difference in degrees between the specified value and the input Direction instance.
        int differentPosition = Math.abs(direction.compareTo(this));
        if(differentPosition == 7) {
            differentPosition = 1;
        }
        return differentPosition*45;

    }
}