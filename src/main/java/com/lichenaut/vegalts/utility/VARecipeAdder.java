package com.lichenaut.vegalts.utility;

import com.lichenaut.vegalts.VegAlts;
import com.lichenaut.vegalts.recipes.fifteen.VAHoneyBottle;
import com.lichenaut.vegalts.recipes.fifteen.VAHoneycomb;
import com.lichenaut.vegalts.recipes.seventeen.VABlazeRod17;
import com.lichenaut.vegalts.recipes.seventeen.VAGlowInkSac;
import com.lichenaut.vegalts.recipes.seventeen.VAShulkerShell17;
import com.lichenaut.vegalts.recipes.sixteen.VANetherStar16;
import com.lichenaut.vegalts.recipes.thirteen.*;

import java.util.HashSet;

public class VARecipeAdder {

    private final VegAlts plugin;

    public VARecipeAdder(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipes(int version) {
        HashSet<String> addedRecipies = new HashSet<>();//tracks the most up-to-date recipes, depending on version
        for (int i = version; i > 0; i--) {
            if (i == 20) {

            /*} else if (i == 19) {*/

            } else if (i == 18 || i == 17) {
                if (addedRecipies.add("vegBlazeRod")) new VABlazeRod17(plugin).addRecipe();
                new VAGlowInkSac(plugin).addRecipe();
                if (addedRecipies.add("vegShulkerShell")) new VAShulkerShell17(plugin).addRecipe();
            } else if (i == 16) {
                if (addedRecipies.add("vegNetherStar")) new VANetherStar16(plugin).addRecipe();
            } else if (i == 15) {
                new VAHoneyBottle(plugin).addRecipe();
                new VAHoneycomb(plugin).addRecipe();
            } else if (i == 14 || i == 13) {
                if (addedRecipies.add("vegNetherStar")) new VANetherStar13(plugin).addRecipe();
                new VABeef(plugin).addRecipe();
                if (addedRecipies.add("vegBlazeRod")) new VABlazeRod13(plugin).addRecipe();
                new VABone(plugin).addRecipe();
                if (version == 13) new VABoneMeal(plugin).addRecipe();//composter added in 1.14
                new VAChicken(plugin).addRecipe();
                new VACod(plugin).addRecipe();
                new VAEgg(plugin).addRecipe();
                new VAEnderPearl(plugin).addRecipe();
                new VAFeather(plugin).addRecipe();
                new VAGhastTear(plugin).addRecipe();
                new VAGunpowder(plugin).addRecipe();
                new VAInkSac(plugin).addRecipe();
                new VALeather(plugin).addRecipe();
                new VAMilk(plugin).addRecipe();
                new VAMutton(plugin).addRecipe();
                new VANautilusShell(plugin).addRecipe();
                new VAPorkchop(plugin).addRecipe();
                new VAPufferfish(plugin).addRecipe();
                new VARabbit(plugin).addRecipe();
                new VARabbitHide(plugin).addRecipe();
                new VARabbitsFoot(plugin).addRecipe();
                new VASalmon(plugin).addRecipe();
                new VAScute(plugin).addRecipe();
                if (addedRecipies.add("vegShulkerShell")) new VAShulkerShell13(plugin).addRecipe();
                new VASlime(plugin).addRecipe();
                new VASpiderEye(plugin).addRecipe();
                new VAString(plugin).addRecipe();
                new VATropicalFish(plugin).addRecipe();
                break;
            }
        }
    }
}
