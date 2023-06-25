package com.lichenaut.vegalts.recipes.thirteen;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class VAZombieHead {

    private final VegAlts plugin;

    public VAZombieHead(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipe() {
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(plugin, "veg_zombie_head"), new ItemStack(Material.ZOMBIE_HEAD))
                .shape(
                        "DFD",
                        "FSF",
                        "DFD")
                .setIngredient('S', Material.SKELETON_SKULL)
                .setIngredient('F', Material.ROTTEN_FLESH)
                .setIngredient('D', Material.GREEN_DYE);
        Bukkit.addRecipe(recipe);
    }
}