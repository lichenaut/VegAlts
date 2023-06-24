package com.lichenaut.vegalts.recipes.thirteen;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

public class VAGhastTear {

    private final VegAlts plugin;

    public VAGhastTear(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipe() {
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(plugin, "veg_ghast_tear"), new ItemStack(Material.GHAST_TEAR))
                .shape(
                        "GGG",
                        "GNG",
                        "GGG")
                .setIngredient('G', Material.GUNPOWDER)
                .setIngredient('N', new RecipeChoice.MaterialChoice(Material.IRON_NUGGET, Material.GOLD_NUGGET));
        Bukkit.addRecipe(recipe);
    }
}
