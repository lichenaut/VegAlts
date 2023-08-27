package com.lichenaut.vegalts.listeners.twenty;

import com.lichenaut.vegalts.VegAlts;
import com.lichenaut.vegalts.utility.VAFishingReference;
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

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class VAFishingListener20 implements Listener {

    private final VegAlts plugin;
    private final VAFishingReference ref;
    private final ArrayList<Material> randCaughtFlora;
    private final ArrayList<Material> randCaughtJunk;
    private final ArrayList<Material> randCaughtTreasure;

    public VAFishingListener20(VegAlts plugin, VAFishingReference ref) {
        this.plugin = plugin;
        this.ref = ref;
        randCaughtFlora = new ArrayList<>();
        randCaughtJunk = new ArrayList<>();
        randCaughtTreasure = new ArrayList<>();

        if (plugin.getConfig().getBoolean("kelp")) {
            randCaughtFlora.add(Material.KELP);
            randCaughtFlora.add(Material.KELP);
        }
        if (plugin.getConfig().getBoolean("lily-pad")) {
            randCaughtFlora.add(Material.LILY_PAD);
            randCaughtFlora.add(Material.LILY_PAD);
        }
        if (plugin.getConfig().getBoolean("moss-carpet")) {
            randCaughtFlora.add(Material.MOSS_CARPET);
            randCaughtFlora.add(Material.MOSS_CARPET);
        }
        if (plugin.getConfig().getBoolean("vine")) {
            randCaughtFlora.add(Material.VINE);
            randCaughtFlora.add(Material.VINE);
        }
        if (plugin.getConfig().getBoolean("wheat-seeds")) {
            randCaughtFlora.add(Material.WHEAT_SEEDS);
            randCaughtFlora.add(Material.WHEAT_SEEDS);
        }
        if (plugin.getConfig().getBoolean("melon-seeds")) {
            randCaughtFlora.add(Material.MELON_SEEDS);
            randCaughtFlora.add(Material.MELON_SEEDS);
        }
        if (plugin.getConfig().getBoolean("pumpkin-seeds")) {
            randCaughtFlora.add(Material.PUMPKIN_SEEDS);
            randCaughtFlora.add(Material.PUMPKIN_SEEDS);
        }
        if (plugin.getConfig().getBoolean("beetroot-seeds")) {
            randCaughtFlora.add(Material.BEETROOT_SEEDS);
            randCaughtFlora.add(Material.BEETROOT_SEEDS);
        }
        if (plugin.getConfig().getBoolean("grass")) {
            randCaughtFlora.add(Material.GRASS);
            randCaughtFlora.add(Material.GRASS);
        }
        if (plugin.getConfig().getBoolean("seagrass")) {
            randCaughtFlora.add(Material.SEAGRASS);
            randCaughtFlora.add(Material.SEAGRASS);
        }
        if (plugin.getConfig().getBoolean("hanging-roots")) {
            randCaughtFlora.add(Material.HANGING_ROOTS);
            randCaughtFlora.add(Material.HANGING_ROOTS);
        }
        if (plugin.getConfig().getBoolean("sugar-cane")) {
            randCaughtFlora.add(Material.SUGAR_CANE);
            randCaughtFlora.add(Material.SUGAR_CANE);
        }
        if (plugin.getConfig().getBoolean("sea-pickle")) randCaughtFlora.add(Material.SEA_PICKLE);
        if (plugin.getConfig().getBoolean("glow-lichen")) randCaughtFlora.add(Material.GLOW_LICHEN);
        if (plugin.getConfig().getBoolean("potato")) randCaughtFlora.add(Material.POTATO);
        if (plugin.getConfig().getBoolean("poisonous-potato")) randCaughtFlora.add(Material.POISONOUS_POTATO);
        if (plugin.getConfig().getBoolean("bowl")) {
            randCaughtJunk.add(Material.BOWL);
            randCaughtJunk.add(Material.BOWL);
        }
        if (plugin.getConfig().getBoolean("stick")) {
            randCaughtJunk.add(Material.STICK);
            randCaughtJunk.add(Material.STICK);
        }
        if (plugin.getConfig().getBoolean("arrow")) {
            randCaughtJunk.add(Material.ARROW);
            randCaughtJunk.add(Material.ARROW);
        }
        if (plugin.getConfig().getBoolean("charcoal")) {
            randCaughtJunk.add(Material.CHARCOAL);
            randCaughtJunk.add(Material.CHARCOAL);
        }
        if (plugin.getConfig().getBoolean("flint")) {
            randCaughtJunk.add(Material.FLINT);
            randCaughtJunk.add(Material.FLINT);
        }
        if (plugin.getConfig().getBoolean("clay-ball")) {
            randCaughtJunk.add(Material.CLAY_BALL);
            randCaughtJunk.add(Material.CLAY_BALL);
        }
        if (plugin.getConfig().getBoolean("compass")) randCaughtJunk.add(Material.COMPASS);
        if (plugin.getConfig().getBoolean("brush")) randCaughtJunk.add(Material.BRUSH);
        if (plugin.getConfig().getBoolean("flower-pot")) randCaughtJunk.add(Material.FLOWER_POT);
        if (plugin.getConfig().getBoolean("water-bucket")) randCaughtJunk.add(Material.WATER_BUCKET);
        if (plugin.getConfig().getBoolean("prismarine-shard")) randCaughtJunk.add(Material.PRISMARINE_SHARD);
        if (plugin.getConfig().getBoolean("prismarine-crystals")) randCaughtJunk.add(Material.PRISMARINE_CRYSTALS);
        if (plugin.getConfig().getBoolean("shears")) randCaughtJunk.add(Material.SHEARS);
        if (plugin.getConfig().getBoolean("water-bottle")) randCaughtJunk.add(Material.POTION);
        if (plugin.getConfig().getBoolean("bottle-o-enchanting")) {
            randCaughtTreasure.add(Material.EXPERIENCE_BOTTLE);
            randCaughtTreasure.add(Material.EXPERIENCE_BOTTLE);
            randCaughtTreasure.add(Material.EXPERIENCE_BOTTLE);
        }
        if (plugin.getConfig().getBoolean("iron-nugget")) {
            randCaughtTreasure.add(Material.IRON_NUGGET);
            randCaughtTreasure.add(Material.IRON_NUGGET);
            randCaughtTreasure.add(Material.IRON_NUGGET);
        }
        if (plugin.getConfig().getBoolean("gold-nugget")) {
            randCaughtTreasure.add(Material.GOLD_NUGGET);
            randCaughtTreasure.add(Material.GOLD_NUGGET);
            randCaughtTreasure.add(Material.GOLD_NUGGET);
        }
        if (plugin.getConfig().getBoolean("name-tag")) {
            randCaughtTreasure.add(Material.NAME_TAG);
            randCaughtTreasure.add(Material.NAME_TAG);
            randCaughtTreasure.add(Material.NAME_TAG);
        }
        if (plugin.getConfig().getBoolean("wet-sponge")) {
            randCaughtTreasure.add(Material.WET_SPONGE);
            randCaughtTreasure.add(Material.WET_SPONGE);
            randCaughtTreasure.add(Material.WET_SPONGE);
        }
        if (plugin.getConfig().getBoolean("spyglass")) {
            randCaughtTreasure.add(Material.getMaterial("SPYGLASS"));
            randCaughtTreasure.add(Material.getMaterial("SPYGLASS"));
            randCaughtTreasure.add(Material.getMaterial("SPYGLASS"));
        }
        if (plugin.getConfig().getBoolean("totem-of-undying")) randCaughtTreasure.add(Material.TOTEM_OF_UNDYING);
    }

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
        if (caughtEntity == null || (!p.hasPermission("vegalts.fishing") && !plugin.getPluginConfig().getBoolean("global-vegan-fishing")) || p.hasPermission("vegalts.fishing.disabled")) return;
        Material caught = ((Item) caughtEntity).getItemStack().getType();
        if (caught == Material.getMaterial("BAMBOO") || caught == Material.COCOA_BEANS) return;
        Random rand = new Random();

        if (ref.getFish().contains(caught)) {
            if (plugin.getConfig().getBoolean("random-coral")) randCaughtFlora.add(getCoral());
            int n = rand.nextInt(randCaughtFlora.size());
            caught = randCaughtFlora.get(n);
        } else if (ref.getJunk().contains(caught)) {
            int n = rand.nextInt(randCaughtJunk.size());
            switch (randCaughtJunk.get(n)) {
                case BRUSH:
                    ItemStack brush = new ItemStack(Objects.requireNonNull(Material.getMaterial("BRUSH")));
                    Damageable brushDamage = (Damageable) brush.getItemMeta();
                    brushDamage.damage(rand.nextInt(40)+14);
                    brush.setItemMeta((ItemMeta) brushDamage);
                    ((Item) caughtEntity).setItemStack(brush);
                    return;
                case SHEARS:
                    ItemStack shears = new ItemStack(Material.SHEARS);
                    Damageable shearsDamage = (Damageable) shears.getItemMeta();
                    shearsDamage.damage(rand.nextInt(210)+18);
                    shears.setItemMeta((ItemMeta) shearsDamage);
                    ((Item) caughtEntity).setItemStack(shears);
                    return;
                case POTION:
                    ItemStack bottle = new ItemStack(Material.POTION);
                    ItemMeta meta = bottle.getItemMeta();
                    PotionMeta pmeta = (PotionMeta) meta;
                    PotionData pdata = new PotionData(PotionType.WATER);
                    pmeta.setBasePotionData(pdata);
                    bottle.setItemMeta(meta);
                    ((Item) caughtEntity).setItemStack(bottle);
                    return;
            }
        } else if (ref.getTreasure().contains(caught)) {
            if (plugin.getConfig().getBoolean("random-disc")) {
                randCaughtTreasure.add(getDisc());
                randCaughtTreasure.add(getDisc());
                randCaughtTreasure.add(getDisc());
            }
            int n = rand.nextInt(randCaughtTreasure.size());
            caught = randCaughtTreasure.get(n);
        } else caught = Material.STICK;

        ((Item) caughtEntity).setItemStack(new ItemStack(caught));
    }
}