package de.wowlordnick2.events;

import de.wowlordnick2.EventsManger;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class TestEvent extends EventsManger {

    @Override
    public void onEnable() {
        System.out.println("Event started" + eventTitle());
    }


    public String eventTitle() {
        return "Test Event";
    }


    public boolean positive() {
        return true;
    }

    @Override
    public ItemStack itemStack() {

       ItemStack itemStack = new ItemStack(Material.DIAMOND);
       return itemStack;
    }
}

