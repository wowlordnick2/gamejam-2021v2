package de.wowlordnick2.listener;

import de.wowlordnick2.Main;
import de.wowlordnick2.manger.EventsManger;
import de.wowlordnick2.manger.InventoryManger;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

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

            if (EventsManger.events.get(event.getSlot()).getDescription() == null) {
                player.sendMessage(Main.color(Main.getPrefix() + ChatColor.DARK_AQUA + "Es gibt keine Beschreibung für dieses Event"));
            } else {
                player.sendMessage(Main.color(Main.getPrefix() + EventsManger.events.get(event.getSlot()).getDescription()));
            }
            System.out.println(EventsManger.getEvents().get(event.getSlot()).eventTitle());


            event.setCancelled(true);
        }

    }
}
