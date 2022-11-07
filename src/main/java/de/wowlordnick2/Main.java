package de.wowlordnick2;

import de.wowlordnick2.events.TestEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Plugin started");

        EventsManger.registerEvents(new TestEvent());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Plugin stopped");

       EventsManger.unregisterEvents(new TestEvent());
    }


}
