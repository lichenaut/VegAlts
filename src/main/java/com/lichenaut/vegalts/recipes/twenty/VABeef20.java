package com.lichenaut.vegalts.recipes.twenty;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapelessRecipe;

public class VABeef20 {

    private final VegAlts plugin;

    public VABeef20(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipe() {
        ShapelessRecipe recipe = new ShapelessRecipe(new NamespacedKey(plugin, "veg_beef"), new ItemStack(Material.BEEF))
                .addIngredient(6, Material.RED_MUSHROOM)
                .addIngredient(1, Material.BEETROOT)
                .addIngredient(1, Material.WHEAT)
                .addIngredient(new RecipeChoice.MaterialChoice(Material.WHEAT_SEEDS, Material.MELON_SEEDS, Material.PUMPKIN_SEEDS, Material.BEETROOT_SEEDS, Material.getMaterial("TORCHFLOWER_SEEDS")));
        Bukkit.addRecipe(recipe);
    }
}