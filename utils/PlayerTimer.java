package de.wowlordnick2.utils;

import de.wowlordnick2.Main;
import de.wowlordnick2.events.TimerOut;
import net.kyori.adventure.text.Component;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.logging.Formatter;

import static de.wowlordnick2.Main.color;

public class PlayerTimer {


    /**
     * Start the player timer with the given timer enum
     * @param timer
     */


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

                if (PlayerMangment.playerList.size() == 0) {

                    Bukkit.broadcastMessage(color(Main.getPrefix() + "Das Event wurde beendet ,da es keine Spieler in der Liste gibt!"));
                    cancel();
                } else {

                    TextComponent component = new TextComponent("§7Spiel läuft schon seit " + (hour < 10 ? "0" + hour : hour) + "h:" + (min < 10 ? "0" + min : min) + "m:" + (sec < 10 ? "0" + sec : sec)+ "s");
                    for (Player all : Bukkit.getOnlinePlayers()) {

                        if (showTimer) {

                            all.spigot().sendMessage(ChatMessageType.ACTION_BAR, component);
                        } else {
                            component = new TextComponent(color("&cHier gib es nichts zu sehen!"));

                            all.spigot().sendMessage(ChatMessageType.ACTION_BAR, component);

                        }


                    }
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
