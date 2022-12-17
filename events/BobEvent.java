package de.wowlordnick2.events;

import de.wowlordnick2.Main;
import de.wowlordnick2.manger.EventsManger;
import de.wowlordnick2.utils.Enums.Difficulties;
import de.wowlordnick2.utils.PlayerMangment;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class BobEvent extends EventsManger {
    @Override
    public void onEnable() {
        System.out.println("Event started " + eventTitle() + " " + positive() + " " + getDifficulty());
        sendBossBar();



        PlayerMangment.playerList.forEach(player -> {
            player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 300, 1));
        });
        onDisable();

    }

    @Override
    public String eventTitle() {
        return "Ist das Bob der Baubehinderer?";
    }

    @Override
    public Difficulties getDifficulty() {
        return Difficulties.NORMAL;
    }

    @Override
    public boolean positive() {
        return false;
    }

    @Override
    public ItemStack itemStack() {
        return getItemStack(Material.WOODEN_PICKAXE , eventTitle() , positive() , getDifficulty() , getAuthor() ,false);
    }

    @Override
    public String getAuthor() {
        return "theflexitime#7600";
    }

    @Override
    public String getDescription() {
        return "Bei diesem Event wird jedem Spieler abbaulähmumg gegeben";
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
