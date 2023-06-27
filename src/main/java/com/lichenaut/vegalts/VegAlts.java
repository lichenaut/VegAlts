package com.lichenaut.vegalts;

import com.lichenaut.vegalts.commands.VACommand;
import com.lichenaut.vegalts.commands.VATabCompleter;
import com.lichenaut.vegalts.utility.VARecipeAdder;
import org.bukkit.Bukkit;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public final class VegAlts extends JavaPlugin {

    private final VegAlts plugin = this;
    private final Logger log = getLogger();
    private final Configuration config = getConfig();
    private int version;

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        //int pluginId = ?????;
        //Metrics metrics = new Metrics(plugin, pluginId);

        if (config.getBoolean("disable-plugin")) log.info("Plugin disabled in config.yml.");
        else {
            //new VAUpdateChecker(this, plugin).getVersion(version -> {if (!this.getDescription().getVersion().equals(version)) {getLog().info("Update available.");}});

            String sVersion = Bukkit.getServer().getBukkitVersion();
            version = Integer.parseInt(sVersion.split("-")[0].split(Pattern.quote("."))[1]);

            if (version >= 13) {
                Objects.requireNonNull(getCommand("va")).setExecutor(new VACommand(plugin));
                Objects.requireNonNull(getCommand("va")).setTabCompleter(new VATabCompleter());
                new VARecipeAdder(plugin).addRecipes(version);
                
            } else log.severe("Unsupported version detected: " + sVersion + "! Disabling plugin.");
        }
    }

    public Logger getLog() {return log;}
    public Configuration getPluginConfig() {return config;}
    public int getVersion() {return version;}
}