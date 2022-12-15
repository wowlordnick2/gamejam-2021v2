package de.wowlordnick2.manger;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class InventoryManger {

    //TODO Work on the InventoryManger

    public static Inventory InvEvent = Bukkit.createInventory(null, 9*4, "§8» §6§lEvent §8«");


    public static  Inventory openInventory() {

        for (int i = 0; i < EventsManger.events.size(); i++) {

            if (i != 31) {
                InvEvent.setItem(i, EventsManger.events.get(i).itemStack());
            }

        }





        return InvEvent;
    }


    public static Inventory InvTimer = Bukkit.createInventory(null, 9*4, "§6Timer");

    public static Inventory openTimerInventory() {

        ItemStack gray = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta grayMeta = gray.getItemMeta();

        grayMeta.setDisplayName(" ");
        gray.setItemMeta(grayMeta);


        for (int i = 0; i < 36; i++) {
            InvTimer.setItem(i, gray);
        }

        ItemStack item = new ItemStack(Material.CLOCK);
        ItemMeta itemMeta = item.getItemMeta();

        itemMeta.setDisplayName("§6Timer");
        item.setItemMeta(itemMeta);
        itemMeta.setLore(Arrays.asList("§7Hier kannst du den Timer einstellen", "§7und starten!"));


        InvTimer.setItem(13 , new ItemStack(Material.ARROW));
        InvTimer.setItem(22, new ItemStack(Material.BEDROCK));
        InvTimer.setItem(31, new ItemStack(Material.BOOK));


        return InvTimer;
    }


}
