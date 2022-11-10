package de.wowlordnick2.commands;

import de.wowlordnick2.Main;
import de.wowlordnick2.manger.TimerManger;
import de.wowlordnick2.utils.Enums.TimerState;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class forcestart implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {


       if (sender instanceof Player) {

           Player player = (Player) sender;

           if (player.hasPermission("eventsystem.forcestart")) {

               if (args.length == 0) {

                   if (Main.getInstance().config.getBoolean("Game.forcestart")) {

                      Bukkit.broadcastMessage(Main.color(Main.getPrefix() + " Der Forcestart wurde aktiviert! Das Event startet in 15 Sekunden!"));
                      TimerManger.setSec(15);
                      TimerManger.setMin(0);

                     } else {
                          player.sendMessage("§cDer Forcestart ist deaktiviert!");

                   }

               }

           } else {
               player.sendMessage("§cBitte benutze /forcestart");
           }


       }


        return false;
    }
}
