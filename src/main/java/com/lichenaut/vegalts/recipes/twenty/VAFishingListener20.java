package com.lichenaut.vegalts.recipes.twenty;

import com.lichenaut.vegalts.VegAlts;
import com.lichenaut.vegalts.utility.VAFishingReference;
import org.bukkit.Material;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

import java.util.Random;

public class VAFishingListener20 implements Listener {

    private final VegAlts plugin;

    public VAFishingListener20(VegAlts plugin) {this.plugin = plugin;}

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

    @EventHandler
    public void onFishing(PlayerFishEvent e) {
        Player p = e.getPlayer();
        Entity caughtEntity = e.getCaught();
        if (caughtEntity != null && (p.hasPermission("vegalts.fishing") || plugin.getPluginConfig().getBoolean("global-vegan-fishing")) && !p.hasPermission("vegalts.fishing.disabled")) {
            Material caught = ((Item) caughtEntity).getItemStack().getType();
            if (caught != Material.BAMBOO && caught != Material.COCOA_BEANS) {
                Random rand = new Random();
                if (VAFishingReference.getFish().contains(caught)) {
                    int n = rand.nextInt(27);
                    if (n <= 1) {caught = Material.KELP;
                    } else if (n <= 3) {caught = Material.LILY_PAD;
                    } else if (n <= 5) {caught = Material.MOSS_CARPET;
                    } else if (n <= 7) {caught = Material.VINE;
                    } else if (n <= 9) {caught = Material.WHEAT_SEEDS;
                    } else if (n <= 11) {caught = Material.MELON_SEEDS;
                    } else if (n <= 13) {caught = Material.PUMPKIN_SEEDS;
                    } else if (n <= 15) {caught = Material.BEETROOT_SEEDS;
                    } else if (n <= 17) {caught = Material.GRASS;
                    } else if (n <= 19) {caught = Material.SEAGRASS;
                    } else if (n <= 21) {caught = Material.HANGING_ROOTS;
                    } else if (n <= 23) {caught = Material.SUGAR_CANE;
                    } else if (n == 24) {caught = Material.SEA_PICKLE;
                    } else if (n == 25) {caught = Material.GLOW_LICHEN;
                    } else {caught = getCoral();}
                } else if (VAFishingReference.getJunk().contains(caught)) {
                    int n = rand.nextInt(20);
                    if (n <= 1) {caught = Material.BOWL;
                    } else if (n <= 3) {caught = Material.STICK;
                    } else if (n <= 5) {caught = Material.ARROW;
                    } else if (n <= 7) {caught = Material.CHARCOAL;
                    } else if (n <= 9) {caught = Material.FLINT;
                    } else if (n <= 11) {caught = Material.CLAY_BALL;
                    } else if (n == 12) {caught = Material.COMPASS;
                    } else if (n == 13) {caught = Material.BRUSH;
                    } else if (n == 14) {caught = Material.FLOWER_POT;
                    } else if (n == 15) {caught = Material.WATER_BUCKET;
                    } else if (n == 16) {caught = Material.PRISMARINE_SHARD;
                    } else if (n == 17) {caught = Material.PRISMARINE_CRYSTALS;
                    } else if (n == 18) {
                        ItemStack shears = new ItemStack(Material.SHEARS);
                        Damageable shearsDamage = (Damageable) shears.getItemMeta();
                        shearsDamage.damage(rand.nextInt(210)+18);

                        shears.setItemMeta((ItemMeta) shearsDamage);
                        ((Item) caughtEntity).setItemStack(shears);
                        return;
                    } else {
                        ItemStack bottle = new ItemStack(Material.POTION);
                        ItemMeta meta = bottle.getItemMeta();
                        PotionMeta pmeta = (PotionMeta) meta;
                        PotionData pdata = new PotionData(PotionType.WATER);
                        pmeta.setBasePotionData(pdata);
                        bottle.setItemMeta(meta);

                        ((Item) caughtEntity).setItemStack(bottle);
                        return;
                    }
                } else if (VAFishingReference.getTreasure().contains(caught)) {
                    int n = rand.nextInt(22);
                    if (n <= 2) {
                        ((Item) caughtEntity).setItemStack(new ItemStack(Material.EXPERIENCE_BOTTLE));
                        return;
                    } else if (n <= 5) {
                        ((Item) caughtEntity).setItemStack(new ItemStack(Material.IRON_NUGGET));
                        return;
                    } else if (n <= 8) {
                        ((Item) caughtEntity).setItemStack(new ItemStack(Material.GOLD_NUGGET));
                        return;
                    } else if (n <= 11) {caught = Material.NAME_TAG;
                    } else if (n <= 14) {caught = Material.WET_SPONGE;
                    } else if (n <= 17) {caught = Material.SPYGLASS;
                    } else if (n <= 20) {caught = getDisc();
                    } else {caught = Material.TOTEM_OF_UNDYING;}
                }
                ((Item) caughtEntity).setItemStack(new ItemStack(caught));
            }
        }
    }
}