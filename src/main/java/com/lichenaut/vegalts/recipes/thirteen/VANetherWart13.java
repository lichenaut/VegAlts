package com.lichenaut.vegalts.recipes.thirteen;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapelessRecipe;

public class VANetherWart13 {

    private final VegAlts plugin;

    public VANetherWart13(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipe() {
        ShapelessRecipe recipe = new ShapelessRecipe(new NamespacedKey(plugin, "veg_nether_wart"), new ItemStack(Material.NETHER_WART))
                .addIngredient(new RecipeChoice.MaterialChoice(Material.BROWN_MUSHROOM, Material.RED_MUSHROOM))
                .addIngredient(Material.BLAZE_POWDER);
        Bukkit.addRecipe(recipe);
    }
}