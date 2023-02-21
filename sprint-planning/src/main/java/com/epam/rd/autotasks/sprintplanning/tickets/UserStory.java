package com.epam.rd.autotasks.sprintplanning.tickets;

public class UserStory extends Ticket {

    UserStory[] dependsOn;

    public UserStory(int id, String name, int estimate, UserStory... dependsOn) { //A dependency is another user story that must be completed first to allow the dependent user story to complete.
        super(id, name, estimate);
        this.dependsOn = dependsOn;
    }

    @Override
    //Like the Ticket#complete() method, this sets the ticket to completed state.
    //The difference is that the user story may not be completed if its dependencies are not completed yet.
    public void complete() {
        int countOfNonCompletedTicket = 0;
        for(UserStory i : dependsOn) {

            if (i.isCompleted() == true) {
                countOfNonCompletedTicket ++;
            }
        }
        if (countOfNonCompletedTicket == dependsOn.length) {
            completedTicket = true;
        }else 	completedTicket = false;
    }

    public UserStory[] getDependencies() { //getDependencies() - Returns a defensive copy of dependencies array.
        UserStory[] cloneDependencies = new UserStory[dependsOn.length];
        for(int j = 0; j < dependsOn.length; j ++) {
            cloneDependencies[j] = dependsOn[j];
        }

        return cloneDependencies;
    }

    @Override
    public String toString() {
        return "[US "+ id + "] " + name;
    }
}