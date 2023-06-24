package com.lichenaut.vegalts.recipes.thirteen;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapelessRecipe;

public class VATropicalFish {

    private final VegAlts plugin;

    public VATropicalFish(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipe() {
        ShapelessRecipe recipe = new ShapelessRecipe(new NamespacedKey(plugin, "veg_tropical_fish"), new ItemStack(Material.TROPICAL_FISH))
                .addIngredient(1, Material.BROWN_MUSHROOM)
                .addIngredient(2, Material.KELP)
                .addIngredient(1, Material.WHEAT)
                .addIngredient(1, Material.CARROT)
                .addIngredient(new RecipeChoice.MaterialChoice(Material.WHEAT_SEEDS, Material.MELON_SEEDS, Material.PUMPKIN_SEEDS, Material.BEETROOT_SEEDS));
        Bukkit.addRecipe(recipe);
    }
}