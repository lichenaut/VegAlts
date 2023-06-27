package com.lichenaut.vegalts.utility;

import com.lichenaut.vegalts.VegAlts;
import com.lichenaut.vegalts.listeners.nineteen.VAFishingListener19;
import com.lichenaut.vegalts.listeners.thirteen.*;
import com.lichenaut.vegalts.recipes.eighteen.VAGoatHorn18;
import com.lichenaut.vegalts.recipes.fifteen.VAHoneyBottle;
import com.lichenaut.vegalts.recipes.fifteen.VAHoneycomb;
import com.lichenaut.vegalts.recipes.nineteen.*;
import com.lichenaut.vegalts.recipes.seventeen.VABlazeRod17;
import com.lichenaut.vegalts.recipes.seventeen.VAGlowInkSac;
import com.lichenaut.vegalts.recipes.seventeen.VAGoatHorn17;
import com.lichenaut.vegalts.recipes.seventeen.VAShulkerShell17;
import com.lichenaut.vegalts.listeners.sixteen.VAFishingListener16;
import com.lichenaut.vegalts.recipes.sixteen.VANetherStar16;
import com.lichenaut.vegalts.recipes.thirteen.*;
import com.lichenaut.vegalts.listeners.twenty.VABrushListener;
import com.lichenaut.vegalts.listeners.twenty.VAFishingListener20;
import com.lichenaut.vegalts.recipes.twenty.VAPiglinHead;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

import java.util.HashSet;

public class VARecipeAdder {

    private final VegAlts plugin;

    public VARecipeAdder(VegAlts plugin) {this.plugin = plugin;}

    public void addRecipes(int version) {
        PluginManager pMan = Bukkit.getPluginManager();
        HashSet<String> addedRecipies = new HashSet<>();//tracks the most up-to-date recipes, depending on version
        for (int i = version; i > 0; i--) {
            if (i == 20) {
                pMan.registerEvents(new VABrushListener(plugin), plugin);
                if (addedRecipies.add("vegFishing")) pMan.registerEvents(new VAFishingListener20(plugin), plugin);
                if (plugin.getPluginConfig().getBoolean("piglin-head")) new VAPiglinHead(plugin).addRecipe();
            } else if (i == 19) {
                if (addedRecipies.add("vegFishing")) pMan.registerEvents(new VAFishingListener19(plugin), plugin);
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
                if (addedRecipies.add("vegFishing")) pMan.registerEvents(new VAFishingListener16(plugin), plugin);
                if (plugin.getPluginConfig().getBoolean("nether-star")) if (addedRecipies.add("vegNetherStar")) new VANetherStar16(plugin).addRecipe();
            } else if (i == 15) {
                if (plugin.getPluginConfig().getBoolean("honey-bottle")) new VAHoneyBottle(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("honeycomb")) new VAHoneycomb(plugin).addRecipe();
            } else if (i == 14 || i == 13) {
                if (plugin.getPluginConfig().getBoolean("beef")) new VABeef(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("blaze-rod")) if (addedRecipies.add("vegBlazeRod")) new VABlazeRod13(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("bone")) new VABone(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("bone-meal")) if (version == 13) new VABoneMeal(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("chicken")) new VAChicken(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("cod")) new VACod(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("creeper-head")) new VACreeperHead(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("dragons-breath")) new VADragonsBreath(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("egg")) new VAEgg(plugin).addRecipe();
                pMan.registerEvents(new VAEggThrowListener(), plugin);
                if (plugin.getPluginConfig().getBoolean("ender-pearl")) new VAEnderPearl(plugin).addRecipe();
                pMan.registerEvents(new VAEnderPearlListener(plugin), plugin);
                if (plugin.getPluginConfig().getBoolean("feather")) new VAFeather(plugin).addRecipe();
                if (addedRecipies.add("vegFishing")) pMan.registerEvents(new VAFishingListener13(plugin), plugin);
                if (plugin.getPluginConfig().getBoolean("ghast-tear")) new VAGhastTear(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("gunpowder")) new VAGunpowder(plugin).addRecipe();
                pMan.registerEvents(new VAInfestedBlockListener(plugin), plugin);
                if (plugin.getPluginConfig().getBoolean("ink-sac")) new VAInkSac(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("leather")) new VALeather(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("milk")) new VAMilk(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("mutton")) new VAMutton(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("nautilus-shell")) new VANautilusShell(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("nether-star")) if (addedRecipies.add("vegNetherStar")) new VANetherStar13(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("nether-wart")) new VANetherWart(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("phantom-membrane")) new VAPhantomMembrane(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("player-head")) new VAPlayerHead(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("porkchop")) new VAPorkchop(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("pufferfish")) new VAPufferfish(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("rabbit")) new VARabbit(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("rabbit-hide")) new VARabbitHide(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("rabbits-foot")) new VARabbitsFoot(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("salmon")) new VASalmon(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("scute")) new VAScute(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("shulker-shell")) if (addedRecipies.add("vegShulkerShell")) new VAShulkerShell13(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("skeleton-skull")) new VASkeletonSkull(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("slimeball")) new VASlimeball(plugin).addRecipe();
                pMan.registerEvents(new VASpecialCraftListener(plugin), plugin);
                if (plugin.getPluginConfig().getBoolean("spider-eye")) new VASpiderEye(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("string")) new VAString(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("tropical-fish")) new VATropicalFish(plugin).addRecipe();
                if (plugin.getPluginConfig().getBoolean("zombie-head")) new VAZombieHead(plugin).addRecipe();
                break;
            }
        }
    }
}
