package de.wowlordnick2.listener;

import de.wowlordnick2.Main;
import de.wowlordnick2.manger.ConfigManger;
import de.wowlordnick2.utils.Enums.Timer;
import de.wowlordnick2.utils.Enums.TimerState;
import de.wowlordnick2.utils.PlayerMangment;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAttemptPickupItemEvent;

import java.awt.*;
import java.util.UUID;

import static de.wowlordnick2.utils.PlayerTimer.isRunning;

public class FindItem implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onPlayerAttemptPickupItem(PlayerAttemptPickupItemEvent event) {



        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();
        Material item = event.getItem().getItemStack().getType();



        int winamount = ConfigManger.getWinPoints();
        if (isRunning) {

            if(PlayerMangment.playerList.contains(player)) {

                if (PlayerMangment.playerItem.containsKey(item)) {


                    if (winamount == ConfigManger.getPoints(uuid)) {
                        Bukkit.broadcastMessage(Main.color(Main.getPrefix() + "&a" + player.getName() + " &7hat das Spiel gewonnen!"));
                        Bukkit.getOnlinePlayers().forEach(all -> {
                            if (PlayerMangment.playerList.contains(all)) {

                                int points = ConfigManger.getPoints(all.getUniqueId());

                                all.sendMessage(Main.color(Main.getPrefix() + "&7Du hast &a" + points + " &7Punkte erreicht!"));
                            }
                        });

                    } else {

                        ConfigManger.setPoints(uuid, ConfigManger.getPoints(uuid) + 1);
                        Bukkit.broadcastMessage(Main.color(Main.getPrefix() + "&a" + player.getName() + " &7hat ein Item gefunden! &8(&a" + ConfigManger.getPoints(uuid) + "&8/&a" + winamount + "&8)"));

                        //TODO: Add the random item to the player


                    }

                    




                }





            }


        }





    }
}
