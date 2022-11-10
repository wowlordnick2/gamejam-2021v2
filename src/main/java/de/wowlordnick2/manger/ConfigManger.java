package de.wowlordnick2.manger;

import de.wowlordnick2.Main;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;

public class ConfigManger {

    //TODO: Better ConfigManger with comments and stuff like that (maybe with a config builder)


    public static File config = new File("plugins/EventSystem/config.yml");

    public static File stats = new File("plugins/EventSystem/" + ymal(config).getString("Stats.File"));



    public static void createConfig(File file) {
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            Main.getInstance().saveResource(file.getName(), true);
        }
    }



    //save the file to the disk
    public static void save(YamlConfiguration ymal, File file) {
        try {
            ymal.save(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** returns the ymal file of a file if file don´t exist it will return null -> @NOTNULL
     *
     * @param file
     * @return
     */
    public static @NotNull YamlConfiguration ymal(File file) {

        if (!(file.exists())) {

            return null;
        }


        return YamlConfiguration.loadConfiguration(file);
    }
}
