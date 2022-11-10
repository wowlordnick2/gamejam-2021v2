package de.wowlordnick2.utils.Enums;

public enum TimerState {

    /**
     * Different Game States
     */

    WARMUP(),
    STARTED(),
    STOPPED();



    TimerState() {

    }


    public boolean isWARMUP() {
        return this == WARMUP;
    }



}
