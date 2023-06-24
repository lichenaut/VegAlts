package com.lichenaut.vegalts.recipes.twenty;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BrushableBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;
import java.util.Random;

public class VABrushListener implements Listener {

    @EventHandler
    public void onBrush(PlayerInteractEvent e) {
        if (e.getClickedBlock() == null || !e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || (!e.getPlayer().getInventory().getItemInMainHand().isSimilar(new ItemStack(Material.BRUSH)) && !e.getPlayer().getInventory().getItemInOffHand().isSimilar(new ItemStack(Material.BRUSH)))) return;
        Block block = e.getClickedBlock();
        boolean isSusGravel = block.getType() == Material.SUSPICIOUS_GRAVEL;
        boolean isSusSand = block.getType() == Material.SUSPICIOUS_SAND;
        if (isSusGravel || isSusSand) {
            BrushableBlock bb = (BrushableBlock) block.getState();
            if (Objects.equals(bb.getItem(), new ItemStack(Material.COAL)) || Objects.equals(bb.getItem(), new ItemStack(Material.SNIFFER_EGG))) {
                e.setCancelled(true);
                if (isSusGravel) block.setType(Material.GRAVEL); else block.setType(Material.SAND);

                Random rand = new Random();
                int n = rand.nextInt(2);
                if (n == 0) {block.getWorld().dropItem(block.getLocation().add(0, 1, 0), new ItemStack(Material.TORCHFLOWER_SEEDS));
                } else {block.getWorld().dropItem(block.getLocation().add(0, 1, 0), new ItemStack(Material.PITCHER_POD));}
            }
        }
    }
}