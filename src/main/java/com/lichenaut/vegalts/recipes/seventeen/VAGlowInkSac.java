package com.lichenaut.vegalts.recipes.seventeen;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;

public class VAGlowInkSac {

    private final VegAlts plugin;

    public VAGlowInkSac(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipe() {
        ShapelessRecipe recipe = new ShapelessRecipe(new NamespacedKey(plugin, "veg_glow_ink_sac"), new ItemStack(Material.GLOW_INK_SAC))
                .addIngredient(Material.INK_SAC)
                .addIngredient(Material.GLOWSTONE_DUST);
        Bukkit.addRecipe(recipe);
    }
}
