package de.wowlordnick2;

import de.wowlordnick2.commands.*;
import de.wowlordnick2.events.*;
import de.wowlordnick2.listener.CommandPre;
import de.wowlordnick2.listener.Connection;
import de.wowlordnick2.listener.FindItem;
import de.wowlordnick2.listener.InventoryClick;
import de.wowlordnick2.manger.ConfigManger;
import de.wowlordnick2.manger.EventsManger;
import de.wowlordnick2.utils.Enums.Difficulties;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.logging.Logger;

public final class Main extends JavaPlugin {

    private static Main instance;

    private static String prefix;
    public static Difficulties difficulties;

    public File file = new File(getDataFolder(), "config.yml");
    public YamlConfiguration config = YamlConfiguration.loadConfiguration(file);





    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;

        System.out.println("Plugin started");


        File file = ConfigManger.points;

        if (!file.exists()) {

            ConfigManger.createConfig(file);
            ConfigManger.save(file , ConfigManger.pointsConfig);

        }

        Logger.getLogger("Minecraft").info("Points saved");




        EventsManger.registerEvents(new MLGEvent());
        EventsManger.registerEvents(new BobEvent());
        EventsManger.registerEvents(new TimerOut());
        EventsManger.registerEvents(new AlleineEvent());
        EventsManger.registerEvents(new InstantBurnEvent());
        EventsManger.registerEvents(new AntistaerkungEvent());


        /*
          Register the commands
         */
        getCommand("join").setExecutor(new joinCommand());
        getCommand("leave").setExecutor(new leave());
        getCommand("event").setExecutor(new CallEvent());
        getCommand("timer").setExecutor(new TimerEventCommand());
        getCommand("startevent").setExecutor(new startCommand());
        getCommand("forcestart").setExecutor(new forcestart());
        getCommand("menu").setExecutor(new menuCommand());


        PluginManager manger = Bukkit.getPluginManager();
        manger.registerEvents(new InventoryClick(), this);
        manger.registerEvents(new CommandPre(), this);
        manger.registerEvents(new InstantBurnEvent() , this);
        manger.registerEvents(new Connection() , this);
        manger.registerEvents(new FindItem() , this);

        prefix = color("&a&lEvent Sytem &8» &7");

        getLogger().info("Load " + EventsManger.getEvents().size() + " Events");

        /**
         * Load the config file
         */
        if (!file.exists()) {
            saveDefaultConfig();

            getConfig().options().copyDefaults(true);

            saveConfig();
        }
        if (getResource("config.yml") != null)  {

            getConfig().options().copyDefaults(true);
            saveDefaultConfig();
        }


        String token = getConfig().getString("Discord.token");
        System.out.println(token);












    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Plugin stopped");

       EventsManger.unregisterEvents(new MLGEvent());
       EventsManger.unregisterEvents(new BobEvent());
       EventsManger.unregisterEvents(new TimerOut());
       EventsManger.unregisterEvents(new AlleineEvent());






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

    public static void setDifficulties(Difficulties difficulties) {
        Main.difficulties = difficulties;
    }


    @NotNull
    @Override
    public YamlConfiguration getConfig() {
        return config;
    }
}
