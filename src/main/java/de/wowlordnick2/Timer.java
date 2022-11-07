package de.wowlordnick2;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Timer {


    public static boolean isRunning = false;
    public static boolean UP = true;
    public static boolean showTimer = true;

    public static int sec = 0;
    public static int min = 0;
    public static int hour = 0;


    /**
     * Start the timer
     */

    public void Timer(){


        new BukkitRunnable() {
            @Override
            public void run() {

                if (isRunning) {
                    if (UP) {
                        sec++;
                        if (sec == 60) {
                            sec = 0;
                            min++;
                        }
                        if (min == 60) {
                            min = 0;
                            hour++;
                        }
                    } else {
                        sec--;
                        if (sec == -1) {
                            sec = 59;
                            min--;
                        }
                        if (min == -1) {
                            min = 59;
                            hour--;
                        }
                    }
                }

                PlayerMangment.playerList.forEach(player -> {

                    if (showTimer) {
                        player.sendActionBar(Component.text("Timer: " + hour + ":" + min + ":" + sec));
                    }
                });

            }
        }.runTaskTimerAsynchronously(Main.getPlugin(Main.class) , 0 , 20);

    }

    /**
     * Return if the timer is running
     */
    public static boolean isRunning() {
        return isRunning;
    }

    /**
     * set the timer
     */
    public static void setTimer(int hour , int min , int sec) {
        Timer.hour = hour;
        Timer.min = min;
        Timer.sec = sec;
    }

    /**
     * set the timer to up or down
     */
    public static void setUP(boolean UP) {
        Timer.UP = UP;
    }

    /**
     * set the timer to running or not
     */
    public static void setRunning(boolean running) {
        isRunning = running;
    }


}
