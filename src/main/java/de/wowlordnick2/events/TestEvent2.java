package de.wowlordnick2.events;

import de.wowlordnick2.Main;
import de.wowlordnick2.utils.Enums.Eventdifficulties;
import de.wowlordnick2.utils.EventsManger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class TestEvent2 extends EventsManger {

    @Override
    public void onEnable() {
        System.out.println("Event started " + eventTitle() + " " + positive() +  " "  + getDifficulty());

        Bukkit.getOnlinePlayers().forEach(player -> {
            player.sendMessage(Main.color(Main.getPrefix() + "Event started " + eventTitle() +  " Score: " + positive() + " Difficulty: " + getDifficulty() + " author: " + getAuthor()));
        });
        sendBossBar();
        onDisable();
    }

    @Override
    public String eventTitle() {
        return "Test Event 2";
    }

    @Override
    public Eventdifficulties getDifficulty() {
        return Eventdifficulties.HARD;
    }

    @Override
    public ItemStack itemStack() {

        return getItemStack(Material.ACACIA_LEAVES , eventTitle() , positive() , getDifficulty() , getAuthor());
    }

    @Override
    public String getAuthor() {
        return "ohnonick2#3864";
    }

    @Override
    public String getdescription() {
        return "Test Event 2";
    }
}
