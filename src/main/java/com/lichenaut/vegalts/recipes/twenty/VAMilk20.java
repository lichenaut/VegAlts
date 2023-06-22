package com.lichenaut.vegalts.recipes.twenty;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

public class VAMilk20 {

    private final VegAlts plugin;

    public VAMilk20(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipe() {
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(plugin, "veg_milk_bucket"), new ItemStack(Material.MILK_BUCKET))
                .shape(
                        "SSS",
                        "SWS",
                        "SSS")
                .setIngredient('S', new RecipeChoice.MaterialChoice(Material.WHEAT_SEEDS, Material.MELON_SEEDS, Material.PUMPKIN_SEEDS, Material.BEETROOT_SEEDS, Material.TORCHFLOWER_SEEDS))
                .setIngredient('W', Material.WATER_BUCKET);
        Bukkit.addRecipe(recipe);
    }
}
