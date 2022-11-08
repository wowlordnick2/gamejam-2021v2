package de.wowlordnick2.utils.Enums;

import de.wowlordnick2.Main;
import org.bukkit.ChatColor;

public enum Role {

    USER("User "),
    TEAM("Team "),
    SYSTEM("Projektleitung ");


    Role(String name) {
    this.name = name;
    }

    private String name;


    public String getName() {
        return name;
    }
}
