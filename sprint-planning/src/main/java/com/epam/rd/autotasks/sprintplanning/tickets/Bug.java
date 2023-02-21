package com.epam.rd.autotasks.sprintplanning.tickets;

public class Bug extends Ticket {
    UserStory userStory;
    static Bug newbug;

    public static Bug createBug(int id, String name, int estimate, UserStory userStory) {
        if(userStory.isCompleted() == false | userStory == null) {
            return null;
        }
        newbug = new Bug(id, name, estimate, userStory);
        return newbug;
    }

    private Bug(int id, String name, int estimate, UserStory userStory) {
        super(id, name, estimate);
        this.userStory = userStory;

    }

    @Override
    public String toString() {
        return "[Bug "+ id +"] "+ userStory.getName() + ": "+ name;
    }
}