package com.lichenaut.vegalts.recipes.thirteen;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class VASkeletonSkull {

    private final VegAlts plugin;

    public VASkeletonSkull(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipe() {
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(plugin, "veg_skeleton_skull"), new ItemStack(Material.SKELETON_SKULL))
                .shape(
                        "BBB",
                        "B B",
                        "BBB")
                .setIngredient('B', Material.BONE);
        Bukkit.addRecipe(recipe);
    }
}
