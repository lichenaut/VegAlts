package com.lichenaut.vegalts.listeners.thirteen;

import com.lichenaut.vegalts.VegAlts;
import com.lichenaut.vegalts.utility.VAFishingReference;
import com.lichenaut.vegalts.utility.VARecipeAdder;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

import java.util.Random;

public class VAFishingListener13 implements Listener {

    private final VegAlts plugin;
    private final VARecipeAdder adder;

    public VAFishingListener13(VegAlts plugin, VARecipeAdder adder) {this.plugin = plugin;this.adder = adder;}

    private Material getCoral() {
        Random rand = new Random();
        int n = rand.nextInt(15);
        if (n == 0) {return Material.DEAD_BRAIN_CORAL;
        } else if (n == 1) {return Material.DEAD_BUBBLE_CORAL;
        } else if (n == 2) {return Material.DEAD_FIRE_CORAL;
        } else if (n == 3) {return Material.DEAD_HORN_CORAL;
        } else if (n == 4) {return Material.DEAD_TUBE_CORAL;
        } else if (n == 5) {return Material.DEAD_BRAIN_CORAL_FAN;
        } else if (n == 6) {return Material.DEAD_BRAIN_CORAL_WALL_FAN;
        } else if (n == 7) {return Material.DEAD_BUBBLE_CORAL_FAN;
        } else if (n == 8) {return Material.DEAD_BUBBLE_CORAL_WALL_FAN;
        } else if (n == 9) {return Material.DEAD_FIRE_CORAL_FAN;
        } else if (n == 10) {return Material.DEAD_FIRE_CORAL_WALL_FAN;
        } else if (n == 11) {return Material.DEAD_HORN_CORAL_FAN;
        } else if (n == 12) {return Material.DEAD_HORN_CORAL_WALL_FAN;
        } else if (n == 13) {return Material.DEAD_TUBE_CORAL_FAN;
        } else {return Material.DEAD_TUBE_CORAL_WALL_FAN;}
    }

    private Material getDisc() {//excludes pigstep, otherside, 5, relic, cat, and 13 (replacement for creeper-skeleton drop)
        Random rand = new Random();
        int n = rand.nextInt(10);
        if (n == 0) {return Material.MUSIC_DISC_11;
        } else if (n == 1) {return Material.MUSIC_DISC_FAR;
        } else if (n == 2) {return Material.MUSIC_DISC_CHIRP;
        } else if (n == 3) {return Material.MUSIC_DISC_BLOCKS;
        } else if (n == 4) {return Material.MUSIC_DISC_MALL;
        } else if (n == 5) {return Material.MUSIC_DISC_STAL;
        } else if (n == 6) {return Material.MUSIC_DISC_MELLOHI;
        } else if (n == 7) {return Material.MUSIC_DISC_WAIT;
        } else if (n == 8) {return Material.MUSIC_DISC_STRAD;
        } else {return Material.MUSIC_DISC_WARD;}
    }

    private Material tryAgain(Player p, Entity e, FishHook h) {
        Material newTry;
        if (adder.getTries() < plugin.getConfig().getInt("fishing-attempts")) {
            adder.addTries();
            newTry = onFishing(new PlayerFishEvent(p, e, h, PlayerFishEvent.State.CAUGHT_FISH));
        } else {
            adder.resetTries();
            newTry = Material.STICK;
        }
        return newTry;
    }

