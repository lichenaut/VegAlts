package com.lichenaut.vegalts.recipes.thirteen;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class VACreeperHead {

    private final VegAlts plugin;

    public VACreeperHead(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipe() {
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(plugin, "veg_creeper_head"), new ItemStack(Material.CREEPER_HEAD))
                .shape(
                        "DGD",
                        "GSG",
                        "DGD")
                .setIngredient('S', Material.SKELETON_SKULL)
                .setIngredient('G', Material.GUNPOWDER)
                .setIngredient('D', Material.LIME_DYE);
        Bukkit.addRecipe(recipe);
    }
}