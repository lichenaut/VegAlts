package com.lichenaut.vegalts.recipes.twenty;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapelessRecipe;

public class VARabbit20 {

    private final VegAlts plugin;

    public VARabbit20(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipe() {
        RecipeChoice.MaterialChoice seeds = new RecipeChoice.MaterialChoice(Material.WHEAT_SEEDS, Material.MELON_SEEDS, Material.PUMPKIN_SEEDS, Material.BEETROOT_SEEDS, Material.getMaterial("TORCHFLOWER_SEEDS"));

        ShapelessRecipe recipe = new ShapelessRecipe(new NamespacedKey(plugin, "veg_rabbit"), new ItemStack(Material.RABBIT))
                .addIngredient(4, Material.BROWN_MUSHROOM)
                .addIngredient(1, Material.WHEAT)
                .addIngredient(seeds)
                .addIngredient(seeds);
        Bukkit.addRecipe(recipe);
    }
}