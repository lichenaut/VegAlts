package com.lichenaut.vegalts.recipes.thirteen;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapelessRecipe;

public class VARottenFlesh {

    private final VegAlts plugin;

    public VARottenFlesh(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipe() {
        ShapelessRecipe recipe = new ShapelessRecipe(new NamespacedKey(plugin, "veg_rotten_flesh"), new ItemStack(Material.ROTTEN_FLESH))
                .addIngredient(new RecipeChoice.MaterialChoice(Material.BROWN_MUSHROOM, Material.RED_MUSHROOM))
                .addIngredient(1, Material.SPIDER_EYE)
                .addIngredient(1, Material.BONE_MEAL);
        Bukkit.addRecipe(recipe);
    }
}
