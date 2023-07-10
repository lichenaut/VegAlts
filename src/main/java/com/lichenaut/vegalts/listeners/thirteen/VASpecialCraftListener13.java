package com.lichenaut.vegalts.listeners.thirteen;

import com.lichenaut.vegalts.VegAlts;
import com.lichenaut.vegalts.utility.VASpecialCraftReference;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

import java.util.Objects;
import java.util.Random;

public class VASpecialCraftListener13 implements Listener {

    private final VegAlts plugin;

    public VASpecialCraftListener13(VegAlts plugin) {this.plugin = plugin;}

    private int invSpace(Player p) {//count open inventory slots
        ItemStack[] inventory = p.getInventory().getContents();
        int space = 0;
        for (int i = 0; i < 36; i++) if (inventory[i] == null || inventory[i].getType() == Material.AIR) space++;
        return space;
    }

    private boolean hasHornRecipe(CraftItemEvent e, int version) {//valid horn recipe?
        boolean slime = false;
        boolean music = false;
        boolean dye = false;
        boolean stone = false;
        for (ItemStack is : e.getInventory().getMatrix()) {
            if (is != null) {
                if (version == 17) {if (is.isSimilar(new ItemStack(Material.MUSIC_DISC_CAT)) || is.isSimilar(new ItemStack(Material.MUSIC_DISC_13)) || is.isSimilar(new ItemStack(Material.MUSIC_DISC_11)) || is.isSimilar(new ItemStack(Material.MUSIC_DISC_FAR)) || is.isSimilar(new ItemStack(Material.MUSIC_DISC_CHIRP)) || is.isSimilar(new ItemStack(Material.MUSIC_DISC_BLOCKS)) || is.isSimilar(new ItemStack(Material.MUSIC_DISC_MALL)) || is.isSimilar(new ItemStack(Material.MUSIC_DISC_STAL)) || is.isSimilar(new ItemStack(Material.MUSIC_DISC_MELLOHI)) || is.isSimilar(new ItemStack(Material.getMaterial("MUSIC_DISC_PIGSTEP"))) || is.isSimilar(new ItemStack(Material.MUSIC_DISC_WAIT)) || is.isSimilar(new ItemStack(Material.MUSIC_DISC_STRAD))) {music = true;continue;}
                } else if (version == 18) {if (is.isSimilar(new ItemStack(Material.getMaterial("MUSIC_DISC_OTHERSIDE"))) || is.isSimilar(new ItemStack(Material.MUSIC_DISC_CAT)) || is.isSimilar(new ItemStack(Material.MUSIC_DISC_13)) || is.isSimilar(new ItemStack(Material.MUSIC_DISC_11)) || is.isSimilar(new ItemStack(Material.MUSIC_DISC_FAR)) || is.isSimilar(new ItemStack(Material.MUSIC_DISC_CHIRP)) || is.isSimilar(new ItemStack(Material.MUSIC_DISC_BLOCKS)) || is.isSimilar(new ItemStack(Material.MUSIC_DISC_MALL)) || is.isSimilar(new ItemStack(Material.MUSIC_DISC_STAL)) || is.isSimilar(new ItemStack(Material.MUSIC_DISC_MELLOHI)) || is.isSimilar(new ItemStack(Material.getMaterial("MUSIC_DISC_PIGSTEP"))) || is.isSimilar(new ItemStack(Material.MUSIC_DISC_WAIT)) || is.isSimilar(new ItemStack(Material.MUSIC_DISC_STRAD))) {music = true;continue;}
                } else {if (is.isSimilar(new ItemStack(Material.getMaterial("DISC_FRAGMENT_5")))) {music = true;continue;}}
                if (is.isSimilar(new ItemStack(Material.SLIME_BALL))) {slime = true;
                } else if (is.isSimilar(new ItemStack(Material.getMaterial("BLACK_DYE")))) {dye = true;
                } else if (is.isSimilar(new ItemStack(Material.getMaterial("POINTED_DRIPSTONE")))) stone = true;
            }
        }
        return slime && music && dye && stone;
    }

    private boolean hasHeadRecipe(CraftItemEvent e) {//valid head recipe?
        int leatherCount = 0;
        boolean skull = false;
        for (ItemStack is : e.getInventory().getMatrix()) {
            if (is != null) {
                if (is.isSimilar(new ItemStack(Material.LEATHER))) leatherCount++;
                else if (is.isSimilar(new ItemStack(Material.SKELETON_SKULL))) skull = true;
            }
        }
        return leatherCount == 8 && skull;
    }

    private boolean giveItem(CraftItemEvent e, Player p, ItemStack item) {//used in getting rid of empty bucket when crafting fake milk
        boolean isCancelled = p.getInventory().addItem(item).size() != 0;
        if (isCancelled) e.setCancelled(true);
        return isCancelled;
    }

    private void forceItem(CraftItemEvent e, Player p, ItemStack item) {//used for byproducts of craft events
        if (invSpace(p) < getBottleneck(e)) {
            p.getWorld().dropItem(p.getLocation(), item);
            return;
        }
        boolean success = p.getInventory().addItem(item).size() == 0;
        if (!success) {p.getWorld().dropItem(p.getLocation(), item);}//drop item at player location if their inventory is full
    }

    private int getBottleneck(CraftItemEvent e) {//get the amount of items crafted by a shift-click
        int bottleneck = 10000;
        boolean foundItem = false;
        for (ItemStack is : e.getInventory().getMatrix()) if (is != null && is.getAmount() < bottleneck) {
            bottleneck = is.getAmount();
            foundItem = true;
        }
        if (!foundItem) bottleneck = 0;
        return bottleneck;
    }

