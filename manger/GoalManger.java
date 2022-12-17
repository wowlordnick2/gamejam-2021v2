package de.wowlordnick2.manger;

import de.wowlordnick2.Main;
import de.wowlordnick2.utils.Enums.Blocking;
import de.wowlordnick2.utils.Enums.Goal;
import de.wowlordnick2.utils.PlayerMangment;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
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

                    List<String> blockedItems = new ArrayList<>();

                    for (Blocking blocking : Blocking.values()) {
                        blockedItems.add(blocking.name());
                    }

                    if (blockedItems.contains(material.name())) {

                        setupGoal(goal);

                    } else {
                        PlayerMangment.playerItem.put(player, material);
                        player.sendMessage(Main.color(Main.getPrefix() + "&7Du musst &a" + material.name() + " &7finden!"));
                    }

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

            case RANDOM: {
                System.out.println("Random");
            }


        }


    }
}
