package de.wowlordnick2.utils;

import de.wowlordnick2.utils.Enums.Eventdifficulties;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class InventoryManger {

    public static Inventory InvEvent = Bukkit.createInventory(null, 9*4, "§8» §6§lEvent §8«");


    public static  Inventory openInventory() {

        EventsManger.events.forEach(event -> {
            InvEvent.addItem(event.itemStack());
        });



        return InvEvent;
    }


}
