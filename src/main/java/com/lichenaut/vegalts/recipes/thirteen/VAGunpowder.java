package com.lichenaut.vegalts.recipes.thirteen;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;

public class VAGunpowder {

    private final VegAlts plugin;

    public VAGunpowder(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipe() {
        ShapelessRecipe recipe = new ShapelessRecipe(new NamespacedKey(plugin, "veg_gunpowder"), new ItemStack(Material.GUNPOWDER))
                .addIngredient(1, Material.GLOWSTONE_DUST)
                .addIngredient(1, Material.SAND)
                .addIngredient(1, Material.GRAVEL);
        Bukkit.addRecipe(recipe);
    }
}
