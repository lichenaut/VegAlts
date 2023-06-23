package com.lichenaut.vegalts.recipes.thirteen;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;

public class VAFeather {

    private final VegAlts plugin;

    public VAFeather(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipe() {
        ShapelessRecipe recipe = new ShapelessRecipe(new NamespacedKey(plugin, "veg_feather"), new ItemStack(Material.FEATHER))
                .addIngredient(Material.STICK)
                .addIngredient(Material.PAPER);
        Bukkit.addRecipe(recipe);
    }
}
