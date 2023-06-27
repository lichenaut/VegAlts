package com.lichenaut.vegalts.recipes.eighteen;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

public class VAGoatHorn18 {

    private final VegAlts plugin;

    public VAGoatHorn18(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipe() {
        RecipeChoice.MaterialChoice discs = new RecipeChoice.MaterialChoice(Material.MUSIC_DISC_CAT, Material.MUSIC_DISC_13, Material.MUSIC_DISC_11, Material.MUSIC_DISC_FAR, Material.MUSIC_DISC_CHIRP, Material.MUSIC_DISC_BLOCKS, Material.MUSIC_DISC_MALL, Material.MUSIC_DISC_STAL, Material.MUSIC_DISC_MELLOHI, Material.getMaterial("MUSIC_DISC_OTHERSIDE"), Material.getMaterial("MUSIC_DISC_PIGSTEP"), Material.MUSIC_DISC_WAIT, Material.MUSIC_DISC_STRAD, Material.MUSIC_DISC_WARD);

        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(plugin, "veg_goat_horn"), new ItemStack(Material.getMaterial("GOAT_HORN"), 4))
                .shape(
                        "SMD",
                        " P ")
                .setIngredient('S', Material.SLIME_BALL)
                .setIngredient('M', discs)
                .setIngredient('D', Material.getMaterial("BLACK_DYE"))
                .setIngredient('P', Material.getMaterial("POINTED_DRIPSTONE"));
        Bukkit.addRecipe(recipe);
        ShapedRecipe recipe2 = new ShapedRecipe(new NamespacedKey(plugin, "veg_goat_horn_screaming"), new ItemStack(Material.getMaterial("GOAT_HORN"), 4))
                .shape(
                        " G ",
                        "SMD",
                        " P ")
                .setIngredient('G', Material.GUNPOWDER)
                .setIngredient('S', Material.SLIME_BALL)
                .setIngredient('M', discs)
                .setIngredient('D', Material.getMaterial("BLACK_DYE"))
                .setIngredient('P', Material.getMaterial("POINTED_DRIPSTONE"));
        Bukkit.addRecipe(recipe2);
        ShapedRecipe recipe3 = new ShapedRecipe(new NamespacedKey(plugin, "veg_goat_horn_2"), new ItemStack(Material.getMaterial("GOAT_HORN"), 4))
                .shape(
                        "DMS",
                        " P ")
                .setIngredient('S', Material.SLIME_BALL)
                .setIngredient('M', discs)
                .setIngredient('D', Material.getMaterial("BLACK_DYE"))
                .setIngredient('P', Material.getMaterial("POINTED_DRIPSTONE"));
        Bukkit.addRecipe(recipe3);
        ShapedRecipe recipe4 = new ShapedRecipe(new NamespacedKey(plugin, "veg_goat_horn_screaming_2"), new ItemStack(Material.getMaterial("GOAT_HORN"), 4))
                .shape(
                        " G ",
                        "DMS",
                        " P ")
                .setIngredient('G', Material.GUNPOWDER)
                .setIngredient('S', Material.SLIME_BALL)
                .setIngredient('M', discs)
                .setIngredient('D', Material.getMaterial("BLACK_DYE"))
                .setIngredient('P', Material.getMaterial("POINTED_DRIPSTONE"));
        Bukkit.addRecipe(recipe4);
    }
}