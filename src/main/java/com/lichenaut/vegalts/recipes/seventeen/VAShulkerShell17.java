package com.lichenaut.vegalts.recipes.seventeen;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class VAShulkerShell17 {

    private final VegAlts plugin;

    public VAShulkerShell17(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipe() {
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(plugin, "veg_shulker_shell"), new ItemStack(Material.SHULKER_SHELL))
                .shape(
                        "AAA",
                        "AAA",
                        "R R")
                .setIngredient('A', Material.AMETHYST_CLUSTER)
                .setIngredient('R', Material.END_ROD);
        Bukkit.addRecipe(recipe);
    }
}
