package de.wowlordnick2.utils;

import de.wowlordnick2.Main;
import org.bukkit.scheduler.BukkitRunnable;

public class EventTimer {

    public static boolean isRunning = false;

    private static int sec = 0;
    private static int min = 0;

    public void startTimer() {
        isRunning = true;

        sec = Main.difficulties.getSec();
        min = Main.difficulties.getMin();

        new BukkitRunnable() {



            @Override
            public void run() {

                if (sec == 0) {
                    sec = 59;
                    min--;
                } else if (min == 0) {
                    sec = 59;
                    sec--;
                } else if (sec == 0 && min == 0) {
                    cancel();
                } else {
                    sec--;
                }



            }
        }.runTaskTimerAsynchronously(Main.getInstance(), 0, 20);


    }

    public static String getEventTimer() {
        return "Nächstes Event in " + min + ":" + sec;
    }

}
