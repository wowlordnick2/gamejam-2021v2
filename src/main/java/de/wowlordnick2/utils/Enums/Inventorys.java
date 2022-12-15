package de.wowlordnick2.utils.Enums;

import de.wowlordnick2.Main;
import org.jetbrains.annotations.Nullable;

public enum Inventorys {


    /**
     * The List of all registered Events
     */
    ANTIVERSTAERKUNG(null , 9*3 , "&cAntistärkung");




    private String owner;
    private int size;
    private String title;

    Inventorys(@Nullable String owner, int size, String title) {
        this.owner = owner;
        this.size = size;
        this.title = title;
    }

    public int getSize() {
        return size;
    }

    public String getOwner() {
        return owner;
    }

    public String getTitle() {
        return Main.color(title);
    }

}
