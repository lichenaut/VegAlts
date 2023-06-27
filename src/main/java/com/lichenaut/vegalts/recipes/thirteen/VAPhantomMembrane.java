package com.lichenaut.vegalts.recipes.thirteen;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class VAPhantomMembrane {

    private final VegAlts plugin;

    public VAPhantomMembrane(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipe() {
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(plugin, "veg_phantom_membrane"), new ItemStack(Material.PHANTOM_MEMBRANE, 2))
                .shape(
                        "PSP",
                        "SPS",
                        "PSP")
                .setIngredient('P', Material.PAPER)
                .setIngredient('S', Material.STRING);
        Bukkit.addRecipe(recipe);
    }
}