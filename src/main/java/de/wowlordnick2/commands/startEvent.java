package de.wowlordnick2.commands;

import de.wowlordnick2.Main;
import de.wowlordnick2.utils.Enums.EventTimer;
import de.wowlordnick2.utils.InventoryManger;
import de.wowlordnick2.utils.PlayerMangment;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class startEvent implements CommandExecutor , TabCompleter {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        String prefix = Main.getPrefix();

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (args.length == 0) {
                player.sendMessage(Main.color(prefix + "&cPlease use /startEvent <difficulty>"));
                player.openInventory(InventoryManger.openInventory());


                return true;
            }


            if (args.length == 1) {

                if (args[0].equalsIgnoreCase(EventTimer.FAST.toString())) {

                    player.sendMessage(prefix +  "started " + EventTimer.FAST.toString());

                    PlayerMangment.playerList.add(player);


                } else if (args[0].equalsIgnoreCase(EventTimer.NORMAL.toString())) {
                    player.sendMessage(prefix +  "started " + EventTimer.NORMAL.toString());
                    PlayerMangment.playerList.add(player);
                } else if (args[0].equalsIgnoreCase(EventTimer.SLOW.toString())) {
                    player.sendMessage(prefix +  "started " + EventTimer.SLOW.toString());
                    PlayerMangment.playerList.add(player);
                } else {
                    player.sendMessage(Main.color(prefix + "&cThis event does not exist"));
                }
            }
        } else {
            sender.sendMessage(prefix + "You must be a player to use this command");
        }





        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {

      List<String> list = new ArrayList<>();

      for (EventTimer eventsDifficulties : EventTimer.values()) {
        list.add(eventsDifficulties.toString());
      }

      return list;

    }
}
