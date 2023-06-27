package com.lichenaut.vegalts.recipes.thirteen;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.*;

public class VALeather13 {

    private final VegAlts plugin;

    public VALeather13(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipe() {
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(plugin, "veg_leather"), new ItemStack(Material.LEATHER))
                .shape(
                        "AAA",
                        "SBS",
                        "SSS")
                .setIngredient('A', Material.APPLE)
                .setIngredient('B', Material.GLASS_BOTTLE)
                .setIngredient('S', Material.STRING);
        Bukkit.addRecipe(recipe);
        if (plugin.getPluginConfig().getBoolean("leather-smelting")) {
            FurnaceRecipe furnaceRecipe = new FurnaceRecipe(new NamespacedKey(plugin, "veg_leather_furnace"), new ItemStack(Material.LEATHER), Material.ROTTEN_FLESH, 0, 200);
            Bukkit.addRecipe(furnaceRecipe);
        }
    }
}