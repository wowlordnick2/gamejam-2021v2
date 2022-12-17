package de.wowlordnick2.listener;

import de.wowlordnick2.Main;
import io.papermc.paper.event.player.AbstractChatEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class CommandPre implements Listener {

    @EventHandler(ignoreCancelled = true , priority = EventPriority.HIGHEST)
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {


        String message = event.getMessage();
        Player player = event.getPlayer();

        if (message.equalsIgnoreCase("reload") || message.equalsIgnoreCase("rl")) {

            if (player.hasPermission("eventsystem.reload")) {


                Bukkit.broadcastMessage(Main.color(Main.getPrefix() + "§cDer Server wird neugestartet!"));
                Bukkit.reload();

            }else {
                player.sendMessage("§cDu hast keine Rechte um den Server zu neustarten!");
            }

            event.setCancelled(true);
        }





    }
}
