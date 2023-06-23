package com.lichenaut.vegalts;

import com.lichenaut.vegalts.utility.VAContainerConsumerListener;
import com.lichenaut.vegalts.utility.VARecipeAdder;
import org.bukkit.Bukkit;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;
import java.util.regex.Pattern;

public final class VegAlts extends JavaPlugin {

    private final VegAlts plugin = this;

    @Override
    public void onEnable() {
        Logger log = getLogger();
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        Configuration config = getConfig();

        //int pluginId = ?????;
        //Metrics metrics = new Metrics(plugin, pluginId);

        if (config.getBoolean("disable-plugin")) {
            log.info("Plugin disabled in config.yml.");
        } else {
            //new VAUpdateChecker(this, plugin).getVersion(version -> {if (!this.getDescription().getVersion().equals(version)) {getLog().info("Update available.");}});

            int version = Integer.parseInt(Bukkit.getServer().getBukkitVersion().split("-")[0].split(Pattern.quote("."))[1]);

            if (version >= 13) {new VARecipeAdder(plugin).addRecipes(version);
            } else {log.severe("Unsupported version detected: " + Bukkit.getServer().getBukkitVersion() + "!");}

            Bukkit.getPluginManager().registerEvents(new VAContainerConsumerListener(), this);
        }

    }
}