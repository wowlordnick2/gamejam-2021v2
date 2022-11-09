package de.wowlordnick2.utils;

import de.wowlordnick2.utils.Enums.Eventdifficulties;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.beans.EventSetDescriptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InventoryManger {

    public static Inventory InvEvent = Bukkit.createInventory(null, 9*4, "§8» §6§lEvent §8«");


    public static  Inventory openInventory() {

        for (int i = 0; i < EventsManger.events.size(); i++) {

            if (i != 31) {
                InvEvent.setItem(i, EventsManger.events.get(i).itemStack());
            }

        }

        return InvEvent;
    }


}
