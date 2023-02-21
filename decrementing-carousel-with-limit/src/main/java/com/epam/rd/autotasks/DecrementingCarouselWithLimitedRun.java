package com.epam.rd.autotasks;

public class DecrementingCarouselWithLimitedRun extends DecrementingCarousel{
    String typeOfChange = "DECREMENTING_LIMIT";
    int actionLimit;

    public DecrementingCarouselWithLimitedRun(final int capacity, final int actionLimit) {
        super(capacity);
        this.actionLimit = actionLimit;
    }

    @Override
    public CarouselRun run(){

        if (ifRun == true) {
            return null;
        }
        ifRun = true;
        CarouselRun carouselRun = new CarouselRun(arrayC, capacity, typeOfChange, actionLimit);
        return carouselRun;
    }
}