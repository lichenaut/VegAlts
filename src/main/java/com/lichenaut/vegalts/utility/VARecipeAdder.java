package com.lichenaut.vegalts.utility;

import com.lichenaut.vegalts.VegAlts;
import com.lichenaut.vegalts.listeners.nineteen.VAFishingListener19;
import com.lichenaut.vegalts.listeners.sixteen.VAProjectileListener16;
import com.lichenaut.vegalts.listeners.thirteen.*;
import com.lichenaut.vegalts.recipes.eighteen.VAGoatHorn18;
import com.lichenaut.vegalts.recipes.fifteen.VAHoneyBottle;
import com.lichenaut.vegalts.recipes.fifteen.VAHoneycomb;
import com.lichenaut.vegalts.recipes.fourteen.VALeather14;
import com.lichenaut.vegalts.recipes.nineteen.*;
import com.lichenaut.vegalts.recipes.seventeen.VABlazeRod17;
import com.lichenaut.vegalts.recipes.seventeen.VAGlowInkSac;
import com.lichenaut.vegalts.recipes.seventeen.VAGoatHorn17;
import com.lichenaut.vegalts.recipes.seventeen.VAShulkerShell17;
import com.lichenaut.vegalts.listeners.sixteen.VAFishingListener16;
import com.lichenaut.vegalts.recipes.sixteen.VANetherStar16;
import com.lichenaut.vegalts.recipes.sixteen.VANetherWart16;
import com.lichenaut.vegalts.recipes.thirteen.*;
import com.lichenaut.vegalts.listeners.twenty.VABrushListener;
import com.lichenaut.vegalts.listeners.twenty.VAFishingListener20;
import com.lichenaut.vegalts.recipes.twenty.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

import java.util.HashSet;

public class VARecipeAdder {

    private final VegAlts plugin;
    private int fishingTries = 0;//prevent infinite fishing result re-rolls

    public VARecipeAdder(VegAlts plugin) {this.plugin = plugin;}

    public int getTries() {return fishingTries;}
    public void addTries() {fishingTries++;}
    public void resetTries() {fishingTries = 0;}

