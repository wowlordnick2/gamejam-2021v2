package de.wowlordnick2.listener;

import de.wowlordnick2.Main;
import de.wowlordnick2.events.AlleineEvent;
import de.wowlordnick2.events.AntistaerkungEvent;
import de.wowlordnick2.events.TimerOut;
import de.wowlordnick2.manger.EventsManger;
import de.wowlordnick2.manger.InventoryManger;
import de.wowlordnick2.utils.Enums.Inventorys;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;

import static de.wowlordnick2.events.AntistaerkungEvent.mobCount;

public class InventoryClick implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onInventoryClick(@NotNull InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();

        /**
         * if the player clicked on the inventory
         */
        if (event.getClickedInventory() == null) {
            return;
        }
        if (event.getInventory().equals(InventoryManger.InvEvent)) {
            if (event.getCurrentItem() == null) {
                return;
            }
            if (EventsManger.events.get(event.getSlot()).isOption()) {
                if (EventsManger.events.get(event.getSlot()).getInventory() == null) {
                   player.sendMessage(getDescription(event.getSlot()));
                }
                if (event.isShiftClick()) {
                    player.sendMessage(getDescription(event.getSlot()));
                } else {
                    player.openInventory(EventsManger.events.get(event.getSlot()).getInventory());
                }
            } else {
                player.sendMessage(getDescription(event.getSlot()));

            }
            System.out.println(EventsManger.getEvents().get(event.getSlot()).eventTitle());


            event.setCancelled(true);
        }

        if (event.getInventory().equals(AntistaerkungEvent.operation)) {


            if (event.getSlot() == 18) {

                backtothemainmenu(player);
            }

            if (event.getSlot() == 10) {
                if (event.isRightClick()) {

                    mobCount++;


                } else if (event.isLeftClick()) {

                    if (mobCount > 1) {
                        mobCount--;
                    } else {

                        player.sendMessage(Main.color(Main.getPrefix() + "&cDer Wert kann nicht kleiner als 1 sein!"));
                    }

                }

                Main.getInstance().config.set("Events.Antistaerkung.MobCount" , mobCount);
                Main.getInstance().saveConfig();

                AntistaerkungEvent.operation.setItem(10, AntistaerkungEvent.getMobSpawnRateItem());

            }





            event.setCancelled(true);
        }
        else if (event.getInventory().equals(TimerOut.operation)) {




            if (event.getSlot() == 18) {

               backtothemainmenu(player);
            }




            event.setCancelled(true);
        } else if (event.getInventory().equals(AlleineEvent.operation)) {


            if (event.getSlot() == 18) {

                backtothemainmenu(player);
            }


            event.setCancelled(true);

        }


    }


    private static String getDescription(int slot) {
        if (EventsManger.events.get(slot).getDescription() == null) {
            return Main.color(Main.getPrefix() + "Zu diesem Event gibt es keine Beschreibung");
        }

        return Main.color(Main.getPrefix() + " " + ChatColor.GRAY + EventsManger.events.get(slot).getDescription());
    }


    /**
     * @param player
     *
     */

    public void backtothemainmenu(Player player) {
        player.closeInventory();
        player.openInventory(InventoryManger.InvEvent);
    }

}
