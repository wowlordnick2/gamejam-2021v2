package de.wowlordnick2.commands;

import de.wowlordnick2.Main;
import de.wowlordnick2.utils.Enums.Messages;
import de.wowlordnick2.utils.Enums.Timer;
import de.wowlordnick2.utils.EventTimer;
import de.wowlordnick2.utils.PlayerTimer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TimerEventCommand implements CommandExecutor , TabCompleter {

   //This command is used to start the timer for debugg ing

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

       if (sender instanceof Player) {

           Player player = (Player) sender;

           if (player.hasPermission("wowlordnick2.event")) {

               if (args.length == 1) {
                   if (args[0].equalsIgnoreCase("start")) {
                       if (PlayerTimer.isRunning) {

                           player.sendMessage(Main.color(Main.getPrefix() + "&cDer Timer läuft bereits!"));
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
                       player.sendMessage(Main.color(Main.getPrefix() + "&cBitte benutze /event start , /event reset , /event stop , /event down"));
                   }
               }
           }
         } else {
           sender.sendMessage(Main.color(Messages.CONOSLEN_MESSAGE.getMessage()));

        }

        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {

        Player player = (Player) sender;

        if (player.hasPermission("wowlordnick2.event")) {
            List<String> list = new ArrayList<>();
            list.add("start");
            list.add("stop");
            list.add("reset");
            list.add("down");
            return list;
        }



        return null;
    }
}
