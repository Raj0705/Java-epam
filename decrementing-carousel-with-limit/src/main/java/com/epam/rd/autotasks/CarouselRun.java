package com.epam.rd.autotasks;

public class CarouselRun {
    int[] arrayC;
    int capacity;
    String typeOfChange;
    int counter = 1;
    //int round = 1;
    int actionLimit;
    boolean stop = false;


    public CarouselRun(int[] arrayC, int capacity, String typeOfChange, int actionLimit) {
        this.arrayC = arrayC;
        this.capacity = capacity;
        this.typeOfChange = typeOfChange;
        this.actionLimit = actionLimit;
    }

    public CarouselRun(int[] arrayC, int capacity, String typeOfChange) {
        this.arrayC = arrayC;
        this.capacity = capacity;
        this.typeOfChange = typeOfChange;
    }







    public int next() {
        if (isFinished() == false) {
            while(arrayC[0] == 0) {
                turn();
            }
            int firstElement = arrayC[0];
            arrayC[0] = changeElement(firstElement);
            turn();
            return firstElement;

        }
        return -1;
    }

    public int changeElement(int element) {
        switch (typeOfChange) {
            case "DECREMENTING":
                element--;
                break;
            case "DECREMENTING_LIMIT":
                if (counter == actionLimit) {
                    stop = true;
                }
                element--;
                counter++;
                break;
            default:
                System.out.println("There is no such carousel type");

        }

        return element;
    }


    public void turn() {
        int firstElement = arrayC[0];
        for(int i = 0; i < capacity-1; i++) {
            arrayC[i] = arrayC[i+1];
        }
        arrayC[capacity-1] = firstElement;

    }


    public boolean isFinished() {
        if(stop==false) {
            for(int j = 0; j < arrayC.length; j++) {
                if(arrayC[j] > 0) {
                    return false;
                }
            }
        }
        return true;

    }

}