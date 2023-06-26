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
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

public class VAEgg {

    private final VegAlts plugin;

    public VAEgg(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipe() {
        ItemStack bottle = new ItemStack(Material.POTION);
        ItemMeta meta = bottle.getItemMeta();
        PotionMeta pmeta = (PotionMeta) meta;
        pmeta.setBasePotionData(new PotionData(PotionType.WATER));
        bottle.setItemMeta(meta);

        ItemStack egg = new ItemStack(Material.EGG);
        ItemMeta eggMeta = egg.getItemMeta();
        eggMeta.setCustomModelData(1);
        eggMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        egg.setItemMeta(eggMeta);

        ShapelessRecipe recipe = new ShapelessRecipe(new NamespacedKey(plugin, "veg_egg"), egg)
                .addIngredient(1, bottle)
                .addIngredient(1, Material.WHEAT)
                .addIngredient(new RecipeChoice.MaterialChoice(Material.WHEAT_SEEDS, Material.MELON_SEEDS, Material.PUMPKIN_SEEDS, Material.BEETROOT_SEEDS));
        Bukkit.addRecipe(recipe);
    }
}