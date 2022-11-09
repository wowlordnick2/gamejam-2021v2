package de.wowlordnick2.events;

import de.wowlordnick2.Main;
import de.wowlordnick2.utils.Enums.Eventdifficulties;
import de.wowlordnick2.utils.EventsManger;
import de.wowlordnick2.utils.PlayerMangment;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class Abbau extends EventsManger {
    @Override
    public void onEnable() {
        System.out.println("Event started " + eventTitle() + " " + positive() +  " "  + getDifficulty());
        sendBossBar();
        Bukkit.getOnlinePlayers().forEach(player -> {
            player.sendMessage(Main.color(Main.getPrefix() + "Event started " + eventTitle() +  " Score: " + positive() + " Difficulty: " + getDifficulty() + " author: " + getAuthor()));
        });

        PlayerMangment.playerList.forEach(player -> {

            player.sendMessage("Event started " + eventTitle() +  " Score: " + positive() + " Difficulty: " + getDifficulty() + " author: " + getAuthor());

            new BukkitRunnable() {

                int timer = 0;

                @Override
                public void run() {
                    timer++;
                    if(timer <= 30) {

                        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 20, Integer.MAX_VALUE));

                    } else {

                        timer = 0;
                        cancel();
                        player.removePotionEffect(PotionEffectType.SLOW_DIGGING);

                    }


                }
            }.runTaskTimerAsynchronously(Main.getInstance() , 0 , 20);


        });


        onDisable();
    }

    @Override
    public String eventTitle() {
        return "Abbaulähmung (Ist das Bob?)";
    }

    @Override
    public Eventdifficulties getDifficulty() {
        return Eventdifficulties.NORMAL;
    }

    @Override
    public ItemStack itemStack() {
        return getItemStack(Material.DIAMOND_PICKAXE , eventTitle() , positive() , getDifficulty() , getAuthor());
    }

    @Override
    public String getAuthor() {
        return "theflexitime#7600";
    }

    @Override
    public String getdescription() {
        return "Bei diesem Event wird jedem Spieler abbaulähmumg gegeben";
    }
}
