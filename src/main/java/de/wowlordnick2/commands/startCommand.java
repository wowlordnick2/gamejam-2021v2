package de.wowlordnick2.commands;

import de.wowlordnick2.manger.TimerManger;
import de.wowlordnick2.utils.Enums.Difficulties;
import de.wowlordnick2.utils.Enums.Timer;
import de.wowlordnick2.utils.Enums.TimerState;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Difficulty;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class startCommand implements CommandExecutor , TabCompleter {


   // This command is used to start the game

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {


        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (player.hasPermission("eventsystem.start")) {

                if (args.length == 0) {

                    player.sendMessage("§cBitte benutze /start fast/normal/slow");

                } else if (args.length == 1) {

                    if (Timer.SLOW.name().equalsIgnoreCase(args[0])) {

                        TimerState state = TimerState.WARMUP;
                        TimerManger.warmUpTimer(Timer.SLOW);

                    } else if (Timer.FAST.name().equalsIgnoreCase(args[0])) {

                            TimerState state = TimerState.WARMUP;
                            TimerManger.warmUpTimer(Timer.FAST);

                        } else if (Timer.NORMAL.name().equalsIgnoreCase(args[0])) {

                            TimerState state = TimerState.WARMUP;
                            TimerManger.warmUpTimer(Timer.NORMAL);

                        } else {

                        player.sendMessage("§cBitte benutze /start fast/normal/slow");

                    }


                }

            }

        }




        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {


        if (args.length == 1) {


            return Arrays.asList("fast" , "normal" , "slow");

        }



        return null;
    }
}
