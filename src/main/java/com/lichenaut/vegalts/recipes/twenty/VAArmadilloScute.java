package com.lichenaut.vegalts.recipes.twenty;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class VAArmadilloScute {

    private final VegAlts plugin;

    public VAArmadilloScute(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipe() {
        ItemStack armadilloScute = new ItemStack(Material.getMaterial("ARMADILLO_SCUTE"), 2);

        ShapedRecipe recipe1 = new ShapedRecipe(new NamespacedKey(plugin, "veg_ascute_1"), armadilloScute)
                .shape(
                        "KKK",
                        "KBK",
                        "BBB")
                .setIngredient('K', Material.BRICK)
                .setIngredient('B', Material.BONE);
        Bukkit.addRecipe(recipe1);
        ShapedRecipe recipe2 = new ShapedRecipe(new NamespacedKey(plugin, "veg_ascute_2"), armadilloScute)
                .shape(
                        "BBB",
                        "KBK",
                        "KKK")
                .setIngredient('K', Material.BRICK)
                .setIngredient('B', Material.BONE);
        Bukkit.addRecipe(recipe2);
    }
}