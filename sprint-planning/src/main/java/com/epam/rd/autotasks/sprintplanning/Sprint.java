package com.epam.rd.autotasks.sprintplanning;

import com.epam.rd.autotasks.sprintplanning.tickets.Bug;
import com.epam.rd.autotasks.sprintplanning.tickets.Ticket;
import com.epam.rd.autotasks.sprintplanning.tickets.UserStory;

public class Sprint {
    int capacity;
    int ticketsLimit;
    Ticket[] tickets;

    public Sprint(int capacity, int ticketsLimit) {
        this.capacity  = capacity;
        this.ticketsLimit = ticketsLimit;
        tickets = new Ticket[ticketsLimit];
    }

    private int takeFirstAvailablePlaceInTickets() {
        int index = -1;
        for(int i = tickets.length-1; i >= 0 ; i--) {
            if (tickets[i] == null) {
                index = i;
            }
        }
        return index;
    }



    public boolean ifTicketCanBeAdded(Ticket ticket) {
        if (ticket != null ) {
            if (ticket.isCompleted() == false ) {
                if( (capacity - getTotalEstimate()) >= ticket.getEstimate() ) {
                    if (takeFirstAvailablePlaceInTickets() >= 0 ){   //check for limit



                        return true;
                    }
                }
            }
        }

        return false;

    }

    public boolean addUserStory(UserStory userStory) {
        if (ifTicketCanBeAdded(userStory) == true ) {
            if (userStory.getDependencies().length > 0) {
                int countOFFitDependencies = 0;
                for(int i = 0; i< tickets.length; i++) {
                    for(UserStory us : userStory.getDependencies())
                        if(us.equals(tickets[i])) {
                            countOFFitDependencies++;
                        }
                }
                if (countOFFitDependencies == userStory.getDependencies().length) {
                    tickets[takeFirstAvailablePlaceInTickets()] = userStory;
                    return true;
                }

            }else {
                tickets[takeFirstAvailablePlaceInTickets()] = userStory;
                return true;
            }
        }

        return false;
    }

    // accepts a userStory, if it is not null and not completed. Returns true if the bug is accepted, false otherwise.
    public boolean addBug(Bug bugReport) {
        if(ifTicketCanBeAdded(bugReport) == true) {
            tickets[takeFirstAvailablePlaceInTickets()] = bugReport;
            return true;
        }
        return false;
    }

    //Returns a defensive copy array of the sprint tickets. Make sure the order of tickets is as they were accepted to the sprint.
    public Ticket[] getTickets() {
        int countOfPutTickets = 0;
        for(int i = 0; i< tickets.length; i++) {
            if (tickets[i] != null) {
                countOfPutTickets++;
            }
        }

        Ticket[] ticketClone = new Ticket[countOfPutTickets];
        for(int i = 0; i< ticketClone.length; i++) {
            ticketClone[i] = tickets[i];
        }
        return ticketClone;
    }

    //Returns the sum of estimates of all the tickets accepted to the sprint.
    public int getTotalEstimate() {
        int sum = 0;
        for(int i= 0; i< tickets.length; i++) {
            if (tickets[i] != null) {
                sum = sum + tickets[i].getEstimate();
            }

        }
        return sum;
    }
}
