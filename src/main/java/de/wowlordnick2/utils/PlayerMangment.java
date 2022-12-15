package de.wowlordnick2.utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.advancement.Advancement;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PlayerMangment {

    /**
     * the list of all players in the game
     */
    public static List<Player> playerList = new ArrayList<>();

    /**
     * the list of all players who are offline
     */
    public static List<Player> offlinePlayerList = new ArrayList<>();


    public static HashMap<Player , Material> playerItem = new HashMap<>();
    public static HashMap<Player , Advancement> playerAdvancement = new HashMap<>();
    public static HashMap<Player, Location> playerLocation = new HashMap<>();
    public static HashMap<Player, String> playerStructure = new HashMap<>();



}
