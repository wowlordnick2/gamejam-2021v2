package de.wowlordnick2.manger;

import de.wowlordnick2.Main;
import de.wowlordnick2.listener.FindItem;
import de.wowlordnick2.utils.Enums.Difficulties;
import de.wowlordnick2.utils.Enums.Goal;
import de.wowlordnick2.utils.Enums.Timer;
import de.wowlordnick2.utils.EventTimer;
import de.wowlordnick2.utils.PlayerMangment;
import de.wowlordnick2.utils.PlayerTimer;
import net.kyori.adventure.text.Component;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.time.YearMonth;

public class TimerManger {




    /**
     * Returns the time in a string
     *
     * @return
     */

    public static int warpupsec = 60;
    public static int warpupmin = 0;
    public static boolean isRunning;

    public static void warmUpTimer(Timer timer) {

        TextComponent text = new TextComponent(Main.color(Main.getPrefix() + " &cDas Spiel startet sofort! Es ist Zeit sich ein zutragen! (/join) &7(&cClick&7)"));

        text.setClickEvent(new net.md_5.bungee.api.chat.ClickEvent(net.md_5.bungee.api.chat.ClickEvent.Action.RUN_COMMAND, "/join"));

        Bukkit.getOnlinePlayers().forEach(player -> player.spigot().sendMessage(text));

        new BukkitRunnable() {

            @Override
            public void run() {

                if (warpupmin == 0 && warpupsec == 0) {
                    Bukkit.broadcast(Component.text(" PLayer §cDer Timer ist abgelaufen!"));
                    isRunning = false;
                    cancel();
                    if (PlayerMangment.playerList.size() <= Main.getInstance().config.getInt("Game.minplayers")) {
                        Bukkit.broadcast(Component.text(Main.color (Main.getPrefix() + "§cEs sind nicht genügend Spieler online!")));
                        cancel();
                    } else {
                        PlayerTimer.Timer();
                        PlayerTimer.setRunning(true);
                        PlayerTimer.setUP(true);
                        EventTimer.startTimer(timer);


                        PlayerMangment.playerList.forEach(player -> {
                            YamlConfiguration points = ConfigManger.pointsConfig;
                            points.set("Points." + player.getUniqueId(), 0);
                            ConfigManger.save(ConfigManger.pointsConfig, ConfigManger.points);


                            String goal = Main.getInstance().config.getString("Goal.Goal");

                            //TODO add more goals

                            if (goal == null) {
                                GoalManger.setupGoal(Goal.ITEMS);

                            } else {

                                if (goal.equalsIgnoreCase(Goal.ITEMS.toString())) {

                                    GoalManger.setupGoal(Goal.ITEMS);

                                    Bukkit.broadcastMessage(getGoalMessage(Goal.ITEMS));

                                }

                            }




                        });
                        Bukkit.broadcast(Component.text(Main.color(Main.getPrefix() + "&aDas Event startet!")));

                    }

                } else if (warpupsec == 0) {
                    warpupsec = 59;
                    warpupmin--;

                } else {

                    Bukkit.getOnlinePlayers().forEach(player -> {
                        player.sendActionBar(Component.text("Das Spiel startet in §e" + warpupmin + "§7:§e" + warpupsec));
                        isRunning = true;
                    });

                    warpupsec--;
                }


            }


        }.runTaskTimerAsynchronously(Main.getInstance(), 0, 20);


    }

    public static void setMin(int min) {
        TimerManger.warpupmin = min;
    }

    public static void setSec(int sec) {
        TimerManger.warpupsec = sec;
    }

    public static String getGoalMessage(Goal goal) {


        return Main.color(Main.getPrefix() + "&aDas Ziel ist &e" + goal.toString());
    }

}
