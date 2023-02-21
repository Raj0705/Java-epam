package com.epam.rd.autotasks;

public class CompleteByRequestTask implements Task {
    /*Constructor of the CompleteByRequestTask takes no parameters.
    Calling execute method on the task does not make it finished until the complete method is called.
    Once the complete method is called, the next call to execute makes the task finished.
    Note that the task is not finished right after calling the complete method. The task finishes only when subsequent call to execute occurs*/
    private boolean finish = false;
    private boolean complite = false;


    @Override
    public void execute() {
        if(complite == true) {
            finish = true;
        }
    }

    @Override
    public boolean isFinished() {
        return finish;
    }

    public void complete() {
        complite = true;
    }
}