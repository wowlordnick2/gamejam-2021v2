package de.wowlordnick2.listener;

import de.wowlordnick2.Main;
import de.wowlordnick2.utils.EventsManger;
import de.wowlordnick2.utils.InventoryManger;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryClick implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onInventoryClick(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();

        if (event.getClickedInventory() == null) {
            return;
        }




        if (event.getInventory().equals(InventoryManger.InvEvent)) {


            if (event.getCurrentItem() == null) {
                return;
            }

            if (EventsManger.events.get(event.getSlot()).getdescription() == null) {
                player.sendMessage(Main.color(Main.getPrefix() + ChatColor.DARK_AQUA + "Es gibt keine Beschreibung für dieses Event"));
            } else {
                player.sendMessage(Main.color(Main.getPrefix() + EventsManger.events.get(event.getSlot()).getdescription()));
            }
            System.out.println(EventsManger.getEvents().get(event.getSlot()).eventTitle());



            event.setCancelled(true);
        }

    }
}
