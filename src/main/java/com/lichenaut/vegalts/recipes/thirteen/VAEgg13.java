package com.lichenaut.vegalts.recipes.thirteen;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.tags.ItemTagType;

public class VAEgg13 {

    private final VegAlts plugin;

    public VAEgg13(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipe() {
        ItemStack egg = new ItemStack(Material.EGG);
        ItemMeta eggMeta = egg.getItemMeta();
        NamespacedKey key = new NamespacedKey(plugin, "veg");
        eggMeta.getCustomTagContainer().setCustomTag(key, ItemTagType.STRING, "veg");
        egg.setItemMeta(eggMeta);

        ShapelessRecipe recipe = new ShapelessRecipe(new NamespacedKey(plugin, "veg_egg"), egg)
                .addIngredient(1, Material.POTION)
                .addIngredient(1, Material.WHEAT)
                .addIngredient(new RecipeChoice.MaterialChoice(Material.WHEAT_SEEDS, Material.MELON_SEEDS, Material.PUMPKIN_SEEDS, Material.BEETROOT_SEEDS));
        Bukkit.addRecipe(recipe);
    }
}