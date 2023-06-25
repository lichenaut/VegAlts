package com.lichenaut.vegalts.recipes.thirteen;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class VAPlayerHead {

    private final VegAlts plugin;

    public VAPlayerHead(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipe() {
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(plugin, "veg_player_head"), new ItemStack(Material.PLAYER_HEAD))
                .shape(
                        "LLL",
                        "LSL",
                        "LLL")
                .setIngredient('S', Material.SKELETON_SKULL)
                .setIngredient('L', Material.LEATHER);
        Bukkit.addRecipe(recipe);
    }
}