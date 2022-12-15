package de.wowlordnick2.events;

import de.wowlordnick2.Main;
import de.wowlordnick2.manger.EventsManger;
import de.wowlordnick2.utils.Enums.Difficulties;
import de.wowlordnick2.utils.PlayerMangment;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class InstantBurnEvent extends EventsManger implements Listener {

    public static boolean isRunning = false;
    public int time = 0;

    @Override
    public void onEnable() {
        System.out.println("Event started " + eventTitle() + " " + positive() + " " + getDifficulty());
        sendBossBar();
        isRunning = true;


        new BukkitRunnable() {
            @Override
            public void run() {

                //is time over 5 seconds then stop the event
                if (time >= 5) {
                    cancel();
                   isRunning = false;
                   time = 0;
                }

                if (isRunning) {
                 PlayerMangment.playerList.forEach(player -> {
                     player.setFireTicks(10);
                 });


                }
            }
        }.runTaskTimerAsynchronously(Main.getInstance(), 0, 20);


        onDisable();

        new BukkitRunnable() {
            @Override
            public void run() {
                isRunning = false;
            }
        }.runTaskLater(Main.getInstance() , 20 * 5);

    }

    @Override
    public String eventTitle() {
        return "Instant Burn";
    }

    @Override
    public Difficulties getDifficulty() {
        return Difficulties.FUNKTION;
    }

    @Override
    public boolean positive() {
        return true;
    }

    @Override
    public ItemStack itemStack() {
        return getItemStack( Material.FLINT_AND_STEEL , eventTitle() , positive() , getDifficulty() , getAuthor());
    }

    @Override
    public String getAuthor() {
        return "ohnonick2#3864";
    }

    @Override
    public String getDescription() {
        return "Bei diesen Event wird alles brennbar gemacht was brennbar ist";
    }

    @Override
    public boolean isOption() {
        return false;
    }

    @Override
    public Inventory getInventory() {
        return null;
    }

    /**
     *
     * @param event
     * BlockBreakEvent
     */
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {

        /**
         * if the event is running if yes then the burn able blocks will burn
         */
        if (isRunning) {
            switch (event.getBlock().getType()) {
                case IRON_ORE:
                    //spawn the iron ingot
                    event.setDropItems(false);
                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.IRON_INGOT));
                    break;
                case GOLD_ORE:
                    event.setDropItems(false);
                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.GOLD_INGOT));
                    break;
            }

        }

    }
}
