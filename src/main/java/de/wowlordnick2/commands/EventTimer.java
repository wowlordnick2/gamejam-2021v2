package de.wowlordnick2.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class EventTimer implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {


       if (sender instanceof Player) {

        if (args.length == 1 ) {

            if (args[0].equalsIgnoreCase("start")) {

                de.wowlordnick2.utils.Enums.EventTimer O = de.wowlordnick2.utils.Enums.EventTimer.NORMAL;
                de.wowlordnick2.utils.EventTimer.startTimer();
                de.wowlordnick2.utils.EventTimer.isRunning = true;


            } else if (args[0].equalsIgnoreCase("stop")) {
                de.wowlordnick2.utils.EventTimer.isRunning = true;

            } else {
                sender.sendMessage("§cPlease use /eventTimer <start/stop>");
            }

        }


       } else {
           sender.sendMessage("You have to be a player to use this command");
       }





        return false;
    }
}
