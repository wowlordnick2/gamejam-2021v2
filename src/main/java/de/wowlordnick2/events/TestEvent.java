package de.wowlordnick2.events;

import de.wowlordnick2.Main;
import de.wowlordnick2.utils.Enums.Eventdifficulties;
import de.wowlordnick2.utils.Enums.Role;
import de.wowlordnick2.utils.EventsManger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class TestEvent extends EventsManger {

    @Override
    public void onEnable() {
        System.out.println("Event started " + eventTitle() + " " + positive() +  " "  + getDifficulty());
        sendBossBar();
        Bukkit.getOnlinePlayers().forEach(player -> {
            player.sendMessage(Main.color(Main.getPrefix() + "Event started " + eventTitle() +  " "  + getDifficulty() + " von " + author(Role.SYSTEM , "ohnonick2")));
        });

        onDisable();
    }


    public String eventTitle() {
        return ChatColor.DARK_AQUA + "Test Event";
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
       ItemStack itemStack = new ItemStack(Material.DIAMOND);

        ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.setDisplayName(eventTitle());


        //set the lore of the item with Role and is the Positiv or Negativ Event and the difficulty
        itemMeta.setLore(Arrays.asList(author(Role.SYSTEM , ChatColor.DARK_AQUA + "ohnonick2"), Main.color(positive() ? "&cGutes Event " : "&cBöses Event"), Main.color(ChatColor.BLUE + getDifficulty().toString())));

        itemStack.setItemMeta(itemMeta);

       return itemStack;
    }

}

