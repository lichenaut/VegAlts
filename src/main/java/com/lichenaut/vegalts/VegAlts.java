package com.lichenaut.vegalts;

import com.lichenaut.vegalts.utility.VAContainerConsumerReference;
import com.lichenaut.vegalts.utility.VARecipeAdder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public final class VegAlts extends JavaPlugin implements Listener {

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

            if (version >= 13 && version <= 20) {
                new VARecipeAdder(plugin).addRecipes(version);
            } else {
                log.severe("Unsupported version detected: 1." + version + "!");}

            Bukkit.getPluginManager().registerEvents(this, this);
        }

    }

    @EventHandler
    public void onPlayerCraft(CraftItemEvent e) {
        if (VAContainerConsumerReference.getContainerConsumers().contains(e.getRecipe().getResult().getType())) {
            ItemStack result = new ItemStack(Objects.requireNonNull(e.getCurrentItem()));
            try {e.getInventory().setMatrix(new ItemStack[]{Objects.requireNonNull(e.getInventory().getMatrix()[0]).subtract(), Objects.requireNonNull(e.getInventory().getMatrix()[1]).subtract(), Objects.requireNonNull(e.getInventory().getMatrix()[2]).subtract(), Objects.requireNonNull(e.getInventory().getMatrix()[3]).subtract(), Objects.requireNonNull(e.getInventory().getMatrix()[4]).subtract(), Objects.requireNonNull(e.getInventory().getMatrix()[5]).subtract(), Objects.requireNonNull(e.getInventory().getMatrix()[6]).subtract(), Objects.requireNonNull(e.getInventory().getMatrix()[7]).subtract(), Objects.requireNonNull(e.getInventory().getMatrix()[8]).subtract()});
            } catch (NullPointerException ignored) {}
            if (e.getAction().equals(InventoryAction.MOVE_TO_OTHER_INVENTORY)) {
                Player p = (Player) e.getInventory().getHolder();
                assert p != null;
                ItemStack[] inventory = p.getInventory().getContents();
                boolean isSet = false;
                for (int i = inventory.length-6; i > 0; i--) {
                    if (inventory[i] == null || inventory[i].getType() == Material.AIR) {
                        p.getInventory().setItem(i, result);
                        isSet = true;
                        break;
                    }
                }
                if (!isSet) {p.getWorld().dropItem(p.getLocation(), result);}
            } else {((HumanEntity) Objects.requireNonNull(e.getInventory().getHolder())).setItemOnCursor(result);}
        }
    }
}