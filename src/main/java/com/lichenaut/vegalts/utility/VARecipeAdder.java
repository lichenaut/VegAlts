package com.lichenaut.vegalts.utility;

import com.lichenaut.vegalts.VegAlts;
import com.lichenaut.vegalts.recipes.twenty.VAMilk20;
import com.lichenaut.vegalts.recipes.thirteen.VAMilk13;
import org.bukkit.Material;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashSet;

public class VARecipeAdder {

    private final VegAlts plugin;

    public VARecipeAdder(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipes(int version) {
        HashSet<String> addedRecipies = new HashSet<String>();
        for (int i = version; i > 0; i--) {
            if (version == 20) {
                if (addedRecipies.add("vegMilk")) {
                    new VAMilk20(plugin).addRecipe();
                }
            /*} else if (version == 19) {

            } else if (version == 18 || version == 17) {

            } else if (version == 16) {

            } else if (version == 15) {*/

            } else if (version == 14 || version == 13) {
                if (addedRecipies.add("vegMilk")) {
                    new VAMilk13(plugin).addRecipe();
                }
            }
        }
    }
}
