package com.epam.rd.autotasks;

public class HalvingCarousel extends DecrementingCarousel {

    public HalvingCarousel(final int capacity) {
        super(capacity);
    }

    public CarouselRun run(){

        if (ifRun == true) {
            return null;
        }
        ifRun = true;
        CarouselRun carouselRun = new CarouselRun(arrayC, capacity, 1);

        return carouselRun;
    }

}