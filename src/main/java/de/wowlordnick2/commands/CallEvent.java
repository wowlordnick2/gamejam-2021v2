package de.wowlordnick2.commands;

import de.wowlordnick2.Main;
import de.wowlordnick2.manger.EventsManger;
import de.wowlordnick2.utils.Enums.Messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CallEvent implements CommandExecutor , TabCompleter {

    /**
     * This command is used to call the events from the EventsManger class
     */
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {


        if (!(sender instanceof Player)){

            sender.sendMessage(Main.color(Messages.CONOSLEN_MESSAGE.getMessage()));

        }


        if (sender.hasPermission("wowlordnick2.event")) {

            if (args.length == 1) {
                Player player = (Player) sender;

                int id;

                try{
                    id = Integer.parseInt(args[0]);
                } catch(NumberFormatException ex){ // handle your exception

                  player.sendMessage(Main.color(Main.getPrefix() + "&cDas ist keine Zahl!"));

                  return true;
                }


                if (id < EventsManger.events.size()) {

                    EventsManger.callEvent(id);
                } else {
                    sender.sendMessage(Main.color(Main.getPrefix() + "&cDas Event mit der ID " + id + " existiert nicht!"));
                    return true;
                }




            } else {
                sender.sendMessage(Main.color(Main.getPrefix() + "&cNutze /callEvent <id>"));
            }


        }



        return false;
    }


    /**
     * This method is used to get the tab complete for the command
     */
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {


        List<String> list = new ArrayList<>();


        if (args.length == 1) {

            for (int i = 0; i < EventsManger.events.size(); i++) {

                list.add(String.valueOf(i));

            }


        }

        return list;
    }
}
