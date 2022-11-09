package de.wowlordnick2.events;

import de.wowlordnick2.Main;
import de.wowlordnick2.utils.Enums.Eventdifficulties;
import de.wowlordnick2.utils.EventsManger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.management.relation.Role;
import java.awt.*;
import java.util.Arrays;

public class TestEvent extends EventsManger {

    @Override
    public void onEnable() {
        System.out.println("Event started " + eventTitle() + " " + positive() +  " "  + getDifficulty());
        sendBossBar();
        Bukkit.getOnlinePlayers().forEach(player -> {
            player.sendMessage(Main.color(Main.getPrefix() + "Event started " + eventTitle() +  " Score: " + positive() + " Difficulty: " + getDifficulty() + " author: " + getAuthor()));
        });

        onDisable();
    }


    public String eventTitle() {
        return "Test Event";
    }


    //return the difficulty of the event
    @Override
    public Eventdifficulties getDifficulty() {

        return Eventdifficulties.EASY;
    }


    public static boolean positive() {
        return true;
    }

    @Override
    public ItemStack itemStack() {

        return getItemStack(Material.DIAMOND , eventTitle() , positive() , getDifficulty() , getAuthor());
    }

    @Override
    public String getAuthor() {
        return "ohnonick2#3864";
    }

    @Override
    public String getdescription() {
        return "Test Event 1";
    }
}

