package com.lichenaut.vegalts;

import com.lichenaut.vegalts.utility.VARecipeAdder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public final class VegAlts extends JavaPlugin implements Listener {

    private final VegAlts plugin = this;
    private Logger log;

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

            int version = Integer.parseInt(Bukkit.getServer().getBukkitVersion().split("-")[0].split(Pattern.quote("."))[1]);

            if (version >= 13 && version <= 20) {
                new VARecipeAdder(plugin).addRecipes(version);
            } else {log.severe("Unsupported version detected: 1." + version + "!");}

            Bukkit.getPluginManager().registerEvents(this, this);
        }

    }

    @EventHandler
    public void onPlayerCraft(CraftItemEvent e) {
        ItemStack result = new ItemStack(Objects.requireNonNull(e.getCurrentItem()));//add if statement so this only happens on relevant crafts (buckets, bottles)
        e.getInventory().setMatrix(new ItemStack[]{new ItemStack(Material.AIR), new ItemStack(Material.AIR), new ItemStack(Material.AIR), new ItemStack(Material.AIR), new ItemStack(Material.AIR), new ItemStack(Material.AIR), new ItemStack(Material.AIR), new ItemStack(Material.AIR), new ItemStack(Material.AIR)});
        ((HumanEntity) Objects.requireNonNull(e.getInventory().getHolder())).setItemOnCursor(result);
    }

    public Logger getLog() {return log;}
}
