package bindu.bunny.bunnypaper;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class BunnyPaper extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Logger logger = getLogger();
        logger.info("Enabling BunnyPaper...");
        Bukkit.getPluginManager().registerEvents(new PlayerConnection(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerMovement(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
