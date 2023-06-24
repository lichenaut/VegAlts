package com.lichenaut.vegalts.recipes.thirteen;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class VAScute {

    private final VegAlts plugin;

    public VAScute(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipe() {
        ShapedRecipe recipe1 = new ShapedRecipe(new NamespacedKey(plugin, "veg_scute_1"), new ItemStack(Material.SCUTE))
                .shape(
                        "BBB",
                        "KBK",
                        "KKK")
                .setIngredient('K', Material.KELP)
                .setIngredient('B', Material.BONE);
        Bukkit.addRecipe(recipe1);
        ShapedRecipe recipe2 = new ShapedRecipe(new NamespacedKey(plugin, "veg_scute_2"), new ItemStack(Material.SCUTE))
                .shape(
                        "KKK",
                        "KBK",
                        "BBB")
                .setIngredient('K', Material.KELP)
                .setIngredient('B', Material.BONE);
        Bukkit.addRecipe(recipe2);
    }
}