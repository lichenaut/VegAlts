package com.lichenaut.vegalts.recipes.thirteen;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class VABone {

    private final VegAlts plugin;

    public VABone(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipe() {
        ShapedRecipe recipeVert = new ShapedRecipe(new NamespacedKey(plugin, "bonemeal_line_vertical"), new ItemStack(Material.BONE))
                .shape(
                        "B",
                        "B",
                        "B")
                .setIngredient('B', Material.BONE_MEAL);
        Bukkit.addRecipe(recipeVert);
        ShapedRecipe recipeHorz = new ShapedRecipe(new NamespacedKey(plugin, "bonemeal_line_horizontal"), new ItemStack(Material.BONE))
                .shape("BBB")
                .setIngredient('B', Material.BONE_MEAL);
        Bukkit.addRecipe(recipeHorz);
        ShapedRecipe recipeDiag1 = new ShapedRecipe(new NamespacedKey(plugin, "bonemeal_line_diagonal_1"), new ItemStack(Material.BONE))
                .shape(
                        "B  ",
                        " B ",
                        "  B")
                .setIngredient('B', Material.BONE_MEAL);
        Bukkit.addRecipe(recipeDiag1);
        ShapedRecipe recipeDiag2 = new ShapedRecipe(new NamespacedKey(plugin, "bonemeal_line_diagonal_2"), new ItemStack(Material.BONE))
                .shape(
                        "  B",
                        " B ",
                        "B  ")
                .setIngredient('B', Material.BONE_MEAL);
        Bukkit.addRecipe(recipeDiag2);
    }
}