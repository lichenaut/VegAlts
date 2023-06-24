package com.lichenaut.vegalts.utility;

import com.lichenaut.vegalts.VegAlts;
import com.lichenaut.vegalts.recipes.fifteen.VAHoneyBottle;
import com.lichenaut.vegalts.recipes.fifteen.VAHoneycomb;
import com.lichenaut.vegalts.recipes.sixteen.VANetherStar16;
import com.lichenaut.vegalts.recipes.thirteen.*;

import java.util.HashSet;

public class VARecipeAdder {

    private final VegAlts plugin;

    public VARecipeAdder(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipes(int version) {
        HashSet<String> addedRecipies = new HashSet<>();
        for (int i = version; i > 0; i--) {
            if (i == 20) {

            /*} else if (i == 19) {

            } else if (i == 18 || i == 17) {*/

            } else if (i == 16) {
                if (addedRecipies.add("vegNetherStar")) {new VANetherStar16(plugin).addRecipe();}
            } else if (i == 15) {
                new VAHoneyBottle(plugin).addRecipe();
                new VAHoneycomb(plugin).addRecipe();
            } else if (i == 14 || i == 13) {
                if (addedRecipies.add("vegNetherStar")) {new VANetherStar13(plugin).addRecipe();}
                new VABeef(plugin).addRecipe();
                new VABone(plugin).addRecipe();
                if (version == 13) {new VABoneMeal(plugin).addRecipe();}
                new VAChicken(plugin).addRecipe();
                new VACod(plugin).addRecipe();
                new VAEgg(plugin).addRecipe();
                new VAFeather(plugin).addRecipe();
                new VALeather(plugin).addRecipe();
                new VAMilk(plugin).addRecipe();
                new VAMutton(plugin).addRecipe();
                new VAPorkchop(plugin).addRecipe();
                new VAPufferfish(plugin).addRecipe();
                new VARabbit(plugin).addRecipe();
                new VARabbitHide(plugin).addRecipe();
                new VARabbitsFoot(plugin).addRecipe();
                new VASalmon(plugin).addRecipe();
                new VAScute(plugin).addRecipe();
                new VASlime(plugin).addRecipe();
                new VASpiderEye(plugin).addRecipe();
                new VAString(plugin).addRecipe();
                new VATropicalFish(plugin).addRecipe();
                break;
            }
        }
    }
}
