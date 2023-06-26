package com.lichenaut.vegalts.utility;

import com.lichenaut.vegalts.VegAlts;
import com.lichenaut.vegalts.recipes.eighteen.VAGoatHorn18;
import com.lichenaut.vegalts.recipes.fifteen.VAHoneyBottle;
import com.lichenaut.vegalts.recipes.fifteen.VAHoneycomb;
import com.lichenaut.vegalts.recipes.nineteen.*;
import com.lichenaut.vegalts.recipes.seventeen.VABlazeRod17;
import com.lichenaut.vegalts.recipes.seventeen.VAGlowInkSac;
import com.lichenaut.vegalts.recipes.seventeen.VAGoatHorn17;
import com.lichenaut.vegalts.recipes.seventeen.VAShulkerShell17;
import com.lichenaut.vegalts.recipes.sixteen.VAFishingListener16;
import com.lichenaut.vegalts.recipes.sixteen.VANetherStar16;
import com.lichenaut.vegalts.recipes.thirteen.*;
import com.lichenaut.vegalts.recipes.twenty.VABrushListener;
import com.lichenaut.vegalts.recipes.twenty.VAFishingListener20;
import com.lichenaut.vegalts.recipes.twenty.VAPiglinHead;
import org.bukkit.Bukkit;

import java.util.HashSet;

public class VARecipeAdder {

    private final VegAlts plugin;

    public VARecipeAdder(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipes(int version) {
        HashSet<String> addedRecipies = new HashSet<>();//tracks the most up-to-date recipes, depending on version
        for (int i = version; i > 0; i--) {
            if (i == 20) {
                Bukkit.getPluginManager().registerEvents(new VABrushListener(), plugin);
                if (addedRecipies.add("vegFishing")) Bukkit.getPluginManager().registerEvents(new VAFishingListener20(), plugin);
                new VAPiglinHead(plugin).addRecipe();
            } else if (i == 19) {
                if (addedRecipies.add("vegFishing")) Bukkit.getPluginManager().registerEvents(new VAFishingListener19(), plugin);
                new VAFroglightOchre(plugin).addRecipe();
                new VAFroglightPearlescent(plugin).addRecipe();
                new VAFroglightVerdant(plugin).addRecipe();
                if (addedRecipies.add("vegGoatHorn")) new VAGoatHorn19(plugin).addRecipe();
            } else if (i == 18) {
                if (addedRecipies.add("vegGoatHorn")) new VAGoatHorn18(plugin).addRecipe();
            } else if (i == 17) {
                if (addedRecipies.add("vegBlazeRod")) new VABlazeRod17(plugin).addRecipe();
                new VAGlowInkSac(plugin).addRecipe();
                if (addedRecipies.add("vegGoatHorn")) new VAGoatHorn17(plugin).addRecipe();
                if (addedRecipies.add("vegShulkerShell")) new VAShulkerShell17(plugin).addRecipe();
            } else if (i == 16) {
                if (addedRecipies.add("vegFishing")) Bukkit.getPluginManager().registerEvents(new VAFishingListener16(), plugin);
                if (addedRecipies.add("vegNetherStar")) new VANetherStar16(plugin).addRecipe();
            } else if (i == 15) {
                new VAHoneyBottle(plugin).addRecipe();
                new VAHoneycomb(plugin).addRecipe();
            } else if (i == 14 || i == 13) {
                new VABeef(plugin).addRecipe();
                if (addedRecipies.add("vegBlazeRod")) new VABlazeRod13(plugin).addRecipe();
                new VABone(plugin).addRecipe();
                if (version == 13) new VABoneMeal(plugin).addRecipe();//composter added in 1.14
                new VAChicken(plugin).addRecipe();
                new VACod(plugin).addRecipe();
                new VACreeperHead(plugin).addRecipe();
                new VADragonsBreath(plugin).addRecipe();
                new VAEgg(plugin).addRecipe();
                Bukkit.getPluginManager().registerEvents(new VAVegEggThrowListener(), plugin);
                new VAEnderPearl(plugin).addRecipe();
                new VAFeather(plugin).addRecipe();
                if (addedRecipies.add("vegFishing")) Bukkit.getPluginManager().registerEvents(new VAFishingListener13(), plugin);
                new VAGhastTear(plugin).addRecipe();
                new VAGunpowder(plugin).addRecipe();
                new VAInkSac(plugin).addRecipe();
                new VALeather(plugin).addRecipe();
                new VAMilk(plugin).addRecipe();
                new VAMutton(plugin).addRecipe();
                new VANautilusShell(plugin).addRecipe();
                if (addedRecipies.add("vegNetherStar")) new VANetherStar13(plugin).addRecipe();
                new VAPhantomMembrane(plugin).addRecipe();
                new VAPlayerHead(plugin).addRecipe();
                new VAPorkchop(plugin).addRecipe();
                new VAPufferfish(plugin).addRecipe();
                new VARabbit(plugin).addRecipe();
                new VARabbitHide(plugin).addRecipe();
                new VARabbitsFoot(plugin).addRecipe();
                new VASalmon(plugin).addRecipe();
                new VAScute(plugin).addRecipe();
                if (addedRecipies.add("vegShulkerShell")) new VAShulkerShell13(plugin).addRecipe();
                new VASkeletonSkull(plugin).addRecipe();
                new VASlime(plugin).addRecipe();
                new VASpiderEye(plugin).addRecipe();
                new VAString(plugin).addRecipe();
                new VATropicalFish(plugin).addRecipe();
                new VAZombieHead(plugin).addRecipe();
                break;
            }
        }
    }
}
