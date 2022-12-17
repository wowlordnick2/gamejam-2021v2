package de.wowlordnick2.commands;

import de.wowlordnick2.Main;
import de.wowlordnick2.manger.EventsManger;
import de.wowlordnick2.manger.TimerManger;
import de.wowlordnick2.utils.Enums.Messages;
import de.wowlordnick2.utils.EventTimer;
import de.wowlordnick2.utils.PlayerMangment;
import de.wowlordnick2.utils.PlayerTimer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class joinCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (args.length == 0) {

                if (TimerManger.isRunning) {

                    if (PlayerMangment.playerList.contains(player)) {
                        player.sendMessage(Main.color(Main.getPrefix() + "&cDu bist bereits in der Event-Liste!"));
                    } else {
                        PlayerMangment.playerList.add(player);
                        player.sendMessage(Main.color(Main.getPrefix() + "&aDu bist der Event-Liste hinzugefügt worden!"));
                    }
                } else {
                    player.sendMessage(Main.color(Main.getPrefix() + "&cEs läuft kein Event oder du warst zu spät!"));
                }


            }



        } else {
            sender.sendMessage(Main.color(Messages.CONOSLEN_MESSAGE.getMessage()));
        }







        return false;
    }
}
