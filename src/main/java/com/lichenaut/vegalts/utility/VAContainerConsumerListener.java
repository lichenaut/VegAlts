package com.lichenaut.vegalts.utility;

import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

import java.util.Objects;

public class VAContainerConsumerListener implements Listener {

    private void giveItem(CraftItemEvent e, Player p, ItemStack item) {
        ItemStack[] inventory = p.getInventory().getContents();
        boolean isSet = false;
        for (int i = inventory.length-6; i > 0; i--) {
            if (inventory[i] == null || inventory[i].getType() == Material.AIR || (inventory[i].getType() == e.getRecipe().getResult().getType() && (e.getRecipe().getResult().getMaxStackSize() != e.getRecipe().getResult().getAmount()))) {
                p.getInventory().setItem(i, item);
                isSet = true;
                break;
            }
        }
        if (!isSet) {p.getWorld().dropItem(p.getLocation(), item);}
    }

    @EventHandler
    public void onPlayerCraft(CraftItemEvent e) {
        if (VASpecialCraftReference.getContainerConsumers().contains(e.getRecipe().getResult().getType())) {
            ItemStack result = new ItemStack(Objects.requireNonNull(e.getCurrentItem()));
            try {e.getInventory().setMatrix(new ItemStack[]{Objects.requireNonNull(e.getInventory().getMatrix()[0]).subtract(), Objects.requireNonNull(e.getInventory().getMatrix()[1]).subtract(), Objects.requireNonNull(e.getInventory().getMatrix()[2]).subtract(), Objects.requireNonNull(e.getInventory().getMatrix()[3]).subtract(), Objects.requireNonNull(e.getInventory().getMatrix()[4]).subtract(), Objects.requireNonNull(e.getInventory().getMatrix()[5]).subtract(), Objects.requireNonNull(e.getInventory().getMatrix()[6]).subtract(), Objects.requireNonNull(e.getInventory().getMatrix()[7]).subtract(), Objects.requireNonNull(e.getInventory().getMatrix()[8]).subtract()});
            } catch (NullPointerException ignored) {}
            if (e.getAction().equals(InventoryAction.MOVE_TO_OTHER_INVENTORY)) {
                Player p = (Player) e.getInventory().getHolder();
                assert p != null;
                giveItem(e, p, result);
            } else {((HumanEntity) Objects.requireNonNull(e.getInventory().getHolder())).setItemOnCursor(result);}
        } else if (VASpecialCraftReference.getHydraters().contains(e.getRecipe().getResult().getType())) {
            Player p = (Player) e.getInventory().getHolder();
            assert p != null;
            ItemStack[] inventory = p.getInventory().getContents();

            boolean hasBucket = false;
            int bucketIndex = 0;
            for (int i = 0; i < 36; i++) {
                if (inventory[i] != null && inventory[i].getType() == Material.BUCKET) {
                    bucketIndex = i;
                    hasBucket = true;
                    break;
                }
            }

            if (e.getAction().equals(InventoryAction.MOVE_TO_OTHER_INVENTORY) && hasBucket) {
                Objects.requireNonNull(p.getInventory().getItem(bucketIndex)).subtract();
                giveItem(e, p, new ItemStack(Material.WATER_BUCKET));
            } else {
                ItemStack bottle = new ItemStack(Material.POTION, 1);
                ItemMeta meta = bottle.getItemMeta();
                PotionMeta pmeta = (PotionMeta) meta;
                PotionData pdata = new PotionData(PotionType.WATER);
                pmeta.setBasePotionData(pdata);
                bottle.setItemMeta(meta);

                giveItem(e, p, bottle);
            }
        }
    }
}