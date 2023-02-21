package com.epam.rd.autotasks;
/*A task carousel has a capacity provided as a constructor parameter.
The TaskCarousel has isEmpty method. It returns true if there is no task in the carousel for execution. Returns false otherwise.
The TaskCarousel has isFull method. It returns true if there is no more room in the carousel to add another task. Returns false otherwise.
You may add tasks to the carousel via addTask method. It returns true if the task is accepted and false otherwise.
Task may be not accepted due to following reasons:
- Task argument is null.
 - Task is already finished.
- Carousel is full.
You may execute tasks in the carousel via execute method.
Each time when this method is invoked, carousel must switch to the next task within and execute it.
Iteration is in circular manner. If there are 4 tasks inside a carousel, then if we call execute method on the carousel 4 times in a row,
each task must be executed once.
If the task is finished after execution, remove it from the carousel.
The method returns true if any task was executed. Returns false otherwise.*/

public class TaskCarousel {
    private int capacity;
    private int currentPositionExecute = -1;

    private Task[] tasks;

    public TaskCarousel(int capacity) {
        this.capacity = capacity;
        this.tasks = new Task[capacity];
    }

    private int positionFirstFreeAdd() {
        int position = -1;
        for(int i=tasks.length-1; i>=0; i--) {
            if (tasks[i] == null) {
                position = i;
            }
        }
        return position;
    }

    private boolean checkTask(Task task) {
        if(task != null) {
            if(task.isFinished() == false) {
                if( isFull() == false) {
                    return true;
                }}
        }
        return false;
    }

    public boolean addTask(Task task) {
        int position = positionFirstFreeAdd();
        if (checkTask(task) == true & position >=0) {
            tasks[position] = task;
            return true;
        }
        return false;
    }

    public boolean execute() {
        resetCurrentPosition();
        if (currentPositionExecute >= 0 && tasks[currentPositionExecute]!=null) {

            if(tasks[currentPositionExecute].isFinished() == false) {
                tasks[currentPositionExecute].execute();
                if (tasks[currentPositionExecute].isFinished() == true) {
                    tasks[currentPositionExecute] = null;
                }

                return true;
            }

        }
        return false;
    }
    private int resetCurrentPosition() {
        currentPositionExecute++;
        if(isEmpty() == false) {
            if(currentPositionExecute == capacity) {
                currentPositionExecute = 0;
            }
            for(int i = currentPositionExecute; i<tasks.length; i++) {
                if (tasks[i]!=null) {
                    currentPositionExecute = i;
                    return currentPositionExecute;
                }
            }
            for(int i=0; i<currentPositionExecute; i++) {
                if (tasks[i]!=null) {
                    currentPositionExecute = i;
                    return currentPositionExecute;
                }
            }

        }else {currentPositionExecute = -1;}

        return currentPositionExecute;

    }

    public boolean isFull() {
        boolean b = (positionFirstFreeAdd() == -1);
        return b;
    }

    public boolean isEmpty() {
        for(int i = 0; i<tasks.length; i++) {
            if(tasks[i]!=null) {
                return false;
            }
        }
        return true;

    }

}