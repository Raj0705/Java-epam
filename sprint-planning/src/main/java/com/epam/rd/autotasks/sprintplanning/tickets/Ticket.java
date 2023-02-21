package com.epam.rd.autotasks.sprintplanning.tickets;

public class Ticket {
    protected int id;
    protected String name;
    protected int estimate;
    protected boolean completedTicket = false;

    public Ticket(int id, String name, int estimate) {
        this.id = id;
        this.name = name;
        this.estimate = estimate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        if (completedTicket == true) {
            return true;
        }
        return false;
    }

    public void complete() { // complete() - Sets the ticket to completed state.
        completedTicket = true;
    }

    public int getEstimate() {
        return estimate;
    }
}
