package com.lichenaut.vegalts.recipes.thirteen;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class VAEgg {

    private final VegAlts plugin;

    public VAEgg(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipe() {
        ItemStack egg = new ItemStack(Material.EGG);
        ItemMeta eggMeta = egg.getItemMeta();
        eggMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        egg.setItemMeta(eggMeta);

        ShapelessRecipe recipe = new ShapelessRecipe(new NamespacedKey(plugin, "veg_egg"), egg)
                .addIngredient(1, Material.POTION, -1)
                .addIngredient(1, Material.WHEAT)
                .addIngredient(new RecipeChoice.MaterialChoice(Material.WHEAT_SEEDS, Material.MELON_SEEDS, Material.PUMPKIN_SEEDS, Material.BEETROOT_SEEDS));
        Bukkit.addRecipe(recipe);
    }
}