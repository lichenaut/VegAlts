package com.lichenaut.vegalts.recipes.sixteen;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

public class VANetherStar16 {

    private final VegAlts plugin;

    public VANetherStar16(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipe() {
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(plugin, "veg_nether_star"), new ItemStack(Material.NETHER_STAR))
                .shape(
                        "SES",
                        "ECE",
                        "SES")
                .setIngredient('S', new RecipeChoice.MaterialChoice(Material.SOUL_SAND, Material.SOUL_SOIL))
                .setIngredient('E', Material.END_CRYSTAL)
                .setIngredient('C', Material.CONDUIT);
        Bukkit.addRecipe(recipe);
    }
}
