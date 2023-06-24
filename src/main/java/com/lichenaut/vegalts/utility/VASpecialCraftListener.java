package com.lichenaut.vegalts.utility;

import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

import java.util.Objects;

public class VASpecialCraftListener implements Listener {

    private int invSpace(Player p) {//count open inventory slots
        ItemStack[] inventory = p.getInventory().getContents();
        int space = 0;
        for (int i = 0; i < 36; i++) if (inventory[i] == null || inventory[i].getType() == Material.AIR) space++;
        return space;
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
        for (ItemStack is : e.getInventory().getMatrix()) if (is != null && is.getAmount() < bottleneck) {bottleneck = is.getAmount();}
        return bottleneck;
    }

    @EventHandler
    public void onPlayerCraft(CraftItemEvent e) {
        Player p = (Player) e.getInventory().getHolder();
        assert p != null;
        int bottleneck = getBottleneck(e);
        ItemStack result = new ItemStack(Objects.requireNonNull(e.getCurrentItem()));
        if (VASpecialCraftReference.getContainerConsumers().contains(e.getRecipe().getResult().getType())) {//get rid of old bucket when crafting fake milk
            if (e.getClick().isShiftClick()) {//shift click
                if (!giveItem(e, p, result)) {
                    try {e.getInventory().setMatrix(new ItemStack[]{Objects.requireNonNull(e.getInventory().getMatrix()[0]).subtract(), Objects.requireNonNull(e.getInventory().getMatrix()[1]).subtract(), Objects.requireNonNull(e.getInventory().getMatrix()[2]).subtract(), Objects.requireNonNull(e.getInventory().getMatrix()[3]).subtract(), Objects.requireNonNull(e.getInventory().getMatrix()[4]).subtract(), Objects.requireNonNull(e.getInventory().getMatrix()[5]).subtract(), Objects.requireNonNull(e.getInventory().getMatrix()[6]).subtract(), Objects.requireNonNull(e.getInventory().getMatrix()[7]).subtract(), Objects.requireNonNull(e.getInventory().getMatrix()[8]).subtract()});
                    } catch (NullPointerException ignored) {}
                }
            } else {//normal click
                ((HumanEntity) Objects.requireNonNull(e.getInventory().getHolder())).setItemOnCursor(result);
                try {e.getInventory().setMatrix(new ItemStack[]{Objects.requireNonNull(e.getInventory().getMatrix()[0]).subtract(), Objects.requireNonNull(e.getInventory().getMatrix()[1]).subtract(), Objects.requireNonNull(e.getInventory().getMatrix()[2]).subtract(), Objects.requireNonNull(e.getInventory().getMatrix()[3]).subtract(), Objects.requireNonNull(e.getInventory().getMatrix()[4]).subtract(), Objects.requireNonNull(e.getInventory().getMatrix()[5]).subtract(), Objects.requireNonNull(e.getInventory().getMatrix()[6]).subtract(), Objects.requireNonNull(e.getInventory().getMatrix()[7]).subtract(), Objects.requireNonNull(e.getInventory().getMatrix()[8]).subtract()});
                } catch (NullPointerException ignored) {}
            }
        } else if (VASpecialCraftReference.getHydraters().contains(e.getRecipe().getResult().getType())) {//fill containers with water when crafting leather
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

            ItemStack bottle = new ItemStack(Material.POTION, 1);
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
        } else if (VASpecialCraftReference.getDehydraters().contains(e.getRecipe().getResult().getType())) {forceItem(e, p, new ItemStack(Material.GLASS_BOTTLE));//empty a water bottle
        } else if (VASpecialCraftReference.getPurifiers().contains(e.getRecipe().getResult().getType())) {for (int i = 0; i < bottleneck; i++) forceItem(e, p, new ItemStack(Material.POTATO));}//'scrape the poison off a potato'
    }
}