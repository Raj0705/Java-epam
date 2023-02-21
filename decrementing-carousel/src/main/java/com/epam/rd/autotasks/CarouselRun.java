package com.epam.rd.autotasks;

public class CarouselRun {
    int[] arrayC;
    int capacity;

    public CarouselRun(int[] arrayC, int capacity) {
        this.arrayC = arrayC;
        this.capacity = capacity;
    }

    public int next() {
        if (isFinished() == false) {
            while(arrayC[0] == 0) {
                turn();
            }
            int firstElement = arrayC[0];
            if (isFinished() == true) {
                return -1;
            }
            arrayC[0] = DecrementingCarousel.changeElement(firstElement);
            turn();
            return firstElement;
        }
        return -1;
    }


    public void turn() {
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