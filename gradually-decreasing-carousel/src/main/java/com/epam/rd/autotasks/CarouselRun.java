package com.epam.rd.autotasks;

public class CarouselRun {
    int[] arrayC;
    int capacity;
    String typeOfChange;
    int counter = 1;
    int round = 1;

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
            System.out.println("return " + firstElement);
            return firstElement;

        }
        return -1;
    }

    public int changeElement(int element) {
        switch (typeOfChange) {
            case "DECREMENTING": element--;
                break;
            case "GRADUALLY":
                element = element-round;
                if(element<0) {element = 0;}
                break;
            default:
                System.out.println("There is no such carousel type");

        }

        return element;
    }


    public void turn() {
        counter++;
        if(counter > capacity) {
            round++;
            counter=1;
        }
        int firstElement = arrayC[0];
        for(int i = 0; i < capacity-1; i++) {
            arrayC[i] = arrayC[i+1];
        }
        arrayC[capacity-1] = firstElement;


    }


    public boolean isFinished() {
        int max = arrayC[0];
        for(int j = 0; j < capacity-1; j++) {
            if(arrayC[j] < arrayC[j+1]) {
                max = arrayC[j+1];
            }
        }
        if(max == 0) {
            return true;
        }else {
            return false;
        }


    }

}