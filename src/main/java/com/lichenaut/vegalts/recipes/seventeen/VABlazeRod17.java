package com.lichenaut.vegalts.recipes.seventeen;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

public class VABlazeRod17 {

    private final VegAlts plugin;

    public VABlazeRod17(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipe() {
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(plugin, "veg_blaze_rod"), new ItemStack(Material.BLAZE_ROD))
                .shape(
                        "GDG",
                        "GRG",
                        "GDG")
                .setIngredient('R', new RecipeChoice.MaterialChoice(Material.IRON_BARS, Material.LIGHTNING_ROD))
                .setIngredient('D', Material.GLOWSTONE_DUST)
                .setIngredient('G', Material.GUNPOWDER);
        Bukkit.addRecipe(recipe);
    }
}
