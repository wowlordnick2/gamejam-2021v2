package de.wowlordnick2.commands;

import de.wowlordnick2.Main;
import de.wowlordnick2.utils.EventsDifficulties;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class startEvent implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        String prefix = Main.color("&8[&6Event&8] &7");

        if (sender instanceof Player) {

            Player player = (Player) sender;


            if (args.length == 1) {

                if (args[0].equalsIgnoreCase(EventsDifficulties.FAST.toString())) {

                    player.sendMessage("§aEvent started " + EventsDifficulties.FAST.toString());

                } else if (args[0].equalsIgnoreCase(EventsDifficulties.NORMAL.toString())) {
                    player.sendMessage("§aEvent started " + EventsDifficulties.NORMAL.toString());

                } else if (args[0].equalsIgnoreCase(EventsDifficulties.SLOW.toString())) {
                    player.sendMessage("§aEvent started " + EventsDifficulties.SLOW.toString());

                } else {
                    player.sendMessage(Main.color(prefix + "&cThis event does not exist"));


                }

            }


        } else {
            sender.sendMessage("You must be a player to use this command");
        }





        return false;
    }
}
