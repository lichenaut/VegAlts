package com.lichenaut.vegalts.recipes.nineteen;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class VAGoatHorn19 {

    private final VegAlts plugin;

    public VAGoatHorn19(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipe() {
        ShapedRecipe recipe1 = new ShapedRecipe(new NamespacedKey(plugin, "veg_goat_horn"), new ItemStack(Material.GOAT_HORN))
                .shape(
                        "SFD",
                        " P ")
                .setIngredient('S', Material.SLIME_BALL)
                .setIngredient('F', Material.DISC_FRAGMENT_5)
                .setIngredient('D', Material.BLACK_DYE)
                .setIngredient('P', Material.POINTED_DRIPSTONE);
        Bukkit.addRecipe(recipe1);
        ShapedRecipe recipe2 = new ShapedRecipe(new NamespacedKey(plugin, "veg_goat_horn_screaming"), new ItemStack(Material.GOAT_HORN))
                .shape(
                        " G ",
                        "SFD",
                        " P ")
                .setIngredient('G', Material.GUNPOWDER)
                .setIngredient('S', Material.SLIME_BALL)
                .setIngredient('F', Material.DISC_FRAGMENT_5)
                .setIngredient('D', Material.BLACK_DYE)
                .setIngredient('P', Material.POINTED_DRIPSTONE);
        Bukkit.addRecipe(recipe2);
    }
}