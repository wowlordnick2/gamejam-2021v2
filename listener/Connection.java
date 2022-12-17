package de.wowlordnick2.listener;

import de.wowlordnick2.Main;
import de.wowlordnick2.utils.Enums.Goal;
import de.wowlordnick2.utils.PlayerMangment;
import de.wowlordnick2.utils.PlayerTimer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Connection implements Listener {


    @EventHandler(ignoreCancelled = true)
    public void onPlayerJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();

        if (PlayerMangment.offlinePlayerList.contains(player)) {

            player.sendMessage(Main.color(Main.getPrefix() + " Willkommen zurück! " + player.getName()));
            PlayerMangment.playerList.add(player);

            if (Goal.ITEMS == Goal.ITEMS) {
                player.sendMessage(Main.color(Main.getPrefix() + " &7Dein Ziel ist es &a" + PlayerMangment.playerItem.get(player) + " &7Items zu finden!"));
            }

        }


    }


    @EventHandler(ignoreCancelled = true)
    public void onPlayerQuit(PlayerQuitEvent event) {

        Player player = event.getPlayer();

        if (PlayerMangment.playerList.contains(player)) {

            player.sendMessage(Main.color(Main.getPrefix() + " Auf Wiedersehen! " + player.getName()));
            PlayerMangment.playerList.remove(player);
            PlayerMangment.offlinePlayerList.add(player);
        }


    }
}
