package de.wowlordnick2.events;

import de.wowlordnick2.Main;
import de.wowlordnick2.manger.EventsManger;
import de.wowlordnick2.manger.TimerManger;
import de.wowlordnick2.utils.Enums.Difficulties;
import de.wowlordnick2.utils.PlayerTimer;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;



public class TimerOut extends EventsManger {
    @Override
    public void onEnable() {
        System.out.println("Event started " + eventTitle() + " " + positive() + " " + getDifficulty());
        sendBossBar();

        PlayerTimer.showTimer = false;

        new BukkitRunnable() {
          @Override
          public void run() {

              PlayerTimer.showTimer=true;

          }
        }.runTaskLaterAsynchronously(Main.getInstance() , 20*5 );

        onDisable();

    }

    @Override
    public String eventTitle() {
        return "Kein Stress";
    }

    @Override
    public Difficulties getDifficulty() {
        return Difficulties.FUNKTION;
    }

    @Override
    public boolean positive() {
        return false;
    }

    @Override
    public ItemStack itemStack() {
        return getItemStack(Material.CLOCK , eventTitle() , positive() , getDifficulty() , getAuthor());
    }

    @Override
    public String getAuthor() {
        return "ohnonick2#3864";
    }

    @Override
    public String getDescription() {
        return "Bei diesem Event wird der Timer ausgeblendet";
    }

    @Override
    public boolean isOption() {
        return false;
    }

    @Override
    public Inventory getInventory() {
        return null;
    }
}
