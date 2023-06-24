package com.lichenaut.vegalts.recipes.thirteen;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapelessRecipe;

public class VAPufferfish {

    private final VegAlts plugin;

    public VAPufferfish(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipe() {
        RecipeChoice.MaterialChoice seeds = new RecipeChoice.MaterialChoice(Material.WHEAT_SEEDS, Material.MELON_SEEDS, Material.PUMPKIN_SEEDS, Material.BEETROOT_SEEDS);

        ShapelessRecipe recipe = new ShapelessRecipe(new NamespacedKey(plugin, "veg_pufferfish"), new ItemStack(Material.PUFFERFISH))
                .addIngredient(1, Material.BROWN_MUSHROOM)
                .addIngredient(1, Material.SPIDER_EYE)
                .addIngredient(4, Material.KELP)
                .addIngredient(1, Material.WHEAT)
                .addIngredient(seeds)
                .addIngredient(seeds);
        Bukkit.addRecipe(recipe);
    }
}