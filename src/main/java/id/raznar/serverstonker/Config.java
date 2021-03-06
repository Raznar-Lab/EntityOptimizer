package id.raznar.serverstonker;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {
    private static File file;
    private static YamlConfiguration configurationFile;


    public static void setup() {
        file = new File(Main.plugin.getDataFolder(), "config.yml");
        if(!file.exists()) {
            try {
                file.createNewFile();
            }catch(IOException error) {
                Bukkit.getLogger().info(Utils.colorize("&cInvalid Configuration!"));
            }
        }
        configurationFile = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration get() {
        return configurationFile;
    }
    public static void save() {
        try{
            configurationFile.save(file);
        }catch (IOException error) {
            Bukkit.getLogger().info(Utils.colorize("&cInvalid Configuration"));
        }
    }
    public static void reload() {
        configurationFile = YamlConfiguration.loadConfiguration(file);
    }
}
