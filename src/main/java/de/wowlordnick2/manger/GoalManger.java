package de.wowlordnick2.manger;

import de.wowlordnick2.Main;
import de.wowlordnick2.utils.Enums.Blocking;
import de.wowlordnick2.utils.Enums.Goal;
import de.wowlordnick2.utils.PlayerMangment;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.util.Random;

public class GoalManger {


    public static void setupGoal(Goal goal) {

        YamlConfiguration config = Main.getInstance().config;


        switch (goal) {

            case MOBS: {
                System.out.println("Mobs");
            }
            break;
            case BLOCKS: {
                System.out.println("Blocks");
            }
            break;
            case ITEMS: {

                PlayerMangment.playerList.forEach(player -> {
                    Random random = new Random();
                    int randomItem = random.nextInt(Material.values().length);

                    Material material = Material.values()[randomItem];

                    Bukkit.broadcastMessage("Das Item von " + player.getName() + " ist " + material.name());
                    PlayerMangment.playerItem.put(player , material);



                });

                System.out.println("Items");
            }
            break;
            case ADVANCEMENTS: {

                System.out.println("Advancements");
            }
            break;
            case LOCATION: {
                System.out.println("Location");
            }
            case STRUCTURE: {

            }
            break;




        }


    }
}
