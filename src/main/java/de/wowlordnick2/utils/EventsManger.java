package de.wowlordnick2.utils;

import de.wowlordnick2.Main;
import de.wowlordnick2.utils.Enums.Eventdifficulties;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public abstract class EventsManger {

    public BossBar bossBar = null;


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

        new BukkitRunnable() {
            int i = 0;
            @Override
            public void run() {

                if (i > 5) {
                    cancel();

                    Bukkit.getOnlinePlayers().forEach(player -> {
                        bossBar.removePlayer(player);
                    });

                }
                i++;

            }
        }.runTaskTimerAsynchronously(Main.getInstance(), 0, 20);

    }
    /**
     * Return the name of the event
     */
    public abstract String eventTitle();

    public abstract Eventdifficulties getDifficulty();

    /**
     * Return the value of the event (positive or negative)
     */
    public static boolean positive() {
        return false;
    }

    /**
     * Return the ItemStack of the event
     */
    public abstract ItemStack itemStack(); //coming soon

    //get the Event Author
    public abstract String getAuthor();

    public abstract String getdescription();

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







    }

    /**
     * Call Event
     */
    public static void callEvent(int id) {

        EventsManger eventsManger = events.get(id);
        eventsManger.onEnable();
        eventsManger.onDisable();


    }


    public void sendBossBar() {



        if(positive()){
            bossBar = Bukkit.createBossBar(eventTitle(), BarColor.GREEN, BarStyle.SOLID, BarFlag.DARKEN_SKY, BarFlag.CREATE_FOG);
        }else{
            bossBar = Bukkit.createBossBar(eventTitle(), BarColor.PURPLE, BarStyle.SOLID, BarFlag.DARKEN_SKY, BarFlag.CREATE_FOG);
        }

        BossBar finalBossBar = bossBar;
        Bukkit.getOnlinePlayers().forEach(finalBossBar::addPlayer);

    }


    public ItemStack getItemStack(Material material , String eventname , boolean positiv , Eventdifficulties event , String author) {

        ItemStack itemStack = new ItemStack(material);

        ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.setDisplayName(ChatColor.RED + eventname);


        //set the lore of the item with Role and is the Positiv or Negativ Event and the difficulty
        itemMeta.setLore(Arrays.asList(
                "\n",
                ChatColor.GRAY + "von " +  ChatColor.DARK_AQUA + author,
                ChatColor.GRAY + "Positiv: " + ChatColor.DARK_AQUA + positiv,
                ChatColor.GRAY + "Schwierigkeit: " + ChatColor.DARK_AQUA + event,
                "\n",
                ChatColor.GRAY + "Klicke um die Description zu sehen"
        ));

        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }



}
