package com.lichenaut.vegalts.recipes.thirteen;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;

public class VARabbitsFoot {

    private final VegAlts plugin;

    public VARabbitsFoot(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipe() {
        ShapelessRecipe recipe = new ShapelessRecipe(new NamespacedKey(plugin, "veg_rabbits_foot"), new ItemStack(Material.RABBIT_FOOT).add())
                .addIngredient(1, Material.RABBIT_HIDE)
                .addIngredient(1, Material.BONE);
        Bukkit.addRecipe(recipe);
    }
}