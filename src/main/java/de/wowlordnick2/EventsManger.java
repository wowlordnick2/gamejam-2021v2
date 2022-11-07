package de.wowlordnick2;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Boss;
import org.bukkit.entity.Minecart;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Command;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public abstract class EventsManger {

    /**
     * @param playerList
     * @param eventTitle
     * @param positive
     * @param onEvent
     * @param endEvent
     */
    /**
     * The List of all registered Events
     */
    public static ArrayList<EventsManger> events = new ArrayList<>();
    /**
     * Is the onEnable method of the events
     */
    public abstract void onEnable();
    /**
     * Is the onDisable method of the events
     */
    public void onDisable() {
        System.out.println("Event stopped" + eventTitle());
    }
    /**
     * Return the name of the event
     */
    public abstract String eventTitle();
    /**
     * Return the value of the event (positive or negative)
     */
    public abstract boolean positive();
    /**
     * Return the ItemStack of the event
     */
    public abstract ItemStack itemStack(); //coming soon

    /**
     *  1. Register a new event
     */
    public static void registerEvents(EventsManger eventsManger) {
        events.add(eventsManger);
    }
    /**
     *  2. Unregister a new event
     */
    public static void unregisterEvents(EventsManger eventsManger) {
        events.remove(eventsManger);
    }
    /**
     *  3. if the events is already registered
     */
    public boolean isRegistered(EventsManger eventsManger) {
        return events.contains(eventsManger);
    }
    /**
     * Return the List of all registered Events
     */
    public static ArrayList<EventsManger> getEvents() {
        return events;
    }

    /**
     * return the registered events by size
     */
    public static int getEventsSize() {
        return events.size();
    }

    /**
     * Send the BossBar to all players in the playerList with the eventTitle
     */
    public static void sendBossBar(@NotNull EventsManger eventsManger , int time) {


        //if the event is positive or negative

        BossBar bossBar = null;

        if(eventsManger.positive()){
            bossBar = Bukkit.createBossBar(eventsManger.eventTitle(), BarColor.GREEN, BarStyle.SOLID, BarFlag.DARKEN_SKY, BarFlag.CREATE_FOG);
        }else{
            //Purple ist mysteriös!!!
            bossBar = Bukkit.createBossBar(eventsManger.eventTitle(), BarColor.PURPLE, BarStyle.SOLID, BarFlag.DARKEN_SKY, BarFlag.CREATE_FOG);
        }



        final int time2 = time;

        BossBar finalBossBar = bossBar;
        new BukkitRunnable() {
            @Override
            public void run() {

                if (time2 <= 0) {

                    PlayerMangment.playerList.forEach(player -> {
                       finalBossBar.removePlayer(player);
                    });

                } else {

                    PlayerMangment.playerList.forEach(player -> {
                        finalBossBar.addPlayer(player);
                    });

                }
            }
        }.runTaskTimerAsynchronously(Main.getPlugin(Main.class), 0, 20);

    }

    /**
     * Call Event by random
     */
    public static void callRandomEvent() {

        Random random = new Random();
        int randomEvent = random.nextInt(events.size() + 1);

        if (randomEvent == 0) {
            System.out.println("No event");
        } else {
            events.get(randomEvent).onEnable();
            events.get(randomEvent).sendBossBar(events.get(randomEvent), 10);
            events.get(randomEvent).onDisable();
        }


    }

    /**
     * Call Event
     */
    public static void callEvent(int id) {

        EventsManger eventsManger = events.get(id);
        eventsManger.onEnable();
        eventsManger.sendBossBar(eventsManger, 10);
        eventsManger.onDisable();


    }

}
