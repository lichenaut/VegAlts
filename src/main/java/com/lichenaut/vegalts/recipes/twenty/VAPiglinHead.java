package com.lichenaut.vegalts.recipes.twenty;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class VAPiglinHead {

    private final VegAlts plugin;

    public VAPiglinHead(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipe() {
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(plugin, "veg_piglin_head"), new ItemStack(Material.getMaterial("PIGLIN_HEAD")))
                .shape(
                        "PPP",
                        "PSP",
                        "PPP")
                .setIngredient('S', Material.SKELETON_SKULL)
                .setIngredient('P', Material.PORKCHOP);
        Bukkit.addRecipe(recipe);
    }
}