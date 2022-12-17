package de.wowlordnick2.events;

import de.wowlordnick2.Main;
import de.wowlordnick2.manger.EventsManger;
import de.wowlordnick2.utils.Enums.Difficulties;
import de.wowlordnick2.utils.Enums.Inventorys;
import de.wowlordnick2.utils.PlayerMangment;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Random;

import static de.wowlordnick2.Main.color;

public class AlleineEvent extends EventsManger {

    public static Inventory operation = Inventorys.ALLEINEEVENT.getInventory();
    @Override
    public void onEnable() {
        System.out.println("Event started " + eventTitle() + " " + positive() + " " + getDifficulty());
        sendBossBar();

        PlayerMangment.playerList.forEach(player -> {

            //spawn 5 random mobs around the player
            for (int i = 0; i < 6; i++) {
                Random random = new Random();
                int x = random.nextInt(10);
                int z = random.nextInt(10);

                Entity entity = player.getWorld().spawnEntity(player.getLocation().add(x, 0, z),  getRandomMob());

                entity.setCustomName(color("&cDu bist alleine?"));
                entity.setCustomNameVisible(true);
                entity.setFallDistance(0);


            }



        });



        onDisable();



    }

    @Override
    public String eventTitle() {
        return "Fühlest du dich alleine ?";
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
        return getItemStack(Material.BEE_SPAWN_EGG , eventTitle() , positive() , getDifficulty() , getAuthor() , true);
    }

    @Override
    public String getAuthor() {
        return "theflexitime#7600";
    }

    @Override
    public String getDescription() {
        return "Bei diesem Event wird bei jedem Spieler Random Mobs gespawnt";
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
                    operation.setItem(i, arrow);
                    break;
                }
                default:
                    operation.setItem(i, getInventoryPlaceHolder());


            }



        }


        return operation;
    }


    private EntityType getRandomMob() {
        Random random = new Random();
        int i = random.nextInt(4);
        switch (i) {
            case 0:
                return EntityType.SPIDER;
            case 1:
                return EntityType.CAVE_SPIDER;
            case 2:
                return EntityType.CREEPER;
            case 3:
                return EntityType.ENDERMAN;
            case 4:
                return EntityType.SKELETON;


        }
       System.out.println("Error in getRandomMob " + i);
        return null;

    }


}
