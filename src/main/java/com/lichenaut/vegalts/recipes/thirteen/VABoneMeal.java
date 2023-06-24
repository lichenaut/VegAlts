package com.lichenaut.vegalts.recipes.thirteen;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

public class VABoneMeal {

    private final VegAlts plugin;

    public VABoneMeal(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipe() {
        RecipeChoice.MaterialChoice vegCompostables = new RecipeChoice.MaterialChoice(Material.APPLE, Material.BEETROOT, Material.CARROT, Material.COCOA_BEANS, Material.FERN, Material.LARGE_FERN, Material.DANDELION, Material.POPPY, Material.BLUE_ORCHID, Material.ALLIUM, Material.AZURE_BLUET, Material.RED_TULIP, Material.ORANGE_TULIP, Material.WHITE_TULIP, Material.PINK_TULIP, Material.OXEYE_DAISY, Material.BROWN_MUSHROOM, Material.RED_MUSHROOM, Material.LILY_PAD, Material.MELON, Material.MUSHROOM_STEM, Material.NETHER_WART, Material.POTATO, Material.PUMPKIN, Material.CARVED_PUMPKIN, Material.SEA_PICKLE, Material.WHEAT, Material.BAKED_POTATO, Material.BREAD, Material.COOKIE, Material.HAY_BLOCK, Material.RED_MUSHROOM_BLOCK, Material.BROWN_MUSHROOM_BLOCK);

        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(plugin, "veg_bone_meal"), new ItemStack(Material.BONE_MEAL))
                .shape(
                        "CCC",
                        "CCC",
                        "CCC")
                .setIngredient('C', vegCompostables);
        Bukkit.addRecipe(recipe);
    }
}