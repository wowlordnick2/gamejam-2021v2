package de.wowlordnick2.events;

import de.wowlordnick2.Main;
import de.wowlordnick2.manger.EventsManger;
import de.wowlordnick2.utils.Enums.Difficulties;
import de.wowlordnick2.utils.Enums.Inventorys;
import de.wowlordnick2.utils.PlayerMangment;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Wolf;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;


import java.util.Arrays;

public class AntistaerkungEvent extends EventsManger {


    public static int mobCount = Main.getInstance().config.getInt("Events.Antistaerkung.MobCount");
    public static Inventory operation = Inventorys.ANTIVERSTAERKUNG.getInventory();

    @Override
    public void onEnable() {
        System.out.println("Event started " + eventTitle() + " " + positive() +  " "  + getDifficulty());
        sendBossBar();


        PlayerMangment.playerList.forEach(player -> {
            for (int i = 0; i < mobCount; i++) {
            Entity entity = player.getLocation().getWorld().spawnEntity(player.getLocation(), EntityType.WOLF);
                Wolf wolf = (Wolf) entity;
                wolf.setAngry(true);
                wolf.setTarget(player);
            }
        });



        onDisable();
    }

    @Override
    public String eventTitle() {
        return "Antistärkung Event";
    }


    @Override
    public Difficulties getDifficulty() {
        return Difficulties.EASY;
    }

    @Override
    public boolean positive() {
        return false;
    }

    @Override
    public ItemStack itemStack() {
        return getItemStack(Material.POTION , eventTitle() , positive() , getDifficulty() , getAuthor() , true);
    }

    @Override
    public String getAuthor() {
        return "theflexitime#7600";
    }

    @Override
    public String getDescription() {
        return "Es spawnt {0} aggressiven Wolf / Wölfe die auf  den Spieler getriggert sind".replace("{0}"  , String.valueOf(mobCount));
    }

    @Override
    public boolean isOption() {
        return true;
    }


    /**
     *
     * @return Inventory
     */
    public Inventory getInventory() {
        ItemStack itemStack1 = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta itemMeta1 = itemStack1.getItemMeta();
        itemMeta1.setDisplayName(ChatColor.DARK_AQUA.toString());
        itemStack1.setItemMeta(itemMeta1);

        for (int i = 0; i < operation.getSize(); i++) {
            if (operation.getItem(i) == null) {
                switch (i) {
                    case 10: {
                        operation.setItem(10 , getMobSpawnRateItem());
                    }
                    case 18: {
                        ItemStack arrow = new ItemStack(Material.ARROW);
                        ItemMeta arrowMeta = arrow.getItemMeta();
                        arrowMeta.setDisplayName(Main.color("&7Zurück"));
                        arrow.setItemMeta(arrowMeta);
                        operation.setItem(18 , arrow);
                    }
                    break;
                    default:
                    operation.setItem(i , itemStack1);
                    break;
                }

            }
        }


        return operation;
    }


    /**
     *
     * @return ItemStack
     */
    public static @NotNull ItemStack getMobSpawnRateItem(){

        ItemStack itemStack = new ItemStack(Material.CLOCK);
        ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.setDisplayName("§c§lMob Spawnrate");

        itemMeta.setLore(Arrays.asList(
                "\n",
                ChatColor.GRAY + "Aktuelle Mob Count " +  ChatColor.DARK_AQUA + mobCount,
                ChatColor.GRAY + "Hoch : " + "§cRechtsklick",
                ChatColor.GRAY + "Runter : " + "§cLinksklick",
                "\n"
                )
        );



        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

}
