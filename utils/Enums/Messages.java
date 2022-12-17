package de.wowlordnick2.utils.Enums;

import de.wowlordnick2.Main;

public enum Messages {


    CONOSLEN_MESSAGE(Main.getPrefix() + " &cDu musst ein Spieler sein!"),
    PLAYER_NOPERM(Main.getPrefix() + " &cDu hast keine Rechte!");






    Messages(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }

}