    public void addRecipes(int version) {
        PluginManager pMan = Bukkit.getPluginManager();
        HashSet<String> addedRecipies = new HashSet<>();//tracks the most up-to-date recipes, depending on version
        for (int i = version; i > 0; i--) {
            if (i == 20) {
                if (plugin.getPluginConfig().getBoolean("beef")) if (addedRecipies.add("vegBeef")) new VABeef20(plugin).addRecipe();
                pMan.registerEvents(new VABrushListener(plugin), plugin);
                if (plugin.getPluginConfig().getBoolean("chicken")) if (addedRecipies.add("vegChicken")) new VAChicken20(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("cod")) if (addedRecipies.add("vegCod")) new VACod20(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("egg")) if (addedRecipies.add("vegEgg")) new VAEgg20(plugin).addRecipe();
                if (addedRecipies.add("vegFishing")) pMan.registerEvents(new VAFishingListener20(plugin, this), plugin);
                if (plugin.getPluginConfig().getBoolean("milk")) if (addedRecipies.add("vegMilk")) new VAMilk20(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("mutton")) if (addedRecipies.add("vegMutton")) new VAMutton20(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("piglin-head")) new VAPiglinHead(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("porkchop")) if (addedRecipies.add("vegPorkchop")) new VAPorkchop20(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("pufferfish")) if (addedRecipies.add("vegPufferfish")) new VAPufferfish20(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("rabbit")) if (addedRecipies.add("vegRabbit")) new VARabbit20(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("salmon")) if (addedRecipies.add("vegSalmon")) new VASalmon20(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("tropical-fish")) if (addedRecipies.add("vegTropicalFish")) new VATropicalFish20(plugin).addRecipe();
            } else if (i == 19) {
                if (addedRecipies.add("vegFishing")) pMan.registerEvents(new VAFishingListener19(plugin, this), plugin);
                if (plugin.getPluginConfig().getBoolean("ochre-froglight")) new VAFroglightOchre(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("pearlescent-froglight"))  new VAFroglightPearlescent(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("verdant-froglight")) new VAFroglightVerdant(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("goat-horn")) if (addedRecipies.add("vegGoatHorn")) new VAGoatHorn19(plugin).addRecipe();
            } else if (i == 18) {
                if (plugin.getPluginConfig().getBoolean("goat-horn")) if (addedRecipies.add("vegGoatHorn")) new VAGoatHorn18(plugin).addRecipe();
            } else if (i == 17) {
                if (plugin.getPluginConfig().getBoolean("blaze-rod")) if (addedRecipies.add("vegBlazeRod")) new VABlazeRod17(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("glow-ink-sac")) new VAGlowInkSac(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("goat-horn")) if (addedRecipies.add("vegGoatHorn")) new VAGoatHorn17(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("shulker-shell")) if (addedRecipies.add("vegShulkerShell")) new VAShulkerShell17(plugin).addRecipe();
            } else if (i == 16) {
                if (addedRecipies.add("vegFishing")) pMan.registerEvents(new VAFishingListener16(plugin, this), plugin);
                if (plugin.getPluginConfig().getBoolean("nether-star")) if (addedRecipies.add("vegNetherStar")) new VANetherStar16(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("nether-wart")) if (addedRecipies.add("vegNetherWart")) new VANetherWart16(plugin).addRecipe();
                pMan.registerEvents(new VAProjectileListener16(), plugin);
            } else if (i == 15) {
                if (plugin.getPluginConfig().getBoolean("honey-bottle")) new VAHoneyBottle(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("honeycomb")) new VAHoneycomb(plugin).addRecipe();
            } else if (i == 14) {
                if (plugin.getPluginConfig().getBoolean("leather")) if (addedRecipies.add("vegLeather")) new VALeather14(plugin).addRecipe();
            } else if (i == 13) {
                if (plugin.getPluginConfig().getBoolean("beef")) if (addedRecipies.add("vegBeef")) new VABeef13(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("blaze-rod")) if (addedRecipies.add("vegBlazeRod")) new VABlazeRod13(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("bone")) new VABone(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("bone-meal")) if (version == 13) new VABoneMeal(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("chicken")) if (addedRecipies.add("vegChicken")) new VAChicken13(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("cod")) if (addedRecipies.add("vegCod")) new VACod13(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("creeper-head")) new VACreeperHead(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("dragons-breath")) new VADragonsBreath(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("egg")) if (addedRecipies.add("vegEgg")) new VAEgg13(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("ender-pearl")) new VAEnderPearl(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("feather")) new VAFeather(plugin).addRecipe();
                if (addedRecipies.add("vegFishing")) pMan.registerEvents(new VAFishingListener13(plugin, this), plugin);
                if (plugin.getPluginConfig().getBoolean("ghast-tear")) new VAGhastTear(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("gunpowder")) new VAGunpowder(plugin).addRecipe();
                pMan.registerEvents(new VAInfestedBlockListener(plugin), plugin);
                if (plugin.getPluginConfig().getBoolean("ink-sac")) new VAInkSac(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("leather")) if (addedRecipies.add("vegLeather")) new VALeather13(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("milk")) if (addedRecipies.add("vegMilk")) new VAMilk13(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("mutton")) if (addedRecipies.add("vegMutton")) new VAMutton13(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("nautilus-shell")) new VANautilusShell(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("nether-star")) if (addedRecipies.add("vegNetherStar")) new VANetherStar13(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("nether-wart")) if (addedRecipies.add("vegNetherWart")) new VANetherWart13(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("phantom-membrane")) new VAPhantomMembrane(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("player-head")) new VAPlayerHead(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("porkchop")) if (addedRecipies.add("vegPorkchop")) new VAPorkchop13(plugin).addRecipe();
                pMan.registerEvents(new VAProjectileListener13(plugin), plugin);
                if (plugin.getPluginConfig().getBoolean("pufferfish")) if (addedRecipies.add("vegPufferfish")) new VAPufferfish13(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("rabbit")) if (addedRecipies.add("vegRabbit")) new VARabbit13(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("rabbit-hide")) new VARabbitHide(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("rabbits-foot")) new VARabbitsFoot(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("rotten-flesh")) new VARottenFlesh(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("salmon")) if (addedRecipies.add("vegSalmon")) new VASalmon13(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("scute")) new VAScute(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("shulker-shell")) if (addedRecipies.add("vegShulkerShell")) new VAShulkerShell13(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("skeleton-skull")) new VASkeletonSkull(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("slimeball")) new VASlimeball(plugin).addRecipe();
                pMan.registerEvents(new VASpecialCraftListener(plugin), plugin);
                if (plugin.getPluginConfig().getBoolean("spider-eye")) new VASpiderEye(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("string")) new VAString(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("tropical-fish")) if (addedRecipies.add("vegTropicalFish")) new VATropicalFish13(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("zombie-head")) new VAZombieHead(plugin).addRecipe();
                break;
            }
        }
    }
}
