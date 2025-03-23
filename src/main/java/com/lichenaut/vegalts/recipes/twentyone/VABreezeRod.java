package com.lichenaut.vegalts.recipes.twentyone;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class VABreezeRod {

    private final VegAlts plugin;

    public VABreezeRod(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipe() {
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(plugin, "veg_breeze_rod"), new ItemStack(Material.getMaterial("BREEZE_ROD")))
                .shape(
                        "AAA",
                        "ABA",
                        "AAA")
                .setIngredient('A', Material.getMaterial("AMETHYST_CLUSTER"))
                .setIngredient('B', Material.BLAZE_ROD);
        Bukkit.addRecipe(recipe);
    }
}
