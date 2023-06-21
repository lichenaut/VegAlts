package com.lichenaut.vegalts;

import com.lichenaut.vegalts.utility.VADirectoryMaker;
import com.lichenaut.vegalts.utility.VAUpdateChecker;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class VegAlts extends JavaPlugin {

    private final VegAlts plugin = this;
    private Logger log;
    private String dataFolderPath;


    @Override
    public void onEnable() {
        log = getLogger();
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        Configuration config = getConfig();

        //int pluginId = ?????;
        //Metrics metrics = new Metrics(plugin, pluginId);

        if (config.getBoolean("disable-plugin")) {
            log.info("Plugin disabled in config.yml.");
        } else {
            //new VAUpdateChecker(this, plugin).getVersion(version -> {if (!this.getDescription().getVersion().equals(version)) {getLog().info("Update available.");}});

            dataFolderPath = getDataFolder().getPath();

            VADirectoryMaker dirMaker = new VADirectoryMaker(plugin);
            dirMaker.makeDir(dataFolderPath);

        }

    }

    public Logger getLog() {return log;}
    public String getPluginFolderPath() {return dataFolderPath;}
}