    private void subtractCraftInventory(CraftItemEvent e) {
        for (ItemStack is : e.getInventory().getMatrix()) {
            if (is != null) {
                is.subtract();
            }
        }
    }

    private void clearCraftInventory(CraftItemEvent e) {try {e.getInventory().setMatrix(new ItemStack[]{Objects.requireNonNull(e.getInventory().getMatrix()[0]).subtract(), Objects.requireNonNull(e.getInventory().getMatrix()[1]).subtract(), Objects.requireNonNull(e.getInventory().getMatrix()[2]).subtract(), Objects.requireNonNull(e.getInventory().getMatrix()[3]).subtract(), Objects.requireNonNull(e.getInventory().getMatrix()[4]).subtract(), Objects.requireNonNull(e.getInventory().getMatrix()[5]).subtract(), Objects.requireNonNull(e.getInventory().getMatrix()[6]).subtract(), Objects.requireNonNull(e.getInventory().getMatrix()[7]).subtract(), Objects.requireNonNull(e.getInventory().getMatrix()[8]).subtract()});} catch (NullPointerException ignored) {}}

    @EventHandler
    public void onPlayerCraft(CraftItemEvent e) {
        Player p = (Player) e.getInventory().getHolder();
        assert p != null;
        int bottleneck = getBottleneck(e);
        int version = plugin.getVersion();
        ItemStack result = new ItemStack(e.getRecipe().getResult());
        if (VASpecialCraftReference.getContainerConsumers().contains(result.getType())) {//get rid of old bucket when crafting fake milk
            if (e.getClick().isShiftClick()) {
                if (!giveItem(e, p, result)) clearCraftInventory(e);
            } else {
                ((HumanEntity) Objects.requireNonNull(e.getInventory().getHolder())).setItemOnCursor(result);
                clearCraftInventory(e);
            }
        } else if (version >= 15 && VASpecialCraftReference.getDehydraters().contains(result.getType())) {forceItem(e, p, new ItemStack(Material.GLASS_BOTTLE));//empty a water bottle
        } else if (VASpecialCraftReference.getHydraters().contains(result.getType())) {//fill containers with water when crafting leather
            ItemStack[] inventory = p.getInventory().getContents();

            boolean hasBucket = false;//find the location of an empty bucket in player inventory
            int bucketIndex = 0;
            for (int i = 0; i < 36; i++) {
                if (inventory[i] != null && inventory[i].getType() == Material.BUCKET) {
                    bucketIndex = i;
                    hasBucket = true;
                    break;
                }
            }

            ItemStack bottle = new ItemStack(Material.POTION);
            ItemMeta meta = bottle.getItemMeta();
            PotionMeta pmeta = (PotionMeta) meta;
            pmeta.setBasePotionData(new PotionData(PotionType.WATER));
            bottle.setItemMeta(meta);

            if (e.getClick().isShiftClick()) {
                if (invSpace(p) > 0) {
                    if (hasBucket) {//if player has an empty bucket, fill it instead of many bottles
                        Objects.requireNonNull(p.getInventory().getItem(bucketIndex)).subtract();
                        forceItem(e, p, new ItemStack(Material.WATER_BUCKET));
                        for (int i = 0; i < bottleneck; i++) {forceItem(e, p, new ItemStack(Material.GLASS_BOTTLE));}//give back the unfilled bottles
                    } else {for (int i = 0; i < bottleneck; i++) {forceItem(e, p, bottle);}}//fill many bottles
                }
            } else forceItem(e, p, bottle);
        } else if (VASpecialCraftReference.getPurifiers().contains(result.getType())) {for (int i = 0; i < bottleneck; i++) forceItem(e, p, new ItemStack(Material.POTATO));//scrape the poison off a potato
        } else if (version >= 17 && result.isSimilar(new ItemStack(Material.getMaterial("GOAT_HORN")))) {
            if (version == 17 || version == 18) {bottleneck *= 4;}

            if (e.getClick().isShiftClick()) {
                for (int i = 0; i < bottleneck; i++) {
                    ItemStack goatHorn = new ItemStack(Material.getMaterial("GOAT_HORN"));
                    subtractCraftInventory(e);
                    forceItem(e, p, goatHorn);
                }
            } else {
                ItemStack goatHorn = new ItemStack(Material.getMaterial("GOAT_HORN"));
                if (version == 17 || version == 18) {goatHorn.add(3);}
                subtractCraftInventory(e);
                ((HumanEntity) Objects.requireNonNull(e.getInventory().getHolder())).setItemOnCursor(goatHorn);
            }

            e.setCancelled(true);
            if (!hasHornRecipe(e, version)) e.getInventory().setItem(0, null);
        } else if (result.isSimilar(new ItemStack(Material.PLAYER_HEAD))) {
            if ((p.hasPermission("vegalts.playerhead") || plugin.getPluginConfig().getBoolean("global-unique-playerhead")) && !p.hasPermission("vegalts.playerhead.disabled")) {
                ItemStack playerSkull = new ItemStack(Material.PLAYER_HEAD);
                SkullMeta meta = (SkullMeta) playerSkull.getItemMeta();
                meta.setOwningPlayer(p);
                playerSkull.setItemMeta(meta);

                if (e.getClick().isShiftClick()) {
                    for (int i = 0; i < bottleneck; i++) {
                        subtractCraftInventory(e);
                        forceItem(e, p, playerSkull);
                    }
                } else {
                    subtractCraftInventory(e);
                    ((HumanEntity) Objects.requireNonNull(e.getInventory().getHolder())).setItemOnCursor(playerSkull);
                }

                e.setCancelled(true);
                if (!hasHeadRecipe(e)) e.getInventory().setItem(0, null);
            }
        }
    }
}