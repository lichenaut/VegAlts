package com.lichenaut.vegalts.recipes.fifteen;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;

public class VAHoneycomb {

    private final VegAlts plugin;

    public VAHoneycomb(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipe() {
        ShapelessRecipe recipe = new ShapelessRecipe(new NamespacedKey(plugin, "veg_honeycomb"), new ItemStack(Material.getMaterial("HONEYCOMB")))
                .addIngredient(1, Material.POTION)
                .addIngredient(1, Material.SUGAR)
                .addIngredient(1, Material.PAPER)
                .addIngredient(1, Material.ORANGE_DYE);
        Bukkit.addRecipe(recipe);
    }
}