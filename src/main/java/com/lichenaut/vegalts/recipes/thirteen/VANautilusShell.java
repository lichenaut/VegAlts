package com.lichenaut.vegalts.recipes.thirteen;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class VANautilusShell {

    private final VegAlts plugin;

    public VANautilusShell(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipe() {
        ShapedRecipe recipe1 = new ShapedRecipe(new NamespacedKey(plugin, "veg_nautilus_shell_1"), new ItemStack(Material.NAUTILUS_SHELL))
                .shape(
                        "KKK",
                        "KIS",
                        "SSS")
                .setIngredient('K', Material.KELP)
                .setIngredient('B', Material.SCUTE)
                .setIngredient('I', Material.INK_SAC);
        Bukkit.addRecipe(recipe1);
        ShapedRecipe recipe2 = new ShapedRecipe(new NamespacedKey(plugin, "veg_nautilus_shell_2"), new ItemStack(Material.NAUTILUS_SHELL))
                .shape(
                        "KKK",
                        "SIK",
                        "SSS")
                .setIngredient('K', Material.KELP)
                .setIngredient('B', Material.SCUTE)
                .setIngredient('I', Material.INK_SAC);
        Bukkit.addRecipe(recipe2);
        ShapedRecipe recipe3 = new ShapedRecipe(new NamespacedKey(plugin, "veg_nautilus_shell_3"), new ItemStack(Material.NAUTILUS_SHELL))
                .shape(
                        "SSS",
                        "SIK",
                        "KKK")
                .setIngredient('K', Material.KELP)
                .setIngredient('B', Material.SCUTE)
                .setIngredient('I', Material.INK_SAC);
        Bukkit.addRecipe(recipe3);
        ShapedRecipe recipe4 = new ShapedRecipe(new NamespacedKey(plugin, "veg_nautilus_shell_4"), new ItemStack(Material.NAUTILUS_SHELL))
                .shape(
                        "SSS",
                        "KIS",
                        "KKK")
                .setIngredient('K', Material.KELP)
                .setIngredient('B', Material.SCUTE)
                .setIngredient('I', Material.INK_SAC);
        Bukkit.addRecipe(recipe4);
    }
}
