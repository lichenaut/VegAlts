package com.lichenaut.vegalts.recipes.twenty;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapelessRecipe;

public class VACod20 {

    private final VegAlts plugin;

    public VACod20(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipe() {
        RecipeChoice.MaterialChoice seeds = new RecipeChoice.MaterialChoice(Material.WHEAT_SEEDS, Material.MELON_SEEDS, Material.PUMPKIN_SEEDS, Material.BEETROOT_SEEDS, Material.getMaterial("TORCHFLOWER_SEEDS"));

        ShapelessRecipe recipe = new ShapelessRecipe(new NamespacedKey(plugin, "veg_cod"), new ItemStack(Material.COD))
                .addIngredient(3, Material.BROWN_MUSHROOM)
                .addIngredient(2, Material.KELP)
                .addIngredient(1, Material.WHEAT)
                .addIngredient(seeds)
                .addIngredient(seeds);
        Bukkit.addRecipe(recipe);
    }
}