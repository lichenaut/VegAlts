package com.lichenaut.vegalts.recipes.fifteen;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;

public class VAHoneyBottle {

    private final VegAlts plugin;

    public VAHoneyBottle(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipe() {
        ShapelessRecipe recipe = new ShapelessRecipe(new NamespacedKey(plugin, "veg_honey_bottle"), new ItemStack(Material.HONEY_BOTTLE))
                .addIngredient(1, Material.GLASS_BOTTLE)
                .addIngredient(1, Material.HONEYCOMB);
        Bukkit.addRecipe(recipe);
    }
}