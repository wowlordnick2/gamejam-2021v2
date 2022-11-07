package de.wowlordnick2.utils;

import org.bukkit.inventory.ItemStack;

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
     * Call Event by random
     */
    public static void callRandomEvent() {

        Random random = new Random();
        int randomEvent = random.nextInt(events.size());

        EventsManger eventsManger = events.get(randomEvent);
        eventsManger.onEnable();
        eventsManger.onDisable();


    }

    /**
     * Call Event
     */
    public static void callEvent(int id) {

        EventsManger eventsManger = events.get(id);
        eventsManger.onEnable();
        eventsManger.onDisable();


    }



}
