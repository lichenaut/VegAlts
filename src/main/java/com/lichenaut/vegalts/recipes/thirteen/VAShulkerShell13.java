package com.lichenaut.vegalts.recipes.thirteen;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class VAShulkerShell13 {

    private final VegAlts plugin;

    public VAShulkerShell13(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipe() {
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(plugin, "veg_shulker_shell"), new ItemStack(Material.SHULKER_SHELL))
                .shape(
                        "PBP",
                        "TST",
                        "R R")
                .setIngredient('B', Material.PURPUR_BLOCK)
                .setIngredient('P', Material.PURPUR_PILLAR)
                .setIngredient('T', Material.PURPUR_STAIRS)
                .setIngredient('S', Material.PURPUR_SLAB)
                .setIngredient('R', Material.END_ROD);
        Bukkit.addRecipe(recipe);
    }
}
