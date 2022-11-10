package de.wowlordnick2.utils;

import de.wowlordnick2.Main;
import de.wowlordnick2.utils.Enums.Difficulties;
import de.wowlordnick2.utils.Enums.Timer;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.DataOutputStream;

public class EventTimer {

    public static boolean isRunning = false;



    /**
     * Start the event timer with the given timer enum
     * @param timer
     */
    public static void startTimer(Timer timer) {
        final int[] sec = {timer.getSec()};
        final int[] min = {timer.getMin()};

        isRunning = true;
        new BukkitRunnable() {
            @Override
            public void run() {

                if (isRunning) {
                    if (sec[0] == 0 && min[0] == 0) {
                        sec[0] = 59;
                        min[0]--;
                    } else if (sec[0] == 0) {
                        sec[0] = 59;
                        min[0]--;
                    }
                    if (min[0] == 0 && sec[0] == 0) {
                        Bukkit.broadcastMessage("§cDer Timer ist abgelaufen!");
                        cancel();
                        isRunning = false;
                    }
                }
                }
        }.runTaskTimerAsynchronously(Main.getInstance(), 0, 20);


    }


}
