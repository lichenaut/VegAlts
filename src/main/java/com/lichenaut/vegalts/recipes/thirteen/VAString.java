package com.lichenaut.vegalts.recipes.thirteen;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapelessRecipe;

public class VAString {

    private final VegAlts plugin;

    public VAString(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipe() {
        ShapelessRecipe recipe1 = new ShapelessRecipe(new NamespacedKey(plugin, "string1"), new ItemStack(Material.STRING))
                .addIngredient(new RecipeChoice.MaterialChoice(Material.GRASS, Material.SEAGRASS))
                .addIngredient(new RecipeChoice.MaterialChoice(Material.GRASS, Material.SEAGRASS))
                .addIngredient(new RecipeChoice.MaterialChoice(Material.GRASS, Material.SEAGRASS))
                .addIngredient(new RecipeChoice.MaterialChoice(Material.GRASS, Material.SEAGRASS));
        Bukkit.addRecipe(recipe1);
        ShapelessRecipe recipe2 = new ShapelessRecipe(new NamespacedKey(plugin, "string2"), new ItemStack(Material.STRING))
                .addIngredient(Material.TALL_GRASS)
                .addIngredient(new RecipeChoice.MaterialChoice(Material.GRASS, Material.SEAGRASS))
                .addIngredient(new RecipeChoice.MaterialChoice(Material.GRASS, Material.SEAGRASS));
        Bukkit.addRecipe(recipe2);
        ShapelessRecipe recipe3 = new ShapelessRecipe(new NamespacedKey(plugin, "string3"), new ItemStack(Material.STRING))
                .addIngredient(2, Material.TALL_GRASS);
        Bukkit.addRecipe(recipe3);
    }
}