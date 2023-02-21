package com.epam.rd.autotasks;

public class CountDownTask implements Task{
    /*The constructor of CountDownTask takes a single int value as a parameter.
     * It is the initial value of the countdown. Input value must not be negative. If it is, set zero value.
    Each time the execute method is called, this value decrements by one, until it reaches zero.
    Then the execute method no longer decrements the value and the task is considered finished.
    If the task is initialized with zero value, consider it finished right upon creating.
    Value of the task is accessible via getter.
    */
    private int value;
    private boolean finish = false;

    public CountDownTask(int value) {
        value = checkValue(value);
        this.value = value;
    }

    private int checkValue(int value) {
        if(value<0) {
            value = 0;
        }
        return value;
    }

    public int getValue() {
        return value;
    }


    @Override
    public void execute() {
        if (isFinished() == false) {
            value--;
        }
    }

    @Override
    public boolean isFinished() {
        return (this.value == 0);
    }
}