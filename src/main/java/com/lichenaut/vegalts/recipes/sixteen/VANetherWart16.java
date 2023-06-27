package com.lichenaut.vegalts.recipes.sixteen;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapelessRecipe;

public class VANetherWart16 {

    private final VegAlts plugin;

    public VANetherWart16(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipe() {
        ShapelessRecipe recipe = new ShapelessRecipe(new NamespacedKey(plugin, "veg_nether_wart"), new ItemStack(Material.NETHER_WART))
                .addIngredient(new RecipeChoice.MaterialChoice(Material.BROWN_MUSHROOM, Material.RED_MUSHROOM, Material.getMaterial("CRIMSON_FUNGUS"), Material.getMaterial("WARPED_FUNGUS")))
                .addIngredient(Material.BLAZE_POWDER);
        Bukkit.addRecipe(recipe);
    }
}