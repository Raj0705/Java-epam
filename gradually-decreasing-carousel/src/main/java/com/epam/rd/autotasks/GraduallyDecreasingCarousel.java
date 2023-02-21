package com.epam.rd.autotasks;

public class GraduallyDecreasingCarousel extends DecrementingCarousel{
    String typeOfChange = "GRADUALLY";

    public GraduallyDecreasingCarousel(final int capacity) {
        super(capacity);
    }

    @Override
    public CarouselRun run(){

        if (ifRun == true) {
            return null;
        }
        ifRun = true;
        CarouselRun carouselRun = new CarouselRun(arrayC, capacity, typeOfChange);

        return carouselRun;
    }
}