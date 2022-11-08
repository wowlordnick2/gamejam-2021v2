package de.wowlordnick2;

import de.wowlordnick2.commands.CallEvent;
import de.wowlordnick2.commands.TimerEventCommand;
import de.wowlordnick2.commands.startEvent;
import de.wowlordnick2.events.TestEvent;
import de.wowlordnick2.utils.Enums.EventTimer;
import de.wowlordnick2.utils.EventsManger;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main instance;

    private static String prefix;
    public static EventTimer difficulties;


    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;

        System.out.println("Plugin started");

        EventsManger.registerEvents(new TestEvent());

        getCommand("event").setExecutor(new CallEvent());
        getCommand("startevent").setExecutor(new startEvent());
        getCommand("timer").setExecutor(new TimerEventCommand());

        prefix = color("&a&lEvent Sytem &8» &7");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Plugin stopped");

       EventsManger.unregisterEvents(new TestEvent());
    }


    public static String color(String text) {
        return text == null ? null : ChatColor.translateAlternateColorCodes('&', text);
    }

    // 4. Get the instance of the plugin
    public static Main getInstance() {
        return instance;
    }

    // 5. Get the prefix of the plugin
    public static String getPrefix() {
        return prefix;
    }

    public static void setDifficulties(EventTimer difficulties) {
        Main.difficulties = difficulties;
    }
}
