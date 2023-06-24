package com.lichenaut.vegalts.recipes.thirteen;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class VAInkSac {

    private final VegAlts plugin;

    public VAInkSac(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipe() {
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(plugin, "veg_ink_sac"), new ItemStack(Material.INK_SAC))
                .shape(
                        " K ",
                        "KCK",
                        " K ")
                .setIngredient('K', Material.KELP)
                .setIngredient('C', Material.CHARCOAL);
        Bukkit.addRecipe(recipe);
    }
}