    @EventHandler
    public Material onFishing(PlayerFishEvent e) {
        Player p = e.getPlayer();
        Entity caughtEntity = e.getCaught();
        if (caughtEntity != null && (p.hasPermission("vegalts.fishing") || plugin.getPluginConfig().getBoolean("global-vegan-fishing")) && !p.hasPermission("vegalts.fishing.disabled")) {
            Material caught = ((Item) caughtEntity).getItemStack().getType();
            if (caught != Material.COCOA_BEANS) {
                Random rand = new Random();
                if (VAFishingReference.getFish().contains(caught)) {
                    int n = rand.nextInt(22);
                    if (n <= 1) {caught = (plugin.getConfig().getBoolean("kelp")) ? Material.KELP : tryAgain(p, caughtEntity, e.getHook());
                    } else if (n <= 3) {caught = (plugin.getConfig().getBoolean("lily-pad")) ? Material.LILY_PAD : tryAgain(p, caughtEntity, e.getHook());
                    } else if (n <= 5) {caught = (plugin.getConfig().getBoolean("vine")) ? Material.VINE : tryAgain(p, caughtEntity, e.getHook());
                    } else if (n <= 7) {caught = (plugin.getConfig().getBoolean("wheat-seeds")) ? Material.WHEAT_SEEDS : tryAgain(p, caughtEntity, e.getHook());
                    } else if (n <= 9) {caught = (plugin.getConfig().getBoolean("melon-seeds")) ? Material.MELON_SEEDS : tryAgain(p, caughtEntity, e.getHook());
                    } else if (n <= 11) {caught = (plugin.getConfig().getBoolean("pumpkin-seeds")) ? Material.PUMPKIN_SEEDS : tryAgain(p, caughtEntity, e.getHook());
                    } else if (n <= 13) {caught = (plugin.getConfig().getBoolean("beetroot-seeds")) ? Material.BEETROOT_SEEDS : tryAgain(p, caughtEntity, e.getHook());
                    } else if (n <= 15) {caught = (plugin.getConfig().getBoolean("grass")) ? Material.GRASS : tryAgain(p, caughtEntity, e.getHook());
                    } else if (n <= 17) {caught = (plugin.getConfig().getBoolean("seagrass")) ? Material.SEAGRASS : tryAgain(p, caughtEntity, e.getHook());
                    } else if (n <= 19) {caught = (plugin.getConfig().getBoolean("sugar-cane")) ? Material.SUGAR_CANE : tryAgain(p, caughtEntity, e.getHook());
                    } else if (n == 20) {caught = (plugin.getConfig().getBoolean("sea-pickle")) ? Material.SEA_PICKLE : tryAgain(p, caughtEntity, e.getHook());
                    } else caught = (plugin.getConfig().getBoolean("random-coral")) ? getCoral() : tryAgain(p, caughtEntity, e.getHook());
                } else if (VAFishingReference.getJunk().contains(caught)) {
                    int n = rand.nextInt(19);
                    if (n <= 1) {caught = (plugin.getConfig().getBoolean("bowl")) ? Material.BOWL : tryAgain(p, caughtEntity, e.getHook());
                    } else if (n <= 3) {caught = (plugin.getConfig().getBoolean("stick")) ? Material.STICK : tryAgain(p, caughtEntity, e.getHook());
                    } else if (n <= 5) {caught = (plugin.getConfig().getBoolean("arrow")) ? Material.ARROW : tryAgain(p, caughtEntity, e.getHook());
                    } else if (n <= 7) {caught = (plugin.getConfig().getBoolean("charcoal")) ? Material.CHARCOAL : tryAgain(p, caughtEntity, e.getHook());
                    } else if (n <= 9) {caught = (plugin.getConfig().getBoolean("flint")) ? Material.FLINT : tryAgain(p, caughtEntity, e.getHook());
                    } else if (n <= 11) {caught = (plugin.getConfig().getBoolean("clay-ball")) ? Material.CLAY_BALL : tryAgain(p, caughtEntity, e.getHook());
                    } else if (n == 12) {caught = (plugin.getConfig().getBoolean("compass")) ? Material.COMPASS : tryAgain(p, caughtEntity, e.getHook());
                    } else if (n == 13) {caught = (plugin.getConfig().getBoolean("flower-pot")) ? Material.FLOWER_POT : tryAgain(p, caughtEntity, e.getHook());
                    } else if (n == 14) {caught = (plugin.getConfig().getBoolean("water-bucket")) ? Material.WATER_BUCKET : tryAgain(p, caughtEntity, e.getHook());
                    } else if (n == 15) {caught = (plugin.getConfig().getBoolean("prismarine-shard")) ? Material.PRISMARINE_SHARD : tryAgain(p, caughtEntity, e.getHook());
                    } else if (n == 16) {caught = (plugin.getConfig().getBoolean("prismarine-crystals")) ? Material.PRISMARINE_CRYSTALS : tryAgain(p, caughtEntity, e.getHook());
                    } else if (n == 17) {
                        if (plugin.getConfig().getBoolean("")) {
                            ItemStack shears = new ItemStack(Material.SHEARS);
                            Damageable shearsDamage = (Damageable) shears.getItemMeta();
                            shearsDamage.damage(rand.nextInt(210)+18);

                            shears.setItemMeta((ItemMeta) shearsDamage);
                            ((Item) caughtEntity).setItemStack(shears);
                            return Material.SHEARS;
                        } else caught = tryAgain(p, caughtEntity, e.getHook());
                    } else {
                        if (plugin.getConfig().getBoolean("water-bottle")) {
                            ItemStack bottle = new ItemStack(Material.POTION);
                            ItemMeta meta = bottle.getItemMeta();
                            PotionMeta pmeta = (PotionMeta) meta;
                            PotionData pdata = new PotionData(PotionType.WATER);
                            pmeta.setBasePotionData(pdata);
                            bottle.setItemMeta(meta);

                            ((Item) caughtEntity).setItemStack(bottle);
                            return Material.POTION;
                        } else caught = tryAgain(p, caughtEntity, e.getHook());
                    }
                } else if (VAFishingReference.getTreasure().contains(caught)) {
                    int n = rand.nextInt(19);
                    if (n <= 2) {
                        if (plugin.getConfig().getBoolean("bottle-o-enchanting")) {
                            ((Item) caughtEntity).setItemStack(new ItemStack(Material.EXPERIENCE_BOTTLE));
                            return Material.EXPERIENCE_BOTTLE;
                        } else caught = tryAgain(p, caughtEntity, e.getHook());
                    } else if (n <= 5) {
                        if (plugin.getConfig().getBoolean("iron-nugget")) {
                            ((Item) caughtEntity).setItemStack(new ItemStack(Material.IRON_NUGGET));
                            return Material.IRON_NUGGET;
                        } else caught = tryAgain(p, caughtEntity, e.getHook());
                    } else if (n <= 8) {
                        if (plugin.getConfig().getBoolean("gold-nugget")) {
                            ((Item) caughtEntity).setItemStack(new ItemStack(Material.GOLD_NUGGET));
                            return Material.GOLD_NUGGET;
                        } else caught = tryAgain(p, caughtEntity, e.getHook());
                    } else if (n <= 11) {caught = (plugin.getConfig().getBoolean("name-tag")) ? Material.NAME_TAG : tryAgain(p, caughtEntity, e.getHook());
                    } else if (n <= 14) {caught = (plugin.getConfig().getBoolean("wet-sponge")) ? Material.WET_SPONGE : tryAgain(p, caughtEntity, e.getHook());
                    } else if (n <= 17) {caught = (plugin.getConfig().getBoolean("random-disc")) ? getDisc() : tryAgain(p, caughtEntity, e.getHook());
                    } else caught = (plugin.getConfig().getBoolean("totem-of-undying")) ? Material.TOTEM_OF_UNDYING : tryAgain(p, caughtEntity, e.getHook());
                }
                assert caught != null;
                ((Item) caughtEntity).setItemStack(new ItemStack(caught));
                return caught;
            }
        }
        if (caughtEntity != null) return ((Item) caughtEntity).getItemStack().getType(); else return null;
    }
}