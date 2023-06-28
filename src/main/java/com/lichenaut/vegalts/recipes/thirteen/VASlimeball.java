package com.lichenaut.vegalts.recipes.thirteen;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

public class VASlimeball {

    private final VegAlts plugin;

    public VASlimeball(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipe() {
        ItemStack bottle = new ItemStack(Material.POTION);
        ItemMeta meta = bottle.getItemMeta();
        PotionMeta pmeta = (PotionMeta) meta;
        pmeta.setBasePotionData(new PotionData(PotionType.WATER));
        bottle.setItemMeta(meta);

        ShapelessRecipe recipe = new ShapelessRecipe(new NamespacedKey(plugin, "veg_slime_ball"), new ItemStack(Material.SLIME_BALL))
                .addIngredient(1, Material.POTION)
                .addIngredient(Material.WHEAT)
                .addIngredient(Material.SUGAR)
                .addIngredient(Material.CLAY_BALL)
                .addIngredient(Material.LIME_DYE);
        Bukkit.addRecipe(recipe);
    }
}