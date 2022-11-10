package de.wowlordnick2.commands;

import de.wowlordnick2.utils.Enums.Timer;
import de.wowlordnick2.utils.EventTimer;
import de.wowlordnick2.utils.PlayerTimer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class TimerEventCommand implements CommandExecutor {

   //This command is used to start the timer for debugging

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

       if (sender instanceof Player) {

           Player player = (Player) sender;

           if (player.hasPermission("wowlordnick2.event")) {

               if (args.length == 1) {
                   if (args[0].equalsIgnoreCase("start")) {
                       if (PlayerTimer.isRunning) {

                           player.sendMessage("Timer is already running");
                            return true;
                       }
                       PlayerTimer.setTimer(0 , 0 , 0);
                       PlayerTimer.Timer();
                       PlayerTimer.setRunning(true);

                       EventTimer.startTimer(Timer.FAST);

                   } else if (args[0].equalsIgnoreCase("stop")) {
                          PlayerTimer.setRunning(false);
                   } else if (args[0].equalsIgnoreCase("reset")) {
                       PlayerTimer.setTimer(0 , 0  , 0);
                       PlayerTimer.setUP(true);
                       PlayerTimer.setRunning(true);
                   } else if (args[0].equalsIgnoreCase("down")) {
                       PlayerTimer.Timer();
                       PlayerTimer.setUP(false);
                       PlayerTimer.setRunning(true);
                       PlayerTimer.setTimer(0 , 1 , 0);

                   } else {
                       player.sendMessage("§cPlease use /timerEvent <start/stop/reset>");
                   }
               }
           }
       } else {
           sender.sendMessage("You have to be a player to use this command");

       }




        return false;
    }
}
