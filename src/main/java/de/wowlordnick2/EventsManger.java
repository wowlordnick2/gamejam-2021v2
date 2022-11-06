package de.wowlordnick2;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

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
    public abstract void onDisable();
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
     *  2. Unregister a new event
     *  3. if the events is already registered
     */
    public static void registerEvents(EventsManger eventsManger) {
        events.add(eventsManger);
    }
    public static void unregisterEvents(EventsManger eventsManger) {
        events.remove(eventsManger);
    }
    public boolean isRegistered(EventsManger eventsManger) {
        return events.contains(eventsManger);
    }

}
