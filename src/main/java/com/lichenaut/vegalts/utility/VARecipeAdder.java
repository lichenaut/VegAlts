package com.lichenaut.vegalts.utility;

import com.lichenaut.vegalts.VegAlts;
import com.lichenaut.vegalts.recipes.sixteen.VANetherStar16;
import com.lichenaut.vegalts.recipes.thirteen.*;
import com.lichenaut.vegalts.recipes.twenty.VAMilk20;

import java.util.HashSet;

public class VARecipeAdder {

    private final VegAlts plugin;

    public VARecipeAdder(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipes(int version) {
        HashSet<String> addedRecipies = new HashSet<>();
        for (int i = version; i > 0; i--) {
            if (i == 20) {
                if (addedRecipies.add("vegMilk")) {new VAMilk20(plugin).addRecipe();}
            /*} else if (i == 19) {

            } else if (i == 18 || i == 17) {*/

            } else if (i == 16) {
                if (addedRecipies.add("vegNetherStar")) {new VANetherStar16(plugin).addRecipe();}
            //} else if (i == 15) {

            } else if (i == 14 || i == 13) {
                if (addedRecipies.add("vegMilk")) {new VAMilk13(plugin).addRecipe();}
                if (addedRecipies.add("vegNetherStar")) {new VANetherStar13(plugin).addRecipe();}
                new VABone(plugin).addRecipe();
                new VAFeather(plugin).addRecipe();
                new VALeather(plugin).addRecipe();
                new VAScute(plugin).addRecipe();
                new VASlime(plugin).addRecipe();
                new VAString(plugin).addRecipe();
                break;
            }
        }
    }
}
