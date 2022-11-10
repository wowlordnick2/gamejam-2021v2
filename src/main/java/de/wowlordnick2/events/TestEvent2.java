package de.wowlordnick2.events;

import de.wowlordnick2.Main;
import de.wowlordnick2.utils.Enums.Difficulties;
import de.wowlordnick2.manger.EventsManger;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

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
    public Difficulties getDifficulty() {
        return Difficulties.HARD;
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
    public String getDescription() {
        return "Test Event 2";
    }
}
