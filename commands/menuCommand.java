package de.wowlordnick2.commands;

import de.wowlordnick2.Main;
import de.wowlordnick2.manger.InventoryManger;
import de.wowlordnick2.utils.Enums.Messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class menuCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (args.length == 0) {

                player.openInventory(InventoryManger.openInventory());

            } else {
                player.sendMessage(Main.color(Main.getPrefix() + "&cBitte benutze /menu!"));
            }



        } else {

            sender.sendMessage(Main.color(Messages.CONOSLEN_MESSAGE.getMessage()));

        }











        return false;
    }
}
