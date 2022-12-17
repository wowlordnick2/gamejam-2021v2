package de.wowlordnick2.events;

import de.wowlordnick2.Main;
import de.wowlordnick2.manger.EventsManger;
import de.wowlordnick2.manger.TimerManger;
import de.wowlordnick2.utils.Enums.Difficulties;
import de.wowlordnick2.utils.Enums.Inventorys;
import de.wowlordnick2.utils.PlayerTimer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;



public class TimerOut extends EventsManger {


    /**
     * Control with type of players can see the timer if the showTimer is false
     */
    public static boolean speccansee = Main.getInstance().config.getBoolean("Events.TimerOut.speccansee");

    /**
     * Option Inventory for the TimerOut Event
     */
    public static Inventory operation = Inventorys.TIMEROUT.getInventory();

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
        return getItemStack(Material.CLOCK , eventTitle() , positive() , getDifficulty() , getAuthor() , true);
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
        return true;
    }

    @Override
    public Inventory getInventory() {

        for (int i = 0; i < operation.getSize(); i++) {

            switch (i) {

                case 18: {
                    ItemStack arrow = new ItemStack(Material.ARROW);
                    ItemMeta arrowMeta = arrow.getItemMeta();
                    arrowMeta.setDisplayName(Main.color("&7Zurück"));
                    arrow.setItemMeta(arrowMeta);
                    operation.setItem(18 , arrow);
                }
                break;

                default: {
                    operation.setItem(i , getInventoryPlaceHolder());
                }


            }




        }

        return operation;
    }
}
