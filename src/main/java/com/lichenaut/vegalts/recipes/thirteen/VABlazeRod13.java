package com.lichenaut.vegalts.recipes.thirteen;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class VABlazeRod13 {

    private final VegAlts plugin;

    public VABlazeRod13(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipe() {
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(plugin, "veg_blaze_rod"), new ItemStack(Material.BLAZE_ROD))
                .shape(
                        "GDG",
                        "GRG",
                        "GDG")
                .setIngredient('R', Material.IRON_BARS)
                .setIngredient('D', Material.GLOWSTONE_DUST)
                .setIngredient('G', Material.GUNPOWDER);
        Bukkit.addRecipe(recipe);
    }
}