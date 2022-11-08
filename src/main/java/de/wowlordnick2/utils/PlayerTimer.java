package de.wowlordnick2.utils;

import de.wowlordnick2.Main;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerTimer {


    public static boolean isRunning = false;
    public static boolean UP = true;
    public static boolean showTimer = true;

    public static int sec = 0;
    public static int min = 0;
    public static int hour = 0;


    /**
     * Start the timer
     */

    public static  void Timer(){


        new BukkitRunnable() {
            @Override
            public void run() {
                if (isRunning) {
                    if (UP) {
                        if (sec == 60) {
                            sec = 0;
                            min++;
                        } else if (min == 60) {
                            min = 0;
                            hour++;
                        } else {
                            sec++;
                        }

                        //RUN the timer down
                    } else {
                        if (sec == 0) {
                            sec = 59;
                            min--;
                        } else if (min == 0) {
                            sec = 59;
                        } else if (hour == 0) {
                            hour = 0;
                            min = 59;
                            sec = 59;
                        } else if (sec == 0 && min == 0 && hour == 0) {
                            cancel();
                        } else {
                            sec--;
                        }
                    }
                }
                if (showTimer) {
                    Bukkit.getOnlinePlayers().forEach(player -> {
                        player.sendActionBar(Component.text(Main.color("&7Timer: &e" + hour + ":" + min + ":" + sec  + EventTimer.getEventTimer())));
                    });

                }



            }
        }.runTaskTimerAsynchronously(Main.getInstance() , 0 , 20);

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
        PlayerTimer.hour = hour;
        PlayerTimer.min = min;
        PlayerTimer.sec = sec;
    }

    /**
     * set the timer to up or down
     */
    public static void setUP(boolean UP) {
        PlayerTimer.UP = UP;
    }

    /**
     * set the timer to running or not
     */
    public static void setRunning(boolean running) {
        isRunning = running;
    }




}
