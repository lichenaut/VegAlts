package com.lichenaut.vegalts.recipes.thirteen;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class VADragonsBreath {

    private final VegAlts plugin;

    public VADragonsBreath(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipe() {
        ShapedRecipe recipe1 = new ShapedRecipe(new NamespacedKey(plugin, "veg_dragons_breath_1"), new ItemStack(Material.DRAGON_BREATH).add(2))
                .shape(
                        "BBB",
                        "CEC",
                        "CCC")
                .setIngredient('E', Material.END_CRYSTAL)
                .setIngredient('B', Material.GLASS_BOTTLE)
                .setIngredient('C', Material.CHORUS_FRUIT);
        Bukkit.addRecipe(recipe1);
        ShapedRecipe recipe2 = new ShapedRecipe(new NamespacedKey(plugin, "veg_dragons_breath_2"), new ItemStack(Material.DRAGON_BREATH).add(2))
                .shape(
                        "CCC",
                        "CEC",
                        "BBB")
                .setIngredient('E', Material.END_CRYSTAL)
                .setIngredient('B', Material.GLASS_BOTTLE)
                .setIngredient('C', Material.CHORUS_FRUIT);
        Bukkit.addRecipe(recipe2);
    }
}
