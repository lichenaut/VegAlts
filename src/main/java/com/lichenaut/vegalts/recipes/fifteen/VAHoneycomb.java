package com.lichenaut.vegalts.recipes.fifteen;

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

public class VAHoneycomb {

    private final VegAlts plugin;

    public VAHoneycomb(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipe() {
        ItemStack bottle = new ItemStack(Material.POTION);
        ItemMeta meta = bottle.getItemMeta();
        PotionMeta pmeta = (PotionMeta) meta;
        PotionData pdata = new PotionData(PotionType.WATER);
        pmeta.setBasePotionData(pdata);
        bottle.setItemMeta(meta);

        ShapelessRecipe recipe = new ShapelessRecipe(new NamespacedKey(plugin, "veg_honeycomb"), new ItemStack(Material.HONEYCOMB))
                .addIngredient(1, bottle)
                .addIngredient(1, Material.SUGAR)
                .addIngredient(1, Material.PAPER)
                .addIngredient(1, Material.YELLOW_DYE);
        Bukkit.addRecipe(recipe);
    }
}