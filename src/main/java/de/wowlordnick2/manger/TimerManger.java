package de.wowlordnick2.manger;

import de.wowlordnick2.Main;
import de.wowlordnick2.utils.Enums.Difficulties;
import de.wowlordnick2.utils.Enums.Timer;
import de.wowlordnick2.utils.EventTimer;
import de.wowlordnick2.utils.PlayerTimer;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class TimerManger {

    public static String EventTimer() {


        return null;
    }





    /**
     * Returns the time in a string
     *
     * @return
     */

    public static int warpupsec = 60;
    public static int warpupmin = 0;

    public static void warmUpTimer(Timer timer) {




        new BukkitRunnable() {


            @Override
            public void run() {

                if (warpupmin == 0 && warpupsec == 0) {
                    Bukkit.broadcast(Component.text("§cDer Timer ist abgelaufen!"));
                    cancel();

                    PlayerTimer.Timer();
                    PlayerTimer.setRunning(true);
                    PlayerTimer.setUP(true);
                    EventTimer.startTimer(timer);



                } else if (warpupsec == 0) {
                    warpupsec = 59;
                    warpupmin--;
                } else {

                    Bukkit.getOnlinePlayers().forEach(player -> {
                        player.sendActionBar(Component.text("Das Spiel startet in §e" + warpupmin + "§7:§e" + warpupsec));
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
}
