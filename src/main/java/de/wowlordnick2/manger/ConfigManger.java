package de.wowlordnick2.manger;

import de.wowlordnick2.Main;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.UUID;

public class ConfigManger {

    //TODO: Better ConfigManger with comments and stuff like that (maybe with a config builder)

    public static File points = new File("plugins/EventSystem/points.yml");
    public static YamlConfiguration pointsConfig = YamlConfiguration.loadConfiguration(points);

    public static void createConfig(@NotNull File file) {

        if (!file.exists()) {
            file.getParentFile().mkdirs();

        }
    }

    public static void save(@NotNull File file , @NotNull YamlConfiguration config) {
        try {
            config.save(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    //save the file to the disk
    public static void save(YamlConfiguration ymal, @NotNull File file) {

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            ymal.save(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * returns the ymal file of a file if file don´t exist it will return null -> @NOTNULL
     * @return
     */
    public static YamlConfiguration getPointsConfig() {
        return pointsConfig;
    }


    public static int getPoints(UUID uuid) {

        if (pointsConfig.get(String.valueOf(uuid)) == null) {
            return 0;
        }
        return pointsConfig.getInt(String.valueOf(uuid));
    }

    public static boolean hasPoints(String uuid) {
        return pointsConfig.contains(uuid);
    }

    public static void setPoints(UUID uuid , int point) {
        pointsConfig.set(String.valueOf(uuid), point);
       save(pointsConfig , points);
    }

    public static int getWinPoints() {
        return pointsConfig.getInt("Settings.win");
    }

}
