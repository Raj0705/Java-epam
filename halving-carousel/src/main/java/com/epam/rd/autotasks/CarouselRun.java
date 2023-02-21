package com.epam.rd.autotasks;

public class CarouselRun {
    int[] arrayC;
    int capacity;
    int typeOfCarousel;

    public CarouselRun(int[] arrayC, int capacity, int typeOfCarousel) {
        this.arrayC = arrayC;
        this.capacity = capacity;
        this.typeOfCarousel = typeOfCarousel;
    }

    public int next() {
        if (isFinished() == false) {
            while(arrayC[0] == 0) {
                turn();
            }
            int firstElement = arrayC[0];
            if(typeOfCarousel == 0) {
                arrayC[0] = firstElement-1;
            }
            if (typeOfCarousel == 1) {
                arrayC[0] = firstElement/2;
                if(firstElement == 1) {
                    arrayC[0] = 0;
                }
            }
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
        for(int j = 0; j < capacity; j++) {
            if(arrayC[j] > 0) {
                return false;
            }

        }
        return true;
    }

}