package com.lichenaut.vegalts.recipes.thirteen;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.tags.ItemTagType;

public class VAEnderPearl {

    private final VegAlts plugin;

    public VAEnderPearl(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipe() {
        ItemStack pearl = new ItemStack(Material.ENDER_PEARL);
        ItemMeta pearlMeta = pearl.getItemMeta();
        NamespacedKey key = new NamespacedKey(plugin, "veg");
        pearlMeta.getCustomTagContainer().setCustomTag(key, ItemTagType.STRING, "veg");
        pearl.setItemMeta(pearlMeta);

        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(plugin, "veg_ender_pearl"), pearl)
                .shape(
                        "CSC",
                        "SES",
                        "CSC")
                .setIngredient('C', Material.CYAN_DYE)
                .setIngredient('S', Material.SLIME_BALL)
                .setIngredient('E', Material.SPIDER_EYE);
        Bukkit.addRecipe(recipe);
    }
}
