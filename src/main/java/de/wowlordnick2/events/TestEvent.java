package de.wowlordnick2.events;

import de.wowlordnick2.Main;
import de.wowlordnick2.utils.EventsManger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class TestEvent extends EventsManger {

    @Override
    public void onEnable() {
        System.out.println("Event started " + eventTitle() + " " + positive());
        sendBossBar();
        Bukkit.getOnlinePlayers().forEach(player -> {
            player.sendMessage(Main.color(Main.getPrefix() + "startet" + eventTitle() + " " + positive()));
        });



        onDisable();
    }


    public String eventTitle() {
        return ChatColor.DARK_AQUA + " Test Event";
    }


    public static boolean positive() {
        return true;
    }

    @Override
    public ItemStack itemStack() {
       ItemStack itemStack = new ItemStack(Material.DIAMOND);
       return itemStack;
    }
}

