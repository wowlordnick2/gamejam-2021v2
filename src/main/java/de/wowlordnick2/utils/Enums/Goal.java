package de.wowlordnick2.utils.Enums;

public enum Goal {


    ITEMS("Items"),
    BLOCKS("Blocks"),
    MOBS("Mobs"),
    ADVANCEMENTS("Advancements"),
    LOCATION("Location"),
    STRUCTURE("Structure");


    Goal(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }
}
