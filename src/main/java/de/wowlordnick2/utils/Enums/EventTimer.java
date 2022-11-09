package de.wowlordnick2.utils.Enums;

public enum EventTimer {

    FAST(0 , 60),
    NORMAL(5  , 0),
    SLOW(10 , 0);


    EventTimer(int min , int sec) {
        this.min = min;
        this.sec = sec;
    }

    //next Event Time in seconds
    private int min;
    private int sec;

    public int getMin() {
        return min;
    }

    public int getSec() {
        return sec;
    }
}
