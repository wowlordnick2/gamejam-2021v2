package de.wowlordnick2.commands;

import de.wowlordnick2.Main;
import de.wowlordnick2.manger.ConfigManger;
import de.wowlordnick2.manger.TimerManger;
import de.wowlordnick2.utils.Enums.Messages;
import de.wowlordnick2.utils.Enums.Timer;
import de.wowlordnick2.utils.EventTimer;
import de.wowlordnick2.utils.PlayerMangment;
import de.wowlordnick2.utils.PlayerTimer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class leave implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {


        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (PlayerTimer.isRunning || TimerManger.isRunning) {
                PlayerMangment.playerList.remove(player);
                player.sendMessage(Main.color(Main.getPrefix() + "&cDu hast das Event verlassen!"));
                YamlConfiguration config = ConfigManger.getPointsConfig();
                config.set("Points." + player.getUniqueId() , null);
                ConfigManger.save(ConfigManger.points , config);
            } else {
                player.sendMessage(Main.color(Main.getPrefix() + "67Derzeit läuft kein Event!"));
            }


        } else {
            sender.sendMessage(Main.color(Messages.CONOSLEN_MESSAGE.getMessage()));
        }











        return false;
    }
}
