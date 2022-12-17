package de.wowlordnick2.listener;



import de.wowlordnick2.Main;
import de.wowlordnick2.manger.ConfigManger;
import de.wowlordnick2.manger.GoalManger;
import de.wowlordnick2.utils.Enums.Goal;
import de.wowlordnick2.utils.Enums.TimerState;
import de.wowlordnick2.utils.PlayerMangment;
import de.wowlordnick2.utils.PlayerTimer;
import org.bukkit.Bukkit;
import org.bukkit.Material;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAttemptPickupItemEvent;

import java.util.Locale;


public class FindItem implements Listener {

    @EventHandler(ignoreCancelled =true)
    public void onPlayerAttemptPickupItem(PlayerAttemptPickupItemEvent event) {
        Player player = event.getPlayer();
        if (!PlayerMangment.playerList.contains(event.getPlayer())) {
            return;
        }
        Material material = event.getItem().getItemStack().getType();

        if (PlayerMangment.playerItem.get(player) == material) {

            int winamount = Main.getInstance().config.getInt("Goal.needtowingame");
            int currentamount = ConfigManger.getPoints(player.getUniqueId());


            if (currentamount == winamount) {


                Bukkit.broadcastMessage(Main.color(Main.getPrefix() + " &a" + player.getName() + " &7hat das Spiel gewonnen!"));
                TimerState timerState = TimerState.STOPPED;

                PlayerTimer.setRunning(false);

            } else {
                ConfigManger.setPoints(player.getUniqueId(), currentamount + 1);
                Bukkit.broadcastMessage(Main.color(Main.getPrefix() + " &a" + player.getName() + " &7hat ein Item gefunden!"));

                Bukkit.getOnlinePlayers().forEach(all -> {

                    String goal = Main.getInstance().config.getString("Goal.goal");

                    if (goal == null) {

                        GoalManger.setupGoal(Goal.ITEMS);

                    } else if (goal.equalsIgnoreCase("items")) {
                        GoalManger.setupGoal(Goal.ITEMS);
                    }



                });


            }


        }




    }



}
