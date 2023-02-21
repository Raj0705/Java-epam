package com.epam.rd.autotasks;

public class DecrementingCarousel {
    protected int capacity;
    int[] arrayC;
    boolean ifRun = false;

    public DecrementingCarousel(int capacity) {
        this.capacity = capacity;
        this.arrayC = new int[capacity];
    }

    public boolean addElement(int element){
        boolean isAdded = false;
        if (ifRun == false) {
            if(element > 0 ) {
                for(int i = 0; i<capacity; i++) {
                    if(arrayC[i] == 0) {
                        arrayC[i] = element;
                        isAdded = true;
                        break;
                    }
                }
            }else {
                isAdded = false;
            }
        }else {
            isAdded = false;
        }
        return isAdded;
    }


    public CarouselRun run(){

        if (ifRun == true) {
            return null;
        }
        ifRun = true;
        CarouselRun carouselRun = new CarouselRun(arrayC, capacity, 0);
        return carouselRun;
    }
}
