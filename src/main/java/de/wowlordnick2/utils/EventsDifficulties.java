package de.wowlordnick2.utils;

public enum EventsDifficulties {

    FAST(60),
    NORMAL(300),
    SLOW(600);

    EventsDifficulties(int nextEventTime) {

        this.nextEventTime = nextEventTime;


    }

    //next Event Time in seconds
    private int nextEventTime;

    public int getNextEventTime() {
        return nextEventTime;
    }
}
