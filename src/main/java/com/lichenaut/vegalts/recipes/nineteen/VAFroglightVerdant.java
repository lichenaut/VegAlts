package com.lichenaut.vegalts.recipes.nineteen;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;

public class VAFroglightVerdant {

    private final VegAlts plugin;

    public VAFroglightVerdant(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipe() {
        ShapelessRecipe recipe = new ShapelessRecipe(new NamespacedKey(plugin, "veg_verdant_froglight"), new ItemStack(Material.getMaterial("VERDANT_FROGLIGHT")))
                .addIngredient(1, Material.getMaterial("SHROOMLIGHT"))
                .addIngredient(1, Material.SLIME_BALL)
                .addIngredient(1, Material.MAGMA_CREAM)
                .addIngredient(1, Material.getMaterial("GREEN_DYE"));
        Bukkit.addRecipe(recipe);
    }
}