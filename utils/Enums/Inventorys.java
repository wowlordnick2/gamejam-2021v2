package de.wowlordnick2.utils.Enums;

import de.wowlordnick2.Main;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.Nullable;

public enum Inventorys {


    /**
     * The List of all registered Events
     */
    ANTIVERSTAERKUNG(9*3 , "&cAntistärkung"),
    TIMEROUT(9*3 , "&cTimerOut"),
    ALLEINEEVENT(9*3 , "&cAlleineEvent");




    private int size;
    private String title;

    Inventorys(int size, String title) {
        this.size = size;
        this.title = title;
    }

    public Inventory getInventory() {
        Inventory inventory;
        inventory = Main.getInstance().getServer().createInventory(null  , size , Main.color(title));
        return inventory;
    }

}
