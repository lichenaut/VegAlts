package com.lichenaut.vegalts.recipes.thirteen;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;

public class VASpiderEye {

    private final VegAlts plugin;

    public VASpiderEye(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipe() {
        ShapelessRecipe recipe = new ShapelessRecipe(new NamespacedKey(plugin, "veg_spider_eye"), new ItemStack(Material.SPIDER_EYE))
                .addIngredient(2, Material.RED_MUSHROOM)
                .addIngredient(1, Material.BEETROOT)
                .addIngredient(1, Material.POISONOUS_POTATO);
        Bukkit.addRecipe(recipe);
    }
}