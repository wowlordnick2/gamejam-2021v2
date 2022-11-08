package de.wowlordnick2.utils.Enums;

public enum EventsDifficulties {

    FAST(0 , 60),
    NORMAL(5  , 0 ),
    SLOW(10 , 0);


    EventsDifficulties(int min , int sec) {

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
