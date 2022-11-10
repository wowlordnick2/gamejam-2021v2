package de.wowlordnick2.events;

import de.wowlordnick2.Main;
import de.wowlordnick2.utils.Enums.Difficulties;
import de.wowlordnick2.manger.EventsManger;
import de.wowlordnick2.utils.PlayerMangment;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;

public class MLGEvent extends EventsManger {
    @Override
    public void onEnable() {

        System.out.println("Event started " + eventTitle() + " " + positive() +  " "  + getDifficulty());
        sendBossBar();
        Bukkit.getOnlinePlayers().forEach(player -> {
            player.sendMessage(Main.color(Main.getPrefix() + "Event started " + eventTitle() +  " Score: " + positive() + " Difficulty: " + getDifficulty() + " author: " + getAuthor()));
        });

        PlayerMangment.playerList.forEach(player -> {

            Location loc = player.getLocation();
            loc.setY(loc.getY() + 100);
            player.teleport(loc);

            if (player.getWorld().getEnvironment() != World.Environment.NETHER ) {
                player.getInventory().addItem(new ItemStack(Material.WATER_BUCKET));

            } else {
                player.getInventory().addItem(new ItemStack(Material.OAK_BOAT));

            }

            player.sendMessage(Main.color(Main.getPrefix() + "Event started " + eventTitle() +  " Score: " + positive() + " Difficulty: " + getDifficulty() + " author: " + getAuthor()));
        });



        onDisable();
    }

    @Override
    public String eventTitle() {
        return "Höhenangst ? (MLG Event)";
    }

    @Override
    public Difficulties getDifficulty() {
        return Difficulties.NORMAL;
    }

    @Override
    public ItemStack itemStack() {
        return getItemStack(Material.WATER_BUCKET , eventTitle() , positive() , getDifficulty() , getAuthor());
    }

    @Override
    public String getAuthor() {
        return "ohnonick2#3864";
    }

    @Override
    public String getDescription() {
        return "Bei diesem Event wird der Spieler auf die 100 Y Koordinate hin teleportiert und muss ein Wasser MLG machen. "  + "\n" + "Im Nether bekommt der Spieler ein Boot";
    }
}
