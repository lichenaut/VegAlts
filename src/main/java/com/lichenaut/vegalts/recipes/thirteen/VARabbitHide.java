package com.lichenaut.vegalts.recipes.thirteen;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class VARabbitHide {

    private final VegAlts plugin;

    public VARabbitHide(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipe() {
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(plugin, "veg_rabbit_hide"), new ItemStack(Material.RABBIT_HIDE))
                .shape(
                        " A ",
                        "SBS",
                        " S ")
                .setIngredient('A', Material.APPLE)
                .setIngredient('B', Material.GLASS_BOTTLE)
                .setIngredient('S', Material.STRING);
        Bukkit.addRecipe(recipe);
    }
}